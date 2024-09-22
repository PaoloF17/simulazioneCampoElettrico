package script;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;


public class GamePanel extends JPanel implements Runnable{

    //SCREEN SETTINGS (p= pixels) 
    final int originalTileSize= 8; //8x8 p tile
    final int scale = 8;
    final int tileSize= originalTileSize*scale;// 64*64 p = 1m

    public final int maxScreenCol= 20;
    public final int maxScreenRow= 16;

    public final int screenWidth= tileSize* maxScreenCol; //1280 p
    public final int screenHeight= tileSize* maxScreenRow; //1024 p

    // WORLD SETTINGS 
    public final int maxWorldCol=50; 
    public final int maxWorldRow=50;
    public final int worldWidth= tileSize*maxWorldCol;  //3200
    public final int worldHeight=tileSize*maxScreenRow; //3200


    Controller controller;
    Thread gameThread;
    int FPS=60;


    public GamePanel(){

        
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);//better rendering performancce-
        this.setFocusable(true);
        this.controller= new Controller(this);
        
    }



    public void startGameThread(){
        gameThread= new Thread(this);
        gameThread.start();//calls run method

    }

    @Override
    public void run() {
        
        double drawInterval= 1000000000/FPS;                    //.166 sec tra 2 foto
        double nextDrawTime= System.nanoTime() + drawInterval;
        
        while(gameThread!=null){
            
            // 1)  UPDATE info
            update();
            
            // 2) DRAW on screen updated info 
            repaint();// calls paintComponent

            try {
                double remainingTime= nextDrawTime-System.nanoTime();
                remainingTime= remainingTime/1000000;

                if(remainingTime<0){
                    remainingTime=0;
                }

                Thread.sleep((long) remainingTime);

                nextDrawTime +=drawInterval;

            } catch (InterruptedException e) {
                
                e.printStackTrace();
            }
        }
    }


    public void update(){
        controller.update();
        
           
    }
    //repaint();
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        controller.draw(g);
        g.dispose();//works better
    }

}
