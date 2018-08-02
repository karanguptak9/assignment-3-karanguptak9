package visitor;

import ast.AST;
import ast.AddOpTree;
import ast.IdTree;
import ast.IntTree;
import ast.MultOpTree;
import ast.RelOpTree;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lowell Milliken
 */
public class DrawVisitor extends ASTVisitor {
	private final int nodew = 100;
	private final int nodeh = 30;
	private final int vertSep = 50;
	private final int horizSep = 10;

	private int width;
	private int height;

	private int [] nCount;
	private int [] progress;
	private int depth = 0;
	private BufferedImage bimg;
	private Graphics2D g2;

	public DrawVisitor(int [] nCount) {
		this.nCount = nCount;
		progress = new int [nCount.length];

		width = max(nCount)*(nodew + horizSep);
		height = nCount.length*(nodeh + vertSep);

		g2 = createGraphics2D(width ,height);
	}

	private int max(int [] array) {
		int max = array[0];
		for(int i = 1; i < array.length; i++) {
			if( max < array[ i ] ) max = array[ i ];
		}
		return max;
	}

	public void draw(String s, AST t) {
		ArrayList<AST> k = t.getKids();
		int hstep = nodew + horizSep;
		int vstep = nodeh + vertSep;
		int centerNodeW = nodew /2;

		int x =  width / 2+ t.getTempNode() * hstep;
		int y = depth*vstep;

		g2.setColor(Color.black);
		g2.drawOval(x / 2, y, nodew, nodeh );
		g2.setColor(Color.BLACK);
		g2.drawString(s, (x+10) / 2 , y+2*nodeh/3) ;

		int startx = ( x + centerNodeW) / 2 ;
		int starty = y + nodeh;
		int endx;
		int endy;
		g2.setColor(Color.BLACK);
		for(int i = 0; i < t.kidCount(); i++) {
			endx = (width / 2 + k.get(i).getTempNode() * hstep + centerNodeW) / 2;
			endy = (depth+1)*vstep;
			g2.drawLine(startx , starty, endx, endy);
		}
		depth++;
		visitKids(t);
		depth--;
	}

	public DrawVisitor( ) {
		super( );
	}

	private Graphics2D createGraphics2D( int w, int h)
	{
		Graphics2D g2;
		if (bimg == null || bimg.getWidth() != w || bimg.getHeight() != h)
		{
			bimg = new BufferedImage(w, h,BufferedImage.TYPE_INT_RGB);
		}
		g2 = bimg.createGraphics();
		g2.setBackground(Color.WHITE);
		g2.setRenderingHint(RenderingHints.KEY_RENDERING,
						RenderingHints.VALUE_RENDER_QUALITY);
		g2.clearRect(0, 0, w, h);
		return g2;
	}

    public BufferedImage getImage() {
        return bimg;
    }

    public Object visitProgramTree(AST t) { draw("Program",t);  return null; }
    public Object visitBlockTree(AST t) { draw("Block",t);  return null; }
    public Object visitFunctionDeclTree(AST t) { draw("FunctionDecl",t);  return null; }
    public Object visitCallTree(AST t) { draw("Call",t);  return null; }
    public Object visitDeclTree(AST t) { draw("Decl",t);  return null; }
    public Object visitIntTypeTree(AST t) { draw("IntType",t);  return null; }
    public Object visitBoolTypeTree(AST t) { draw("BoolType",t);  return null; }
    public Object visitFormalsTree(AST t) { draw("Formals",t);  return null; }
    public Object visitActualArgsTree(AST t) { draw("ActualArgs",t);  return null; }
    public Object visitIfTree(AST t) { draw("If",t);  return null; }
    public Object visitWhileTree(AST t) { draw("While",t);  return null; }
    public Object visitReturnTree(AST t) { draw("Return",t);  return null; }
    public Object visitAssignTree(AST t) { draw("Assign",t);  return null; }
    public Object visitIntTree(AST t) { draw("Int: "+((IntTree)t).getSymbol().toString(),t);  return null; }
    public Object visitIdTree(AST t) { draw("Id: "+((IdTree)t).getSymbol().toString(),t);  return null; }
    public Object visitRelOpTree(AST t) { draw("RelOp: "+((RelOpTree)t).getSymbol().toString(),t);  return null; }
    public Object visitAddOpTree(AST t) { draw("AddOp: "+((AddOpTree)t).getSymbol().toString(),t);  return null; }
    public Object visitMultOpTree(AST t) { draw("MultOp: "+((MultOpTree)t).getSymbol().toString(),t);  return null; }

    //new methods here
    //public Object visitFloatTree(AST t) { draw("Float: "+((FloatTree)t).getSymbol().toString(),t);  return null; }
    public Object visitFloatTypeTree(AST t) { draw("FloatType",t);  return null;  }
    public Object visitVoidTypeTree(AST t) { draw("VoidType",t);  return null;  }
    public Object visitRepeatTree(AST t) { draw("Repeat",t);  return null; }

}
