package script;

import java.util.ArrayList;
import java.awt.Graphics;

public class Controller {
    GamePanel gp;
    private ArrayList<Elettrone> electrons;


    public Controller(GamePanel gp){
        electrons = new ArrayList<>();
        
        // Initialize electrons with random positions or fixed ones
        electrons.add(new Elettrone(gp));
        electrons.add(new Elettrone(gp,(gp.screenWidth / 2 - gp.tileSize / 2)+50,(gp.screenHeight / 2 - gp.tileSize / 2)+50));
        System.out.println(electrons.get(0).freeze);
        System.out.println(electrons.get(1).freeze);
    }


    public void addElectrons(Elettrone e){
        electrons.add(e);
    }

    public void update(){
        
 
        for (int i = 0; i < electrons.size(); i++) {
            Elettrone current = electrons.get(i);
            for (int j = 0; j < electrons.size(); j++) {
                if (i != j) {
                    Elettrone target = electrons.get(j);
                    current.update(target); // Interaction logic (forces, etc.)
                }
            }
        }
            
    }
    
    public void draw(Graphics g){
        // Draw all electrons
        for (Elettrone electron : electrons) {
            electron.draw(g);
        }
    
    }
    
}
