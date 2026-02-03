import { HWPXFile } from '../../object/HWPXFile.js';
import { TargetApplicationSort } from '../../object/root/VersionXMLFile.js';
import { MimeTypes } from '../../commonstrings/MimeTypes.js';

/**
 * Creates blank HWPX files
 */
export class BlankFileMaker {
  /**
   * Creates a new blank HWPX file
   * @returns {HWPXFile}
   */
  static make() {
    const hwpxFile = new HWPXFile();

    BlankFileMaker._setupSettingsXMLFile(hwpxFile.settingsXMLFile());
    BlankFileMaker._setupVersionXMLFile(hwpxFile.versionXMLFile());
    BlankFileMaker._setupContainerXMLFile(hwpxFile.containerXMLFile());
    BlankFileMaker._setupContentHPFFile(hwpxFile.contentHPFFile());
    BlankFileMaker._setupHeaderXMLFile(hwpxFile.headerXMLFile());
    BlankFileMaker._setupSectionXMLFile(hwpxFile.sectionXMLFileList().addNew());

    return hwpxFile;
  }

  static _setupSettingsXMLFile(settingsXMLFile) {
    settingsXMLFile.createCaretPosition();
    settingsXMLFile.caretPosition()
      .listIDRefAnd(0)
      .paraIDRefAnd(0)
      .posAnd(16);
  }

  static _setupVersionXMLFile(versionXMLFile) {
    versionXMLFile
      .targetApplicationAnd(TargetApplicationSort.WordProcessor)
      .applicationAnd('hwpxlib-js')
      .appVersionAnd('1.0.0');

    versionXMLFile.version()
      .majorAnd(5)
      .minorAnd(0)
      .microAnd(5)
      .buildNumberAnd(0);
  }

  static _setupContainerXMLFile(containerXMLFile) {
    containerXMLFile.createRootFiles();

    containerXMLFile.rootFiles().addNew()
      .fullPathAnd('Contents/content.hpf')
      .mediaTypeAnd(MimeTypes.HWPML_Package);
  }

  static _setupContentHPFFile(contentHPFFile) {
    contentHPFFile.versionSet('1.0');
    contentHPFFile.uniqueIdentifierSet('bookid');

    contentHPFFile.createManifest();
    const manifest = contentHPFFile.manifest();

    // Settings
    manifest.addItem()
      .idAnd('settings')
      .hrefAnd('Contents/settings.xml')
      .mediaTypeAnd(MimeTypes.XML);

    // Header
    manifest.addItem()
      .idAnd('header')
      .hrefAnd('Contents/header.xml')
      .mediaTypeAnd(MimeTypes.XML);

    // Section 0
    manifest.addItem()
      .idAnd('section0')
      .hrefAnd('Contents/section0.xml')
      .mediaTypeAnd(MimeTypes.XML);

    // Spine
    contentHPFFile.createSpine();
    contentHPFFile.spine().addItemRef().idrefAnd('section0');
  }

  static _setupHeaderXMLFile(headerXMLFile) {
    // Minimal header setup - can be expanded as needed
    // For a blank file, default values are sufficient
  }

  static _setupSectionXMLFile(sectionXMLFile) {
    // Add one empty paragraph
    const para = sectionXMLFile.addNewPara();
    para.idAnd('0')
      .paraPrIDRefAnd('0')
      .styleIDRefAnd('0');

    // Add one empty run with empty text
    const run = para.addNewRun();
    run.charPrIDRefAnd('0');

    const t = run.addNewT();
    t.addText('');
  }
}

export default BlankFileMaker;
