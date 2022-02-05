package ray.light;

import ray.math.Color;
import ray.surface.Surface;

/**
 * This class represents an ambient light which illuminates every surface the same 
 * regardless of position or orientation.
 *
 * @author parryrm
 */
public class AmbientLight extends Light {
	
	/** How bright the light is. */
	public final Color intensity = new Color(1, 1, 1);
	public void setIntensity(Color intensity) { this.intensity.set(intensity); }
	
	/**
	 * Default constructor.
	 */
	public AmbientLight() { }
	
	/**
	 * @see Object#toString()
	 */
	public String toString() {
		
		return "ambient light: " + intensity + " end";
	}

	@Override
	public Color illuminate(Surface s) {
		// TODO Auto-generated method stub
		return s.getMaterial().getColor();
	}

}