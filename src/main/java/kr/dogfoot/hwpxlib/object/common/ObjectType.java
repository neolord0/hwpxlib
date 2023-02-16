package kr.dogfoot.hwpxlib.object.common;

public enum ObjectType {
    Unknown,
    HWPXFile,
    hp_switch,
    hp_case,
    hp_default,
    hp_parameterset,
    hp_parameters,
    hp_booleanParam,
    hp_integerParam,
    hp_floatParam,
    hp_stringParam,
    hp_ListParam,

    // Version.xml
    hv_HCFVersion,

    // META-INF/manifest.xml
    odf_manifest,
    odf_file_entry,
    odf_encryption_data,
    odf_algorithm,
    odf_key_derivation,
    odf_start_key_generation,

    // META-INF/container.xml
    ocf_container,
    ocf_rootfiles,
    ocf_rootfile,

    // Contents/content.hpf
    opf_package,
    opf_metadata,
    opf_title,
    opf_language,
    opf_meta,
    opf_manifest,
    opf_item,
    opf_spine,
    opf_itemref,

    // Settings.xml
    ha_HWPApplicationSetting,
    ha_CaretPosition,
    config_item_set,
    config_item,


    // Contents/header_forTestSwitch.xml
    hh_head,
    hh_beginNum,
    hh_refList,
    hh_fontfaces,
    hh_fontface,
    hh_font,
    hh_substFont,
    hh_typeInfo,
    hh_borderFills,
    hh_borderFill,
    hh_slash,
    hh_backSlash,
    hh_leftBorder,
    hh_rightBorder,
    hh_topBorder,
    hh_bottomBorder,
    hh_diagonal,
    hc_fillBrush,
    hc_winBrush,
    hc_gradation,
    hc_color,
    hc_imgBrush,
    hc_img,
    hh_charProperties,
    hh_charPr,
    hh_fontRef,
    hh_ratio,
    hh_spacing,
    hh_relSz,
    hh_offset,
    hh_bold,
    Italic,
    hh_underline,
    hh_strikeout,
    hh_outline,
    hh_shadow,
    hh_emboss,
    hh_engrave,
    hh_supscript,
    hh_subscript,
    hh_tabProperties,
    hh_tabPr,
    hh_tabItem,
    hh_numberings,
    hh_numbering,
    hh_paraHead,
    hh_bullets,
    hh_bullet,
    hh_paraProperties,
    hh_paraPr,
    hh_align,
    hh_heading,
    hh_breakSetting,
    hh_margin,
    hc_intent,
    hc_left,
    hc_right,
    hc_prev,
    hc_next,
    hh_lineSpacing,
    hh_border,
    hh_autoSpacing,
    hh_styles,
    hh_style,
    hh_memoProperties,
    hh_memoPr,
    hh_trackChanges,
    hh_trackChange,
    hh_trackChangeAuthors,
    hh_trackChangeAuthor,
    hh_forbiddenWordList,
    hh_forbiddenWord,
    hh_compatibleDocument,
    hh_layoutCompatibility,
    each_layoutCompatibilityItem,
    hh_docOption,
    hh_linkinfo,
    hh_trackchageConfig,

    // Contents/section0.xml
    hs_sec,
    hp_p,
    hp_run,
    hp_subList,

    // secPr
    hp_secPr,
    hp_grid,
    hp_startNum,
    hp_visibility,
    hp_lineNumberShape,
    hp_pagePr,
    hp_margin,
    hp_footNotePr,
    hp_autoNumFormat,
    hp_noteLine,
    hp_noteSpacing,
    hp_numbering_for_footnote,
    hp_placement_for_footnote,
    hp_endNotePr,
    hp_numbering_for_endnote,
    hp_placement_for_endnote,
    hp_pageBorderFill,
    hp_offset_for_pageBorderFill,
    hp_masterPage,
    hp_presentation,

    // 컨트롤 문자들
    hp_ctrl,
    hp_colPr,  // 단 설정
    hp_colSz,
    hp_colLine,
    hp_fieldBegin, // 필드 시작
    hp_fieldEnd,     // 필드 끝
    hp_bookmark,    // 책갈피
    hp_header,    // 머리말
    hp_footer,    // 꼬리말
    hp_footNote, // 각주
    hp_endNote,  // 미주
    hp_autoNum,  // 자동 번호
    hp_newNum,    // 새 번호
    hp_pageNumCtrl,
    hp_pageHiding,    // 감추기
    hp_pageNum,  // 쪽 번호 위치
    hp_indexmark, // 색인
    hp_firstKey,
    hp_secondKey,
    hp_hiddenComment,  // 숨믄 설명

