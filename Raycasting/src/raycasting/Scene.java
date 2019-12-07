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
      lights.add(createLight(0, 400, 0, 0xFFFFFF));// luz ping pong
      //lights.add(createLight(0, 400, 310, 0xFFFFFF));// luz sinuca
      lights.add(createLight(-700, 200, 110, 0xFFFFFF));// luz balcao bar
      
      //chao
      primitives.add(createBox(-1000, -30, -1000, 1000, -29, 1000, 0x4a2010));
      primitives.add(createPlane(0, 1, 0, -30));
      // ping pong
      primitives.add(createSphere(-60, 115, -20, 4, 0xFFFFFF));
      primitives.add(createBox(-150, 60, -110, 150, 70, 110, 0x91a5ae)); // mesa
      primitives.add(createBox(-1, 70, -110, 1, 75, 110, 0xFFFFFF));
      primitives.add(createBox(-150, 70, -1, 150, 71, 1, 0xFFFFFF)); 
      primitives.add(createCylinder(-90, -30, 70, 10, 90, 0xf4d58c));
      primitives.add(createCylinder(90, -30, 70, 10, 90, 0xf4d58c));
      primitives.add(createCylinder(-90, -30, -70, 10, 90, 0xf4d58c));
      primitives.add(createCylinder(90, -30, -70, 10, 90, 0xf4d58c));
      
      // sinuca
      primitives.add(createBox(-150, 40, 410, 150, 70, 210, 0x54603a)); // mesa
      primitives.add(createBox(-120, 20, 410, 120, 40, 210, 0x54603a));
      primitives.add(createBox(-30, 30, 210, 30, 50, 208, 0x3c1301)); //Gaveta das bolas
      primitives.add(createBox(-10, 40, 208, 10, 45, 206, 0x3c1301));
      primitives.add(createBox(-155, 70, 420, -150, 74, 200, 0x3c1301));//bordas da mesa
      primitives.add(createBox(155, 70, 420, 150, 74, 200, 0x3c1301));
      primitives.add(createBox(-150, 70, 420, 150, 74, 410, 0x3c1301));
      primitives.add(createBox(-150, 70, 210, 150, 74, 200, 0x3c1301));
      primitives.add(createCylinder(-140, -30, 400, 6, 70, 0xf4d58c)); //pés da sinuca
      primitives.add(createCylinder(140, -30, 400, 6, 70, 0xf4d58c));
      primitives.add(createCylinder(-140, -30, 220, 6, 70, 0xf4d58c));
      primitives.add(createCylinder(140, -30, 220, 6, 70, 0xf4d58c));
      primitives.add(createCylinder(-140, 70, 400, 10, 1, 0x54603a)); //Buracos da Sinuca Contorno
      primitives.add(createCylinder(140, 70, 400, 10, 1, 0x54603a));
      primitives.add(createCylinder(-140, 70, 220, 10, 1, 0x54603a));
      primitives.add(createCylinder(140, 70, 220, 10, 1, 0x54603a));
      primitives.add(createCylinder(0, 70, 400, 10, 1, 0x54603a));
      primitives.add(createCylinder(0, 70, 220, 10, 1, 0x54603a));
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
      
      //balcao do bar
      
      primitives.add(createBox(-490, -30, -200, -470, 90, 410, 0x3c1301)); //base
      primitives.add(createBox(-490, -30, -220, -630, 90, -200, 0x3c1301));
      primitives.add(createBox(-500, 90, -180, -460, 100, 410, 0x3c1301));//balcao
      primitives.add(createBox(-460, 90, -220, -630, 100, -180, 0x3c1301));
      
      //Cadeiras balcao
      
      // Cadeira 1
      primitives.add(createDisc(-380, 80, -100, 0, 360, 0, 25, 0x834747));//poltrona
      primitives.add(createCylinder(-380, 70, -100, 25, 10, 0x964a4a));
      primitives.add(createCylinder(-380, -25, -100, 5, 100, 0x6d7c85));//haste
      primitives.add(createBox(-407, -30, -105, -353, -25, -95, 0x6d7c85));//base
      primitives.add(createBox(-385, -30, -127, -375, -25, -73, 0x6d7c85));
      
      // Cadeira 2
      primitives.add(createDisc(-380, 80, 0, 0, 360, 0, 25, 0x834747));//poltrona
      primitives.add(createCylinder(-380, 70, 0, 25, 10, 0x964a4a));
      primitives.add(createCylinder(-380, -25, 0, 5, 100, 0x6d7c85));//haste
      primitives.add(createBox(-407, -30, -5, -353, -25, 5, 0x6d7c85));//base
      primitives.add(createBox(-385, -30, -27, -375, -25, 27, 0x6d7c85));
      
      // Cadeira 3
      primitives.add(createDisc(-380, 80, 100, 0, 360, 0, 25, 0x834747));//poltrona
      primitives.add(createCylinder(-380, 70, 100, 25, 10, 0x964a4a));
      primitives.add(createCylinder(-380, -25, 100, 5, 100, 0x6d7c85));//haste
      primitives.add(createBox(-407, -30, 95, -353, -25, 105, 0x6d7c85));//base
      primitives.add(createBox(-385, -30, 73, -375, -25, 127, 0x6d7c85));
      
      // Cadeira 4
      primitives.add(createDisc(-380, 80, 200, 0, 360, 0, 25, 0x834747));//poltrona
      primitives.add(createCylinder(-380, 70, 200, 25, 10, 0x964a4a));
      primitives.add(createCylinder(-380, -25, 200, 5, 100, 0x6d7c85));//haste
      primitives.add(createBox(-407, -30, 195, -353, -25, 205, 0x6d7c85));//base
      primitives.add(createBox(-385, -30, 173, -375, -25, 227, 0x6d7c85));
      
      // Cadeira 5
      primitives.add(createDisc(-380, 80, 300, 0, 360, 0, 25, 0x834747));//poltrona
      primitives.add(createCylinder(-380, 70, 300, 25, 10, 0x964a4a));
      primitives.add(createCylinder(-380, -25, 300, 5, 100, 0x6d7c85));//haste
      primitives.add(createBox(-407, -30, 295, -353, -25, 305, 0x6d7c85));//base
      primitives.add(createBox(-385, -30, 273, -375, -25, 327, 0x6d7c85));
      
      

     
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
