package kr.dogfoot.hwpxlib.tool.finder.comm;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.tool.finder.*;
import kr.dogfoot.hwpxlib.tool.finder.header.*;
import kr.dogfoot.hwpxlib.tool.finder.history.*;
import kr.dogfoot.hwpxlib.tool.finder.manifest.FromEncryptionData;
import kr.dogfoot.hwpxlib.tool.finder.manifest.FromFileEntry;
import kr.dogfoot.hwpxlib.tool.finder.manifest.FromManifestXMLFile;
import kr.dogfoot.hwpxlib.tool.finder.section.*;
import kr.dogfoot.hwpxlib.tool.finder.section.ctrl.*;
import kr.dogfoot.hwpxlib.tool.finder.section.object.*;
import kr.dogfoot.hwpxlib.tool.finder.section.object.comm.FromCaption;
import kr.dogfoot.hwpxlib.tool.finder.section.object.comm.FromDrawText;
import kr.dogfoot.hwpxlib.tool.finder.section.object.comm.FromRenderingInfo;
import kr.dogfoot.hwpxlib.tool.finder.section.object.picture.*;
import kr.dogfoot.hwpxlib.tool.finder.section.object.table.FromTc;
import kr.dogfoot.hwpxlib.tool.finder.section.object.table.FromTr;
import kr.dogfoot.hwpxlib.tool.finder.section.object.textart.FromTextArtPr;
import kr.dogfoot.hwpxlib.tool.finder.section.secpr.*;
import kr.dogfoot.hwpxlib.tool.finder.settings.FromConfigItemSet;
import kr.dogfoot.hwpxlib.tool.finder.settings.FromSettingsXMLFile;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FinderManager {
    private final Map<ObjectType, Queue<FinderBase>> storage;
    private final Parameter parameter;

    public FinderManager(Parameter parameter) {
        storage = new HashMap<ObjectType, Queue<FinderBase>>();
        this.parameter = parameter;
    }

    public FinderBase get(ObjectType objectType) {
        Queue<FinderBase> queue = queue(objectType);
        FinderBase finder = queue.poll();
        if (finder != null) {
            return finder;
        }
        return create(objectType);
    }

    private Queue<FinderBase> queue(ObjectType objectType) {
        Queue<FinderBase> queue = storage.get(objectType);
        if (queue == null) {
            queue = new LinkedList<FinderBase>();
            storage.put(objectType, queue);
        }
        return queue;
    }

    public void release(FinderBase finder) {
        Queue<FinderBase> queue = queue(finder._objectType());
        queue.offer(finder);
    }


    private FinderBase create(ObjectType objectType) {
        switch (objectType) {
            case HWPXFile:
                return new FromHWPXFile(this, parameter);
            case odf_manifest:
                return new FromManifestXMLFile(this, parameter);
            case odf_file_entry:
                return new FromFileEntry(this, parameter);
            case odf_encryption_data:
                return new FromEncryptionData(this, parameter);
            case ocf_container:
                return new FromContainerXMLFile(this, parameter);
            case opf_package:
                return new FromContentHPFFile(this, parameter);
            case hh_head:
                return new FromHeaderXMLFile(this, parameter);
            case hh_refList:
                return new FromRefList(this, parameter);
            case hh_fontfaces:
                return new FromFontfaces(this, parameter);
            case hh_fontface:
                return new FromFontface(this, parameter);
            case hh_font:
                return new FromFont(this, parameter);
            case hh_borderFills:
                return new FromObjectList(this, parameter, objectType);
            case hh_borderFill:
                return new FromBorderFill(this, parameter);
            case hc_fillBrush:
                return new FromFillBrush(this, parameter);
            case hc_gradation:
                return new FromGradation(this, parameter);
            case hc_imgBrush:
                return new FromImgBrush(this, parameter);
            case hh_charProperties:
                return new FromObjectList(this, parameter, objectType);
            case hh_charPr:
                return new FromCharPr(this, parameter);
            case hh_tabProperties:
                return new FromObjectList(this, parameter, objectType);
            case hh_tabPr:
                return new FromTabPr(this, parameter);
            case hh_numberings:
                return new FromObjectList(this, parameter, objectType);
            case hh_numbering:
                return new FromNumbering(this, parameter);
            case hh_bullets:
                return new FromObjectList(this, parameter, objectType);
            case hh_bullet:
                return new FromBullet(this, parameter);
            case hh_paraProperties:
                return new FromObjectList(this, parameter, objectType);
            case hh_paraPr:
                return new FromParaPr(this, parameter);
            case hh_margin:
                return new FromParaMargin(this, parameter);
            case hh_styles:
                return new FromObjectList(this, parameter, objectType);
            case hh_memoProperties:
                return new FromObjectList(this, parameter, objectType);
            case hh_trackChanges:
                return new FromObjectList(this, parameter, objectType);
            case hh_trackChangeAuthors:
                return new FromObjectList(this, parameter, objectType);
            case hh_forbiddenWordList:
                return new FromObjectList(this, parameter, objectType);
            case hh_compatibleDocument:
                return new FromCompatibleDocument(this, parameter);
            case hh_layoutCompatibility:
                return new FromObjectList(this, parameter, objectType);
            case hh_docOption:
                return new FromDocOption(this, parameter);
            case masterPage:
                return new FromMasterPageXMLFile(this, parameter);
            case hs_sec:
                return new FromSectionXMLFile(this, parameter);
            case hp_subList:
                return new FromSubList(this, parameter);
            case hp_p:
                return new FromPara(this, parameter);
            case hp_run:
                return new FromRun(this, parameter);
            case hp_secPr:
                return new FromSecPr(this, parameter);
            case hp_pagePr:
                return new FromPagePr(this, parameter);
            case hp_footNotePr:
                return new FromFootNotePr(this, parameter);
            case hp_endNotePr:
                return new FromEndNotePr(this, parameter);
            case hp_pageBorderFill:
                return new FromPageBorderFill(this, parameter);
            case hp_presentation:
                return new FromPresentation(this, parameter);
            case hp_ctrl:
                return new FromCtrl(this, parameter);
            case hp_colPr:
                return new FromColPr(this, parameter);
            case hp_fieldBegin:
                return new FromFieldBegin(this, parameter);
            case hp_parameters:
                return new FromParameterList(this, parameter, objectType);
            case hp_listParam:
                return new FromListParam(this, parameter);
            case hp_header:
            case hp_footer:
                return new FromHeaderFooter(this, parameter, objectType);
            case hp_footNote:
            case hp_endNote:
                return new FromFootNoteEndNote(this, parameter, objectType);
            case hp_autoNum:
            case hp_newNum:
                return new FromAutoNumNewNum(this, parameter, objectType);
            case hp_indexmark:
                return new FromIndexmark(this, parameter);
            case hp_hiddenComment:
                return new FromHiddenComment(this, parameter);
            case hp_t:
                return new FromT(this, parameter);
            case hp_tbl:
                return new FromTable(this, parameter);
            case hp_cellzoneList:
                return new FromObjectList(this, parameter, objectType);
            case hp_tr:
                return new FromTr(this, parameter);
            case hp_tc:
                return new FromTc(this, parameter);
            case hp_parameterset:
                return new FromParameterList(this, parameter, objectType);
            case hp_pic:
                return new FromPicture(this, parameter);
            case hp_imgRect:
                return new FromImageRect(this, parameter);
            case hp_effects:
                return new FromEffects(this, parameter);
            case hp_shadow_for_effects:
                return new FromEffectsShadow(this, parameter);
            case hp_effectsColor:
                return new FromEffectsColor(this, parameter);
            case hp_glow:
                return new FromEffectsGlow(this, parameter);
            case hp_reflection:
                return new FromEffectsReflection(this, parameter);
            case hp_container:
                return new FromContainer(this, parameter);
            case hp_ole:
                return new FromOLE(this, parameter);
            case hp_equation:
                return new FromEquation(this, parameter);
            case hp_line:
                return new FromLine(this, parameter);
            case hp_rect:
                return new FromRectangle(this, parameter);
            case hp_ellipse:
                return new FromEllipse(this, parameter);
            case hp_arc:
                return new FromArc(this, parameter);
            case hp_polygon:
                return new FromPolygon(this, parameter);
            case hp_curve:
                return new FromCurve(this, parameter);
            case hp_connectLine:
                return new FromConnectLine(this, parameter);
            case hp_textart:
                return new FromTextArt(this, parameter);
            case hp_textartPr:
                return new FromTextArtPr(this, parameter);
            case hp_outline:
                return new FromObjectList(this, parameter, objectType);
            case hp_compose:
                return new FromCompose(this, parameter);
            case hp_dutmal:
                return new FromDutmal(this, parameter);
            case hp_btn:
            case hp_radioBtn:
            case hp_checkBtn:
                return new FromButton(this, parameter, objectType);
            case hp_comboBox:
                return new FromComboBox(this, parameter);
            case hp_listBox:
                return new FromListBox(this, parameter);
            case hp_edit:
                return new FromEdit(this, parameter);
            case hp_scrollBar:
                return new FromScrollBar(this, parameter);
            case hp_video:
                return new FromVideo(this, parameter);
            case hp_chart:
                return new FromChart(this, parameter);
            case hp_caption:
                return new FromCaption(this, parameter);
            case hp_renderingInfo:
                return new FromRenderingInfo(this, parameter);
            case hp_drawText:
                return new FromDrawText(this, parameter);
            case hp_linesegarray:
                return new FromObjectList(this, parameter, objectType);
            case ha_HWPApplicationSetting:
                return new FromSettingsXMLFile(this, parameter);
            case config_item_set:
                return new FromConfigItemSet(this, parameter);
            case hhs_history:
                return new FromHistoryXMLFile(this, parameter);
            case hhs_historyEntry:
                return new FromHistoryEntry(this, parameter);
            case hhs_packageDiff:
            case hhs_headDiff:
            case hhs_bodyDiff:
                return new FromFilePartDiff(this, parameter, objectType);
            case hhs_insert:
                return new FromInsertDiff(this, parameter);
            case hhs_update:
                return new FromUpdateDiff(this, parameter);
            case hhs_delete:
                return new FromDeleteDiff(this, parameter);
        }
        return null;
    }
}