    hp_t,
    hp_markpenBegin,    // 형광팬 시작
    hp_markpenEnd,    // 형광팬 끝
    hp_titleMark,  // 제목 차래 표시
    hp_tab,  // 탭
    hp_lineBreak,  // 강제 줄나눔
    hp_hyphen,    // 하이픈
    hp_nbSpace,
    hp_fwSpace,
    hp_insertBegin,  // 삽입 시작
    hp_insertEnd,  // 삽입 끝
    hp_deleteBegin,  // 삭제 시작
    hp_deleteEnd, // 삭제 끝

    // AbstractShapeObjectType
    hp_sz,
    hp_pos_for_shapeObject,
    hp_outMargin,
    hp_caption,
    hp_shapeComment,

    // 표 개체
    hp_tbl,
    hp_inMargin,
    hp_cellzoneList,
    hp_cellzone,
    hp_tr,
    hp_tc,
    hp_cellAddr,
    hp_cellSpan,
    hp_cellSz,
    hp_cellMargin,

    // 수식 개체
    hp_equation,
    hp_script,

    hp_chart,

    // AbstractShapeComponentType
    hp_offset_for_shapeComponent,
    hp_orgSz,
    hp_curSz,
    hp_flip,
    hp_rotationInfo,
    hp_renderingInfo,
    hc_transMatrix,
    hc_scaMatrix,
    hc_rotMatrix,

    // 그림 개체
    hp_pic,
    hp_lineShape,
    hp_imgRect,
    hc_pt0,
    hc_pt1,
    hc_pt2,
    hc_pt3,
    hp_imgClip,
    hp_imgDim,
    hp_effects,
    hp_shadow_for_effects,
    hp_skew,
    hp_scale,
    hp_effectsColor,
    hp_rgb,
    hp_cmyk,
    hp_scheme,
    hp_system,
    hp_effect,
    hp_glow,
    hp_softEdge,
    hp_reflection,
    hp_alpha,
    hp_pos,

    // ole 개체
    hp_ole,
    hc_extent,

    // 묶음 개체
    hp_container,

    // AbstractDrawingObjectType
    hp_drawText,
    hp_textMargin,
    hp_shadow_for_drawingObject,

    // 선 개체
    hp_line,
    hc_startPt,
    hc_endPt,

    // 사각형 개체
    hp_rect,

    // 타원 개체
    hp_ellipse,
    hc_center,
    hc_ax1,
    hc_ax2,
    hc_start1,
    hc_start2,
    hc_end1,
    hc_end2,

    // 호 개체
    hp_arc,

    // 다각형 개체
    hp_polygon,
    hc_pt,

    // 곡선 개체
    hp_curve,
    hp_seg,

    // 연결선 개체
    hp_connectLine,
    hp_startPt,
    hp_endPt,

    // 글맵시 개체
    hp_textart,
    hp_textartPr,
    hp_outline,

    // AbstractFormObjectType
    hp_formCharPr,

    // 버튼 개체
    hp_btn,

    // 라디오버튼 개체
    hp_radioBtn,

    // 채크버튼 개체
    hp_checkBtn,

    // 콤보박스 개체
    hp_comboBox,
    hp_listItem,

    // 리스트박스 개체
    hp_listBox,

    // 에디트박스 개체
    hp_edit,
    hp_text,

    // 스크롤바 개체
    hp_scrollBar,

    // 비디오 개체
    hp_video,

    // 글자겹침 개체
    hp_compose,
    hp_charPr,

    // 덧말 개체
    hp_dutmal,
    hp_mainText,
    hp_subText,

    hp_linesegarray,
    hp_lineseg,

    masterPage,

    // 문사이력 파일
    hhs_history,
    hhs_historyEntry,
    hhs_packageDiff,
    hhs_headDiff,
    hhs_bodyDiff,
    hhs_insert,
    hhs_update,
    hhs_delete
}


