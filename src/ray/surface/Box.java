package ray.surface;

import ray.math.Point3;
import ray.math.Vector3;

public class Box extends Surface {
	
	/* The corner of the box with the smallest x, y, and z components. */
	protected final Point3 minPt = new Point3();
	public void setMinPt(Point3 minPt) { this.minPt.set(minPt); }

	/* The corner of the box with the largest x, y, and z components. */
	protected final Point3 maxPt = new Point3();
	public void setMaxPt(Point3 maxPt) { this.maxPt.set(maxPt); }

	public Box() { }

	/**
	 * @see Object#toString()
	 */
	public String toString() {
		return "box " + minPt + " " + maxPt + " " + material + " end";
	}

	@Override
	public double intersection(Vector3 ray, Point3 origin) {
		// TODO Auto-generated method stub
		
		return 0;
	}

	public double planeIntersection(Vector3 ray, Point3 origin, Point3 point) {
		double t = Double.POSITIVE_INFINITY;
		Vector3 normal = getNormal(point);
		double numer = (normal.dot(new Vector3(point))) - (normal.dot(new Vector3(origin)));
		double denom = normal.dot(ray);
		if (denom != 0) {
			t = numer/denom;
		}
		return t;
	}
	
	@Override
	public Vector3 getNormal(Point3 p) {
		// TODO Auto-generated method stub
		return null;
	}
}
