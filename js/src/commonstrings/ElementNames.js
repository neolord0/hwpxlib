/**
 * XML Element names used in HWPX files
 */
export const ElementNames = {
  hp_switch: 'hp:switch',
  hp_case: 'hp:case',
  hp_default: 'hp:default',

  // Version.xml
  hv_HCFVersion: 'hv:HCFVersion',

  // META-INF/manifest.xml
  odf_manifest: 'odf:manifest',
  odf_file_entry: 'odf:file-entry',
  odf_encryption_data: 'odf:encryption-data',
  odf_algorithm: 'odf:algorithm',
  odf_key_derivation: 'odf:key-derivation',
  odf_start_key_generation: 'odf:start-key-generation',

  // META-INF/container.xml
  ocf_container: 'ocf:container',
  ocf_rootfiles: 'ocf:rootfiles',
  ocf_rootfile: 'ocf:rootfile',

  // Contents/content.hpf
  opf_package: 'opf:package',
  opf_metadata: 'opf:metadata',
  opf_title: 'opf:title',
  opf_language: 'opf:language',
  opf_meta: 'opf:meta',
  opf_manifest: 'opf:manifest',
  opf_item: 'opf:item',
  opf_spine: 'opf:spine',
  opf_itemref: 'opf:itemref',

  // Settings.xml
  ha_HWPApplicationSetting: 'ha:HWPApplicationSetting',
  ha_CaretPosition: 'ha:CaretPosition',
  config_item_set: 'config-item-set',
  config_item_set2: 'config:config-item-set',
  config_item: 'config-item',
  config_item2: 'config:config-item',

  // Contents/header.xml
  hh_head: 'hh:head',
  hh_beginNum: 'hh:beginNum',
  hh_refList: 'hh:refList',
  hh_fontfaces: 'hh:fontfaces',
  hh_fontface: 'hh:fontface',
  hh_font: 'hh:font',
  hh_substFont: 'hh:substFont',
  hh_typeInfo: 'hh:typeInfo',
  hh_borderFills: 'hh:borderFills',
  hh_borderFill: 'hh:borderFill',
  hh_slash: 'hh:slash',
  hh_backSlash: 'hh:backSlash',
  hh_leftBorder: 'hh:leftBorder',
  hh_rightBorder: 'hh:rightBorder',
  hh_topBorder: 'hh:topBorder',
  hh_bottomBorder: 'hh:bottomBorder',
  hh_diagonal: 'hh:diagonal',
  hc_fillBrush: 'hc:fillBrush',
  hc_winBrush: 'hc:winBrush',
  hc_gradation: 'hc:gradation',
  hc_color: 'hc:color',
  hc_imgBrush: 'hc:imgBrush',
  hc_img: 'hc:img',
  hh_charProperties: 'hh:charProperties',
  hh_charPr: 'hh:charPr',
  hh_fontRef: 'hh:fontRef',
  hh_ratio: 'hh:ratio',
  hh_spacing: 'hh:spacing',
  hh_relSz: 'hh:relSz',
  hh_offset: 'hh:offset',
  hh_bold: 'hh:bold',
  hh_italic: 'hh:italic',
  hh_underline: 'hh:underline',
  hh_strikeout: 'hh:strikeout',
  hh_outline: 'hh:outline',
  hh_shadow: 'hh:shadow',
  hh_emboss: 'hh:emboss',
  hh_engrave: 'hh:engrave',
  hh_supscript: 'hh:supscript',
  hh_subscript: 'hh:subscript',
  hh_tabProperties: 'hh:tabProperties',
  hh_tabPr: 'hh:tabPr',
  hh_tabItem: 'hh:tabItem',
  hh_numberings: 'hh:numberings',
  hh_numbering: 'hh:numbering',
  hh_paraHead: 'hh:paraHead',
  hh_bullets: 'hh:bullets',
  hh_bullet: 'hh:bullet',
  hh_paraProperties: 'hh:paraProperties',
  hh_paraPr: 'hh:paraPr',
  hh_align: 'hh:align',
  hh_heading: 'hh:heading',
  hh_breakSetting: 'hh:breakSetting',
  hh_margin: 'hh:margin',
  hc_intent: 'hc:intent',
  hc_left: 'hc:left',
  hc_right: 'hc:right',
  hc_prev: 'hc:prev',
  hc_next: 'hc:next',
  hh_lineSpacing: 'hh:lineSpacing',
  hh_border: 'hh:border',
  hh_autoSpacing: 'hh:autoSpacing',
  hh_styles: 'hh:styles',
  hh_style: 'hh:style',
  hh_memoProperties: 'hh:memoProperties',
  hh_memoPr: 'hh:memoPr',
  hh_trackChanges: 'hh:trackChanges',
  hh_trackChange: 'hh:trackChange',
  hh_trackChangeAuthors: 'hh:trackChangeAuthors',
  hh_trackChangeAuthor: 'hh:trackChangeAuthor',
  hh_forbiddenWordList: 'hh:forbiddenWordList',
  hh_forbiddenWord: 'hh:forbiddenWord',
  hh_compatibleDocument: 'hh:compatibleDocument',
  hh_layoutCompatibility: 'hh:layoutCompatibility',
  hh_docOption: 'hh:docOption',
  hh_linkinfo: 'hh:linkinfo',
  hh_metaTag: 'hh:metaTag',
  hh_trackchageConfig: 'hh:trackchageConfig',

  // Contents/section0.xml
  hs_sec: 'hs:sec',
  hp_p: 'hp:p',
  hp_run: 'hp:run',

  // secPr
  hp_secPr: 'hp:secPr',
  hp_grid: 'hp:grid',
  hp_startNum: 'hp:startNum',
  hp_visibility: 'hp:visibility',
  hp_lineNumberShape: 'hp:lineNumberShape',
  hp_pagePr: 'hp:pagePr',
  hp_margin: 'hp:margin',
  hp_footNotePr: 'hp:footNotePr',
  hp_autoNumFormat: 'hp:autoNumFormat',
  hp_noteLine: 'hp:noteLine',
  hp_noteSpacing: 'hp:noteSpacing',
  hp_numbering: 'hp:numbering',
  hp_placement: 'hp:placement',
  hp_endNotePr: 'hp:endNotePr',
  hp_pageBorderFill: 'hp:pageBorderFill',
  hp_masterPage: 'hp:masterPage',
  hp_presentation: 'hp:presentation',

  // Control characters
  hp_ctrl: 'hp:ctrl',
  hp_colPr: 'hp:colPr',
  hp_colSz: 'hp:colSz',
  hp_colLine: 'hp:colLine',
  hp_fieldBegin: 'hp:fieldBegin',
  hp_parameterset: 'hp:parameterset',
  hp_parameters: 'hp:parameters',
  hp_booleanParam: 'hp:booleanParam',
  hp_integerParam: 'hp:integerParam',
  hp_unsignedintegerParam: 'hp:unsignedintegerParam',
  hp_floatParam: 'hp:floatParam',
  hp_stringParam: 'hp:stringParam',
  hp_listParam: 'hp:listParam',
  hp_subList: 'hp:subList',
  hp_metaTag: 'hp:metaTag',
  hp_fieldEnd: 'hp:fieldEnd',
  hp_bookmark: 'hp:bookmark',
  hp_header: 'hp:header',
  hp_footer: 'hp:footer',
  hp_footNote: 'hp:footNote',
  hp_endNote: 'hp:endNote',
  hp_autoNum: 'hp:autoNum',
  hp_newNum: 'hp:newNum',
  hp_pageNumCtrl: 'hp:pageNumCtrl',
  hp_pageHiding: 'hp:pageHiding',
  hp_pageNum: 'hp:pageNum',
  hp_indexmark: 'hp:indexmark',
  hp_firstKey: 'hp:firstKey',
  hp_secondKey: 'hp:secondKey',
  hp_hiddenComment: 'hp:hiddenComment',

  hp_t: 'hp:t',
  hp_markpenBegin: 'hp:markpenBegin',
  hp_markpenEnd: 'hp:markpenEnd',
  hp_titleMark: 'hp:titleMark',
  hp_tab: 'hp:tab',
  hp_lineBreak: 'hp:lineBreak',
  hp_hyphen: 'hp:hyphen',
  hp_nbSpace: 'hp:nbSpace',
  hp_fwSpace: 'hp:fwSpace',
  hp_insertBegin: 'hp:insertBegin',
  hp_insertEnd: 'hp:insertEnd',
  hp_deleteBegin: 'hp:deleteBegin',
  hp_deleteEnd: 'hp:deleteEnd',

  // AbstractShapeObjectType
  hp_sz: 'hp:sz',
  hp_pos: 'hp:pos',
  hp_outMargin: 'hp:outMargin',
  hp_caption: 'hp:caption',
  hp_shapeComment: 'hp:shapeComment',

  // Table object
  hp_tbl: 'hp:tbl',
  hp_inMargin: 'hp:inMargin',
  hp_cellzoneList: 'hp:cellzoneList',
  hp_cellzone: 'hp:cellzone',
  hp_tr: 'hp:tr',
  hp_tc: 'hp:tc',
  hp_cellAddr: 'hp:cellAddr',
  hp_cellSpan: 'hp:cellSpan',
  hp_cellSz: 'hp:cellSz',
  hp_cellMargin: 'hp:cellMargin',
  hp_label: 'hp:label',

  // Equation object
  hp_equation: 'hp:equation',
  hp_script: 'hp:script',

  // Chart object
  hp_chart: 'hp:chart',

  // AbstractShapeComponentType
  hp_offset: 'hp:offset',
  hp_orgSz: 'hp:orgSz',
  hp_curSz: 'hp:curSz',
  hp_flip: 'hp:flip',
  hp_rotationInfo: 'hp:rotationInfo',
  hp_renderingInfo: 'hp:renderingInfo',
  hc_transMatrix: 'hc:transMatrix',
  hc_scaMatrix: 'hc:scaMatrix',
  hc_rotMatrix: 'hc:rotMatrix',

  // Picture object
  hp_pic: 'hp:pic',
  hp_lineShape: 'hp:lineShape',
  hp_imgRect: 'hp:imgRect',
  hc_pt0: 'hc:pt0',
  hc_pt1: 'hc:pt1',
  hc_pt2: 'hc:pt2',
  hc_pt3: 'hc:pt3',
  hp_imgClip: 'hp:imgClip',
  hp_imgDim: 'hp:imgDim',
  hp_effects: 'hp:effects',
  hp_skew: 'hp:skew',
  hp_scale: 'hp:scale',
  hp_effectsColor: 'hp:effectsColor',
  hp_rgb: 'hp:rgb',
  hp_cmyk: 'hp:cmyk',
  hp_scheme: 'hp:scheme',
  hp_system: 'hp:system',
  hp_effect: 'hp:effect',
  hp_glow: 'hp:glow',
  hp_softEdge: 'hp:softEdge',
  hp_reflection: 'hp:reflection',
  hp_alpha: 'hp:alpha',

  // OLE object
  hp_ole: 'hp:ole',
  hc_extent: 'hc:extent',

  // Container object
  hp_container: 'hp:container',

  // AbstractDrawingObjectType
  hp_drawText: 'hp:drawText',
  hp_textMargin: 'hp:textMargin',
  hp_shadow: 'hp:shadow',

  // Line object
  hp_line: 'hp:line',
  hc_startPt: 'hc:startPt',
  hc_endPt: 'hc:endPt',

  // Rectangle object
  hp_rect: 'hp:rect',

  // Ellipse object
  hp_ellipse: 'hp:ellipse',
  hc_center: 'hc:center',
  hc_ax1: 'hc:ax1',
  hc_ax2: 'hc:ax2',
  hc_start1: 'hc:start1',
  hc_start2: 'hc:start2',
  hc_end1: 'hc:end1',
  hc_end2: 'hc:end2',

  // Arc object
  hp_arc: 'hp:arc',

  // Polygon object
  hp_polygon: 'hp:polygon',
  hc_pt: 'hc:pt',

  // Curve object
  hp_curve: 'hp:curve',
  hp_seg: 'hp:seg',

  // ConnectLine object
  hp_connectLine: 'hp:connectLine',
  hp_startPt: 'hp:startPt',
  hp_endPt: 'hp:endPt',
  hp_controlPoints: 'hp:controlPoints',
  hp_point: 'hp:point',

  // TextArt object
  hp_textart: 'hp:textart',
  hp_textartPr: 'hp:textartPr',
  hp_outline: 'hp:outline',

  // AbstractFormObjectType
  hp_formCharPr: 'hp:formCharPr',

  // Button object
  hp_btn: 'hp:btn',

  // RadioButton object
  hp_radioBtn: 'hp:radioBtn',

  // CheckButton object
  hp_checkBtn: 'hp:checkBtn',

  // ComboBox object
  hp_comboBox: 'hp:comboBox',
  hp_listItem: 'hp:listItem',

  // ListBox object
  hp_listBox: 'hp:listBox',

  // Edit object
  hp_edit: 'hp:edit',
  hp_text: 'hp:text',

  // ScrollBar object
  hp_scrollBar: 'hp:scrollBar',

  // Video object
  hp_video: 'hp:video',

  // Compose object
  hp_compose: 'hp:compose',
  hp_charPr: 'hp:charPr',

  // Dutmal object
  hp_dutmal: 'hp:dutmal',
  hp_mainText: 'hp:mainText',
  hp_subText: 'hp:subText',

  hp_linesegarray: 'hp:linesegarray',
  hp_lineseg: 'hp:lineseg',

  masterPage: 'masterPage',

  // Document history
  hhs_history: 'hhs:history',
  hhs_historyEntry: 'hhs:historyEntry',
  hhs_packageDiff: 'hhs:packageDiff',
  hhs_headDiff: 'hhs:headDiff',
  hhs_bodyDiff: 'hhs:bodyDiff',
  hhs_insert: 'hhs:insert',
  hhs_update: 'hhs:update',
  hhs_delete: 'hhs:delete',
  b_Sources: 'b:Sources'
};

export default ElementNames;
