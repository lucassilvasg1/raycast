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
  
   public List<Color> ambientColors = new ArrayList<Color>();
   public List<Color> diffuseColors = new ArrayList<Color>();
   public List<Color> specularColors = new ArrayList<Color>();

   public List<Geometry> listaRemovidos = new ArrayList<Geometry>();
   
   public static double rotationX = 0;
   
   public static double rotationY = 0;
   
   public static double distancia = 1500;

   public Controller(Viewer v, Scene s)
   {
      viewer = v;
      scene = s;
      camera = new Camera(distancia, viewer.getHeight());
      pixels = new int[viewer.getWidth() * viewer.getHeight()];
      tracer = new Tracer(pixels, viewer.getWidth(), viewer.getHeight());
      position1 = scene.lights.get(0).position.z;
      position2 = scene.lights.get(1).position.z;
      position3 = scene.lights.get(2).position.z;
      
      for (Geometry g : scene.primitives) {
    	  diffuseColors.add(g.getMaterial().getDiffuse());
      }
      
      for (Geometry g : scene.primitives) {
    	  ambientColors.add(g.getMaterial().getAmbient());
      }
      
      for (Geometry g : scene.primitives) {
    	  specularColors.add(g.getMaterial().getSpecular());
      }
   }

   public Viewer getView()
   {
      return viewer;
   }

   public void step()
   {
      camera.rotate(rotationX, rotationY);
      camera.distance = distancia;
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
        	 if(e.getKeyCode() == KeyEvent.VK_1)
             {
                Light l = scene.lights.get(0); 
                
                l.color =new Color(0, 0, 0);
                
             }
             
             if(e.getKeyCode() == KeyEvent.VK_2)
             {
                Light l = scene.lights.get(0); 
                
                l.color =new Color(0.5, 0.5, 0.5);
                
             }
             
             if(e.getKeyCode() == KeyEvent.VK_3)
             {
                Light l = scene.lights.get(0); 
                
                l.color =new Color(1, 1, 1);
                
             }
             if(e.getKeyCode() == KeyEvent.VK_4)
             {
                Light l = scene.lights.get(1); 
                
                l.color =new Color(0, 0, 0);
                
             }
             
             if(e.getKeyCode() == KeyEvent.VK_5)
             {
                Light l = scene.lights.get(1); 
                
                l.color =new Color(0, 0, 0.5);
                
             }
             
             if(e.getKeyCode() == KeyEvent.VK_6)
             {
                Light l = scene.lights.get(1); 
                
                l.color =new Color(0, 0, 1);
                
             }if(e.getKeyCode() == KeyEvent.VK_7)
             {
                 Light l = scene.lights.get(2); 
                 
                 l.color =new Color(0, 0, 0);
                 
              }
              
              if(e.getKeyCode() == KeyEvent.VK_8)
              {
                 Light l = scene.lights.get(2); 
                 
                 l.color =new Color(0.5, 0.5, 0.5);
                 
              }
              
              if(e.getKeyCode() == KeyEvent.VK_9)
              {
                 Light l = scene.lights.get(2); 
                 
                 l.color =new Color(1, 1, 1);
                 
              }
          
              
            if (e.getKeyCode() == KeyEvent.VK_A)
            {
            	for (Geometry g : scene.primitives) {
            		Color ambient = g.getMaterial().getAmbient();
            		g.setMaterial(new Material(ambient, new Color(0.0 , 0.0 , 0.0), new Color(0.0 , 0.0 , 0.0)));
            	}
 
            }
            
            if (e.getKeyCode() == KeyEvent.VK_S)
            {
                  for (Geometry g : scene.primitives)
                  {
                	 Color specular = g.getMaterial().getSpecular();
                     g.setMaterial(new Material(new Color(0.0, 0.0, 0.0), new Color(0.0, 0.0, 0.0), specular));
                  }
            }
            
            if (e.getKeyCode() == KeyEvent.VK_D)
            {
                  for (Geometry g : scene.primitives)
                  {
                	 Color diffuse = g.getMaterial().getDiffuse();
                     g.setMaterial(new Material(new Color(0.0, 0.0, 0.0), diffuse, new Color(0.0, 0.0, 0.0)));
                  }
            }
            
            if (e.getKeyCode() ==  KeyEvent.VK_R) {
            	int index = 0;
            	for (Geometry g : scene.primitives) {
            		Color ambient = ambientColors.get(index);
            		Color diffuse = diffuseColors.get(index);
            		Color specular = specularColors.get(index);
            		
            		g.setMaterial(new Material(ambient, diffuse, specular));
            		index = index + 1;
            	}
            }
            
            if(e.getKeyCode() == KeyEvent.VK_UP)
            {
               rotationX += 0.01;
               camera.rotate(rotationX, rotationY);
            }
            
            if(e.getKeyCode() == KeyEvent.VK_DOWN)
            {
               rotationX -= 0.001;
               camera.rotate(rotationX, rotationY);
            }
            if(e.getKeyCode() == KeyEvent.VK_LEFT)
            {
               rotationY += 0.001;
               camera.rotate(rotationX, rotationY);
            }
            
            if(e.getKeyCode() == KeyEvent.VK_RIGHT)
            {
               rotationY -= 0.001;
               camera.rotate(rotationX, rotationY);
            }
            if(e.getKeyCode() == KeyEvent.VK_MINUS)
            {
               distancia -= 5;
               camera.distance = distancia;
            }
            if(e.getKeyCode() == KeyEvent.VK_EQUALS)
            {
               distancia += 5;
               camera.distance = distancia;
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
            int ximg = (viewer.getWidth() - viewer.getImage().getWidth()) / 2;
            int yimg = (viewer.getHeight() - viewer.getImage().getHeight()) / 2;
            Point imgLocation = new Point(ximg, yimg);

            Point relative = e.getPoint();
            relative.x -= imgLocation.x;
            relative.y -= imgLocation.y;

            int x = relative.x - 300;
            int y = relative.y;

            int yStart = viewer.getHeight() >> 1;

            Ray ray = new Ray();
            camera.transform(ray.origin.set(0.0, 0.0, 1.0)).mul(-camera.distance);
            camera.transform(ray.direction.set(x, yStart - y, camera.fov)).normalize();

            Ray hitRay = new Ray();
            Geometry geometry = scene.intersect(ray, hitRay);

            System.out.println("x:" + x + " Y:" + y);

            if (geometry == null)
            {
               System.out.println("BACKGROUND");
            }
            else
            {
            	int index = scene.primitives.indexOf(geometry);
               scene.primitives.remove(geometry);
               ambientColors.remove(index);
               specularColors.remove(index);
               diffuseColors.remove(index);
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
