package kr.dogfoot.hwpxlib.tool.textextractor;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.SectionXMLFile;
import kr.dogfoot.hwpxlib.object.content.section_xml.SubList;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.*;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Table;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.table.Tc;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.table.Tr;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.t.NormalText;

/**
 * 한글 파일에서 텍스트를 추출하는 객체
 *
 * @author woojh
 */
public class TextExtractor {

    /**
     * 텍스트를 추출한다.
     * @param hwpxFile  한글 파일 객체
     * @return          추출된 문자열
     */
    public static String extract(HWPXFile hwpxFile) {
        StringBuffer sb = new StringBuffer();
        ObjectList<SectionXMLFile> sections = hwpxFile.sectionXMLFileList();
        for (int i = 0; i < sections.count(); i++) {
            SectionXMLFile section = sections.get(i);
            for (Para para : section.paras()) {
                extractObject(para, sb);
            }
        }
        return sb.toString();
    }

    public static void extractObject(HWPXObject obj, StringBuffer sb) {
        ObjectType objectType = obj._objectType();
        switch (objectType) {
            case hp_run:
                extractRun( (Run)obj, sb);
                break;
            case hp_t:
                extractText( (T)obj, sb);
                break;
            case NormalText:
                extractNormalText( (NormalText)obj, sb);
                break;
            case hp_tbl:
                extractTable( (Table)obj, sb);
                break;
            case hp_tr:
                extractTr( (Tr)obj, sb);
                break;
            case hp_tc:
                extractTc( (Tc)obj, sb);
                break;
            case hp_subList:
                extractSubList( (SubList)obj, sb);
                break;
            case hp_p:
                extractPara( (Para)obj, sb);
                break;
            default:
                break;
        }
    }

    private static void extractRun(Run run, StringBuffer sb) {
        for (RunItem runItem : run.runItems()) {
            extractObject(runItem, sb);
        }
    }

    public static void extractText(T t, StringBuffer sb) {
        if (t.onlyText() != null) {
            sb.append(t.onlyText()).append("\n");
        }

        Iterable<TItem> items = t.items();
        if (items != null) {
            for (TItem item : items) {
                extractObject(item, sb);
            }
        }
    }

    public static void extractNormalText(NormalText normalText, StringBuffer sb) {
        sb.append(normalText.text()).append("\n");
    }

    public static void extractTable(Table t, StringBuffer sb) {
        for (Tr tr : t.trs()) {
            extractObject(tr, sb);
        }
    }

    public static void extractTr(Tr tr, StringBuffer sb) {
        for (Tc tc : tr.tcs()) {
            extractObject(tc, sb);
        }
    }

    private static void extractTc(Tc tc, StringBuffer sb) {
        SubList subList = tc.subList();
        extractObject(subList, sb);
    }

    private static void extractSubList(SubList subList, StringBuffer sb) {
        for (Para para : subList.paras()) {
            extractObject(para, sb);
        }
    }

    private static void extractPara(Para para, StringBuffer sb) {
        for (Run run : para.runs()) {
            extractObject(run, sb);
        }
    }
}
