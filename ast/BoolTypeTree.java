package ast;

import visitor.*;

public class BoolTypeTree extends AST {

    public BoolTypeTree() {
    }

    @Override
    public void setDecoration( AST t ) {
        super.setDecoration(t);
    }

    public Object accept(ASTVisitor v) {
        return v.visitBoolTypeTree(this);
    }

}

