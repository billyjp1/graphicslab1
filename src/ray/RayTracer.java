package ray;

import ray.math.Point3;
import ray.math.Vector3;
import ray.surface.Surface;

import java.io.File;
import java.util.ArrayList;


/**
 * A simple ray tracer.
 *
 * @author ags
 */
public class RayTracer {

	/**
	 * The main method takes all the parameters an assumes they are input files
	 * for the ray tracer. It tries to render each one and write it out to a PNG
	 * file named <input_file>.png.
	 *
	 * @param args
	 */
	public static final void main(String[] args) {
		for (String inputString : args)
		{
			File inputFile = new File(inputString);
			if (inputFile.isFile()) 
			{
				if (inputFile.getName().endsWith(".xml"))
				{
					runXML(inputFile.getPath());
				}
			}
			else if (inputFile.isDirectory())
			{
				File[] listing = inputFile.listFiles();
				if (listing != null) 
				{
					for (File file : listing) 
					{
						if (file.getName().endsWith(".xml"))
						{
							runXML(inputString + "/" + file.getName());
						}
					}
				}
			}
			else
			{
				System.out.println("Input argument \"" + inputString + "\" is neither an XML file nor a directory.");
			}
		}
	}

	public static void runXML(String inputFilename)
	{
		Parser parser = new Parser();
		String outputFilename = inputFilename + ".png";
		System.out.println(inputFilename);
		// Parse the input file
		Scene scene = (Scene) parser.parse(inputFilename, Scene.class);

		// Render the scene
		renderImage(scene);

		// Write the image out
		scene.getImage().write(outputFilename);
	}
	
	/**
	 * Compute the basis for the camera coordinate system (u, v, w)
	 * @param scene the scene
	 * @return An array containing each vector [u, v, w]
	 */
	public static Vector3[] computeBasis(Scene scene) 
	{
		// TODO: compute the basis.
		Vector3 w = scene.camera.projNormal;
		Vector3 up = scene.camera.viewUp;
		
		w.normalize();
		Vector3 u = new Vector3();
		u.cross(up, w);
		u.normalize();
		
		Vector3 v = new Vector3();
		v.cross(w, u);
		
		return new Vector3[]{u, v, w};
		//return new Vector3[]{new Vector3(), new Vector3(), new Vector3()};
	}
	
	/**
	 * Return the ray direction (from view point to pixel location on view rectangle).
	 * @param scene the scene
	 * @param basis the basis of the camera coordinate system (u, v, w).
	 * @param i the column index of the image
	 * @param j the row index of the image
	 * @return the ray direction as a Vector3
	 */
	public static Vector3 computeRayDirection(Scene scene, Vector3[] basis, int i, int j) {
		// TODO compute the ray direction
		double imgWidth = scene.getImage().getWidth();
		double imgHeight = scene.getImage().getHeight();
		double viewWidth = scene.getCamera().viewWidth;
		double viewHeight = scene.getCamera().viewHeight;
		double imgPosX = viewWidth / 2;
		double imgNegX = imgPosX * -1;
		double imgPosY = viewHeight / 2;
		double imgNegY = imgPosY * -1;

		double pixelWidth = viewWidth / imgWidth;
		double pixelHeight = viewHeight / imgHeight;
		
		double uPos = imgNegX + (pixelWidth) * (i + .5);
		double vPos = imgNegY + (pixelHeight) * (j + .5);
		Vector3 ray = new Vector3();//scene.getCamera().viewPoint);

		Vector3 viewDir = new Vector3(scene.getCamera().viewDir);
		viewDir.normalize();
		
		ray.scaleAdd(uPos, basis[0]);
		ray.scaleAdd(vPos, basis[1]);
		ray.scaleAdd(scene.getCamera().projDistance, viewDir);	
		//ray.scaleAdd(-scene.getCamera().projDistance, basis[2]);
		return ray;
	}
	
	/**
	 * The renderImage method renders the entire scene.
	 *
	 * @param scene The scene to be rendered
	 */
	public static void renderImage(Scene scene) {

		// Get the output image
		Image image = scene.getImage();

		// Timing counters
		long startTime = System.currentTimeMillis();

		/*
		 * Render the image, writing the pixel values into image.
		 */
		Vector3[] basis = computeBasis(scene);
		System.out.println("" + basis[0] + basis[1] + basis[2]);
		System.out.println(image.getHeight());
		
		// TODO: render the image by setting the color of each pixel in "image"
		// Use your computeRayDirection helper function.
		Point3 origin = scene.getCamera().viewPoint;
		Vector3 dirVec;
		for (int i = 0; i < image.width; i++) {
			for (int j = 0; j < image.height; j++) {
				dirVec = computeRayDirection(scene, basis, i, j);
				ArrayList<Surface> surfaces = scene.getGroup().getSurfaces();
				double nearest = Double.POSITIVE_INFINITY;
				Surface nearestSurface = surfaces.get(0);
				for (int k = 0; k < surfaces.size(); k++) {
					double check = surfaces.get(k).intersection(new Vector3(dirVec), new Point3(origin));
					if (nearest > check && check > 0) { // && check > 0
						nearest = check;
						nearestSurface = surfaces.get(k);
					}
//if (check < 0) image.setPixelColor(new Color(1,1,1), i, j);
				} 
				
				//Use light to color
				if (nearest != Double.POSITIVE_INFINITY) {
					Point3 p = new Point3(dirVec);
					p.scale(nearest);
					p.add(origin);
					image.setPixelColor(scene.getLights().get(0).illuminate(nearestSurface, p), i, j);
				}
			}
		}
		
		
		// Output time
		long totalTime = (System.currentTimeMillis() - startTime);
		System.out.println("Done.  Total rendering time: "
				+ (totalTime / 1000.0) + " seconds");
	}

}
