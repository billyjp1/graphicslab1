package ray.surface;
import ray.math.Point3;
import ray.math.Vector3;

public class HitRecord {
	protected Surface surface;
	protected double point;
	protected Vector3 normal;
	protected double t;
	
	public HitRecord(Surface s, double hitPoint, Vector3 normal) {
		this.surface = s;
		this.point = hitPoint;
		this.normal = normal;
	}
	
	public double isHit(Vector3 ray, Point3 origin, double closest) {
		
		
		
		return t;
	}
}
