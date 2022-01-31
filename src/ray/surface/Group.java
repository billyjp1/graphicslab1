package ray.surface;
import java.util.ArrayList;
/**
 * A group of surfaces.
 * @author parryrm
 *
 */
public class Group extends Surface {
	protected ArrayList<Surface> surfaces = new ArrayList<Surface>();
	
	public void add(Surface toAdd) {
		this.surfaces.add(toAdd);
	}
}
