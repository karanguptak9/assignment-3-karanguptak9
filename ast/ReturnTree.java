package ast;

import visitor.*;

public class ReturnTree extends AST {

    public ReturnTree() {
    }

    @Override
    public void setDecoration( AST t ) {
        super.setDecoration(t);
    }

    public Object accept(ASTVisitor v) {
        return v.visitReturnTree(this);
    }

}

