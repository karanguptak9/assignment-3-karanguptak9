package ast;

import visitor.*;

public class DeclTree extends AST {

    public DeclTree() {
    }

    @Override
    public void setDecoration( AST t ) {
        super.setDecoration(t);
    }

    public Object accept(ASTVisitor v) {
        return v.visitDeclTree(this);
    }

}

