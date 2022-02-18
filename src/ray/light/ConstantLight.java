
package ray.light;

import ray.math.Color;
import ray.math.Point3;
import ray.surface.Surface;

/**
 * This class represents a constant light source which reveals the surface color.
 *
 * @author parryrm
 */
public class ConstantLight extends Light {
	
	/**
	 * Default constructor.  Produces a unit intensity light at the origin.
	 */
	public ConstantLight() { }
	
	public Color illuminate(Surface surf, Point3 p) {
		return surf.getMaterial().getColor();
	}
	/**
	 * @see Object#toString()
	 */
	public String toString() {
		
		return "constant light end";
	}
}