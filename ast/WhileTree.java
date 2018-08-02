package ast;

import visitor.*;

public class WhileTree extends AST {

    public WhileTree() {
    }

    @Override
    public void setDecoration( AST t ) {
        super.setDecoration(t);
    }

    public Object accept(ASTVisitor v) {
        return v.visitWhileTree(this);
    }
}

