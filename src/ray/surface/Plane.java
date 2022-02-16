package ray.surface;

import ray.math.Point3;
import ray.math.Vector3;

/**
 * Represents a plane as a point on the plane and the normal to the plane.
 * 
 * @author parryrm
 *
 */
public class Plane extends Surface {
	
	/* A point on the plane. */
	protected final Point3 point = new Point3();
	public void setPoint(Point3 point) { this.point.set(point); }

	/* The normal vector. */
	protected final Vector3 normal = new Vector3();
	public void setNormal(Vector3 normal) { this.normal.set(normal); }
	public Vector3 getNormal() { return this.normal; }
	
	public Plane() { }
	

	public double intersection(Vector3 ray, Point3 origin) {
		double t = Double.POSITIVE_INFINITY;
		//Vector3 oVec = new Vector3(origin);
		double numer = (normal.dot(new Vector3(point))) - (normal.dot(new Vector3(origin)));
		double denom = normal.dot(ray);
		if (denom != 0) {

			t = numer/denom;
		}
		return t;
	}
	
	/**
	 * @see Object#toString()
	 */
	public String toString() {
		return "plane " + point + " " + normal + " " + material + " end";
	}

}
