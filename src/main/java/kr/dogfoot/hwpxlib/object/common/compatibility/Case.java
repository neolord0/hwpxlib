package kr.dogfoot.hwpxlib.object.common.compatibility;

import kr.dogfoot.hwpxlib.object.common.ObjectType;

public class Case extends InSwitchObject {
    private String requiredNamespace;
    public Case() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_case;
    }

    public String requiredNamespace() {
        return requiredNamespace;
    }

    public void requiredNamespace(String requiredNamespace) {
        this.requiredNamespace = requiredNamespace;
    }

    public Case requiredNamespaceAnd(String requiredNamespace) {
        this.requiredNamespace = requiredNamespace;
        return this;
    }

    @Override
    public Case clone() {
        Case cloned = new Case();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(Case from) {
        requiredNamespace = from.requiredNamespace;

        super.copyForm(from);
    }
}
