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
    
    Color skyColour = new Color(175, 190, 214);
    Color groundColour = new Color(100,100,100);
    
    //rock visuals
    
    Color rainColour = new Color (9, 52, 122);
    int rainLength = 40;
    int rainThickness = 40;
    
    //rain array
    
   
   
    
    //rain speed
    
    
    
   
    //entity variables
    
    Rectangle dude = new Rectangle(400, 400, 50, 50);
    Color skin = new Color(189, 115, 75);
    
    //start & end variables
    boolean start = false;
    
    //movement variables
    boolean jump = false;
    int jumpVelocity = 5;
   
    
    //gravity 
    int gravity = 1;

    
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
        
        //create rain
        
     
        
        // GAME DRAWING ENDS HERE
    
    
   
    
    // The main game loop
    // In here is where all the logic for my game will go
    public void run(){


        // Used to keep track of time used to draw and update the game
        // This is used to limit the framerate later on
        long startTime;
        long deltaTime;
        
        
        Random randGen = new Random();
        //generate random X position for rain
        int rainY = 900;
         for (int i = 0; i < rainLength; i++) {
             //generate random X position for rain
             int rainX = randGen.nextInt();
             rain[i] = new Rectangle(rainX, rainY, rainThickness, rainLength);
         }
        
        
        // the main game loop section
        // game will end if you set done = false;
        boolean done = false; 
        while(!done){

            // determines when we started so we can keep a framerate
            startTime = System.currentTimeMillis();
            
            // all your game rules and move is done in here
            // GAME LOGIC STARTS HERE 
            
            
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
            if (key == KeyEvent.VK_SPACE) {
            jump = true;
        }
        
         

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}