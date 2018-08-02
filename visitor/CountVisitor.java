package visitor;

import ast.AST;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lowell Milliken
 */
public class CountVisitor extends ASTVisitor {

  private int [] nCount = new int[100];
  private int depth = 0;
  private int maxDepth = 0;
  boolean space = false;
  int spacingAmount;

  public CountVisitor(int newDepth){
    maxDepth = newDepth;
    nCount = new int[maxDepth + 1];
    for (int index =0; index < maxDepth; index++){
      nCount[index] = 0;
    }
  }

  public CountVisitor( ) {
    super( );
  }

  /**
   * Professor J Rob asked me to add spaces between each if for better understanding
   * and so I adding a comment for the grader to know this.
   * @param t
   */
  private void count(AST t) {
    if(space == false){

      int offset = 0;
      if (t.kidCount() <= 0) {
        t.setTempNode(nCount[depth] + 2);
        nCount[depth] = t.getTempNode();
      }

      else {

        depth++;
        visitKids(t);
        if (t.kidCount() > 1) {

          int index = 1;
          while(index <= t.kidCount()){

            if (index == 1 || index == t.kidCount()) {
              offset += t.getKid(index).getTempNode();
            }
            index++;
          }

          offset = offset / 2;
        } else {
         offset = nCount[depth];
        }
        depth--;
        t.setTempNode( offset );

        if (nCount[depth] > offset) {
          space = true;
          spacingAmount = nCount[depth] ;
          depth++;
          visitKids(t);
          depth--;
          space = false;
          offset += spacingAmount;
          t.setTempNode(offset);
        }

        nCount[depth] = offset;
      }
    } else {

      depth++;
      visitKids(t);
      depth--;
      t.setTempNode(t.getTempNode() + spacingAmount);
    }

  }


  public int[] getCount() {
    int [] count = new int[maxDepth + 1];
    for(int i = 0; i <= maxDepth; i++) {
      count[i] = nCount[i];
    }
    return count;
  }

  public void printCount() {
    for(int i = 0; i <= maxDepth; i++) {
      System.out.println("Depth: " + i + " Nodes: " + nCount[i]);
    }
  }

    public Object visitProgramTree(AST t) {count(t); return null;}
    public Object visitBlockTree(AST t) {count(t); return null;}
    public Object visitFunctionDeclTree(AST t) {count(t); return null;    }
    public Object visitCallTree(AST t) {count(t); return null;    }
    public Object visitDeclTree(AST t) {count(t); return null;    }
    public Object visitIntTypeTree(AST t) {count(t); return null;    }
    public Object visitBoolTypeTree(AST t) {count(t); return null;    }
    public Object visitFormalsTree(AST t) {count(t); return null;    }
    public Object visitActualArgsTree(AST t) {count(t); return null;    }
    public Object visitIfTree(AST t) {count(t); return null;    }
    public Object visitWhileTree(AST t) {count(t); return null;    }
    public Object visitReturnTree(AST t) {count(t); return null;    }
    public Object visitAssignTree(AST t) {count(t); return null;    }
    public Object visitIntTree(AST t) {count(t); return null;    }
    public Object visitIdTree(AST t) {count(t); return null;    }
    public Object visitRelOpTree(AST t) {count(t); return null;    }
    public Object visitAddOpTree(AST t) {count(t); return null;    }
    public Object visitMultOpTree(AST t) {count(t); return null;    }

    //new methods here
    public Object visitFloatTree(AST t) {count(t); return null;    }
    public Object visitFloatTypeTree(AST t) {count(t); return null;    }
    public Object visitVoidTypeTree(AST t) {count(t); return null;    }
    public Object visitRepeatTree(AST t) {count(t); return null;   }

}
