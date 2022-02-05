package ray.surface;

import ray.math.Vector3;
import ray.math.Point3;

/**
 * Representation of a 2D disk by a center, radius and normal.
 * 
 * @author parryrm
 *
 */
public class Disc extends Plane {

	/* The radius. */
	protected double radius = 1.0;
	public void setRadius(double radius) { this.radius = radius; }
	
	public Disc() { }

	public double intersection(Vector3 ray, Point3 origin) {
		double t = Double.POSITIVE_INFINITY;
		double numer = normal.dot(new Vector3(point)) - normal.dot(new Vector3(origin));
		double denom = normal.dot(ray);
		if (denom != 0) {
			t = numer/denom;
			ray.scale(t);
			origin.add(ray);
			if (point.distance(origin) > radius) {
				return Double.POSITIVE_INFINITY;
			}
		}
		return t;
	}
	
	/**
	 * @see Object#toString()
	 */
	public String toString() {	
		return "disk " + point + " " + normal + " " + radius + " " + material + " end";
	}

}
