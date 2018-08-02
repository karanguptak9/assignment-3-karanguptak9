package ast;

import visitor.*;

public class CallTree extends AST {

    public CallTree() {
    }

    @Override
    public void setDecoration( AST t ) {
        super.setDecoration(t);
    }

    public Object accept(ASTVisitor v) {
        return v.visitCallTree(this);
    }

}

