package raycasting;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class Controller
{

   private final Viewer viewer;

   private final Scene scene;

   private Camera camera;

   private final Tracer tracer;

   private final int[] pixels;

   public final double position1, position2, position3;

   public static double POSITION = 1000000;

   public final Material material0;

   public static boolean materialTrue = true;

   public List<Geometry> listaRemovidos = new ArrayList<Geometry>();

   public Controller(Viewer v, Scene s)
   {
      viewer = v;
      scene = s;
      camera = new Camera(900.0, viewer.getHeight());
      pixels = new int[viewer.getWidth() * viewer.getHeight()];
      tracer = new Tracer(pixels, viewer.getWidth(), viewer.getHeight());
      position1 = scene.lights.get(0).position.z;
      position2 = scene.lights.get(1).position.z;
      position3 = scene.lights.get(2).position.z;
      material0 = scene.primitives.get(13).getMaterial();
   }

   public Viewer getView()
   {
      return viewer;
   }

   public void step()
   {
      camera.rotate(0.7, -0.3);
      camera.distance = 900;
      tracer.render(camera, scene);
      viewer.setRGB(pixels);

      viewer.addKeyListener(new KeyListener()
      {

         @Override
         public void keyTyped(KeyEvent e)
         {
         }

         @Override
         public void keyReleased(KeyEvent e)
         {
         }

         @Override
         public void keyPressed(KeyEvent e)
         {
            if (e.getKeyCode() == KeyEvent.VK_1)
            {
               Light l = scene.lights.get(0);

               if (l.position.z == POSITION)
               {
                  l.position.z = position1;
               }
               else
               {
                  l.position = new Vector(l.position.x, l.position.y, POSITION);
               }
            }
            if (e.getKeyCode() == KeyEvent.VK_2)
            {
               Light l = scene.lights.get(1);

               if (l.position.z == POSITION)
               {
                  l.position.z = position2;
               }
               else
               {
                  l.position = new Vector(l.position.x, l.position.y, POSITION);
               }
            }
            if (e.getKeyCode() == KeyEvent.VK_3)
            {
               Light l = scene.lights.get(2);

               if (l.position.z == POSITION)
               {
                  l.position.z = position3;
               }
               else
               {
                  l.position = new Vector(l.position.x, l.position.y, POSITION);
               }
            }
            if (e.getKeyCode() == KeyEvent.VK_M)
            {
               if (materialTrue == true)
               {
                  for (Geometry g : scene.primitives)
                  {
                     g.setMaterial(new Material(new Color(0.1745, 0.01175, 0.01175), new Color(0.61424, 0.04136, 0.04136),
                           new Color(0.727811, 0.626959, 0.626959)));
                  }
                  materialTrue = false;
               }
               else
               {
                  for (Geometry g : scene.primitives)
                  {
                     g.setMaterial(material0);
                  }
                  materialTrue = true;
               }

            }
         }
      });

      viewer.addMouseListener(new MouseListener()
      {
         @Override
         public void mouseReleased(MouseEvent e)
         {
         }

         @Override
         public void mousePressed(MouseEvent e)
         {
         }

         @Override
         public void mouseExited(MouseEvent e)
         {
         }

         @Override
         public void mouseEntered(MouseEvent e)
         {
         }

         @Override
         public void mouseClicked(MouseEvent e)
         {
            System.out.println(Thread.currentThread().getName()); 
            int ximg = (viewer.getWidth() - viewer.getImage().getWidth()) / 2;
            int yimg = (viewer.getHeight() - viewer.getImage().getHeight()) / 2;
            Point imgLocation = new Point(ximg, yimg);

            Point relative = e.getPoint();
            relative.x -= imgLocation.x;
            relative.y -= imgLocation.y;

            // -150, 60, -110, 150, 70, 110,
            int x = relative.x - 300;
            int y = relative.y;

            int xStart = viewer.getWidth() >> 1; // divide por dois
            int yStart = viewer.getHeight() >> 1;

            Ray ray = new Ray();
            camera.transform(ray.origin.set(0.0, 0.0, 1.0)).mul(-camera.distance);
            camera.transform(ray.direction.set(x, yStart - y, camera.fov)).normalize(); // multiplica
                                                                                        // o
                                                                                        // vetor
                                                                                        // pela
                                                                                        // matriz
                                                                                        // de
                                                                                        // transformação

            Ray hitRay = new Ray();
            Geometry geometry = scene.intersect(ray, hitRay);

            System.out.println("x:" + x + " Y:" + y);

            if (geometry == null)
            {
               System.out.println("BACKGROUND");
            }
            else
            {
               scene.primitives.remove(geometry);
               listaRemovidos.add(geometry);
               System.out.println(geometry.getClass().getCanonicalName());
            }

         }
      });

   }

   public Camera getCamera()
   {
      return camera;
   }
}
