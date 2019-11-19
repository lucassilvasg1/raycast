package lucas.raycasting.tracer;

import lucas.raycasting.vector.Vector;

public class Light
{
   private Vector point;

   public Light(Vector point)
   {
      this.point = point;
   }

   public Vector getPoint()
   {
      return point;
   }
}
