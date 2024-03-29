package raycasting;

public class Material
{

   public static final Material DEFAULT = new Material(Color.WHITE, Color.WHITE, Color.WHITE);

   public final Color ambient;

   public final Color diffuse;

   public final Color specular;

   public final double glossiness;

   public Material(Color ka, Color kd, Color ks)
   {
      this(ka, kd, ks, 24.0);
   }

   public Material(Color ka, Color kd, Color ks, double nr)
   {
      ambient = ka;
      diffuse = kd;
      specular = ks;
      glossiness = nr;
   }
   
   public Color getAmbient() {
	   return ambient;
   }
   
   public Color getDiffuse() {
	   if (diffuse == null) {
		   return Color.WHITE;
	   }
	   return diffuse;
   }
   
   public Color getSpecular() {
	   return specular;
   }

   public Color computeDiffuse(Ray r)
   {
      return diffuse;
   }

   public Color computeSpecular(Ray r)
   {
      return specular;
   }

   public double computeGlossiness(Ray r)
   {
      return glossiness;
   }
   
}
