package kr.dogfoot.hwpxlib.object.common;

public enum ObjectType {
    Unknown(null),
    Switch("hp:switch"),
    Case("hp:case"),
    Default("hp:default"),

    HWPXFile(null),

    // Version.xml
    Version_XMLFile("hv:HCFVersion"),

    // META-INF/manifest.xml
    Manifest_XMLFIle("odf:manifest"),
    FileEntry("odf:file-entry"),
    EncryptionData("odf:encryption-data"),
    Algorithm("odf:algorithm"),
    KeyDerivation("odf:key-derivation"),
    StartKeyGeneration("odf:start-key-generation"),

    // META-INF/container.xml
    Container_XMLFile("ocf:container"),
    RootFiles("ocf:rootfiles"),
    RootFile("ocf:rootfile"),

    // Contents/content.hpf
    Content_HPFFile("opf:package"),
    MetaData("opf:metadata"),
    Title("opf:title"),
    Language("opf:language"),
    Meta("opf:meta"),
    Manifest("opf:manifest"),
    ManifestItem("opf:item"),
    Spine("opf:spine"),
    SpineItemRef("opf:itemref"),

    // Settings.xml
    Settings_XMLFile("ha:HWPApplicationSetting"),
    CaretPosition("ha:CaretPosition"),
    ConfigItemSet("config-item-set"),
    ConfigItem("config-item"),


    // Contents/header_forTestSwitch.xml
    Headers_XMLFile("hh:head"),
    BeginNum("hh:beginNum"),
    RefList("hh:refList"),
    Fontfaces("hh:fontfaces"),
    Fontface("hh:fontface"),
    Font("hh:font"),
    SubstFont("hh:substFont"),
    TypeInfo("hh:typeInfo"),
    BorderFills("hh:borderFills"),
    BorderFill("hh:borderFill"),
    Slash("hh:slash"),
    BackSlash("hh:backSlash"),
    LeftBorder("hh:leftBorder"),
    RightBorder("hh:rightBorder"),
    TopBorder("hh:topBorder"),
    BottomBorder("hh:bottomBorder"),
    Diagonal("hh:diagonal"),
    FillBrush("hc:fillBrush"),
    WinBrush("hc:winBrush"),
    Gradation("hc:gradation"),
    Color("hc:color"),
    ImgBrush("hc:imgBrush"),
    Img("hc:img"),
    CharProperties("hh:charProperties"),
    CharPr("hh:charPr"),
    FontRef("hh:fontRef"),
    Ratio("hh:ratio"),
    Spacing("hh:spacing"),
    RelSz("hh:relSz"),
    CharOffset("hh:offset"),
    Bold("hh:bold"),
    Italic("hh:italic"),
    Underline("hh:underline"),
    Strikeout("hh:strikeout"),
    Outline("hh:outline"),
    CharShadow("hh:shadow"),
    Emboss("hh:emboss"),
    Engrave("hh:engrave"),
    Supscript("hh:supscript"),
    Subscript("hh:subscript"),
    TabProperties("hh:tabProperties"),
    TabPr("hh:tabPr"),
    TabItem("hh:tabItem"),
    Numberings("hh:numberings"),
    Numbering("hh:numbering"),
    ParaHead("hh:paraHead"),
    Bullets("hh:bullets"),
    Bullet("hh:bullet"),
    ParaProperties("hh:paraProperties"),
    ParaPr("hh:paraPr"),
    Align("hh:align"),
    Heading("hh:heading"),
    BreakSetting("hh:breakSetting"),
    ParaMargin("hh:margin"),
    Intent("hc:intent"),
    Left("hc:left"),
    Right("hc:right"),
    Prev("hc:prev"),
    Next("hc:next"),
    LineSpacing("hh:lineSpacing"),
    ParaBorder("hh:border"),
    AutoSpacing("hh:autoSpacing"),
    Styles("hh:styles"),
    Style("hh:style"),
    MemoProperties("hh:memoProperties"),
    MemoPr("hh:memoPr"),
    TrackChanges("hh:trackChanges"),
    TrackChange("hh:trackChange"),
    TrackChangeAuthors("hh:trackChangeAuthors"),
    TrackChangeAuthor("hh:trackChangeAuthor"),
    ForbiddenWordList("hh:forbiddenWordList"),
    ForbiddenWord("hh:forbiddenWord"),
    CompatibleDocument("hh:compatibleDocument"),
    LayoutCompatibility("hh:layoutCompatibility"),
    LayoutCompatibilityItem(null), // 다양한 이름
    DocOption("hh:docOption"),
    LinkInfo("hh:linkinfo"),
    TrackChangeConfig("hh:trackchageConfig"),

