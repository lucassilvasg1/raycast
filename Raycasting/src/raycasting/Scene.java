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
      lights.add(createLight(0, 700, 0, 0xdbd3cd));// luz ping pong
      //lights.add(createLight(0, 400, 310, 0xFFFFFF));// luz sinuca
      lights.add(createLight(-680, 400, 110, 0x0028ff));// luz balcao bar
      lights.add(createLight(0, 400, 999, 0xdbd3cd));// luz sofa
      
      
      
      //chao
      primitives.add(createBox(-700, -30, -1000, 700, -29, 1000, 0x3c1301));
      primitives.add(createPlane(0, 1, 0, -30));
      //paredes
      primitives.add(createBox(-700, -30, -1000, -681, 470, 1000, 0x91a5ae)); //Oeste
      primitives.add(createBox(-700, -30, 1000, 700, 470, 1010, 0x6d7c85)); //Norte
      primitives.add(createBox(700, -30, -1000, 681, 470, 1000, 0x91a5ae)); //Leste
      
      // ping pong
      primitives.add(createSphere(-60, 75, -20, 4, 0xFFFFFF));//bola
      primitives.add(createBox(-150, 60, -110, 150, 70, 110, 0x91a5ae)); // mesa
      primitives.add(createBox(-1, 70, -110, 1, 75, 110, 0xFFFFFF));
      primitives.add(createBox(-150, 70, -1, 150, 71, 1, 0xFFFFFF)); 
      primitives.add(createCylinder(-90, -30, 70, 10, 90, 0xf4d58c));
      primitives.add(createCylinder(90, -30, 70, 10, 90, 0xf4d58c));
      primitives.add(createCylinder(-90, -30, -70, 10, 90, 0xf4d58c));
      primitives.add(createCylinder(90, -30, -70, 10, 90, 0xf4d58c));
      
      //Raquetes
      primitives.add(createBox(-55, 70, 10, -40, 75, 15, 0xf4d58c)); 
      primitives.add(createCylinder(-65, 71, 13, 10, 3, 0xe6c261));
      primitives.add(createDisc(-65, 74, 13, 0, 360, 0, 10, 0x3c1301));
      
      primitives.add(createBox(-55, 70, -55, -40, 75, -50, 0xf4d58c)); 
      primitives.add(createCylinder(-65, 71, -53, 10, 3, 0xe6c261));
      primitives.add(createDisc(-65, 74, -53, 0, 360, 0, 10, 0x3c1301));
      
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
      
      //Bolas da Sinuca
      primitives.add(createSphere(30, 78, 310, 8, 0xffd700)); //Primeira Linha
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
      
      //prateleiras
      primitives.add(createBox(-680, 130, -180, -640, 140, 410, 0x3c1301));
      primitives.add(createBox(-680, 170, -180, -640, 180, 410, 0x3c1301));
      
      //Garrafas prateleiras
      
      // Garrafa 1
      primitives.add(createBox(-660, 140, -175, -645, 160, -160, 0x7a0c0f));
      primitives.add(createBox(-655, 160, -170, -650, 165, -165, 0xb5fff6));
      
      // Garrafa 2
      primitives.add(createBox(-660, 140, -145, -645, 160, -130, 0x7a0c0f));
      primitives.add(createBox(-655, 160, -140, -650, 165, -135, 0xb5fff6));
      
      // Garrafa 3
      primitives.add(createBox(-660, 140, -115, -645, 160, -100, 0x7a0c0f));
      primitives.add(createBox(-655, 160, -110, -650, 165, -105, 0xb5fff6));
      
      // Garrafa 4
      primitives.add(createBox(-660, 140, -85, -645, 160, -70, 0x7a0c0f));
      primitives.add(createBox(-655, 160, -80, -650, 165, -75, 0xb5fff6));
      
      // Garrafa 5
      primitives.add(createBox(-660, 140, -55, -645, 160, -40, 0x0d1f64));
      primitives.add(createBox(-655, 160, -50, -650, 165, -45, 0xb5fff6));
      
      // Garrafa 6
      primitives.add(createBox(-660, 140, -25, -645, 160, -10, 0x0d1f64));
      primitives.add(createBox(-655, 160, -20, -650, 165, -15, 0xb5fff6));
      
      // Garrafa 7
      primitives.add(createBox(-660, 140, 05, -645, 160, 20, 0x0d1f64));
      primitives.add(createBox(-655, 160, 10, -650, 165, 15, 0xb5fff6));
      
      // Garrafa 8
      primitives.add(createBox(-660, 140, 35, -645, 160, 50, 0xf1f0f4));
      primitives.add(createBox(-655, 160, 40, -650, 165, 45, 0xb5fff6));
      
      // Garrafa 9
      primitives.add(createBox(-660, 140, 65, -645, 160, 80, 0xf1f0f4));
      primitives.add(createBox(-655, 160, 70, -650, 165, 75, 0xb5fff6));
      
      // Garrafa 10
      primitives.add(createBox(-660, 140, 95, -645, 160, 110, 0xf1f0f4));
      primitives.add(createBox(-655, 160, 100, -650, 165, 105, 0xb5fff6));
      
      // Garrafa 11
      primitives.add(createBox(-660, 140, 125, -645, 160, 140, 0xffd700));
      primitives.add(createBox(-655, 160, 130, -650, 165, 135, 0x58546d));
      
      // Garrafa 12
      primitives.add(createBox(-660, 140, 155, -645, 160, 170, 0xffd700));
      primitives.add(createBox(-655, 160, 160, -650, 165, 165, 0x58546d));
      
      // Garrafa 13
      primitives.add(createBox(-660, 140, 185, -645, 160, 200, 0xffd700));
      primitives.add(createBox(-655, 160, 190, -650, 165, 195, 0x58546d));

      // Garrafa 14
      primitives.add(createBox(-660, 140, 215, -645, 160, 230, 0xffd700));
      primitives.add(createBox(-655, 160, 220, -650, 165, 225, 0x58546d));
      
      // Garrafa 15
      primitives.add(createBox(-660, 140, 245, -645, 160, 260, 0xffd700));
      primitives.add(createBox(-655, 160, 250, -650, 165, 255, 0x58546d));

      // Garrafa 16
      primitives.add(createBox(-660, 140, 275, -645, 160, 290, 0xffd700));
      primitives.add(createBox(-655, 160, 280, -650, 165, 285, 0x58546d));

      // Garrafa 17
      primitives.add(createBox(-660, 140, 305, -645, 160, 320, 0xffd700));
      primitives.add(createBox(-655, 160, 310, -650, 165, 315, 0x58546d));

      // Garrafa 18
      primitives.add(createBox(-660, 140, 335, -645, 160, 350, 0xc0c0c0));
      primitives.add(createBox(-655, 160, 340, -650, 165, 345, 0x58546d));
      
      // Garrafa 19
      primitives.add(createBox(-660, 140, 365, -645, 160, 380, 0xc0c0c0));
      primitives.add(createBox(-655, 160, 370, -650, 165, 375, 0x58546d));
      
      // Garrafa 20
      primitives.add(createBox(-660, 140, 395, -645, 160, 410, 0xc0c0c0));
      primitives.add(createBox(-655, 160, 400, -650, 165, 405, 0x58546d));
      
      
      // Garrafa 1
      primitives.add(createBox(-660, 180, -175, -645, 200, -160, 0x88b14b));
      primitives.add(createBox(-655, 200, -170, -650, 205, -165, 0x000000));
      
      // Garrafa 2
      primitives.add(createBox(-660, 180, -145, -645, 200, -130, 0x88b14b));
      primitives.add(createBox(-655, 200, -140, -650, 205, -135, 0x000000));
      
      // Garrafa 3
      primitives.add(createBox(-660, 180, -115, -645, 200, -100, 0x88b14b));
      primitives.add(createBox(-655, 200, -110, -650, 205, -105, 0x000000));
      
      // Garrafa 4
      primitives.add(createBox(-660, 180, -85, -645, 200, -70, 0x88b14b));
      primitives.add(createBox(-655, 200, -80, -650, 205, -75, 0x000000));
      
      // Garrafa 5
      primitives.add(createBox(-660, 180, -55, -645, 200, -40, 0x88b14b));
      primitives.add(createBox(-655, 200, -50, -650, 205, -45, 0x000000));
      
      // Garrafa 6
      primitives.add(createBox(-660, 180, -25, -645, 200, -10, 0x005582));
      primitives.add(createBox(-655, 200, -20, -650, 205, -15, 0xb5fff6));
      
      // Garrafa 7
      primitives.add(createBox(-660, 180, 05, -645, 200, 20, 0x005582));
      primitives.add(createBox(-655, 200, 10, -650, 205, 15, 0xb5fff6));
      
      // Garrafa 8
      primitives.add(createBox(-660, 180, 35, -645, 200, 50, 0x005582));
      primitives.add(createBox(-655, 200, 40, -650, 205, 45, 0xb5fff6));
      
      // Garrafa 9
      primitives.add(createBox(-660, 180, 65, -645, 200, 80, 0x005582));
      primitives.add(createBox(-655, 200, 70, -650, 205, 75, 0xb5fff6));
      
      // Garrafa 10
      primitives.add(createBox(-660, 180, 95, -645, 200, 110, 0x005582));
      primitives.add(createBox(-655, 200, 100, -650, 205, 105, 0xb5fff6));
      
      // Garrafa 11
      primitives.add(createBox(-660, 180, 125, -645, 200, 140, 0xff009d));
      primitives.add(createBox(-655, 200, 130, -650, 205, 135, 0xb5fff6));
      
      // Garrafa 12
      primitives.add(createBox(-660, 180, 155, -645, 200, 170, 0xee5a40));
      primitives.add(createBox(-655, 200, 160, -650, 205, 165, 0xb14b88));
      
      // Garrafa 13
      primitives.add(createBox(-660, 180, 185, -645, 200, 200, 0xffc828));
      primitives.add(createBox(-655, 200, 190, -650, 205, 195, 0xb5fff6));

      // Garrafa 14
      primitives.add(createBox(-660, 180, 215, -645, 200, 230, 0x000000));
      primitives.add(createBox(-655, 200, 220, -650, 205, 225, 0xffd700));
      
      // Garrafa 15
      primitives.add(createBox(-660, 180, 245, -645, 200, 260, 0x000000));
      primitives.add(createBox(-655, 200, 250, -650, 205, 255, 0xffd700));

      // Garrafa 16
      primitives.add(createBox(-660, 180, 275, -645, 200, 290, 0x0028ff));
      primitives.add(createBox(-655, 200, 280, -650, 205, 285, 0xb5fff6));

      // Garrafa 17
      primitives.add(createBox(-660, 180, 305, -645, 200, 320, 0x7a0c0f));
      primitives.add(createBox(-655, 200, 310, -650, 205, 315, 0x0d1f64));

      // Garrafa 18
      primitives.add(createBox(-660, 180, 335, -645, 200, 350, 0x7a0c0f));
      primitives.add(createBox(-655, 200, 340, -650, 205, 345, 0x0d1f64));
      
      // Garrafa 19
      primitives.add(createBox(-660, 180, 365, -645, 200, 380, 0xc0c0c0));
      primitives.add(createBox(-655, 200, 370, -650, 205, 375, 0x58546d));
      
      // Garrafa 20
      primitives.add(createBox(-660, 180, 395, -645, 200, 410, 0xc0c0c0));
      primitives.add(createBox(-655, 200, 400, -650, 205, 405, 0x58546d));
      
      //balcao do bar
      
      primitives.add(createBox(-490, -30, -200, -470, 90, 410, 0x3c1301)); //base
      primitives.add(createBox(-680, -30, -220, -490, 90, -200, 0x3c1301));
      primitives.add(createBox(-500, 90, -180, -460, 100, 410, 0x3c1301));//balcao
      primitives.add(createBox(-680, 90, -220, -460, 100, -180, 0x3c1301));
      
      //bebidas do balcao
      //Chop 1
      primitives.add(createCylinder(-476, 100, -100, 7, 13, 0xcca50a)); //corpo do copo
      primitives.add(createCylinder(-476, 113, -100, 7, 4, 0xe0e5e7));
      primitives.add(createDisc(-476, 117, -100, 0, 360, 0, 7, 0xe0e5e7));
      primitives.add(createBox(-478, 112, -107, -474, 114, -112, 0xebfffd));//Braço do copo
      primitives.add(createBox(-478, 102, -110, -474, 114, -112, 0xebfffd));
      primitives.add(createBox(-478, 102, -107, -474, 104, -112, 0xebfffd));
      
      //Chop 2
      primitives.add(createCylinder(-484, 100, 0, 7, 13, 0xcca50a)); //corpo do copo
      primitives.add(createCylinder(-484, 113, 0, 7, 4, 0xe0e5e7));
      primitives.add(createDisc(-484, 117, 0, 0, 360, 0, 7, 0xe0e5e7));
      primitives.add(createBox(-486, 112, -7, -482, 114, -12, 0xebfffd));//Braço do copo
      primitives.add(createBox(-486, 102, -10, -482, 114, -12, 0xebfffd));
      primitives.add(createBox(-486, 102, -7, -482, 104, -12, 0xebfffd));
      
      //Chop 3
      primitives.add(createCylinder(-480, 100, 100, 7, 13, 0xcca50a)); //corpo do copo
      primitives.add(createCylinder(-480, 113, 100, 7, 4, 0xe0e5e7));
      primitives.add(createDisc(-480, 117, 100, 0, 360, 0, 7, 0xe0e5e7));
      primitives.add(createBox(-482, 112, 93, -478, 114, 88, 0xebfffd));//Braço do copo
      primitives.add(createBox(-482, 102, 90, -478, 114, 88, 0xebfffd));
      primitives.add(createBox(-482, 102, 93, -478, 104, 88, 0xebfffd));
      
      //Chop 4
      primitives.add(createCylinder(-488, 100, 200, 7, 13, 0xcca50a)); //corpo do copo
      primitives.add(createCylinder(-488, 113, 200, 7, 4, 0xe0e5e7));
      primitives.add(createDisc(-488, 117, 200, 0, 360, 0, 7, 0xe0e5e7));
      primitives.add(createBox(-490, 112, 193, -486, 114, 188, 0xebfffd));//Braço do copo
      primitives.add(createBox(-490, 102, 190, -486, 114, 188, 0xebfffd));
      primitives.add(createBox(-490, 102, 193, -486, 104, 188, 0xebfffd));
      
      //Chop 5
      primitives.add(createCylinder(-476, 100, 300, 7, 13, 0xcca50a)); //corpo do copo
      primitives.add(createCylinder(-476, 113, 300, 7, 4, 0xe0e5e7));
      primitives.add(createDisc(-476, 117, 300, 0, 360, 0, 7, 0xe0e5e7));
      primitives.add(createBox(-478, 112, 293, -474, 114, 288, 0xebfffd));//Braço do copo
      primitives.add(createBox(-478, 102, 290, -474, 114, 288, 0xebfffd));
      primitives.add(createBox(-478, 102, 293, -474, 104, 288, 0xebfffd));
      
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
      
      //mesa do sofa
      primitives.add(createBox(-100, 10, 800, 100, 20, 680, 0x91a5ae)); //base
      primitives.add(createCylinder(-80, -30, 780, 3, 40, 0xf4d58c)); //pés da mesa
      primitives.add(createCylinder(80, -30, 780, 3, 40, 0xf4d58c));
      primitives.add(createCylinder(-80, -30, 700, 3, 40, 0xf4d58c));
      primitives.add(createCylinder(80, -30, 700, 3, 40, 0xf4d58c));
      
      
      //Sofa
      primitives.add(createBox(-150, -30, 990, 150, 20, 860, 0xe6c261)); //base
      primitives.add(createBox(-150, -30, 990, 150, 70, 960, 0xe6c261)); //encosto
      primitives.add(createBox(-180, -30, 990, -150, 40, 860, 0xf4d58c)); //braços
      primitives.add(createBox(150, -30, 990, 180, 40, 860, 0xf4d58c));
      
      //Poltrona Leste
      primitives.add(createBox(200, -30, 800, 330, 20, 680, 0xe6c261)); //base
      primitives.add(createBox(300, -30, 800, 330, 70, 680, 0xe6c261)); //encosto
      primitives.add(createBox(200, -30, 830, 330, 40, 800, 0xf4d58c)); //braços
      primitives.add(createBox(200, -30, 680, 330, 40, 650, 0xf4d58c));
      
      //Poltrona Oeste
      primitives.add(createBox(-330, -30, 800, -200, 20, 680, 0xe6c261)); //base
      primitives.add(createBox(-330, -30, 800, -300, 70, 680, 0xe6c261)); //encosto
      primitives.add(createBox(-330, -30, 830, -200, 40, 800, 0xf4d58c)); //braços
      primitives.add(createBox(-330, -30, 680, -200, 40, 650, 0xf4d58c));
      
      
      
      

     
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
