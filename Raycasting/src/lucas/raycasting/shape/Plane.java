package lucas.raycasting.shape;

import lucas.raycasting.vector.Vector;

public class Plane implements Shape
{

   private Vector point;

   private Vector normal;

   private Vector intersection;

   public Plane(Vector point, Vector normal)
   {
      this.point = point;
      this.normal = normal;
   }

   public boolean intersects(Line line)
   {

      if (line.getDirection().getUnit().dot(normal.getUnit()) == 0)
      {
         return false;
      }

      double numerator = (normal.getX() * (point.getX() - line.getPoint().getX()))
                         + (normal.getY() * (point.getY() - line.getPoint().getY()))
                         + (normal.getZ() * (point.getZ() - line.getPoint().getZ()));

      double denominator = (normal.getX() * line.getDirection().getX())
                           + (normal.getY() * line.getDirection().getY())
                           + (normal.getZ() * line.getDirection().getZ());

      double t = numerator / denominator;

      intersection = solvePoint(t, line.getPoint(), line.getDirection());

      if (intersection.isInfinite())
      {
         return false;
      }

      return true;
   }

   private Vector solvePoint(double t, Vector point, Vector direction)
   { // TODO move to line class
      double x = point.getX() + (t * direction.getX());
      double y = point.getY() + (t * direction.getY());
      double z = point.getZ() + (t * direction.getZ());
      return new Vector(x, y, z);
   }

   public Vector getIntersection()
   {
      return intersection;
   }

   public Vector getNormalIntersection()
   {
      return normal;
   }
}
