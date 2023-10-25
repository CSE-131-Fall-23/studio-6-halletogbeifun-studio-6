package studio6;

import edu.princeton.cs.introcs.StdDraw;

public class RecursiveMethods {

	/**
	 * Computes the geometric sum for the first n terms in the series
	 * 
	 * @param n the number of terms to include in the sum
	 * @return the sum of the first n terms of the geometric series (1/2 + 1/4 + 1/8
	 *         ...)
	 */
	public static double geometricSum(int n) {
		if (n == 0) {
			return 0;
		} else {
			return 1.0/(Math.pow(2.0, n)) + geometricSum(--n);
		}
		
		
	}

	/**
	 * This method uses recursion to compute the greatest common divisor
	 * for the two input values
	 * 
	 * @param p first operand
	 * @param q second operand
	 * @return greatest common divisor of p and q
	 */
	public static int gcd(int p, int q) {
		if (p % q == 0) {
			return q;
		} else {
			return gcd(q, (p%q));
		}
		
	}

	

	/**
	 * This method uses recursion to create a reverse of the given array
	 * 
	 * @param array the array to create a reverse of, not to be mutated
	 * @return an array with the same data as the input but it reverse order
	 */
	public static int[] toReversed(int[] array) {
		int[] copy = new int[array.length];
		if (array.length == 0) {
			return copy;
		} else if (array.length == 1) {
			copy[0] = array[0];
			return copy;
		} else {
			return reverseHelper(array, copy, 0);
		}
	}

	
	
	public static int[] reverseHelper(int[] array, int[] copy, int position) {
		if (position >= array.length/2.0) {
			return copy;
		} else {
			copy[position] = array[array.length - 1 - position];
			copy[array.length - 1 - position] = array[position];
			return reverseHelper(array, copy, ++position);
		}
	}
	
	
	
	
	/**
	 * @param xCenter                       x-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param yCenter                       y-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param radius                        radius of the circle at the current
	 *                                      depth
	 * @param radiusMinimumDrawingThreshold radius above which drawing should occur
	 */
	public static void circlesUponCircles(double xCenter, double yCenter, double radius,
			double radiusMinimumDrawingThreshold) {

		if (radius < radiusMinimumDrawingThreshold) {
			return;
		} else {
			StdDraw.circle(xCenter, yCenter, radius);
			System.out.println(xCenter + " " + yCenter);
			circlesUponCircles(xCenter + radius, yCenter, radius/3.0, radiusMinimumDrawingThreshold);
			circlesUponCircles(xCenter, yCenter - radius, radius/3.0, radiusMinimumDrawingThreshold);
			circlesUponCircles(xCenter - radius, yCenter, radius/3.0, radiusMinimumDrawingThreshold);
			circlesUponCircles(xCenter, yCenter + radius, radius/3.0, radiusMinimumDrawingThreshold);
		}
		
	}

}
