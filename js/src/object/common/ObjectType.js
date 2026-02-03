/**
 * Object types used in HWPX file structure
 */
export const ObjectType = {
  Unknown: 'Unknown',
  NormalText: 'NormalText',
  HWPXFile: 'HWPXFile',
  hp_switch: 'hp_switch',
  hp_case: 'hp_case',
  hp_default: 'hp_default',
  hp_parameterset: 'hp_parameterset',
  hp_parameters: 'hp_parameters',
  hp_booleanParam: 'hp_booleanParam',
  hp_integerParam: 'hp_integerParam',
  hp_unsignedintegerParam: 'hp_unsignedintegerParam',
  hp_floatParam: 'hp_floatParam',
  hp_stringParam: 'hp_stringParam',
  hp_listParam: 'hp_listParam',

  // Version.xml
  hv_HCFVersion: 'hv_HCFVersion',

  // META-INF/manifest.xml
  odf_manifest: 'odf_manifest',
  odf_file_entry: 'odf_file_entry',
  odf_encryption_data: 'odf_encryption_data',
  odf_algorithm: 'odf_algorithm',
  odf_key_derivation: 'odf_key_derivation',
  odf_start_key_generation: 'odf_start_key_generation',

  // META-INF/container.xml
  ocf_container: 'ocf_container',
  ocf_rootfiles: 'ocf_rootfiles',
  ocf_rootfile: 'ocf_rootfile',

  // Contents/content.hpf
  opf_package: 'opf_package',
  opf_metadata: 'opf_metadata',
  opf_title: 'opf_title',
  opf_language: 'opf_language',
  opf_meta: 'opf_meta',
  opf_manifest: 'opf_manifest',
  opf_item: 'opf_item',
  opf_spine: 'opf_spine',
  opf_itemref: 'opf_itemref',

  // Settings.xml
  ha_HWPApplicationSetting: 'ha_HWPApplicationSetting',
  ha_CaretPosition: 'ha_CaretPosition',
  config_item_set: 'config_item_set',
  config_item: 'config_item',

  // Contents/header.xml
  hh_head: 'hh_head',
  hh_beginNum: 'hh_beginNum',
  hh_refList: 'hh_refList',
  hh_fontfaces: 'hh_fontfaces',
  hh_fontface: 'hh_fontface',
  hh_font: 'hh_font',
  hh_substFont: 'hh_substFont',
  hh_typeInfo: 'hh_typeInfo',
  hh_borderFills: 'hh_borderFills',
  hh_borderFill: 'hh_borderFill',
  hh_slash: 'hh_slash',
  hh_backSlash: 'hh_backSlash',
  hh_leftBorder: 'hh_leftBorder',
  hh_rightBorder: 'hh_rightBorder',
  hh_topBorder: 'hh_topBorder',
  hh_bottomBorder: 'hh_bottomBorder',
  hh_diagonal: 'hh_diagonal',
  hc_fillBrush: 'hc_fillBrush',
  hc_winBrush: 'hc_winBrush',
  hc_gradation: 'hc_gradation',
  hc_color: 'hc_color',
  hc_imgBrush: 'hc_imgBrush',
  hc_img: 'hc_img',
  hh_charProperties: 'hh_charProperties',
  hh_charPr: 'hh_charPr',
  hh_fontRef: 'hh_fontRef',
  hh_ratio: 'hh_ratio',
  hh_spacing: 'hh_spacing',
  hh_relSz: 'hh_relSz',
  hh_offset: 'hh_offset',
  hh_bold: 'hh_bold',
  hh_italic: 'hh_italic',
  hh_underline: 'hh_underline',
  hh_strikeout: 'hh_strikeout',
  hh_outline: 'hh_outline',
  hh_shadow: 'hh_shadow',
  hh_emboss: 'hh_emboss',
  hh_engrave: 'hh_engrave',
  hh_supscript: 'hh_supscript',
  hh_subscript: 'hh_subscript',
  hh_tabProperties: 'hh_tabProperties',
  hh_tabPr: 'hh_tabPr',
  hh_tabItem: 'hh_tabItem',
  hh_numberings: 'hh_numberings',
  hh_numbering: 'hh_numbering',
  hh_paraHead: 'hh_paraHead',
  hh_bullets: 'hh_bullets',
  hh_bullet: 'hh_bullet',
  hh_paraProperties: 'hh_paraProperties',
  hh_paraPr: 'hh_paraPr',
  hh_align: 'hh_align',
  hh_heading: 'hh_heading',
  hh_breakSetting: 'hh_breakSetting',
  hh_margin: 'hh_margin',
  hc_intent: 'hc_intent',
  hc_left: 'hc_left',
  hc_right: 'hc_right',
  hc_prev: 'hc_prev',
  hc_next: 'hc_next',
  hh_lineSpacing: 'hh_lineSpacing',
  hh_border: 'hh_border',
  hh_autoSpacing: 'hh_autoSpacing',
  hh_styles: 'hh_styles',
  hh_style: 'hh_style',
  hh_memoProperties: 'hh_memoProperties',
  hh_memoPr: 'hh_memoPr',
  hh_trackChanges: 'hh_trackChanges',
  hh_trackChange: 'hh_trackChange',
  hh_trackChangeAuthors: 'hh_trackChangeAuthors',
  hh_trackChangeAuthor: 'hh_trackChangeAuthor',
  hh_forbiddenWordList: 'hh_forbiddenWordList',
  hh_forbiddenWord: 'hh_forbiddenWord',
  hh_compatibleDocument: 'hh_compatibleDocument',
  hh_layoutCompatibility: 'hh_layoutCompatibility',
  each_layoutCompatibilityItem: 'each_layoutCompatibilityItem',
  hh_docOption: 'hh_docOption',
  hh_linkinfo: 'hh_linkinfo',
  hh_metaTag: 'hh_metaTag',
  hh_trackchageConfig: 'hh_trackchageConfig',

  // Contents/section0.xml
  hs_sec: 'hs_sec',
  hp_p: 'hp_p',
  hp_run: 'hp_run',
  hp_subList: 'hp_subList',

  // secPr
  hp_secPr: 'hp_secPr',
  hp_grid: 'hp_grid',
  hp_startNum: 'hp_startNum',
  hp_visibility: 'hp_visibility',
  hp_lineNumberShape: 'hp_lineNumberShape',
  hp_pagePr: 'hp_pagePr',
  hp_margin: 'hp_margin',
  hp_footNotePr: 'hp_footNotePr',
  hp_autoNumFormat: 'hp_autoNumFormat',
  hp_noteLine: 'hp_noteLine',
  hp_noteSpacing: 'hp_noteSpacing',
  hp_numbering_for_footnote: 'hp_numbering_for_footnote',
  hp_placement_for_footnote: 'hp_placement_for_footnote',
  hp_endNotePr: 'hp_endNotePr',
  hp_numbering_for_endnote: 'hp_numbering_for_endnote',
  hp_placement_for_endnote: 'hp_placement_for_endnote',
  hp_pageBorderFill: 'hp_pageBorderFill',
  hp_offset_for_pageBorderFill: 'hp_offset_for_pageBorderFill',
  hp_masterPage: 'hp_masterPage',
  hp_presentation: 'hp_presentation',

  // Control characters
  hp_ctrl: 'hp_ctrl',
  hp_colPr: 'hp_colPr',
  hp_colSz: 'hp_colSz',
  hp_colLine: 'hp_colLine',
  hp_fieldBegin: 'hp_fieldBegin',
  hp_metaTag: 'hp_metaTag',
  hp_fieldEnd: 'hp_fieldEnd',
  hp_bookmark: 'hp_bookmark',
  hp_header: 'hp_header',
  hp_footer: 'hp_footer',
  hp_footNote: 'hp_footNote',
  hp_endNote: 'hp_endNote',
  hp_autoNum: 'hp_autoNum',
  hp_newNum: 'hp_newNum',
  hp_pageNumCtrl: 'hp_pageNumCtrl',
  hp_pageHiding: 'hp_pageHiding',
  hp_pageNum: 'hp_pageNum',
  hp_indexmark: 'hp_indexmark',
  hp_firstKey: 'hp_firstKey',
  hp_secondKey: 'hp_secondKey',
  hp_hiddenComment: 'hp_hiddenComment',

  hp_t: 'hp_t',
  hp_markpenBegin: 'hp_markpenBegin',
  hp_markpenEnd: 'hp_markpenEnd',
  hp_titleMark: 'hp_titleMark',
  hp_tab: 'hp_tab',
  hp_lineBreak: 'hp_lineBreak',
  hp_hyphen: 'hp_hyphen',
  hp_nbSpace: 'hp_nbSpace',
  hp_fwSpace: 'hp_fwSpace',
  hp_insertBegin: 'hp_insertBegin',
  hp_insertEnd: 'hp_insertEnd',
  hp_deleteBegin: 'hp_deleteBegin',
  hp_deleteEnd: 'hp_deleteEnd',

  // AbstractShapeObjectType
  hp_sz: 'hp_sz',
  hp_pos_for_shapeObject: 'hp_pos_for_shapeObject',
  hp_outMargin: 'hp_outMargin',
  hp_caption: 'hp_caption',
  hp_shapeComment: 'hp_shapeComment',

  // Table object
  hp_tbl: 'hp_tbl',
  hp_inMargin: 'hp_inMargin',
  hp_cellzoneList: 'hp_cellzoneList',
  hp_cellzone: 'hp_cellzone',
  hp_tr: 'hp_tr',
  hp_tc: 'hp_tc',
  hp_cellAddr: 'hp_cellAddr',
  hp_cellSpan: 'hp_cellSpan',
  hp_cellSz: 'hp_cellSz',
  hp_cellMargin: 'hp_cellMargin',
  hp_label: 'hp_label',

  // Equation object
  hp_equation: 'hp_equation',
  hp_script: 'hp_script',

  hp_chart: 'hp_chart',

  // AbstractShapeComponentType
  hp_offset_for_shapeComponent: 'hp_offset_for_shapeComponent',
  hp_orgSz: 'hp_orgSz',
  hp_curSz: 'hp_curSz',
  hp_flip: 'hp_flip',
  hp_rotationInfo: 'hp_rotationInfo',
  hp_renderingInfo: 'hp_renderingInfo',
  hc_transMatrix: 'hc_transMatrix',
  hc_scaMatrix: 'hc_scaMatrix',
  hc_rotMatrix: 'hc_rotMatrix',

  // Picture object
  hp_pic: 'hp_pic',
  hp_lineShape: 'hp_lineShape',
  hp_imgRect: 'hp_imgRect',
  hc_pt0: 'hc_pt0',
  hc_pt1: 'hc_pt1',
  hc_pt2: 'hc_pt2',
  hc_pt3: 'hc_pt3',
  hp_imgClip: 'hp_imgClip',
  hp_imgDim: 'hp_imgDim',
  hp_effects: 'hp_effects',
  hp_shadow_for_effects: 'hp_shadow_for_effects',
  hp_skew: 'hp_skew',
  hp_scale: 'hp_scale',
  hp_effectsColor: 'hp_effectsColor',
  hp_rgb: 'hp_rgb',
  hp_cmyk: 'hp_cmyk',
  hp_scheme: 'hp_scheme',
  hp_system: 'hp_system',
  hp_effect: 'hp_effect',
  hp_glow: 'hp_glow',
  hp_softEdge: 'hp_softEdge',
  hp_reflection: 'hp_reflection',
  hp_alpha: 'hp_alpha',
  hp_pos: 'hp_pos',

  // OLE object
  hp_ole: 'hp_ole',
  hc_extent: 'hc_extent',

  // Container object
  hp_container: 'hp_container',

  // AbstractDrawingObjectType
  hp_drawText: 'hp_drawText',
  hp_textMargin: 'hp_textMargin',
  hp_shadow_for_drawingObject: 'hp_shadow_for_drawingObject',

  // Line object
  hp_line: 'hp_line',
  hc_startPt: 'hc_startPt',
  hc_endPt: 'hc_endPt',

  // Rectangle object
  hp_rect: 'hp_rect',

  // Ellipse object
  hp_ellipse: 'hp_ellipse',
  hc_center: 'hc_center',
  hc_ax1: 'hc_ax1',
  hc_ax2: 'hc_ax2',
  hc_start1: 'hc_start1',
  hc_start2: 'hc_start2',
  hc_end1: 'hc_end1',
  hc_end2: 'hc_end2',

  // Arc object
  hp_arc: 'hp_arc',

  // Polygon object
  hp_polygon: 'hp_polygon',
  hc_pt: 'hc_pt',

  // Curve object
  hp_curve: 'hp_curve',
  hp_seg: 'hp_seg',

  // ConnectLine object
  hp_connectLine: 'hp_connectLine',
  hp_startPt: 'hp_startPt',
  hp_endPt: 'hp_endPt',
  hp_controlPoints: 'hp_controlPoints',
  hp_point: 'hp_point',

  // TextArt object
  hp_textart: 'hp_textart',
  hp_textartPr: 'hp_textartPr',
  hp_outline: 'hp_outline',

  // AbstractFormObjectType
  hp_formCharPr: 'hp_formCharPr',

  // Button object
  hp_btn: 'hp_btn',

  // RadioButton object
  hp_radioBtn: 'hp_radioBtn',

  // CheckButton object
  hp_checkBtn: 'hp_checkBtn',

  // ComboBox object
  hp_comboBox: 'hp_comboBox',
  hp_listItem: 'hp_listItem',

  // ListBox object
  hp_listBox: 'hp_listBox',

  // Edit object
  hp_edit: 'hp_edit',
  hp_text: 'hp_text',

  // ScrollBar object
  hp_scrollBar: 'hp_scrollBar',

  // Video object
  hp_video: 'hp_video',

  // Compose object
  hp_compose: 'hp_compose',
  hp_charPr: 'hp_charPr',

  // Dutmal object
  hp_dutmal: 'hp_dutmal',
  hp_mainText: 'hp_mainText',
  hp_subText: 'hp_subText',

  hp_linesegarray: 'hp_linesegarray',
  hp_lineseg: 'hp_lineseg',

  masterPage: 'masterPage',

  // Document history
  hhs_history: 'hhs_history',
  hhs_historyEntry: 'hhs_historyEntry',
  hhs_packageDiff: 'hhs_packageDiff',
  hhs_headDiff: 'hhs_headDiff',
  hhs_bodyDiff: 'hhs_bodyDiff',
  hhs_insert: 'hhs_insert',
  hhs_update: 'hhs_update',
  hhs_delete: 'hhs_delete',

  // Chart
  c_chartSpace: 'c_chartSpace'
};

export default ObjectType;
