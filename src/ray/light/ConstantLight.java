
package ray.light;

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
	
	/**
	 * @see Object#toString()
	 */
	public String toString() {
		
		return "constant light end";
	}
}