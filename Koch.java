/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

        /*
		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		curve(Integer.parseInt(args[0]),
			  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		      Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		*/

		/*
		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		snowFlake(Integer.parseInt(args[0]));
		*/
	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
		public static void curve(int n, double x1, double y1, double x2, double y2) {
		if (n == 0){
			StdDraw.line(x1, y1, x2, y2);
			return;
		}
		double tx1 = (2*x1+x2)/3;
		double ty1 = (2*y1+y2)/3;
		double tx2 = (x1+2*x2)/3;
		double ty2 = (y1+2*y2)/3;
		//double hx = (Math.sqrt(3)/6)*(ty1-ty2) + 0.5*(tx1+tx2);
		//double hy = (Math.sqrt(3)/6)*(tx2-tx1) + 0.5*(ty1+ty2);
		double hx = tx1 + (tx2 - tx1) * Math.cos(Math.PI / 3) - (ty2 - ty1) * Math.sin(Math.PI / 3);
		double hy = ty1 + (tx2 - tx1) * Math.sin(Math.PI / 3) + (ty2 - ty1) * Math.cos(Math.PI / 3);
		curve (n-1, x1, y1, tx1, ty1);
		curve (n-1, tx1, ty1, hx, hy);
		curve (n-1, hx, hy, tx2, ty2);
		curve (n-1, tx2, ty2, x2, y2);
	}

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
		// A little tweak that makes the drawing look better
		StdDraw.setYscale(0, 1.1);
		StdDraw.setXscale(0, 1.1);
		// Draws a Koch snowflake of depth n
		double x1 = 0.2;
		double y1 = 0.8;
		double x2 = 0.8;
		double y2 = 0.8;
		double x3 = 0.5;
		double y3 = 0.2;
		curve(n, x1, y1, x2, y2);
		curve(n, x2, y2, x3, y3);
		curve(n, x3, y3, x1, y1);
	}

}
