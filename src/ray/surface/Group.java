package ray.surface;
import java.util.ArrayList;

import ray.math.Point3;
import ray.math.Vector3;
/**
 * A group of surfaces.
 * @author parryrm
 *
 */
public class Group extends Surface {
	protected ArrayList<Surface> surfaces = new ArrayList<Surface>();
	
	public ArrayList<Surface> getSurfaces() {
		return surfaces;
	}
	
	public void add(Surface toAdd) {
		this.surfaces.add(toAdd);
	}

	@Override
	public double intersection(Vector3 ray, Point3 origin) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Vector3 getNormal() {
		// TODO Auto-generated method stub
		return null;
	}
}
