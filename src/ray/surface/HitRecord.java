package ray.surface;
import ray.math.Point3;
import ray.math.Vector3;

public class HitRecord {
	public Surface surface;
	public Vector3 normal;
	protected Vector3 dir;
	public double t;
	public Point3 intersect;
	
	public HitRecord() {
		this.surface = null;
		this.normal = null;
		this.t = Double.POSITIVE_INFINITY;
	}
	
	public HitRecord(Surface s, double t, Vector3 normal, Vector3 ray) {
		this.surface = s;
		this.normal = normal; 
		this.dir = ray;
	}
	
	public double isHit(Vector3 ray, Point3 origin, double closest) {
		
		
		
		return t;
	}
}
