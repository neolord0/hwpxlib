import { T, NormalText } from '../../object/content/section_xml/paragraph/T.js';

/**
 * Text extraction methods
 */
export const TextExtractMethod = {
  /** Append control text after paragraph text */
  AppendControlTextAfterParagraphText: 'AppendControlTextAfterParagraphText',
  /** Insert control text inline */
  InsertControlTextInline: 'InsertControlTextInline',
  /** Only paragraph text, ignore controls */
  OnlyParagraphText: 'OnlyParagraphText'
};

/**
 * Text marks for special characters
 */
export class TextMarks {
  constructor() {
    this._lineBreak = '\n';
    this._paraSeparator = '\n';
    this._tab = '\t';
    this._sectionSeparator = '\n\n';
  }

  lineBreak() { return this._lineBreak; }
  lineBreakAnd(value) { this._lineBreak = value; return this; }

  paraSeparator() { return this._paraSeparator; }
  paraSeparatorAnd(value) { this._paraSeparator = value; return this; }

  tab() { return this._tab; }
  tabAnd(value) { this._tab = value; return this; }

  sectionSeparator() { return this._sectionSeparator; }
  sectionSeparatorAnd(value) { this._sectionSeparator = value; return this; }
}

/**
 * Text extractor for HWPX files
 */
export class TextExtractor {
  /**
   * Extracts text from an HWPX file
   * @param {HWPXFile} hwpxFile - The HWPX file object
   * @param {string} method - Extraction method (from TextExtractMethod)
   * @param {boolean} insertParaHead - Whether to insert paragraph head markers
   * @param {TextMarks} textMarks - Text marks for special characters
   * @returns {string} Extracted text
   */
  static extract(hwpxFile, method = TextExtractMethod.AppendControlTextAfterParagraphText, insertParaHead = false, textMarks = new TextMarks()) {
    const extractor = new TextExtractor(hwpxFile, method, insertParaHead, textMarks);
    return extractor._extract();
  }

  /**
   * Extracts text from a specific section
   * @param {SectionXMLFile} section - The section
   * @param {TextMarks} textMarks - Text marks for special characters
   * @returns {string} Extracted text
   */
  static extractFromSection(section, textMarks = new TextMarks()) {
    const result = [];
    for (const para of section.paras()) {
      result.push(TextExtractor.extractFromPara(para, textMarks));
    }
    return result.join(textMarks.paraSeparator());
  }

  /**
   * Extracts text from a specific paragraph
   * @param {Para} para - The paragraph
   * @param {TextMarks} textMarks - Text marks for special characters
   * @returns {string} Extracted text
   */
  static extractFromPara(para, textMarks = new TextMarks()) {
    const result = [];
    for (const run of para.runs()) {
      result.push(TextExtractor.extractFromRun(run, textMarks));
    }
    return result.join('');
  }

  /**
   * Extracts text from a specific run
   * @param {Run} run - The run
   * @param {TextMarks} textMarks - Text marks for special characters
   * @returns {string} Extracted text
   */
  static extractFromRun(run, textMarks = new TextMarks()) {
    const result = [];
    for (const item of run.runItems()) {
      if (item instanceof T) {
        result.push(TextExtractor.extractFromT(item, textMarks));
      }
      // Can add support for other item types (tables, etc.)
    }
    return result.join('');
  }

  /**
   * Extracts text from a T element
   * @param {T} t - The text element
   * @param {TextMarks} textMarks - Text marks for special characters
   * @returns {string} Extracted text
   */
  static extractFromT(t, textMarks = new TextMarks()) {
    if (t.isOnlyText()) {
      return t.onlyText() || '';
    }

    const result = [];
    for (const item of t.items()) {
      if (item instanceof NormalText) {
        result.push(item.text() || '');
      }
      // Handle special items like LineBreak, Tab, etc.
      // For now, just extract normal text
    }
    return result.join('');
  }

  constructor(hwpxFile, method, insertParaHead, textMarks) {
    this._hwpxFile = hwpxFile;
    this._method = method;
    this._insertParaHead = insertParaHead;
    this._textMarks = textMarks;
    this._result = [];
  }

  _extract() {
    const sections = this._hwpxFile.sectionXMLFileList();
    const sectionTexts = [];

    for (let i = 0; i < sections.count(); i++) {
      const section = sections.get(i);
      const sectionText = this._extractSection(section);
      if (sectionText) {
        sectionTexts.push(sectionText);
      }
    }

    return sectionTexts.join(this._textMarks.sectionSeparator());
  }

  _extractSection(section) {
    const paraTexts = [];

    for (const para of section.paras()) {
      const paraText = this._extractPara(para);
      paraTexts.push(paraText);
    }

    return paraTexts.join(this._textMarks.paraSeparator());
  }

  _extractPara(para) {
    const runTexts = [];

    for (const run of para.runs()) {
      const runText = this._extractRun(run);
      runTexts.push(runText);
    }

    return runTexts.join('');
  }

  _extractRun(run) {
    const itemTexts = [];

    for (const item of run.runItems()) {
      if (item instanceof T) {
        itemTexts.push(this._extractT(item));
      }
      // Add support for other item types as needed
    }

    return itemTexts.join('');
  }

  _extractT(t) {
    if (t.isOnlyText()) {
      return t.onlyText() || '';
    }

    const texts = [];
    for (const item of t.items()) {
      if (item instanceof NormalText) {
        texts.push(item.text() || '');
      }
    }
    return texts.join('');
  }
}

export default TextExtractor;
