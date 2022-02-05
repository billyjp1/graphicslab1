package ray.light;

import ray.surface.Surface;
import ray.math.Color;

/**
 * This is the abstract parent class which all lights are child of.
 * You will probably want to add an "illuminate" method to it.
 *
 * @author parryrm
 */
public abstract class Light {
	public abstract Color illuminate(Surface s);
}