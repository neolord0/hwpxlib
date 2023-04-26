package kr.dogfoot.hwpxlib.reader.section_xml;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.*;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.*;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.SecPr;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.section_xml.ctrl.CtrlReader;
import kr.dogfoot.hwpxlib.reader.section_xml.object.*;
import kr.dogfoot.hwpxlib.reader.section_xml.object.formobject.ButtonCoreReader;
import kr.dogfoot.hwpxlib.reader.section_xml.secpr.SecPrReader;
import kr.dogfoot.hwpxlib.reader.section_xml.t.TReader;
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
            case ElementNames.hp_secPr:
                run.createSecPr();
                secPr(run.secPr(), name, attrs);
                break;
            case ElementNames.hp_ctrl:
                ctrl(run.addNewCtrl(), name, attrs);
                break;
            case ElementNames.hp_t:
                t(run.addNewT(), name, attrs);
                break;
            case ElementNames.hp_tbl:
                tbl(run.addNewTable(), name, attrs);
                break;

            case ElementNames.hp_pic:
                pic(run.addNewPicture(), name, attrs);
                break;
            case ElementNames.hp_ole:
                ole(run.addNewOLE(), name, attrs);
                break;
            case ElementNames.hp_container:
                container(run.addNewContainer(), name, attrs);
                break;
            case ElementNames.hp_equation:
                equation(run.addNewEquation(), name, attrs);
                break;
            case ElementNames.hp_chart:
                chart(run.addNewChart(), name, attrs);
                break;

            case ElementNames.hp_line:
                line(run.addNewLine(), name, attrs);
                break;
            case ElementNames.hp_rect:
                rect(run.addNewRectangle(), name, attrs);
                break;
            case ElementNames.hp_ellipse:
                ellipse(run.addNewEllipse(), name, attrs);
                break;
            case ElementNames.hp_arc:
                arc(run.addNewArc(), name, attrs);
                break;
            case ElementNames.hp_polygon:
                polygon(run.addNewPolygon(), name, attrs);
                break;
            case ElementNames.hp_curve:
                curve(run.addNewCurve(), name, attrs);
                break;
            case ElementNames.hp_connectLine:
                connectLine(run.addNewConnectLine(), name, attrs);
                break;
            case ElementNames.hp_textart:
                textArt(run.addNewTextArt(), name, attrs);
                break;
            case ElementNames.hp_compose:
                compose(run.addNewCompose(), name, attrs);
                break;
            case ElementNames.hp_dutmal:
                dutmal(run.addNewDutmal(), name, attrs);
                break;
            case ElementNames.hp_btn:
                btn(run.addNewButton(), name, attrs);
                break;
            case ElementNames.hp_radioBtn:
                radioBtn(run.addNewRadioButton(), name, attrs);
                break;
            case ElementNames.hp_checkBtn:
                checkBtn(run.addNewCheckButton(), name, attrs);
                break;
            case ElementNames.hp_comboBox:
                comboBox(run.addNewComboBox(), name, attrs);
                break;
            case ElementNames.hp_edit:
                edit(run.addNewEdit(), name, attrs);
                break;
            case ElementNames.hp_listBox:
                listBox(run.addNewListBox(), name, attrs);
                break;
            case ElementNames.hp_scrollBar:
                scrollBar(run.addNewScrollBar(), name, attrs);
                break;
            case ElementNames.hp_video:
                video(run.addNewVideo(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_secPr:
                SecPr secPr = new SecPr();
                secPr(secPr, name, attrs);
                return secPr;
            case ElementNames.hp_ctrl:
                Ctrl ctrl = new Ctrl();
                ctrl(ctrl, name, attrs);
                return ctrl;
            case ElementNames.hp_t:
                T t = new T();
                t(t, name, attrs);
                return t;
            case ElementNames.hp_tbl:
                Table table = new Table();
                tbl(table, name, attrs);
                return table;
            case ElementNames.hp_pic:
                Picture picture = new Picture();
                pic(picture, name, attrs);
                return picture;
            case ElementNames.hp_ole:
                OLE ole = new OLE();
                ole(ole, name, attrs);
                return ole;
            case ElementNames.hp_container:
                Container container = new Container();
                container(container, name, attrs);
                return container;
            case ElementNames.hp_equation:
                Equation equation = new Equation();
                equation(equation, name, attrs);
                return equation;
            case ElementNames.hp_chart:
                Chart chart = new Chart();
                chart(chart, name, attrs);
                return chart;

            case ElementNames.hp_line:
                Line line = new Line();
                line(line, name, attrs);
                return line;
            case ElementNames.hp_rect:
                Rectangle rectangle = new Rectangle();
                rect(rectangle, name, attrs);
                return rectangle;
            case ElementNames.hp_ellipse:
                Ellipse ellipse = new Ellipse();
                ellipse(ellipse, name, attrs);
                return ellipse;
            case ElementNames.hp_arc:
                Arc arc = new Arc();
                arc(arc, name, attrs);
                return arc;
            case ElementNames.hp_polygon:
                Polygon polygon = new Polygon();
                polygon(polygon, name, attrs);
                return polygon;
            case ElementNames.hp_curve:
                Curve curve = new Curve();
                curve(curve, name, attrs);
                return curve;
            case ElementNames.hp_connectLine:
                ConnectLine connectLine = new ConnectLine();
                connectLine(connectLine, name, attrs);
                return connectLine;
            case ElementNames.hp_textart:
                TextArt textArt = new TextArt();
                textArt(textArt, name, attrs);
                return textArt;
            case ElementNames.hp_compose:
                Compose compose = new Compose();
                compose(compose, name, attrs);
                return compose;
            case ElementNames.hp_dutmal:
                Dutmal dutmal = new Dutmal();
                dutmal(dutmal, name, attrs);
                return dutmal;
            case ElementNames.hp_btn:
                Button button = new Button();
                btn(button, name, attrs);
                return button;
            case ElementNames.hp_radioBtn:
                RadioButton radioButton = new RadioButton();
                radioBtn(radioButton, name, attrs);
                return radioButton;
            case ElementNames.hp_checkBtn:
                CheckButton checkButton = new CheckButton();
                checkBtn(checkButton, name, attrs);
                return checkButton;
            case ElementNames.hp_comboBox:
                ComboBox comboBox = new ComboBox();
                comboBox(comboBox, name, attrs);
                return comboBox;
            case ElementNames.hp_edit:
                Edit edit = new Edit();
                edit(edit, name, attrs);
                return edit;
            case ElementNames.hp_listBox:
                ListBox listBox = new ListBox();
                listBox(listBox, name, attrs);
                return listBox;
            case ElementNames.hp_scrollBar:
                ScrollBar scrollBar = new ScrollBar();
                scrollBar(scrollBar, name, attrs);
                return scrollBar;
            case ElementNames.hp_video:
                Video video = new Video();
                video(video, name, attrs);
                return video;
        }
        return null;
    }


    private void secPr(SecPr secPr, String name, Attributes attrs) {
        ((SecPrReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.SecPr))
                .secPr(secPr);

        xmlFileReader().startElement(name, attrs);
    }

    private void ctrl(Ctrl ctrl, String name, Attributes attrs) {
        ((CtrlReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.Ctrl))
                .ctrl(ctrl);

        xmlFileReader().startElement(name, attrs);
    }

    private void t(T t, String name, Attributes attrs) {
        ((TReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.T))
                .t(t);

        xmlFileReader().startElement(name, attrs);
    }

    private void tbl(Table table, String name, Attributes attrs) {
        ((TableReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.Tbl))
                .table(table);

        xmlFileReader().startElement(name, attrs);
    }

    private void pic(Picture picture, String name, Attributes attrs) {
        ((PictureReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.Pic))
                .picture(picture);

        xmlFileReader().startElement(name, attrs);
    }


    private void container(Container container, String name, Attributes attrs) {
        ((ContainerControlReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.ContainerControl))
                .container(container);

        xmlFileReader().startElement(name, attrs);
    }

    private void ole(OLE ole, String name, Attributes attrs) {
        ((OLEReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.OLE))
                .ole(ole);

        xmlFileReader().startElement(name, attrs);
    }

    private void equation(Equation equation, String name, Attributes attrs) {
        ((EquationReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.Equation))
                .equation(equation);

        xmlFileReader().startElement(name, attrs);
    }

    private void chart(Chart chart, String name, Attributes attrs) {
        ((ChartReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.Chart))
                .chart(chart);

        xmlFileReader().startElement(name, attrs);
    }

    private void line(Line line, String name, Attributes attrs) {
        ((LineReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.Line))
                .line(line);

        xmlFileReader().startElement(name, attrs);
    }

    private void rect(Rectangle rectangle, String name, Attributes attrs) {
        ((RectangleReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.Rect))
                .rectangle(rectangle);

        xmlFileReader().startElement(name, attrs);
    }

    private void ellipse(Ellipse ellipse, String name, Attributes attrs) {
        ((EllipseReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.Ellipse))
                .ellipse(ellipse);

        xmlFileReader().startElement(name, attrs);
    }

    private void arc(Arc arc, String name, Attributes attrs) {
        ((ArcReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.Arc))
                .arc(arc);

        xmlFileReader().startElement(name, attrs);
    }

    private void polygon(Polygon polygon, String name, Attributes attrs) {
        ((PolygonReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.Polygon))
                .polygon(polygon);

        xmlFileReader().startElement(name, attrs);
    }

    private void curve(Curve curve, String name, Attributes attrs) {
        ((CurveReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.Curve))
                .curve(curve);

        xmlFileReader().startElement(name, attrs);
    }

    private void connectLine(ConnectLine connectLine, String name, Attributes attrs) {
        ((ConnectLineReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.ConnectLine))
                .connectLine(connectLine);

        xmlFileReader().startElement(name, attrs);
    }

    private void textArt(TextArt textArt, String name, Attributes attrs) {
        ((TextArtReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.TextArt))
                .textArt(textArt);

        xmlFileReader().startElement(name, attrs);
    }

    private void compose(Compose compose, String name, Attributes attrs) {
        ((ComposeReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.Compose))
                .compose(compose);

        xmlFileReader().startElement(name, attrs);
    }

    private void dutmal(Dutmal dutmal, String name, Attributes attrs) {
        ((DutmalReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.Dutmal))
                .dutmal(dutmal);

        xmlFileReader().startElement(name, attrs);
    }

    private void btn(Button button, String name, Attributes attrs) {
        ((ButtonCoreReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.ButtonCore))
                .buttonCore(button);

        xmlFileReader().startElement(name, attrs);
    }

    private void radioBtn(RadioButton radioButton, String name, Attributes attrs) {
        ((ButtonCoreReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.ButtonCore))
                .buttonCore(radioButton);

        xmlFileReader().startElement(name, attrs);
    }

    private void checkBtn(CheckButton checkButton, String name, Attributes attrs) {
        ((ButtonCoreReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.ButtonCore))
                .buttonCore(checkButton);

        xmlFileReader().startElement(name, attrs);
    }

    private void comboBox(ComboBox comboBox, String name, Attributes attrs) {
        ((ComboBoxReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.ComboBox))
                .comboBox(comboBox);

        xmlFileReader().startElement(name, attrs);
    }

    private void edit(Edit edit, String name, Attributes attrs) {
        ((EditReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.Edit))
                .edit(edit);

        xmlFileReader().startElement(name, attrs);
    }

    private void listBox(ListBox listBox, String name, Attributes attrs) {
        ((ListBoxReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.ListBox))
                .listBox(listBox);

        xmlFileReader().startElement(name, attrs);
    }

    private void scrollBar(ScrollBar scrollBar, String name, Attributes attrs) {
        ((ScrollBarReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.ScrollBar))
                .scrollBar(scrollBar);

        xmlFileReader().startElement(name, attrs);
    }

    private void video(Video video, String name, Attributes attrs) {
        ((VideoReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.Video))
                .video(video);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return run;
    }
}
