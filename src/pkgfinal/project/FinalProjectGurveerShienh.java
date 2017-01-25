package pkgfinal.project;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author shieg0688
 */


public class FinalProjectGurveerShienh extends JComponent implements KeyListener{

    // Height and Width of our game
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    
    // sets the framerate and delay for our game
    // you just need to select an approproate framerate
    long desiredFPS = 60;
    long desiredTime = (1000)/desiredFPS;
    
    //environment variables
    
    Color skyColour = new Color(135, 206, 235);
    Color groundColour = new Color(100,100,100);
    
    //create monsters
    
     Rectangle monster1 = new Rectangle(1000, 370, 80, 80);
     Rectangle monster2 = new Rectangle(1500, 330, 100, 120);
     Rectangle monster3 = new Rectangle(2100, 370, 50, 80);
     Rectangle monster4 = new Rectangle(2500, 390, 40, 60);
     Rectangle monster5 = new Rectangle(3600, 375, 80, 75);
     Rectangle monster6 = new Rectangle(4200, 350, 120, 100);
     Rectangle monster7 = new Rectangle(4800, 340, 150, 110);
     Rectangle monster8 = new Rectangle(5500, 390, 20, 60);
     Rectangle monster9 = new Rectangle(6000, 330, 180, 120);
     Rectangle monster10 = new Rectangle(6400, 380, 100, 70);
     Rectangle monster11 = new Rectangle(7400, 370, 15, 80);
     Rectangle monster12 = new Rectangle(8500, 360, 40, 90);
     Rectangle monster13 = new Rectangle(9000, 350, 80, 100);
     Rectangle monster14 = new Rectangle(9700, 410, 100, 40);
     Rectangle monster15 = new Rectangle(10000, 310, 150, 140);
     Rectangle monster16 = new Rectangle(10800, 390, 60, 60);
 
    
    
    
   
    //entity variables
    
    Rectangle dude = new Rectangle(150, 400, 50, 50);
    Color skin = new Color(189, 115, 75);
    
    //start & end variables
    
    boolean start = false;
    
    //movement variables
    
    boolean jump = false;
    int jumpVelocity = -25;
   
    
    //gravity 
    
    int gravity = 7;
    
    //monster speed
    
    int gameSpeed = -7;
    
    //hitboxes
    int hitboxY = 50;
    int hitboxX = 50;
    
