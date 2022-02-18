package ray.light;

import ray.math.Color;
import ray.math.Point3;
import ray.math.Vector3;
import ray.surface.HitRecord;
import ray.surface.Surface;

/**
 * This class represents a basic point light which is infinitely small and emits
 * a constant power in all directions. This is a useful idealization of a small
 * light emitter.
 *
 * @author ags
 */
public class PointLight extends Light {
	
	/** Where the light is located in space. */
	public final Point3 position = new Point3();
	public void setPosition(Point3 position) { this.position.set(position); }
	
	/** How bright the light is. */
	public final Color intensity = new Color(1, 1, 1);
	public void setIntensity(Color intensity) { this.intensity.set(intensity); }
	
	/**
	 * Default constructor.  Produces a unit intensity light at the origin.
	 */
	public PointLight() { }
	
	/**
	 * @see Object#toString()
	 */
	public String toString() {
		return "point light: " + position + " " + intensity + " end";
	}

	@Override
	public Color illuminate(Vector3 ray, HitRecord hr) {
		// TODO Auto-generated method stub
		Vector3 x = new Vector3(); 
		x.scaleAdd(hr.t, ray);
		double r = position.distance(x);
		Vector3 l = new Vector3();
		l.sub(position, new Point3(x));
		l.scale(1/r);
		Vector3 n = hr.normal;
		Color E = new Color(intensity);
		E.scale(Math.max(0, n.dot(l)));
		E.scale(1/(r*r));
		//Color k = hr.surface.getMaterial().evaluate();
		return null;
	}
}