package ray.surface;
import ray.math.Vector3;

public class HitRecord {
	protected Surface surface;
	protected double point;
	protected Vector3 normal;
	
	public HitRecord(Surface s, double hitPoint, Vector3 normal) {
		this.surface = s;
		this.point = hitPoint;
		this.normal = normal;
	}
}
