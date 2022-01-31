package ray.light;


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
	
	/**
	 * @see Object#toString()
	 */
	public String toString() {
		return "normal light end";
	}
}