package kr.dogfoot.hwpxlib.reader.section_xml.object.formobject;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.formobject.FormCharPr;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.formobject.FormObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.ShapeObject;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.section_xml.object.shapeobject.ShapeObjectReader;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import org.xml.sax.Attributes;

public abstract class FormObjectReader extends ShapeObjectReader {
    public abstract FormObject formObject();

    @Override
    public ShapeObject shapeObject() {
        return formObject();
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.name:
                formObject().name(value);
                break;
            case AttributeNames.foreColor:
                formObject().foreColor(value);
                break;
            case AttributeNames.backColor:
                formObject().backColor(value);
                break;
            case AttributeNames.groupName:
                formObject().groupName(value);
                break;
            case AttributeNames.tabStop:
                formObject().tabStop(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.tabOrder:
                formObject().tabOrder(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.enabled:
                formObject().enabled(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.borderTypeIDRef:
                formObject().borderTypeIDRef(value);
                break;
            case AttributeNames.drawFrame:
                formObject().drawFrame(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.printable:
                formObject().printable(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.editable:
                formObject().editable(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.command:
                formObject().command(value);
                break;
            default:
                super.setAttribute(name, value);
                break;
        }
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_formCharPr:
                formObject().createFormCharPr();
                formCharPr(formObject().formCharPr(), name, attrs);
                break;
            default:
                super.childElement(name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_formCharPr:
                FormCharPr formCharPr = new FormCharPr();
                formCharPr(formCharPr, name, attrs);
                return formCharPr;
        }

        return super.childElementInSwitch(name, attrs);
    }

    private void formCharPr(FormCharPr formCharPr, String name, Attributes attrs) {
        ((FormCharPrReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.FormCharPr))
                .formCharPr(formCharPr);

        xmlFileReader().startElement(name, attrs);
    }
}
