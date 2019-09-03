package Math;

/*
 * 223. Rectangle Area
 * https://leetcode.com/problems/rectangle-area/description/
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * Explanation and Code from: @jacobi_chain https://leetcode.com/problems/rectangle-area/discuss/62149/Just-another-short-way
 * https://translate.google.com/translate?hl=en&sl=zh-CN&u=https://zhengyang2015.gitbooks.io/lintcode/rectangle-area-leetcode-223.html&prev=search
 * https://www.programcreek.com/2014/06/leetcode-rectangle-area-java/
 * Medium
 */

public class RectangleArea {

	public static int ComputeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int abcd = (C - A) * (D - B);
		int efgh = (G - E) * (H - F);
		
		int common = overlapLength(A, C, E, G) *  overlapLength(B, D, F, H);
		
		return abcd + efgh - common;
	}
	
	public static int overlapLength(int A, int C, int E, int G) {
		if(E > C || A > G)
			return 0;
		
		return Math.min(C, G) - Math.max(A, E);
	}
	
	public static void main(String[] args) {
		System.out.println(ComputeArea(-3, 0, 3, 4, 0, -1, 9, 2));
	}

}
