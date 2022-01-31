package ray.surface;


/**
 * Representation of a 2D disk by a center, radius and normal.
 * 
 * @author parryrm
 *
 */
public class Disc extends Plane {

	/* The radius. */
	protected double radius = 1.0;
	public void setRadius(double radius) { this.radius = radius; }
	
	public Disc() { }

	/**
	 * @see Object#toString()
	 */
	public String toString() {	
		return "disk " + point + " " + normal + " " + radius + " " + material + " end";
	}

}
