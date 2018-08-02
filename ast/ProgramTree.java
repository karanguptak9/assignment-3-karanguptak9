package ast;

import visitor.*;

public class ProgramTree extends AST {

    public ProgramTree() {
    }

    @Override
    public void setDecoration( AST t ) {
        super.setDecoration(t);
    }

    public Object accept(ASTVisitor v) {
        return v.visitProgramTree(this);
    }

}

