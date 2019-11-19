package lucas.raycasting;

import java.awt.BorderLayout;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import lucas.raycasting.image.Color;
import lucas.raycasting.image.Image;
import lucas.raycasting.shape.Line;
import lucas.raycasting.shape.Shape;
import lucas.raycasting.shape.Sphere;
import lucas.raycasting.tracer.Camera;
import lucas.raycasting.tracer.Light;
import lucas.raycasting.vector.Vector;

public class Main
{
   public static void main(String[] args) throws IOException
   {
      Image image = new Image(600, 600);

      Camera camera = new Camera(new Vector(0, 0, 1), new Vector(0, 0, -200), 600, 600);
      camera.generateLines();
      Line[][] lines = camera.getLines();

      Light light = new Light(new Vector(200, 200, -800));

      ArrayList<Shape> shapes = new ArrayList<Shape>();

      shapes.add(new Sphere(new Vector(0, 0, 500), 50));
      shapes.add(new Sphere(new Vector(-100, -100, 500), 50));

      for (int x = 0; x < image.getWidth(); x++)
      {
         for (int y = 0; y < image.getHeight(); y++)
         {
            int color = Color.toRGB(0, 0, 0);
            boolean nothing = true;
            Shape closest = null;
            double magnitude = 0;
            for (Shape shape : shapes)
            { // find the shape that is closest to the camera and intersects the
              // line
               if (shape.intersects(lines[x][y]))
               {
                  Vector distance = new Vector(shape.getIntersection());
                  distance.subtract(camera.getPoint());

                  if (nothing)
                  {
                     nothing = false;
                     closest = shape;
                     magnitude = distance.getMagnitude();
                  }
                  else if (distance.getMagnitude() < magnitude)
                  {
                     closest = shape;
                     magnitude = distance.getMagnitude();
                  }

               }
            }

            if (closest != null)
            { 
               // if shape intersects, render it based on lighting
               Vector normal = closest.getNormalIntersection();
               Vector lightVector = new Vector(closest.getIntersection());
               lightVector.subtract(light.getPoint());

               double dot = normal.getUnit().dot(lightVector.getUnit());

               dot = Math.abs(dot);

               if (dot > 0)
               {
                  int colorLight = (int) Math.round(dot * 255);
                  color = Color.toRGB(colorLight, colorLight, colorLight);
               }
               else
               {
                  color = Color.toRGB(0, 0, 0);
               }

               Line lightLine = new Line(light.getPoint(), lightVector);
               boolean shadowed = false;
               for (Shape shape : shapes)
               { // for all shapes
                  if (shape != closest && shape.intersects(lightLine))
                  { // if intersects light line
                     Vector shapeDistance = new Vector(shape.getIntersection());
                     shapeDistance.subtract(light.getPoint());
                     if (shapeDistance.getMagnitude() < lightVector.getMagnitude())
                     {
                        shadowed = true;
                     }

                  }
               }
               if (shadowed)
               {
                  color = Color.toRGB(0, 0, 0);
               }

            }
            image.setPixel(x, y, color);
         }
      }

      image.save("output.png");
      JLabel lbImage = new JLabel(new ImageIcon(image.getImage()));

      JFrame frame = new JFrame("Computação Gráfica - Raycasting");
      frame.getContentPane().add(lbImage, BorderLayout.CENTER);
      frame.setSize(800, 500);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}
