package raycasting;

import java.util.ArrayList;
import java.util.List;

public class Scene
{

   public List<Light> lights = new ArrayList<>();

   public List<Geometry> primitives = new ArrayList<>();

   public final Color ambient = new Color(0x202020);

   public Scene()
   {
      lights.add(createLight(100, 10, -125, 0xFFFFFF));
      lights.add(createLight(-250, 190, 150, 0xFFFFFF));

      primitives.add(createPlane(0, 1, 0, -30));
      // ping pong
      primitives.add(createSphere(-60, 115, -20, 10, 0xFFFFFF));
      primitives.add(createBox(-150, 40, -110, 150, 70, 110, 0x6492a4)); // mesa
      primitives.add(createBox(-1, 70, -110, 1, 75, 110, 0xFFFFFF));
      primitives.add(createBox(-150, 70, -4, 150, 71, -3, 0xFFFFFF)); 
      primitives.add(createBox(-150, 70, -1, 150, 71, 1, 0xFFFFFF)); 
      primitives.add(createCylinder(-90, -30, 70, 10, 60, 0xDEB887));
      primitives.add(createCylinder(90, -30, 70, 10, 60, 0xDEB887));
      primitives.add(createCylinder(-90, -30, -70, 10, 60, 0xDEB887));
      primitives.add(createCylinder(90, -30, -70, 10, 60, 0xDEB887));
      
      // sinuca
      primitives.add(createSphere(-60, 115, -20, 10, 0x2E8B57));
      primitives.add(createBox(-150, 40, 410, 150, 70, 210, 0x2E8B57)); // mesa
      primitives.add(createCylinder(-140, -20, 400, 10, 60, 0xDEB887));
      primitives.add(createCylinder(140, -20, 400, 10, 60, 0xDEB887));
      primitives.add(createCylinder(-140, -20, 220, 10, 60, 0xDEB887));
      primitives.add(createCylinder(140, -20, 220, 10, 60, 0xDEB887));
      
   }

   public Geometry intersect(final Ray inRay, final Ray outRay)
   {
      Geometry result = null;
      Ray tempRay = new Ray();
      double closest = Double.POSITIVE_INFINITY;
      for (Geometry primitive : primitives)
      {
         if (primitive.intersect(inRay, tempRay))
         {
            double x = tempRay.origin.x - inRay.origin.x;
            double y = tempRay.origin.y - inRay.origin.y;
            double z = tempRay.origin.z - inRay.origin.z;
            double distanceSquared = (x * x) + (y * y) + (z * z);
            if (distanceSquared < closest)
            {
               closest = distanceSquared;
               result = primitive;
               outRay.set(tempRay);
            }
         }
      }
      return result;
   }

   public boolean isShadowed(Vector toLight, Vector hitPoint)
   {
      Ray inRay = new Ray();
      Ray outRay = new Ray();
      inRay.direction.set(toLight).normalize();
      inRay.origin.set(inRay.direction).mul(Tracer.TOLERANCE).add(hitPoint);
      double distanceSquared = toLight.lengthSquared();
      for (Geometry primitive : primitives)
      {
         if (primitive.intersect(inRay, outRay))
         {
            if (outRay.origin.sub(inRay.origin).lengthSquared() < distanceSquared)
            {
               return true;
            }
         }
      }
      return false;
   }

   private Light createLight(double x, double y, double z, int color)
   {
      return new Light(x, y, z, new Color(color));
   }

   private Geometry createPlane(double x, double y, double z, double distance)
   {
      Geometry geometry = new Plane(x, y, z, distance);
      //geometry.setMaterial(new CheckeredMaterial(new Color(0.1, 0.1, 0.1), Color.WHITE, Color.BLACK, Color.WHITE));
      geometry.setMaterial(new BlackRubber(new Color(0.02, 0.02, 0.02), new Color(0.01, 0.01, 0.01), new Color(0.01, 0.01, 0.01), new Color(0.06, 0.06, 0.05)));
      return geometry;
   }

   private Geometry createSphere(double x, double y, double z, double radius, int color)
   {
      Geometry geometry = new Sphere(x, y, z, radius);
      geometry.setMaterial(new Material(getAmbient(color), new Color(color), Color.WHITE));
      return geometry;
   }

   private Geometry createBox(double minx, double miny, double minz, double maxx, double maxy, double maxz, int color)
   {
      Geometry geometry = new Box(minx, miny, minz, maxx, maxy, maxz);
      geometry.setMaterial(new Material(getAmbient(color), new Color(color), Color.WHITE));
      return geometry;
   }

   private Geometry createCylinder(double x, double y, double z, double radius, double height, int color)
   {
      Geometry geometry = new Cylinder(x, y, z, radius, height);
      geometry.setMaterial(new Material(getAmbient(color), new Color(color), Color.WHITE));
      return geometry;
   }

   private Geometry createDisc(double x, double y, double z, double nx, double ny, double nz, double radius, int color)
   {
      Geometry geometry = new Disc(x, y, z, nx, ny, nz, radius);
      geometry.setMaterial(new Material(getAmbient(color), new Color(color), Color.WHITE));
      return geometry;
   }

   private Color getAmbient(int color)
   {
      return new Color(color >> 1 & 0x7f7f7f);
   }

   private class BlackRubber extends Material
   {
      public final Color diffuseColorBr;

      public BlackRubber(Color ambientColor, Color diffuseColor1, Color diffuseColor2, Color specularColor)
      {
         super(ambientColor, diffuseColor1, specularColor);
         diffuseColorBr = diffuseColor2;
      }
      
      public Color computeDiffuse(Ray r)
      {
         return (Math.floor(r.origin.z * 0.025) + Math.floor(r.origin.x * 0.025)) % 2 != 0 ? diffuse : diffuseColorBr;
      }
      
   }
}
