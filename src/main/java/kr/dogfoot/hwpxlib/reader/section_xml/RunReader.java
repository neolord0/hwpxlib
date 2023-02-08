package kr.dogfoot.hwpxlib.reader.section_xml;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
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
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.SecPr:
                SecPr secPr = new SecPr();
                secPr(secPr, name, attrs);
                return secPr;
            case ElementNames.Ctrl:
                Ctrl ctrl = new Ctrl();
                ctrl(ctrl, name, attrs);
                return ctrl;
            case ElementNames.T:
                T t = new T();
                t(t, name, attrs);
                return t;
            case ElementNames.Tbl:
                Table table = new Table();
                tbl(table, name, attrs);
                return table;
            case ElementNames.Pic:
                Picture picture = new Picture();
                pic(picture, name, attrs);
                return picture;
            case ElementNames.OLE:
                OLE ole = new OLE();
                ole(ole, name, attrs);
                return ole;
            case ElementNames.Container:
                Container container = new Container();
                container(container, name, attrs);
                return container;
            case ElementNames.Equation:
                Equation equation = new Equation();
                equation(equation, name, attrs);
                return equation;
            case ElementNames.Line:
                Line line = new Line();
                line(line, name, attrs);
                return line;
            case ElementNames.Rect:
                Rectangle rectangle = new Rectangle();
                rect(rectangle, name, attrs);
                return rectangle;
            case ElementNames.Ellipse:
                Ellipse ellipse = new Ellipse();
                ellipse(ellipse, name, attrs);
                return ellipse;
            case ElementNames.Arc:
                Arc arc = new Arc();
                arc(arc, name, attrs);
                return arc;
            case ElementNames.Polygon:
                Polygon polygon = new Polygon();
                polygon(polygon, name, attrs);
                return polygon;
            case ElementNames.Curve:
                Curve curve = new Curve();
                curve(curve, name, attrs);
                return curve;
            case ElementNames.ConnectLine:
                ConnectLine connectLine = new ConnectLine();
                connectLine(connectLine, name, attrs);
                return connectLine;
            case ElementNames.TextArt:
                TextArt textArt = new TextArt();
                textArt(textArt, name, attrs);
                return textArt;
            case ElementNames.Compose:
                Compose compose = new Compose();
                compose(compose, name, attrs);
                return compose;
            case ElementNames.Dutmal:
                Dutmal dutmal = new Dutmal();
                dutmal(dutmal, name, attrs);
                return dutmal;
            case ElementNames.Btn:
                Button button = new Button();
                btn(button, name, attrs);
                return button;
            case ElementNames.RadioBtn:
                RadioButton radioButton = new RadioButton();
                radioBtn(radioButton, name, attrs);
                return radioButton;
            case ElementNames.CheckBtn:
                CheckButton checkButton = new CheckButton();
                checkBtn(checkButton, name, attrs);
                return checkButton;
            case ElementNames.ComboBox:
                ComboBox comboBox = new ComboBox();
                comboBox(comboBox, name, attrs);
                return comboBox;
            case ElementNames.Edit:
                Edit edit = new Edit();
                edit(edit, name, attrs);
                return edit;
            case ElementNames.ListBox:
                ListBox listBox = new ListBox();
                listBox(listBox, name, attrs);
                return listBox;
            case ElementNames.ScrollBar:
                ScrollBar scrollBar = new ScrollBar();
                scrollBar(scrollBar, name, attrs);
                return scrollBar;
            case ElementNames.Video:
                Video video = new Video();
                video(video, name, attrs);
                return video;
        }
        return null;
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
