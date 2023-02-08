package kr.dogfoot.hwpxlib.object.common.compatibility;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

import java.util.ArrayList;

public class Case extends InSwitchObject {
    private String requiredNamespace;
    public Case() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.Case;
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
}
