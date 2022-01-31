package ray;

import ray.math.Vector3;

import java.io.File;


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
		double imgPosX = scene.getImage().getWidth()/2;
		double imgNegX = imgPosX * -1;
		double imgPosY = scene.getImage().getHeight()/2;
		double imgNegY = imgPosY * -1;
		
		
		return new Vector3();
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
		
		
		
		// Output time
		long totalTime = (System.currentTimeMillis() - startTime);
		System.out.println("Done.  Total rendering time: "
				+ (totalTime / 1000.0) + " seconds");
	}

}
