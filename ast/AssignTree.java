package ast;

import visitor.*;

public class AssignTree extends AST {

    public AssignTree() {
    }

    @Override
    public void setDecoration( AST t ) {
        super.setDecoration(t);
    }

    public Object accept(ASTVisitor v) {
        return v.visitAssignTree(this);
    }

}

