package ast;

import visitor.*;

public class VoidTypeTree extends AST {

    public VoidTypeTree() {
    }

    @Override
    public void setDecoration( AST t ) {
        super.setDecoration(t);
    }

    public Object accept(ASTVisitor v) {
        return v.visitVoidTypeTree(this);
    }

}

