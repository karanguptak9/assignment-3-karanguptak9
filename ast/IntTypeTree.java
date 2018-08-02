package ast;

import visitor.*;

public class IntTypeTree extends AST {

    public IntTypeTree() {
    }

    @Override
    public void setDecoration( AST t ) {
        super.setDecoration(t);
    }

    public Object accept(ASTVisitor v) {
        return v.visitIntTypeTree(this);
    }

}

