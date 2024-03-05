package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.*;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.SecPr;

import java.util.ArrayList;

public class Run extends SwitchableObject {
    /**
     * 글자모양 아이디 참조값
     */
    private String charPrIDRef;
    /**
     * 글자 모양 변경 추적 아이디;
     */
    private String charTcId;
    /**
     * 섹션 정의
     */
    private SecPr secPr;
    /**
     * run item(컨트롤 문자, 텍스트, 컨트롤) 리스트
     */
    private final ArrayList<RunItem> itemList;

    public Run() {
        itemList = new ArrayList<RunItem>();
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_run;
    }

    public String charPrIDRef() {
        return charPrIDRef;
    }

    public void charPrIDRef(String charPrIDRef) {
        this.charPrIDRef = charPrIDRef;
    }

    public Run charPrIDRefAnd(String charPrIDRef) {
        this.charPrIDRef = charPrIDRef;
        return this;
    }

    public String charTcId() {
        return charTcId;
    }

    public void charTcId(String charTcId) {
        this.charTcId = charTcId;
    }

    public Run charTcIdAnd(String charTcId) {
        this.charTcId = charTcId;
        return this;
    }

    public SecPr secPr() {
        return secPr;
    }

    public void createSecPr() {
        secPr = new SecPr();
    }

    public void removeSecPr() {
        secPr = null;
    }

    public int countOfRunItem() {
        return itemList.size();
    }

    public RunItem getRunItem(int index) {
        return itemList.get(index);
    }

    public int getRunItemIndex(RunItem runItem) {
        int count = itemList.size();
        for (int index = 0; index < count; index++) {
            if (itemList.get(index) == runItem) {
                return index;
            }
        }
        return -1;
    }

    public void addRunItem(RunItem runItem) {
        itemList.add(runItem);
    }

    public Ctrl addNewCtrl() {
        Ctrl ctrl = new Ctrl();
        itemList.add(ctrl);
        return ctrl;
    }

    public T addNewT() {
        T t = new T();
        itemList.add(t);
        return t;
    }

    public Table addNewTable() {
        Table table = new Table();
        itemList.add(table);
        return table;
    }

    public Picture addNewPicture() {
        Picture picture = new Picture();
        itemList.add(picture);
        return picture;
    }

    public Container addNewContainer() {
        Container container = new Container();
        itemList.add(container);
        return container;
    }

    public OLE addNewOLE() {
        OLE ole = new OLE();
        itemList.add(ole);
        return ole;
    }

    public Equation addNewEquation() {
        Equation equation = new Equation();
        itemList.add(equation);
        return equation;
    }

    public Line addNewLine() {
        Line line = new Line();
        itemList.add(line);
        return line;
    }

    public Rectangle addNewRectangle() {
        Rectangle rectangle = new Rectangle();
        itemList.add(rectangle);
        return rectangle;
    }

    public Ellipse addNewEllipse() {
        Ellipse ellipse = new Ellipse();
        itemList.add(ellipse);
        return ellipse;
    }

    public Arc addNewArc() {
        Arc arc = new Arc();
        itemList.add(arc);
        return arc;
    }

    public Polygon addNewPolygon() {
        Polygon polygon = new Polygon();
        itemList.add(polygon);
        return polygon;
    }

    public Curve addNewCurve() {
        Curve curve = new Curve();
        itemList.add(curve);
        return curve;
    }

    public ConnectLine addNewConnectLine() {
        ConnectLine connectLine = new ConnectLine();
        itemList.add(connectLine);
        return connectLine;
    }

    public TextArt addNewTextArt() {
        TextArt textArt = new TextArt();
        itemList.add(textArt);
        return textArt;
    }

    public Compose addNewCompose() {
        Compose compose = new Compose();
        itemList.add(compose);
        return compose;
    }

    public Dutmal addNewDutmal() {
        Dutmal dutmal = new Dutmal();
        itemList.add(dutmal);
        return dutmal;
    }

    public Button addNewButton() {
        Button button = new Button();
        itemList.add(button);
        return button;
    }

    public RadioButton addNewRadioButton() {
        RadioButton radioButton = new RadioButton();
        itemList.add(radioButton);
        return radioButton;
    }

    public CheckButton addNewCheckButton() {
        CheckButton checkButton = new CheckButton();
        itemList.add(checkButton);
        return checkButton;
    }

    public ComboBox addNewComboBox() {
        ComboBox comboBox = new ComboBox();
        itemList.add(comboBox);
        return comboBox;
    }

    public ListBox addNewListBox() {
        ListBox listBox = new ListBox();
        itemList.add(listBox);
        return listBox;
    }

    public Edit addNewEdit() {
        Edit edit = new Edit();
        itemList.add(edit);
        return edit;
    }

    public ScrollBar addNewScrollBar() {
        ScrollBar scrollBar = new ScrollBar();
        itemList.add(scrollBar);
        return scrollBar;
    }

    public Video addNewVideo() {
        Video video = new Video();
        itemList.add(video);
        return video;
    }

    public Chart addNewChart() {
        Chart chart = new Chart();
        itemList.add(chart);
        return chart;
    }

    public void insertRunItem(RunItem runItem, int position) {
        itemList.add(position, runItem);
    }

    public void removeRunItem(int position) {
        itemList.remove(position);
    }

    public void removeRunItem(RunItem runItem) {
        itemList.remove(runItem);
    }

    public void removeAllRunItems() {
        itemList.clear();
    }

    public Iterable<RunItem> runItems() {
        return itemList;
    }

    @Override
    public Run clone() {
        Run cloned = new Run();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(Run from) {
        this.charPrIDRef = from.charPrIDRef;
        this.charTcId = from.charTcId;

        if (from.secPr != null) {
            secPr = from.secPr.clone();
        } else {
            secPr = null;
        }

        for (RunItem runItem : from.itemList) {
            itemList.add((RunItem) runItem.clone());
        }

        super.copyFrom(from);
    }
}
