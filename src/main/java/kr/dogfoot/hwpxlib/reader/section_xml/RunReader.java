package kr.dogfoot.hwpxlib.reader.section_xml;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.*;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.*;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.SecPr;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.section_xml.control.*;
import kr.dogfoot.hwpxlib.reader.section_xml.ctrl.CtrlReader;
import kr.dogfoot.hwpxlib.reader.section_xml.secpr.SecPrReader;
import kr.dogfoot.hwpxlib.reader.section_xml.t.TReader;
import kr.dogfoot.hwpxlib.util.AttributeNames;
import kr.dogfoot.hwpxlib.util.ElementNames;
import org.xml.sax.Attributes;

public class RunReader extends ElementReader {
    private Run run;


    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Run;
    }

    public void run(Run run) {
        this.run = run;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.charPrIDRef:
                run.charPrIDRef(value);
                break;
            case AttributeNames.charTcId:
                run.charTcId(value);
                break;
        }
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.SecPr:
                run.createSecPr();
                secPr(run.secPr(), name, attrs);
                break;
            case ElementNames.Ctrl:
                ctrl(run.addNewCtrl(), name, attrs);
                break;
            case ElementNames.T:
                t(run.addNewT(), name, attrs);
                break;
            case ElementNames.Tbl:
                tbl(run.addNewTable(), name, attrs);
                break;
            case ElementNames.Pic:
                pic(run.addNewPicture(), name, attrs);
                break;
            case ElementNames.OLE:
                ole(run.addNewOLE(), name, attrs);
                break;
            case ElementNames.Container:
                container(run.addNewContainer(), name, attrs);
                break;
            case ElementNames.Equation:
                equation(run.addNewEquation(), name, attrs);
                break;
            case ElementNames.Line:
                line(run.addNewLine(), name, attrs);
                break;
            case ElementNames.Rect:
                rect(run.addNewRectangle(), name, attrs);
                break;
            case ElementNames.Ellipse:
                ellipse(run.addNewEllipse(), name, attrs);
                break;
            case ElementNames.Arc:
                arc(run.addNewArc(), name, attrs);
                break;
            case ElementNames.Polygon:
                polygon(run.addNewPolygon(), name, attrs);
                break;
            case ElementNames.Curve:
                curve(run.addNewCurve(), name, attrs);
                break;
            case ElementNames.ConnectLine:
                connectLine(run.addNewConnectLine(), name, attrs);
                break;
            case ElementNames.TextArt:
                textArt(run.addNewTextArt(), name, attrs);
                break;
            case ElementNames.Compose:
                compose(run.addNewCompose(), name, attrs);
                break;
            case ElementNames.Dutmal:
                dutmal(run.addNewDutmal(), name, attrs);
                break;
            case ElementNames.Btn:
                btn(run.addNewButton(), name, attrs);
                break;
            case ElementNames.RadioBtn:
                radioBtn(run.addNewRadioButton(), name, attrs);
                break;
            case ElementNames.CheckBtn:
                checkBtn(run.addNewCheckButton(), name, attrs);
                break;
            case ElementNames.ComboBox:
                comboBox(run.addNewComboBox(), name, attrs);
                break;
            case ElementNames.Edit:
                edit(run.addNewEdit(), name, attrs);
                break;
            case ElementNames.ListBox:
                listBox(run.addNewListBox(), name, attrs);
                break;
            case ElementNames.ScrollBar:
                scrollBar(run.addNewScrollBar(), name, attrs);
                break;
            case ElementNames.Video:
                video(run.addNewVideo(), name, attrs);
                break;
        }
    }

    @Override
    public void childElementInSwitch(HWPXObject child, String name, Attributes attrs) {
        if (child.objectType() == ObjectType.SecPr) {
            secPr((SecPr) child, name, attrs);
        } else if (child.objectType() == ObjectType.Ctrl) {
            ctrl((Ctrl) child, name, attrs);
        } else if (child.objectType() == ObjectType.T) {
            t((T) child, name, attrs);
        } else if (child.objectType() == ObjectType.Tbl) {
            tbl((Table) child, name, attrs);
        } else if (child.objectType() == ObjectType.Pic) {
            pic((Picture) child, name, attrs);
        } else if (child.objectType() == ObjectType.OLE) {
            ole((OLE) child, name, attrs);
        } else if (child.objectType() == ObjectType.Container) {
            container((Container) child, name, attrs);
        } else if (child.objectType() == ObjectType.Equation) {
            equation((Equation) child, name, attrs);
        } else if (child.objectType() == ObjectType.Line) {
            line((Line) child, name, attrs);
        } else if (child.objectType() == ObjectType.Rect) {
            rect((Rectangle) child, name, attrs);
        } else if (child.objectType() == ObjectType.Ellipse) {
            ellipse((Ellipse) child, name, attrs);
        } else if (child.objectType() == ObjectType.Arc) {
            arc((Arc) child, name, attrs);
        } else if (child.objectType() == ObjectType.Polygon) {
            polygon((Polygon) child, name, attrs);
        } else if (child.objectType() == ObjectType.Curve) {
            curve((Curve) child, name, attrs);
        } else if (child.objectType() == ObjectType.ConnectLine) {
            connectLine((ConnectLine) child, name, attrs);
        } else if (child.objectType() == ObjectType.TextArt) {
            textArt((TextArt) child, name, attrs);
        } else if (child.objectType() == ObjectType.Compose) {
            compose((Compose) child, name, attrs);
        } else if (child.objectType() == ObjectType.Dutmal) {
            dutmal((Dutmal) child, name, attrs);
        } else if (child.objectType() == ObjectType.Btn) {
            btn((Button) child, name, attrs);
        } else if (child.objectType() == ObjectType.RadioBtn) {
            radioBtn((RadioButton) child, name, attrs);
        } else if (child.objectType() == ObjectType.CheckBtn) {
            checkBtn((CheckButton) child, name, attrs);
        } else if (child.objectType() == ObjectType.ComboBox) {
            comboBox((ComboBox) child, name, attrs);
        } else if (child.objectType() == ObjectType.Edit) {
            edit((Edit) child, name, attrs);
        } else if (child.objectType() == ObjectType.ListBox) {
            listBox((ListBox) child, name, attrs);
        } else if (child.objectType() == ObjectType.ScrollBar) {
            scrollBar((ScrollBar) child, name, attrs);
        } else if (child.objectType() == ObjectType.Video) {
            video((Video) child, name, attrs);
        }
    }


    private void secPr(SecPr secPr, String name, Attributes attrs) {
        ((SecPrReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.SecPr))
                .secPr(secPr);

        xmlFileReader().startElement(name, attrs);
    }

    private void ctrl(Ctrl ctrl, String name, Attributes attrs) {
        ((CtrlReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.Ctrl))
                .ctrl(ctrl);

        xmlFileReader().startElement(name, attrs);
    }

    private void t(T t, String name, Attributes attrs) {
        ((TReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.T))
                .t(t);

        xmlFileReader().startElement(name, attrs);
    }

    private void tbl(Table table, String name, Attributes attrs) {
        ((TableReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.Tbl))
                .table(table);

        xmlFileReader().startElement(name, attrs);
    }

    private void pic(Picture picture, String name, Attributes attrs) {
        ((PictureReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.Pic))
                .picture(picture);

        xmlFileReader().startElement(name, attrs);
    }


    private void container(Container container, String name, Attributes attrs) {
        ((ContainerControlReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.ContainerControl))
                .container(container);

        xmlFileReader().startElement(name, attrs);
    }

    private void ole(OLE ole, String name, Attributes attrs) {
        ((OLEReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.OLE))
                .ole(ole);

        xmlFileReader().startElement(name, attrs);
    }

    private void equation(Equation equation, String name, Attributes attrs) {
        ((EquationReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.Equation))
                .equation(equation);

        xmlFileReader().startElement(name, attrs);
    }

    private void line(Line line, String name, Attributes attrs) {
        ((LineReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.Line))
                .line(line);

        xmlFileReader().startElement(name, attrs);
    }

    private void rect(Rectangle rectangle, String name, Attributes attrs) {
        ((RectangleReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.Rect))
                .rectangle(rectangle);

        xmlFileReader().startElement(name, attrs);
    }

    private void ellipse(Ellipse ellipse, String name, Attributes attrs) {
        ((EllipseReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.Ellipse))
                .ellipse(ellipse);

        xmlFileReader().startElement(name, attrs);
    }

    private void arc(Arc arc, String name, Attributes attrs) {
        ((ArcReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.Arc))
                .arc(arc);

        xmlFileReader().startElement(name, attrs);
    }

    private void polygon(Polygon polygon, String name, Attributes attrs) {
        ((PolygonReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.Polygon))
                .polygon(polygon);

        xmlFileReader().startElement(name, attrs);
    }

    private void curve(Curve curve, String name, Attributes attrs) {
        ((CurveReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.Curve))
                .curve(curve);

        xmlFileReader().startElement(name, attrs);
    }

    private void connectLine(ConnectLine connectLine, String name, Attributes attrs) {
        ((ConnectLineReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.ConnectLine))
                .connectLine(connectLine);

        xmlFileReader().startElement(name, attrs);
    }

    private void textArt(TextArt textArt, String name, Attributes attrs) {
        ((TextArtReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.TextArt))
                .textArt(textArt);

        xmlFileReader().startElement(name, attrs);
    }

    private void compose(Compose compose, String name, Attributes attrs) {
        ((ComposeReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.Compose))
                .compose(compose);

        xmlFileReader().startElement(name, attrs);
    }

    private void dutmal(Dutmal dutmal, String name, Attributes attrs) {
        ((DutmalReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.Dutmal))
                .dutmal(dutmal);

        xmlFileReader().startElement(name, attrs);
    }

    private void btn(Button button, String name, Attributes attrs) {
        ((ButtonReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.Btn))
                .button(button);

        xmlFileReader().startElement(name, attrs);
    }

    private void radioBtn(RadioButton radioButton, String name, Attributes attrs) {
        ((RadioButtonReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.RadioBtn))
                .radioButton(radioButton);

        xmlFileReader().startElement(name, attrs);
    }

    private void checkBtn(CheckButton checkButton, String name, Attributes attrs) {
        ((CheckButtonReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.CheckBtn))
                .checkButton(checkButton);

        xmlFileReader().startElement(name, attrs);
    }

    private void comboBox(ComboBox comboBox, String name, Attributes attrs) {
        ((ComboBoxReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.ComboBox))
                .comboBox(comboBox);

        xmlFileReader().startElement(name, attrs);
    }

    private void edit(Edit edit, String name, Attributes attrs) {
        ((EditReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.Edit))
                .edit(edit);

        xmlFileReader().startElement(name, attrs);
    }

    private void listBox(ListBox listBox, String name, Attributes attrs) {
        ((ListBoxReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.ListBox))
                .listBox(listBox);

        xmlFileReader().startElement(name, attrs);
    }

    private void scrollBar(ScrollBar scrollBar, String name, Attributes attrs) {
        ((ScrollBarReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.ScrollBar))
                .scrollBar(scrollBar);

        xmlFileReader().startElement(name, attrs);
    }

    private void video(Video video, String name, Attributes attrs) {
        ((VideoReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.Video))
                .video(video);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return run;
    }
}
