package ray.surface;

import ray.math.Point3;
import ray.math.Vector3;

/**
 * Represents a sphere as a center and a radius.
 *
 * @author ags
 */
public class Sphere extends Surface {
	
	/** The center of the sphere. */
	protected final Point3 center = new Point3();
	public void setCenter(Point3 center) { this.center.set(center); } 
	
	/** The radius of the sphere. */
	protected double radius = 1.0;
	public void setRadius(double radius) { this.radius = radius; }
	
	public Sphere() { }
	
	/**
	 * @see Object#toString()
	 */
	public String toString() {
		
		return "sphere " + center + " " + radius + " " + material + " end";
	}

	@Override
	public double intersection(Vector3 ray, Point3 origin) {
		// TODO Auto-generated method stub
		double t = Double.POSITIVE_INFINITY;
		
		Vector3 EminC = new Vector3();
		EminC.sub(origin, center);
		double underSquare = ray.dot(EminC) * ray.dot(EminC);
		double dDot = ray.dot(ray);
		double ecDot = EminC.dot(EminC) - (radius * radius);
		underSquare -= (dDot * ecDot);
		if (underSquare >= 0 && dDot != 0) {
			double numer = Math.sqrt(underSquare);
			double num1 = (-1*ray.dot(EminC)) + numer;
			double num2 = (-1*ray.dot(EminC)) - numer;
			num1 /= dDot;
			num2 /= dDot;
			if ((num1 < num2 || num2 < 0) && num1 >= 0) {
				t = num1;
			} else if (num2 >= 0) {
				t = num2;
			}
		}
		return t;
	}

	@Override
	public Vector3 getNormal(Point3 p) {
		// TODO Auto-generated method stub
		Vector3 norm = new Vector3();
		norm.sub(p, center);
		norm.scale(1/radius);
//		norm.scale(2);
//		norm.normalize();
		return norm;
	}


}
