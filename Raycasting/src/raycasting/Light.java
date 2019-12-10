package raycasting;

public class Light
{

   public Vector position;

   public Color color;

   public Light(double x, double y, double z, Color c)
   {
      position = new Vector(x, y, z);
      color = c;
   }
}
