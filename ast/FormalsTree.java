package ast;

import visitor.*;

public class FormalsTree extends AST {

    public FormalsTree() {
    }

    @Override
    public void setDecoration( AST t ) {
        super.setDecoration(t);
    }

    public Object accept(ASTVisitor v) {
        return v.visitFormalsTree(this);
    }

}

