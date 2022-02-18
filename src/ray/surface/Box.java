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
	
	double txMinus;
	double txPlus;
	double tyMinus;
	double tyPlus;
	double tzMinus;
	double tzPlus;
	
	private double txMin;
	private double txMax;
	private double tyMin;
	private double tyMax;
	private double tzMin;
	private double tzMax;
	
	double tEnter;
	
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
		txMinus = planeIntersection(new Vector3(ray), origin, minPt, new Vector3(-1, 0, 0));
		txPlus = planeIntersection(new Vector3(ray), origin, maxPt, new Vector3(1, 0, 0));
		
		tyMinus = planeIntersection(new Vector3(ray), origin, minPt, new Vector3(0, -1, 0));
		tyPlus = planeIntersection(new Vector3(ray), origin, maxPt, new Vector3(0, 1, 0));
		
		tzMinus = planeIntersection(new Vector3(ray), origin, minPt, new Vector3(0, 0, -1));
		tzPlus = planeIntersection(new Vector3(ray), origin, maxPt, new Vector3(0, 0, 1));
		
		txMin = Math.min(txMinus, txPlus);
		txMax = Math.max(txMinus, txPlus);
		
		tyMin = Math.min(tyMinus, tyPlus);
		tyMax = Math.max(tyMinus, tyPlus);
		
		tzMin = Math.min(tzMinus, tzPlus);
		tzMax = Math.max(tzMinus, tzPlus);
		
		tEnter = Math.max(txMin, tyMin);
		tEnter = Math.max(tzMin, tEnter);
		
		double tExit = Math.min(txMax, tyMax);
		tExit = Math.min(tzMax, tExit);
		
		double t = Double.POSITIVE_INFINITY;
		if (tEnter < tExit) {
			t = tEnter;
		}
		return t;
	}

	public double planeIntersection(Vector3 ray, Point3 origin, Point3 point, Vector3 normal) {
		double t = Double.POSITIVE_INFINITY;
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
		Vector3 normal = new Vector3();
		if (tEnter == txMin) {
			if (txMin == txPlus) {
				normal = new Vector3(1,0,0);
			} else if (txMin == txMinus) {
				normal = new Vector3(-1,0,0);
			}
		} else if (tEnter == tyMin) {
			if (tyMin == tyPlus) {
				normal = new Vector3(0,1,0);
			} else if (tyMin == tyMinus) {
				normal = new Vector3(0,-1,0);
			}
		} else if (tEnter == tzMin) {
			if (tzMin == tzPlus) {
				normal = new Vector3(0,0,1);
			} else if (txMin == txMinus) {
				normal = new Vector3(0,0,-1);
			}
		}
		
		
//		if (p.x == maxPt.x) {
//			normal = new Vector3(1,0,0);
//		} else if (p.x == minPt.x) {
//			normal = new Vector3(-1,0,0);
//		} else if (p.y == maxPt.y) {
//			normal = new Vector3(0,1,0);
//		} else if (p.y == minPt.y) {
//			normal = new Vector3(0,-1,0);
//		} else if (p.z == maxPt.z) {
//			normal = new Vector3(0,0,1);
//		} else if (p.z == minPt.z) {
//			normal = new Vector3(0,0,-1);
//		}
		return normal;
	}
}
