package lucas.raycasting.vector;

public class Vector
{
   private double x, y, z;

   public Vector(double x, double y, double z)
   {
      this.x = x;
      this.y = y;
      this.z = z;
   }

   public Vector(Vector vector)
   {
      x = vector.x;
      y = vector.y;
      z = vector.z;
   }

   public void add(Vector vector)
   {
      x += vector.getX();
      y += vector.getY();
      z += vector.getZ();
   }

   public void subtract(Vector vector)
   {
      x -= vector.getX();
      y -= vector.getY();
      z -= vector.getZ();
   }

   public void multiply(double number)
   {
      x = x * number;
      y = y * number;
      z = z * number;
   }

   public void divide(double number)
   {
      x = x / number;
      y = y / number;
      z = z / number;
   }

   public double getMagnitude()
   {
      double sumSquares = Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2);
      return Math.sqrt(sumSquares);
   }

   public Vector getUnit()
   {
      Vector vector = new Vector(this);
      double magnitude = vector.getMagnitude();
      vector.divide(magnitude);
      return vector;
   }

   public double dot(Vector vector)
   {
      double dot = 0;
      dot += x * vector.x;
      dot += y * vector.y;
      dot += z * vector.z;
      return dot;
   }

   public boolean closer(Vector vector, Vector point)
   {
      Vector thisVector = new Vector(this);
      Vector otherVector = new Vector(vector);
      thisVector.subtract(point);
      otherVector.subtract(point);
      return thisVector.getMagnitude() < otherVector.getMagnitude();
   }

   public boolean isInfinite()
   {
      if (Math.abs(x) == Double.POSITIVE_INFINITY || Math.abs(y) == Double.POSITIVE_INFINITY || Math.abs(z) == Double.POSITIVE_INFINITY)
      {
         return true;
      }
      return false;
   }

   public double getX()
   {
      return x;
   }

   public double getY()
   {
      return y;
   }

   public double getZ()
   {
      return z;
   }

   public String toString()
   {
      return "(" + x + ", " + y + ", " + z + ")";
   }
}
