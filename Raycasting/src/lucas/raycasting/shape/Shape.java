package lucas.raycasting.shape;

import lucas.raycasting.vector.Vector;

public interface Shape
{
   public boolean intersects(Line line);

   public Vector getIntersection();

   public Vector getNormalIntersection();
}
