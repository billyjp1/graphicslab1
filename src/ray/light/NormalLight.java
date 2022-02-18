package ray.light;

import ray.math.Color;
import ray.math.Point3;
import ray.math.Vector3;
import ray.surface.Surface;

/**
 * This class represents a "normal" light which reveals the normal vector on the surface.
 *
 * @author parryrm
 */
public class NormalLight extends Light {
	
	/**
	 * Default constructor.  Produces a unit intensity light at the origin.
	 */
	public NormalLight() { }
	
	public Color illuminate(Surface surf, Point3 p) {
		Vector3 norm = surf.getNormal(new Point3(p));
		return new Color((norm.x + 1) / 2, (norm.y + 1) / 2, (norm.z + 1) / 2);
	}
	
	/**
	 * @see Object#toString()
	 */
	public String toString() {
		return "normal light end";
	}

}