    // Contents/section0.xml
    Section_XMLFile("hs:sec"),
    Para("hp:p"),
    Run("hp:run"),

    // secPr
    SecPr("hp:secPr"),
    Grid("hp:grid"),
    StartNum("hp:startNum"),
    Visibility("hp:visibility"),
    LineNumberShape("hp:lineNumberShape"),
    PagePr("hp:pagePr"),
    PageMargin("hp:margin"),
    FootNotePr("hp:footNotePr"),
    AutoNumFormat("hp:autoNumFormat"),
    NoteLine("hp:noteLine"),
    NoteSpacing("hp:noteSpacing"),
    FootNoteNumbering("hp:numbering"),
    FootNotePlacement("hp:placement"),
    EndNotePr("hp:endNotePr"),
    EndNoteNumbering("hp:numbering"),
    EndNotePlacement("hp:placement"),
    PageBorderFill("hp:pageBorderFill"),
    PageBorderFillOffset("hp:offset"),
    MasterPage("hp:masterPage"),
    Presentation("hp;presentation"),

    // 컨트롤 문자들
    Ctrl("hp:ctrl"),
    ColPr("hp:colPr"),  // 단 설정
    ColSz("hp:colSz"),
    ColLine("hp:colLine"),
    FieldBegin("hp:fieldBegin"), // 필드 시작
    ParameterSet("hp:parameterset"),
    Parameters("hp:parameters"),
    BooleanParam("hp:booleanParam"),
    IntegerParam("hp:integerParam"),
    FloatParam("hp:floatParam"),
    StringParam("hp:stringParam"),
    ListParam("hp:ListParam"),
    SubList("hp:subList"),
    FieldEnd("hp:fieldEnd"),     // 필드 끝
    Bookmark("hp:bookmark"),    // 책갈피
    Header("hp:header"),    // 머리말
    Footer("hp:footer"),    // 꼬리말
    FootNote("hp:footNote"), // 각주
    EndNote("hp:endNote"),  // 미주
    AutoNum("hp:autoNum"),  // 자동 번호
    NewNum("hp:newNum"),    // 새 번호
    PageNumCtrl("hp:pageNumCtrl"),
    PageHiding("hp:pageHiding"),    // 감추기
    PageNum("hp:pageNum"),  // 쪽 번호 위치
    Indexmark("hp:indexmark"), // 색인
    FirstKey("hp:firstKey"),
    SecondKey("hp:secondKey"),
    HiddenComment("hp:hiddenComment"),  // 숨믄 설명

    T("hp:t"),
    MarkpenBegin("hp:markpenBegin"),    // 형광팬 시작
    MarkpenEnd("hp:markpenEnd"),    // 형광팬 끝
    TitleMark("hp:titleMark"),  // 제목 차래 표시
    Tab("hp:tab"),  // 탭
    LineBreak("hp:lineBreak"),  // 강제 줄나눔
    Hyphen("hp:hyphen"),    // 하이픈
    NBSpace("hp:nbSpace"),
    FWSpace("hp:fwSpace"),
    InsertBegin("hp:insertBegin"),  // 삽입 시작
    InsertEnd("hp:insertEnd"),  // 삽입 끝
    DeleteBegin("hp:deleteBegin"),  // 삭제 시작
    DeleteEnd("hp:deleteEnd"), // 삭제 끝

    // AbstractShapeObjectType
    ShapeSz("hp:sz"),
    ShapePos("hp:pos"),
    OutMargin("hp:outMargin"),
    Caption("hp:caption"),
    ShapeComment("hp:shapeComment"),

    // 표 개체
    Tbl("hp:tbl"),
    InMargin("hp:inMargin"),
    CellZoneList("hp:cellzoneList"),
    CellZone("hp:cellzone"),
    Tr("hp:tr"),
    Tc("hp:tc"),
    CellAddr("hp:cellAddr"),
    CellSpan("hp:cellSpan"),
    CellSz("hp:cellSz"),
    CellMargin("hp:cellMargin"),

    // 수식 개체
    Equation("hp:equation"),
    Script("hp:script"),

    Chart("hp:chart"),

