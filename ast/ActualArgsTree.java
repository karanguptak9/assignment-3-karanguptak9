package ast;

import visitor.*;

public class ActualArgsTree extends AST {

    public ActualArgsTree() {
    }

    @Override
    public void setDecoration( AST t ) {
        super.setDecoration(t);
    }

    public Object accept(ASTVisitor v) {
        return v.visitActualArgsTree(this);
    }
}

