package kr.dogfoot.hwpxlib.writer.util;

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

    private final StringBuilder sb;
    private final Stack<ElementInfo> elementStack;

    public XMLStringBuilder() {
        sb = new StringBuilder()
                .append(Prefix);
        elementStack = new Stack<ElementInfo>();
    }

    public XMLStringBuilder openElement(String name) {
        if (!elementStack.empty()) {
            if (!elementStack.peek().hasChild()) {
                sb.append(ElementEnd1);
            }
            elementStack.peek().hadChild();
        }

        sb
                .append(ElementStart1)
                .append(name);

        elementStack.push(new ElementInfo(name));
        return this;
    }

    public XMLStringBuilder closeElement() {
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

    public XMLStringBuilder attribute(String name, String value) {
        if (elementStack.empty() || elementStack.peek().hasChild() || value == null) {
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


    public String toString() {
        while (!elementStack.empty()) {
            closeElement();
        }

        return sb.toString();
    }

    public void clear() {
        sb.setLength(0);
        sb.append(Prefix);

        elementStack.clear();
    }

    private class ElementInfo {
        private final String name;
        private boolean hasChild;
        public ElementInfo(String name) {
            this.name = name;
            hasChild = false;
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
    }
}