    //dude movement
    int movementVelocity = 10;
    boolean moveLeft = false;
    boolean moveRight = false;

    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g)
    {
        // always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);
        
        // GAME DRAWING GOES HERE 
        
        //change sky colour
        
        g.setColor(skyColour);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        
        //create ground
        
        g.setColor(groundColour);
        g.fillRect(0, 450, WIDTH, 150);
        
        //create player
        
        g.setColor(skin);
        g.fillRect(dude.x, dude.y, dude.width, dude.height);
        
       
        
       
        //color monsters
        
        g.setColor(Color.BLACK);
        g.fillRect(monster1.x, monster1.y, monster1.width, monster1.height);
        g.fillRect(monster4.x, monster4.y, monster4.width, monster4.height);
        g.fillRect(monster8.x, monster8.y, monster8.width, monster8.height);
        g.fillRect(monster12.x, monster12.y, monster12.width, monster12.height);
        
        g.setColor(Color.RED);
        g.fillRect(monster2.x, monster2.y, monster2.width, monster2.height);
        g.fillRect(monster5.x, monster5.y, monster5.width, monster5.height);
        g.fillRect(monster9.x, monster9.y, monster9.width, monster9.height);
        g.fillRect(monster13.x, monster13.y, monster13.width, monster13.height);
        
        g.setColor(Color.MAGENTA);
        g.fillRect(monster3.x, monster3.y, monster3.width, monster3.height);
        g.fillRect(monster6.x, monster6.y, monster6.width, monster6.height);
        g.fillRect(monster10.x, monster10.y, monster10.width, monster10.height);
        g.fillRect(monster14.x, monster14.y, monster14.width, monster14.height);
        
        g.setColor(Color.YELLOW);
        g.fillRect(monster16.x, monster16.y, monster16.width, monster16.height);
        g.fillRect(monster7.x, monster7.y, monster7.width, monster7.height);
        g.fillRect(monster11.x, monster11.y, monster11.width, monster11.height);
        g.fillRect(monster15.x, monster15.y, monster15.width, monster15.height);
        
        
           
        
     
        
        // GAME DRAWING ENDS HERE
    
    
    }
    
    // The main game loop
    // In here is where all the logic for my game will go
    public void run(){


        // Used to keep track of time used to draw and update the game
        // This is used to limit the framerate later on
        long startTime;
        long deltaTime;
        
        
       
       
        
        
        // the main game loop section
        // game will end if you set done = false;
        boolean done = false; 
        while(!done){

            // determines when we started so we can keep a framerate
            startTime = System.currentTimeMillis();
            
            // all your game rules and move is done in here
            // GAME LOGIC STARTS HERE 
            
            //move monsters
            if(start == true){
            monster1.x = monster1.x + gameSpeed;
            monster2.x = monster2.x + gameSpeed;
            monster3.x = monster3.x + gameSpeed;
            monster4.x = monster4.x + gameSpeed;
            monster5.x = monster5.x + gameSpeed;
            monster6.x = monster6.x + gameSpeed;
            monster7.x = monster7.x + gameSpeed;
            monster8.x = monster8.x + gameSpeed;
            monster9.x = monster9.x + gameSpeed;
            monster10.x = monster10.x + gameSpeed;
            monster11.x = monster11.x + gameSpeed;
            monster12.x = monster12.x + gameSpeed;
            monster13.x = monster13.x + gameSpeed;
            monster14.x = monster14.x + gameSpeed;
            monster15.x = monster15.x + gameSpeed;
            monster16.x = monster16.x + gameSpeed;
            
            //loop monster spawning
            
            if(monster1.x == 150){
               monster1.x = 11000;
                
            }
            if(monster2.x == -300){
               monster2.x = 11000;
                
            }
            if(monster3.x == -300){
               monster3.x = 11000;
                
            }
            if(monster4.x == -300){
               monster4.x = 11000;
                
            }
            if(monster5.x == -300){
               monster5.x = 11000;
                
            }
            if(monster6.x == -300){
               monster6.x = 11000;
                
            }
            if(monster7.x == -300){
               monster7.x = 11000;
                
            }
            if(monster8.x == -300){
               monster8.x = 11000;
                
            }
            if(monster9.x == -300){
               monster9.x = 11000;
                
            }
            if(monster10.x == -300){
               monster10.x = 11000;
                
            }
            if(monster11.x == -300){
               monster11.x = 11000;
                
            }
            
            if(monster13.x == -300){
               monster13.x = 11000;
                
            }
            if(monster14.x == -300){
               monster14.x = 11000;
                
            }
            if(monster15.x == -300){
               monster15.x = 11000;
                
            }
            if(monster16.x == -300){
               monster16.x = 11000;
                
            }
            
            //hit detection
            if (dude.x == (monster1.x - hitboxX)) {
                        
                            done = true;
                        
            }
            
            if(dude.x == monster1.x){
                done = true;
            }
            
            //create gravity 
            
            if(dude.y < 400){
                dude.y = dude.y + gravity;
            }
            
            //change y coordinates for jump
            
                
             if(jump == true){
                dude.y = dude.y + jumpVelocity;
            }
             //change x coordinates for movement
             if(moveLeft == true){
                 dude.x = dude.x - movementVelocity;
             }
             if(moveRight == true){
                 dude.x = dude.x + movementVelocity;
             }
             
            
            }
            
            
            
            
            
            
            
            
            
          
            
            // GAME LOGIC ENDS HERE 
            
            // update the drawing (calls paintComponent)
            repaint();
            
            
            
            // SLOWS DOWN THE GAME BASED ON THE FRAMERATE ABOVE
            // USING SOME SIMPLE MATH
            deltaTime = System.currentTimeMillis() - startTime;
            try
            {
               if(deltaTime > desiredTime)
               {
                   //took too much time, don't wait
                   Thread.sleep(1);
               }else{
                  // sleep to make up the extra time
                 Thread.sleep(desiredTime - deltaTime);
               }
            }catch(Exception e){};
        }
    }



    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates a windows to show my game
        JFrame frame = new JFrame("My Game");
       
        // creates an instance of my game
        FinalProjectGurveerShienh game = new FinalProjectGurveerShienh();
        // sets the size of my game
        game.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        // adds the game to the window
        frame.add(game);
         
        // sets some options and size of the window automatically
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        // shows the window to the user
        frame.setVisible(true);
        frame.addKeyListener(game);
        // starts my game loop
        game.run();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            start = true;
        }
            
    }
         

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP) {
            jump = true;
        }
        int enter = e.getKeyCode();
        if (enter == KeyEvent.VK_ENTER) {
            start = true;
        }
        int left = e.getKeyCode();
        if (left == KeyEvent.VK_LEFT) {
            moveLeft = true;
        }
        int right = e.getKeyCode();
        if (right == KeyEvent.VK_RIGHT) {
            moveRight = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
         int key = e.getKeyCode();
         if (key == KeyEvent.VK_UP) {
            jump = false;
        }
        int left = e.getKeyCode();
        if (left == KeyEvent.VK_LEFT) {
            moveLeft = false;
        }
        int right = e.getKeyCode();
        if (right == KeyEvent.VK_RIGHT) {
            moveRight = false;
        }
        
    }
}