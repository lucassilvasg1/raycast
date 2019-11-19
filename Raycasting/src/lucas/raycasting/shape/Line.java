package lucas.raycasting.shape;

import lucas.raycasting.vector.Vector;

public class Line
{
   private Vector point;

   private Vector direction;

   public Line(Vector point, Vector direction)
   {
      this.point = point;
      this.direction = direction;
   }

   public Vector getPoint()
   {
      return point;
   }

   public Vector getDirection()
   {
      return direction;
   }
}
