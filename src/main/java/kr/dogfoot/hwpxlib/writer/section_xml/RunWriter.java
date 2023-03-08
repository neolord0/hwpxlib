package kr.dogfoot.hwpxlib.writer.section_xml;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.Run;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.RunItem;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class RunWriter extends ElementWriter {
    public RunWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.Run;
    }

    @Override
    public void write(HWPXObject object) {
        Run run = (Run) object;
        switchObject(run.switchObject());

        xsb()
                .openElement(ElementNames.hp_run)
                .elementWriter(this)
                .attribute(AttributeNames.charPrIDRef, run.charPrIDRef())
                .attribute(AttributeNames.charTcId, run.charTcId());

        if (run.secPr() != null) {
            writeChild(ElementWriterSort.SecPr, run.secPr());
        }

        for (RunItem runItem : run.runItems()) {
            eachRunItem(runItem);
        }

        xsb().closeElement();
        releaseMe();
    }

    private void eachRunItem(RunItem runItem) {
        switch (runItem._objectType()) {
            case hp_ctrl:
                writeChild(ElementWriterSort.Ctrl, runItem);
                break;
            case hp_t:
                writeChild(ElementWriterSort.T, runItem);
                break;
            case hp_tbl:
                writeChild(ElementWriterSort.Table, runItem);
                break;
            case hp_equation:
                writeChild(ElementWriterSort.Equation, runItem);
                break;
            case hp_chart:
                writeChild(ElementWriterSort.Chart, runItem);
                break;
            case hp_pic:
                writeChild(ElementWriterSort.Picture, runItem);
                break;
            case hp_container:
                writeChild(ElementWriterSort.ContainerControl, runItem);
                break;
            case hp_ole:
                writeChild(ElementWriterSort.OLE, runItem);
                break;
            case hp_line:
                writeChild(ElementWriterSort.Line, runItem);
                break;
            case hp_rect:
                writeChild(ElementWriterSort.Rectangle, runItem);
                break;
            case hp_ellipse:
                writeChild(ElementWriterSort.Ellipse, runItem);
                break;
            case hp_arc:
                writeChild(ElementWriterSort.Arc, runItem);
                break;
            case hp_polygon:
                writeChild(ElementWriterSort.Polygon, runItem);
                break;
            case hp_curve:
                writeChild(ElementWriterSort.Curve, runItem);
                break;
            case hp_connectLine:
                writeChild(ElementWriterSort.ConnectLine, runItem);
                break;
            case hp_textart:
                writeChild(ElementWriterSort.TextArt, runItem);
                break;
            case hp_compose:
                writeChild(ElementWriterSort.Compose, runItem);
                break;
            case hp_dutmal:
                writeChild(ElementWriterSort.Dutmal, runItem);
                break;
            case hp_btn:
                writeChild(ElementWriterSort.ButtonCore, runItem);
                break;
            case hp_radioBtn:
                writeChild(ElementWriterSort.ButtonCore, runItem);
                break;
            case hp_checkBtn:
                writeChild(ElementWriterSort.ButtonCore, runItem);
                break;
            case hp_comboBox:
                writeChild(ElementWriterSort.ComboBox, runItem);
                break;
            case hp_edit:
                writeChild(ElementWriterSort.Edit, runItem);
                break;
            case hp_listBox:
                writeChild(ElementWriterSort.ListBox, runItem);
                break;
            case hp_scrollBar:
                writeChild(ElementWriterSort.ScrollBar, runItem);
                break;
            case hp_video:
                writeChild(ElementWriterSort.Video, runItem);
                break;
        }
    }


    @Override
    protected void childInSwitch(HWPXObject child) {
        if (child._objectType() == ObjectType.hp_secPr) {
            writeChild(ElementWriterSort.SecPr, child);
        } else {
            if (child instanceof RunItem) {
                eachRunItem((RunItem) child);
            }
        }
    }
}
