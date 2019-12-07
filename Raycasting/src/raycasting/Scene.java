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
      
      //chao
      primitives.add(createBox(-1000, -30, -1000, 1000, -29, 1000, 0x3a2111));
      primitives.add(createPlane(0, 1, 0, -30));
      // ping pong
      primitives.add(createSphere(-60, 115, -20, 4, 0xFFFFFF));
      primitives.add(createBox(-150, 60, -110, 150, 70, 110, 0x6492a4)); // mesa
      primitives.add(createBox(-1, 70, -110, 1, 75, 110, 0xFFFFFF));
      primitives.add(createBox(-150, 70, -1, 150, 71, 1, 0xFFFFFF)); 
      primitives.add(createCylinder(-90, -30, 70, 10, 90, 0xDEB887));
      primitives.add(createCylinder(90, -30, 70, 10, 90, 0xDEB887));
      primitives.add(createCylinder(-90, -30, -70, 10, 90, 0xDEB887));
      primitives.add(createCylinder(90, -30, -70, 10, 90, 0xDEB887));
      
      // sinuca
      primitives.add(createBox(-150, 40, 410, 150, 70, 210, 0x2E8B57)); // mesa
      primitives.add(createBox(-120, 20, 410, 120, 40, 210, 0x2E8B57));
      primitives.add(createBox(-30, 30, 210, 30, 50, 208, 0x6f330b)); //Gaveta das bolas
      primitives.add(createBox(-10, 40, 208, 10, 45, 206, 0x492106));
      primitives.add(createBox(-155, 70, 420, -150, 74, 200, 0x6f330b));//bordas da mesa
      primitives.add(createBox(155, 70, 420, 150, 74, 200, 0x6f330b));
      primitives.add(createBox(-150, 70, 420, 150, 74, 410, 0x6f330b));
      primitives.add(createBox(-150, 70, 210, 150, 74, 200, 0x6f330b));
      primitives.add(createCylinder(-140, -30, 400, 6, 60, 0xDEB887)); //pés da sinuca
      primitives.add(createCylinder(140, -30, 400, 6, 60, 0xDEB887));
      primitives.add(createCylinder(-140, -30, 220, 6, 60, 0xDEB887));
      primitives.add(createCylinder(140, -30, 220, 6, 60, 0xDEB887));
      primitives.add(createCylinder(-140, 70, 400, 10, 1, 0x2E8B57)); //Buracos da Sinuca Contorno
      primitives.add(createCylinder(140, 70, 400, 10, 1, 0x2E8B57));
      primitives.add(createCylinder(-140, 70, 220, 10, 1, 0x2E8B57));
      primitives.add(createCylinder(140, 70, 220, 10, 1, 0x2E8B57));
      primitives.add(createCylinder(0, 70, 400, 10, 1, 0x2E8B57));
      primitives.add(createCylinder(0, 70, 220, 10, 1, 0x2E8B57));
      primitives.add(createDisc(-140, 71, 400, 0, 360, 0, 10, 0x193c1d));//Buracos da Sinuca Preenchimento
      primitives.add(createDisc(140, 71, 400, 0, 360, 0, 10, 0x193c1d));
      primitives.add(createDisc(-140, 71, 220, 0, 360, 0, 10, 0x193c1d));
      primitives.add(createDisc(140, 71, 220, 0, 360, 0, 10, 0x193c1d));
      primitives.add(createDisc(0, 71, 400, 0, 360, 0, 10, 0x193c1d));
      primitives.add(createDisc(0, 71, 220, 0, 360, 0, 10, 0x193c1d));
      primitives.add(createSphere(30, 78, 310, 8, 0xffd700)); //Bolas da Sinuca
      primitives.add(createSphere(45, 78, 320, 8, 0x0028ff)); //Segunda Linha
      primitives.add(createSphere(45, 78, 300, 8, 0xee0000));
      primitives.add(createSphere(60, 78, 330, 8, 0x800080)); //Terceira Linha
      primitives.add(createSphere(60, 78, 310, 8, 0xffa500)); 
      primitives.add(createSphere(60, 78, 290, 8, 0x408d78));
      primitives.add(createSphere(75, 78, 340, 8, 0x834a4a)); //Quarta Linha
      primitives.add(createSphere(75, 78, 320, 8, 0x000000));
      primitives.add(createSphere(75, 78, 300, 8, 0xffd700));
      primitives.add(createSphere(75, 78, 280, 8, 0x0028ff));
      primitives.add(createSphere(90, 78, 350, 8, 0xee0000)); //Quinta Linha
      primitives.add(createSphere(90, 78, 330, 8, 0x800080));
      primitives.add(createSphere(90, 78, 310, 8, 0xffa500));
      primitives.add(createSphere(90, 78, 290, 8, 0x408d78));
      primitives.add(createSphere(90, 78, 270, 8, 0x834a4a));

     
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
