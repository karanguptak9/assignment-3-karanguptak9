package ast;

import visitor.*;

public class BlockTree extends AST {

    public BlockTree() {
    }

    @Override
    public void setDecoration( AST t ) {
        super.setDecoration(t);
    }

    public Object accept(ASTVisitor v) {
        return v.visitBlockTree(this);
    }

}