    // AbstractShapeComponentType
    Offset("hp:offset"),
    OrgSz("hp:orgSz"),
    CurSz("hp:curSz"),
    Flip("hp:flip"),
    RotationInfo("hp:rotationInfo"),
    RenderingInfo("hp:renderingInfo"),
    TransMatrix("hc:transMatrix"),
    ScaMatrix("hc:scaMatrix"),
    RotMatrix("hc:rotMatrix"),

    // 그림 개체
    Pic("hp:pic"),
    LineShape("hp:lineShape"),
    ImgRect("hp:imgRect"),
    Pt0("hc:pt0"),
    Pt1("hc:pt1"),
    Pt2("hc:pt2"),
    Pt3("hc:pt3"),
    ImgClip("hp:imgClip"),
    ImgDim("hp:imgDim"),
    Effects("hp:effects"),
    EffectsShadow("hp:shadow"),
    Skew("hp:skew"),
    Scale("hp:scale"),
    EffectsColor("hp:effectsColor"),
    ColorRGB("hp:rgb"),
    ColorCMYK("hp:cmyk"),
    ColorSchema("hp:scheme"),
    ColorSystem("hp:system"),
    ColorEffect("hp:effect"),
    EffectsGlow("hp:glow"),
    EffectsSoftEdge("hp:softEdge"),
    EffectsReflection("hp:reflection"),
    Alpha("hp:alpha"),
    Pos("hp:pos"),

    // ole 개체
    OLE("hp:ole"),
    Extent("hc:extent"),

    // 묶음 개체
    Container("hp:container"),

    // AbstractDrawingObjectType
    DrawText("hp:drawText"),
    TextMargin("hp:textMargin"),
    DrawingShadow("hp:shadow"),

    // 선 개체
    Line("hp:line"),
    StartPt("hc:startPt"),
    EndPt("hc:endPt"),

    // 사각형 개체
    Rect("hp:rect"),

    // 타원 개체
    Ellipse("hp:ellipse"),
    Center("hc:center"),
    Ax1("hc:ax1"),
    Ax2("hc:ax2"),
    Start1("hc:start1"),
    Start2("hc:start2"),
    End1("hc:end1"),
    End2("hc:end2"),

    // 호 개체
    Arc("hp:arc"),

    // 다각형 개체
    Polygon("hp:polygon"),
    Pt("hc:pt"),

    // 곡선 개체
    Curve("hp:curve"),
    Seg("hp:seg"),

    // 연결선 개체
    ConnectLine("hp:connectLine"),

    // 글맵시 개체
    TextArt("hp:textart"),
    TextArtPr("hp:textartPr"),
    TextArtOutline("hp:outline"),

    // AbstractFormObjectType
    FormCharPr("hp:formCharPr"),

    // 버튼 개체
    Btn("hp:btn"),

    // 라디오버튼 개체
    RadioBtn("hp:radioBtn"),

    // 채크버튼 개체
    CheckBtn("hp:checkBtn"),

    // 콤보박스 개체
    ComboBox("hp:comboBox"),
    ListItem("hp:listItem"),

    // 리스트박스 개체
    ListBox("hp:listBox"),

    // 에디트박스 개체
    Edit("hp:edit"),
    EditText("hp:text"),

    // 스크롤바 개체
    ScrollBar("hp:scrollBar"),

    // 비디오 개체
    Video("hp:video"),

    // 글자겹침 개체
    Compose("hp:compose"),
    ComposeCharPr("hp:charPr"),

    // 덧말 개체
    Dutmal("hp:dutmal"),
    MainText("hp:mainText"),
    SubText("hp:subText"),

    LineSegArray("hp:linesegarray"),
    LineSeg("hp:lineseg"),

    MasterPage_XMLFile("masterPage"),

    // 문사이력 파일
    History_XMLFile("hhs:history"),
    HistoryEntry("hhs:historyEntry"),
    PackageDiff("hhs:packageDiff"),
    HeadDiff("hhs:headDiff"),
    BodyDiff("hhs:bodyDiff"),
    InsertDiff("hhs:insert"),
    UpdateDiff("hhs:update"),
    DeleteDiff("hhs:delete"),

    End_Of_Object(null);

    private String elementName;

    ObjectType(String elementName) {
        this.elementName = elementName;
    }

    public String elementName() {
        return elementName;
    }

    public boolean equalElementName(String elementName) {
        return this.elementName.equals(elementName);
    }
}


