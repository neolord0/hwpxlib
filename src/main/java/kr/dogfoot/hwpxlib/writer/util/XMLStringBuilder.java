package kr.dogfoot.hwpxlib.writer.util;

import kr.dogfoot.hwpxlib.commonstirngs.Namespaces;
import kr.dogfoot.hwpxlib.object.common.EnumGetIndex;
import kr.dogfoot.hwpxlib.object.common.EnumGetStr;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;

import java.text.DecimalFormat;
import java.util.Stack;

public class XMLStringBuilder {
    private static final String Prefix = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\" ?>";
    private static final String ElementStart1="<";
    private static final String ElementStart2="</";
    private static final String ElementEnd1=">";
    private static final String ElementEnd2="/>";
    private static final String Space = " ";
    private static final String Equal = "=";
    private static final String DoubleQuote = "\"";
    private static final String TrueValue = "1";
    private static final String FalseValue = "0";
    private static final String NameSpacePrefix = "xmlns:";
    private static DecimalFormat floatFormat = new DecimalFormat("#.######");

    private final StringBuilder sb;
    private final Stack<ElementInfo> elementStack;

    public XMLStringBuilder() {
        sb = new StringBuilder()
                .append(Prefix);
        elementStack = new Stack<ElementInfo>();
    }

    
    public XMLStringBuilder openElement(String name) {
        if (!elementStack.empty()) {
            if (!currentElementInfo().hasChild()) {
                sb.append(ElementEnd1);
            }

            currentElementInfo().hadChild();
            checkSwitch(false);
        }

        sb
                .append(ElementStart1)
                .append(name);

        if (!elementStack.empty()) {
            currentElementInfo().increaseChildIndex();
        }

        elementStack.push(new ElementInfo(name));
        return this;
    }

    private ElementInfo currentElementInfo() {
        return elementStack.peek();
    }

    public XMLStringBuilder openElementNotCheckingSwitch(String name) {
        if (!elementStack.empty()) {
            if (!currentElementInfo().hasChild()) {
                sb.append(ElementEnd1);
            }

            currentElementInfo().hadChild();
        }

        sb
                .append(ElementStart1)
                .append(name);

        if (!elementStack.empty()) {
            currentElementInfo().increaseChildIndex();
        }

        elementStack.push(new ElementInfo(name));
        return this;
    }

    private void checkSwitch(boolean atClose) {
        ElementWriter elementWriter = currentElementInfo().elementWriter();
        if (elementWriter == null) {
            return;
        }

        if (elementWriter.hasStoredSwitchObject()
                && (atClose || elementWriter.storedSwitchObjectPosition() == currentElementInfo().childIndex())) {
            elementWriter.makeSwitchObject();
            elementWriter.removeSwitchObject();
        }
    }

    public XMLStringBuilder closeElement() {
        checkSwitch(true);

        ElementInfo elementInfo = elementStack.pop();
        if (elementInfo == null) {
            return this;
        }

        if (elementInfo.hasChild()) {
            sb
                    .append(ElementStart2)
                    .append(elementInfo.name())
                    .append(ElementEnd1);
        } else {
            sb
                    .append(ElementEnd2);
        }
        return this;
    }

    public XMLStringBuilder namespace(Namespaces namespaceSort) {
        if (elementStack.empty() || currentElementInfo().hasChild() || namespaceSort  == null) {
            return this;
        }

        sb
                .append(Space)
                .append(NameSpacePrefix)
                .append(namespaceSort.name())
                .append(Equal)
                .append(DoubleQuote)
                .append(namespaceSort.value())
                .append(DoubleQuote);
        return this;
    }

    public XMLStringBuilder attribute(String name, String value) {
        if (elementStack.empty() || currentElementInfo().hasChild() || value == null) {
            return this;
        }

        sb
                .append(Space)
                .append(name)
                .append(Equal)
                .append(DoubleQuote)
                .append(value)
                .append(DoubleQuote);
        return this;
    }

    public XMLStringBuilder attribute(String name, Integer value) {
        if (value == null) {
            return this;
        }
        return attribute(name, value.toString());
    }

    public XMLStringBuilder attribute(String name, Short value) {
        if (value == null) {
            return this;
        }
        return attribute(name, value.toString());
    }

    public XMLStringBuilder attribute(String name, Long value) {
        if (value == null) {
            return this;
        }
        return attribute(name, value.toString());
    }

    public XMLStringBuilder attribute(String name, Float value) {
        if (value == null) {
            return this;
        }
        return attribute(name, floatFormat.format(value));
    }

    public XMLStringBuilder attribute(String name, Byte value) {
        if (value == null) {
            return this;
        }
        return attribute(name, value.toString());
    }

    public XMLStringBuilder attribute(String name, Boolean value) {
        if (value == null) {
            return this;
        }

        if (value.booleanValue()) {
            return attribute(name, TrueValue);
        } else {
            return attribute(name, FalseValue);
        }
    }

    public XMLStringBuilder attribute(String name, EnumGetStr enumValue) {
        if (enumValue == null) {
            return this;
        }
        return attribute(name, enumValue.str());
    }

    public XMLStringBuilder attributeIndex(String name, EnumGetIndex enumValue) {
        if (enumValue == null) {
            return this;
        }
        return attribute(name, Integer.toString(enumValue.index()));
    }

    public XMLStringBuilder text(String text) {
        if (text == null || text.length() == 0) {
            return this;
        }
        if (!elementStack.empty()) {
            if (!currentElementInfo().hasChild()) {
                sb.append(ElementEnd1);
            }
            currentElementInfo().hadChild();
        }

        sb
                .append(text.replaceAll("\n", "\r\n"));

        return this;
    }

    public String toString() {
        while (!elementStack.empty()) {
            closeElement();
        }

        return sb.toString();
    }

    public XMLStringBuilder clear() {
        sb.setLength(0);
        sb.append(Prefix);

        elementStack.clear();
        return this;
    }

    public XMLStringBuilder elementWriter(ElementWriter elementWriter) {
        currentElementInfo().elementWriter(elementWriter);
        return this;
    }

    private class ElementInfo {
        private final String name;
        private boolean hasChild;
        private int childIndex;
        private ElementWriter elementWriter;

        public ElementInfo(String name) {
            this.name = name;
            hasChild = false;
            childIndex = 0;
            elementWriter = null;
        }

        public String name() {
            return name;
        }

        public boolean hasChild() {
            return hasChild;
        }

        public void hadChild() {
            this.hasChild = true;
        }

        public int childIndex() {
            return childIndex;
        }

        public void increaseChildIndex() {
            childIndex++;
        }

        public ElementWriter elementWriter() {
            return this.elementWriter = elementWriter;
        }

        public void elementWriter(ElementWriter elementWriter) {
            this.elementWriter = elementWriter;
        }
    }
}
