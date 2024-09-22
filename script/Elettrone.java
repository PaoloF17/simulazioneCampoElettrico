package script;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


public class Elettrone {
    GamePanel gp;

    public Rectangle solidArea;
    BufferedImage circle;
    double posX,posY,vx=2,vy;
    boolean freeze;//tenere la particella fissa o in movimento



    public Elettrone(GamePanel gp,double posX,double posY){
        freeze=false;
        this.gp=gp;
        this.posX=posX;
        this.posY=posY;

        solidArea= new Rectangle(8,16,gp.tileSize-16,gp.tileSize-16);
  
        Image();
    }

    // Default constructor (without arguments and center of the screen)
    public Elettrone(GamePanel gp) {
        freeze=true;
        this.gp = gp;
        this.posX = gp.screenWidth / 2 - gp.tileSize / 2;
        this.posY = gp.screenHeight / 2 - gp.tileSize / 2;

        solidArea = new Rectangle(8, 16, gp.tileSize - 16, gp.tileSize - 16);

        Image();
    }

    
    public void Image(){
        try{
            circle=ImageIO.read(getClass().getResourceAsStream("/img/round.png"));
            
        }
        catch (Exception e) {
            e.printStackTrace(); 
        }
    }

    public void draw(Graphics g){      
        if (circle != null) {
            g.drawImage(circle, (int) posX, (int) posY, gp.tileSize/4, gp.tileSize/4, null);
        }else{
            System.out.println("L'immagine del cerchio non è stata caricata.");

        }
       
    }


    public double distance(Elettrone e) {
        double dX = this.posX - e.posX;
        double dY = this.posY - e.posY;
        return Math.sqrt(Math.pow(dX, 2) + Math.pow(dY, 2));
    }


    //da capire il positivo e il negaativo

    public double distanceX(Elettrone e) {
        System.out.println(this.posX - e.posX);
        return this.posX - e.posX;
    }

    public double distanceY(Elettrone e) {
        return this.posY - e.posY;
    }


    // Update method (you can add electron-specific logic here)
    public void update(Elettrone e) {
        
        if (!freeze){

            

            
            
        }
         
        
    }



}
