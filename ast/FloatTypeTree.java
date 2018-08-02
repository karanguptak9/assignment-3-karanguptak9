package ast;

import visitor.*;

public class FloatTypeTree extends AST {

    public FloatTypeTree() {
    }

    @Override
    public void setDecoration( AST t ) {
        super.setDecoration(t);
    }

    public Object accept(ASTVisitor v) {
        return v.visitFloatTypeTree(this);
    }

}

