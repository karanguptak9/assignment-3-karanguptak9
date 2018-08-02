package ast;

import visitor.*;

public class IfTree extends AST {

    public IfTree() {
    }

    @Override
    public void setDecoration( AST t ) {
        super.setDecoration(t);
    }

    public Object accept(ASTVisitor v) {
        return v.visitIfTree(this);
    }

}

