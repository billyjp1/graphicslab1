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
	
	public Plane() { }

	/**
	 * @see Object#toString()
	 */
	public String toString() {
		return "plane " + point + " " + normal + " " + material + " end";
	}

}
