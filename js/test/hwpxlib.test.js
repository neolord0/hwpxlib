import {
  HWPXReader,
  HWPXWriter,
  HWPXFile,
  BlankFileMaker,
  TextExtractor,
  TextMarks,
  TextExtractMethod,
  TargetApplicationSort,
  Para,
  Run,
  T
} from '../src/index.js';

import fs from 'fs';
import path from 'path';
import { fileURLToPath } from 'url';

const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);
const testFileDir = path.join(__dirname, '../../testFile');

describe('BlankFileMaker', () => {
  test('should create a blank HWPX file', () => {
    const hwpxFile = BlankFileMaker.make();

    expect(hwpxFile).toBeDefined();
    expect(hwpxFile.versionXMLFile()).toBeDefined();
    expect(hwpxFile.sectionXMLFileList().count()).toBe(1);
    expect(hwpxFile.sectionXMLFileList().get(0).countOfPara()).toBe(1);
  });

  test('should set correct version information', () => {
    const hwpxFile = BlankFileMaker.make();
    const version = hwpxFile.versionXMLFile();

    expect(version.targetApplication()).toBe(TargetApplicationSort.WordProcessor);
    expect(version.application()).toBe('hwpxlib-js');
    expect(version.version().major()).toBe(5);
    expect(version.version().minor()).toBe(0);
  });

  test('should create content.hpf manifest', () => {
    const hwpxFile = BlankFileMaker.make();
    const manifest = hwpxFile.contentHPFFile().manifest();

    expect(manifest).toBeDefined();
    expect(manifest.items().length).toBe(3); // settings, header, section0
  });
});

describe('HWPXFile Object Model', () => {
  test('should create and manipulate paragraphs', () => {
    const hwpxFile = BlankFileMaker.make();
    const section = hwpxFile.sectionXMLFileList().get(0);

    // Add a new paragraph
    const para = section.addNewPara();
    para.idAnd('test-para');

    expect(section.countOfPara()).toBe(2);
    expect(para.id()).toBe('test-para');
  });

  test('should create and manipulate runs with text', () => {
    const para = new Para();
    const run = para.addNewRun();
    run.charPrIDRefAnd('1');

    const t = run.addNewT();
    t.addText('Hello World');

    expect(para.countOfRun()).toBe(1);
    expect(run.charPrIDRef()).toBe('1');
    expect(t.getText()).toBe('Hello World');
    expect(para.getText()).toBe('Hello World');
  });

  test('should clone objects correctly', () => {
    const para = new Para();
    para.idAnd('original');

    const run = para.addNewRun();
    run.charPrIDRefAnd('1');

    const t = run.addNewT();
    t.addText('Test text');

    const cloned = para.clone();

    expect(cloned.id()).toBe('original');
    expect(cloned.getText()).toBe('Test text');

    // Modify original, cloned should be unaffected
    para.idSet('modified');
    expect(cloned.id()).toBe('original');
  });
});

describe('TextExtractor', () => {
  test('should extract text from HWPX file', () => {
    const hwpxFile = BlankFileMaker.make();
    const section = hwpxFile.sectionXMLFileList().get(0);

    // Clear and add new content
    section.removeAllParas();

    const para1 = section.addNewPara();
    const run1 = para1.addNewRun();
    run1.addNewT().addText('First paragraph');

    const para2 = section.addNewPara();
    const run2 = para2.addNewRun();
    run2.addNewT().addText('Second paragraph');

    const result = TextExtractor.extract(hwpxFile);

    expect(result).toContain('First paragraph');
    expect(result).toContain('Second paragraph');
  });

  test('should use custom text marks', () => {
    const hwpxFile = BlankFileMaker.make();
    const section = hwpxFile.sectionXMLFileList().get(0);

    section.removeAllParas();

    const para1 = section.addNewPara();
    para1.addNewRun().addNewT().addText('Line 1');

    const para2 = section.addNewPara();
    para2.addNewRun().addNewT().addText('Line 2');

    const textMarks = new TextMarks().paraSeparatorAnd('|||');
    const result = TextExtractor.extract(hwpxFile, TextExtractMethod.AppendControlTextAfterParagraphText, false, textMarks);

    expect(result).toBe('Line 1|||Line 2');
  });
});

describe('HWPXWriter', () => {
  test('should write blank file to buffer', async () => {
    const hwpxFile = BlankFileMaker.make();
    const buffer = await HWPXWriter.toBuffer(hwpxFile);

    expect(buffer).toBeDefined();
    expect(buffer.length).toBeGreaterThan(0);

    // ZIP files start with PK signature
    expect(buffer[0]).toBe(0x50); // P
    expect(buffer[1]).toBe(0x4B); // K
  });

  test('should write and read back a file', async () => {
    const hwpxFile = BlankFileMaker.make();

    // Add some content
    const section = hwpxFile.sectionXMLFileList().get(0);
    section.removeAllParas();

    const para = section.addNewPara();
    para.idAnd('test-id');
    const run = para.addNewRun();
    run.addNewT().addText('Test content for round-trip');

    // Write to buffer
    const buffer = await HWPXWriter.toBuffer(hwpxFile);

    // Read back
    const readFile = await HWPXReader.fromBuffer(buffer);

    expect(readFile).toBeDefined();
    expect(readFile.sectionXMLFileList().count()).toBe(1);

    const readSection = readFile.sectionXMLFileList().get(0);
    expect(readSection.countOfPara()).toBe(1);

    const readPara = readSection.getPara(0);
    expect(readPara.getText()).toBe('Test content for round-trip');
  });
});

describe('HWPXReader', () => {
  // Test reading actual HWPX files if available
  const sampleFilePath = path.join(testFileDir, 'reader_writer/SimpleTable.hwpx');

  test('should read existing HWPX file if available', async () => {
    if (!fs.existsSync(sampleFilePath)) {
      console.log('Skipping test: sample file not found at', sampleFilePath);
      return;
    }

    const hwpxFile = await HWPXReader.fromFilepath(sampleFilePath);

    expect(hwpxFile).toBeDefined();
    expect(hwpxFile.versionXMLFile()).toBeDefined();
    expect(hwpxFile.sectionXMLFileList().count()).toBeGreaterThan(0);
  });

  test('should extract text from real HWPX file', async () => {
    const textExtractorPath = path.join(testFileDir, 'tool/textextractor/multipara.hwpx');

    if (!fs.existsSync(textExtractorPath)) {
      console.log('Skipping test: sample file not found at', textExtractorPath);
      return;
    }

    const hwpxFile = await HWPXReader.fromFilepath(textExtractorPath);
    const text = TextExtractor.extract(hwpxFile);

    expect(text).toBeDefined();
    expect(text.length).toBeGreaterThan(0);
    // The file contains Korean text about Kim Ha-seong
    expect(text).toContain('김하성');
  });
});

describe('Object cloning', () => {
  test('should deep clone HWPXFile', () => {
    const original = BlankFileMaker.make();

    // Add content
    const section = original.sectionXMLFileList().get(0);
    section.getPara(0).getRun(0).runItems()[0].addText('Original text');

    const cloned = original.clone();

    // Modify original
    section.getPara(0).getRun(0).runItems()[0].clear();
    section.getPara(0).getRun(0).runItems()[0].addText('Modified text');

    // Check cloned is unaffected
    const clonedSection = cloned.sectionXMLFileList().get(0);
    expect(clonedSection.getPara(0).getText()).toContain('Original text');
  });
});
