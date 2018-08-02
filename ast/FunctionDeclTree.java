package ast;

import visitor.*;

public class FunctionDeclTree extends AST {

    public FunctionDeclTree() {
    }

    @Override
    public void setDecoration( AST t ) {
        super.setDecoration(t);
    }

    public Object accept(ASTVisitor v) {
        return v.visitFunctionDeclTree(this);
    }

}

