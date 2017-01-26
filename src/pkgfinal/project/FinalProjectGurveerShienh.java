package pkgfinal.project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
public class FinalProjectGurveerShienh extends JComponent implements KeyListener {

    // Height and Width of our game
    static final int WIDTH = 800;
    static final int HEIGHT = 600;

    // sets the framerate and delay for our game
    // you just need to select an approproate framerate
    long desiredFPS = 60;
    long desiredTime = (1000) / desiredFPS;

    //environment variables
    Color skyColour = new Color(135, 206, 235);
    Color groundColour = new Color(100, 100, 100);

    //create monsters
    Rectangle monster1 = new Rectangle(1000, 370, 80, 80);
    Rectangle monster2 = new Rectangle(1500, 330, 100, 120);
    Rectangle monster3 = new Rectangle(2100, 370, 50, 80);
    Rectangle monster4 = new Rectangle(2500, 390, 100, 60);
    Rectangle monster5 = new Rectangle(3600, 375, 80, 75);
    Rectangle monster6 = new Rectangle(4200, 350, 120, 100);
    Rectangle monster7 = new Rectangle(4800, 340, 150, 110);
    Rectangle monster8 = new Rectangle(5500, 390, 100, 80);
    Rectangle monster9 = new Rectangle(6000, 330, 180, 120);
    Rectangle monster10 = new Rectangle(6400, 380, 100, 70);
    Rectangle monster11 = new Rectangle(6800, 370, 100, 80);
    Rectangle monster12 = new Rectangle(7100, 360, 80, 90);
    Rectangle monster13 = new Rectangle(7600, 350, 80, 100);
    Rectangle monster14 = new Rectangle(8000, 410, 100, 40);
    Rectangle monster15 = new Rectangle(8250, 310, 150, 140);
    Rectangle monster16 = new Rectangle(8750, 390, 80, 60);

    //entity variables
    Rectangle dude = new Rectangle(150, 400, 50, 50);
    Color skin = new Color(189, 115, 75);

    //start & end variables
    boolean start = false;
    boolean restart = false;

    //scoring
    int totalScore = 0;
    Font scoreFont = new Font("Arial", Font.BOLD, 52);

    //movement variables
    boolean jump = false;
    int jumpVelocity = -200;

    //gravity 
    int gravity = 5;

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
    public void paintComponent(Graphics g) {
        // always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);

        // GAME DRAWING GOES HERE 
        //change sky colour
        g.setColor(skyColour);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        //create ground
        g.setColor(groundColour);
        g.fillRect(0, 450, WIDTH, 150);

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

        //create player
        g.setColor(skin);
        g.fillRect(dude.x, dude.y, dude.width, dude.height);

        //draw score
        g.setColor(Color.WHITE);
        g.setFont(scoreFont);
        g.drawString("" + totalScore, 20, 580);

        // GAME DRAWING ENDS HERE
    }

    // The main game loop
    // In here is where all the logic for my game will go
    public void run() {

        // Used to keep track of time used to draw and update the game
        // This is used to limit the framerate later on
        long startTime;
        long deltaTime;

        // the main game loop section
        // game will end if you set done = false;
        boolean done = false;
        //reset game

        while (!done) {

            // determines when we started so we can keep a framerate
            startTime = System.currentTimeMillis();

            // all your game rules and move is done in here
            // GAME LOGIC STARTS HERE 
            //move monsters
            if (start == true) {
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
                if (monster1.x < -200) {
                    monster1 = new Rectangle(9000, monster1.y, monster1.width, monster1.height);
                }
                if (monster2.x < -200) {
                    monster2 = new Rectangle(9000, monster2.y, monster2.width, monster2.height);
                }
                if (monster3.x < -200) {
                    monster3 = new Rectangle(9000, monster3.y, monster3.width, monster3.height);
                }
                if (monster4.x < -200) {
                    monster4 = new Rectangle(9000, monster4.y, monster4.width, monster4.height);
                }
                if (monster5.x < -200) {
                    monster5 = new Rectangle(9000, monster5.y, monster5.width, monster5.height);
                }
                if (monster6.x < -200) {
                    monster6 = new Rectangle(9000, monster6.y, monster6.width, monster6.height);
                }
                if (monster7.x < -200) {
                    monster7 = new Rectangle(9000, monster7.y, monster7.width, monster7.height);
                }
                if (monster8.x < -200) {
                    monster8 = new Rectangle(9000, monster8.y, monster8.width, monster8.height);
                }
                if (monster9.x < -200) {
                    monster9 = new Rectangle(9000, monster9.y, monster9.width, monster9.height);
                }
                if (monster10.x < -200) {
                    monster10 = new Rectangle(9000, monster10.y, monster10.width, monster10.height);
                }
                if (monster11.x < -200) {
                    monster11 = new Rectangle(9000, monster11.y, monster11.width, monster11.height);
                }
                if (monster12.x < -200) {
                    monster12 = new Rectangle(9000, monster12.y, monster12.width, monster12.height);
                }

                if (monster13.x < -200) {
                    monster13 = new Rectangle(9000, monster13.y, monster13.width, monster13.height);
                }
                if (monster14.x < -200) {
                    monster14 = new Rectangle(9000, monster14.y, monster14.width, monster14.height);
                }
                if (monster15.x < -200) {
                    monster15 = new Rectangle(9000, monster15.y, monster15.width, monster15.height);
                }
                if (monster16.x < -200) {
                    monster16 = new Rectangle(9000, monster16.y, monster16.width, monster16.height);
                }

                //hit detection
                if (dude.x + dude.width >= monster1.x && dude.x <= monster1.x + monster1.width && dude.y + dude.height >= monster1.y) {
                    done = true;
                }
                if (dude.x + dude.width >= monster2.x && dude.x <= monster2.x + monster2.width && dude.y + dude.height >= monster2.y) {
                    done = true;
                }
                if (dude.x + dude.width >= monster3.x && dude.x <= monster3.x + monster3.width && dude.y + dude.height >= monster3.y) {
                    done = true;
                }
                if (dude.x + dude.width >= monster4.x && dude.x <= monster4.x + monster4.width && dude.y + dude.height >= monster4.y) {
                    done = true;
                }
                if (dude.x + dude.width >= monster5.x && dude.x <= monster5.x + monster5.width && dude.y + dude.height >= monster5.y) {
                    done = true;
                }
                if (dude.x + dude.width >= monster6.x && dude.x <= monster6.x + monster6.width && dude.y + dude.height >= monster6.y) {
                    done = true;
                }
                if (dude.x + dude.width >= monster7.x && dude.x <= monster7.x + monster7.width && dude.y + dude.height >= monster7.y) {
                    done = true;
                }
                if (dude.x + dude.width >= monster8.x && dude.x <= monster8.x + monster8.width && dude.y + dude.height >= monster8.y) {
                    done = true;
                }
                if (dude.x + dude.width >= monster9.x && dude.x <= monster9.x + monster9.width && dude.y + dude.height >= monster9.y) {
                    done = true;
                }
                if (dude.x + dude.width >= monster10.x && dude.x <= monster10.x + monster10.width && dude.y + dude.height >= monster10.y) {
                    done = true;
                }
                if (dude.x + dude.width >= monster11.x && dude.x <= monster11.x + monster11.width && dude.y + dude.height >= monster11.y) {
                    done = true;
                }
                if (dude.x + dude.width >= monster12.x && dude.x <= monster12.x + monster12.width && dude.y + dude.height >= monster12.y) {
                    done = true;
                }
                if (dude.x + dude.width >= monster13.x && dude.x <= monster13.x + monster13.width && dude.y + dude.height >= monster13.y) {
                    done = true;
                }
                if (dude.x + dude.width >= monster14.x && dude.x <= monster14.x + monster14.width && dude.y + dude.height >= monster14.y) {
                    done = true;
                }
                if (dude.x + dude.width >= monster15.x && dude.x <= monster15.x + monster15.width && dude.y + dude.height >= monster15.y) {
                    done = true;
                }
                if (dude.x + dude.width >= monster16.x && dude.x <= monster16.x + monster16.width && dude.y + dude.height >= monster16.y) {
                    done = true;
                }

                //scoring
                if (dude.x >= monster1.x + monster1.width) {
                    totalScore = totalScore + 1;
                }
                if (dude.x >= monster2.x + monster2.width) {
                    totalScore = totalScore + 1;
                }
                if (dude.x >= monster3.x + monster3.width) {
                    totalScore = totalScore + 1;
                }
                if (dude.x >= monster4.x + monster4.width) {
                    totalScore = totalScore + 1;
                }
                if (dude.x >= monster5.x + monster5.width) {
                    totalScore = totalScore + 1;
                }
                if (dude.x >= monster6.x + monster6.width) {
                    totalScore = totalScore + 1;
                }
                if (dude.x >= monster7.x + monster7.width) {
                    totalScore = totalScore + 1;
                }
                if (dude.x >= monster8.x + monster8.width) {
                    totalScore = totalScore + 1;
                }
                if (dude.x >= monster9.x + monster9.width) {
                    totalScore = totalScore + 1;
                }
                if (dude.x >= monster10.x + monster10.width) {
                    totalScore = totalScore + 1;
                }
                if (dude.x >= monster11.x + monster11.width) {
                    totalScore = totalScore + 1;
                }
                if (dude.x >= monster12.x + monster12.width) {
                    totalScore = totalScore + 1;
                }
                if (dude.x >= monster13.x + monster13.width) {
                    totalScore = totalScore + 1;
                }
                if (dude.x >= monster14.x + monster14.width) {
                    totalScore = totalScore + 1;
                }
                if (dude.x >= monster15.x + monster15.width) {
                    totalScore = totalScore + 1;
                }
                if (dude.x >= monster16.x + monster16.width) {
                    totalScore = totalScore + 1;
                }

                //create gravity 
                if (dude.y < 400) {
                    dude.y = dude.y + gravity;
                    jump = false;
                }

                //change y coordinates for jump
                if (jump == true) {
                    dude.y = dude.y + jumpVelocity;
                }
                //change x coordinates for movement
                if (moveLeft == true) {
                    dude.x = dude.x - movementVelocity;
                }
                if (moveRight == true) {
                    dude.x = dude.x + movementVelocity;
                }

            }

            // GAME LOGIC ENDS HERE 
            // update the drawing (calls paintComponent)
            repaint();

            // SLOWS DOWN THE GAME BASED ON THE FRAMERATE ABOVE
            // USING SOME SIMPLE MATH
            deltaTime = System.currentTimeMillis() - startTime;
            try {
                if (deltaTime > desiredTime) {
                    //took too much time, don't wait
                    Thread.sleep(1);
                } else {
                    // sleep to make up the extra time
                    Thread.sleep(desiredTime - deltaTime);
                }
            } catch (Exception e) {
            };
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
        game.setPreferredSize(new Dimension(WIDTH, HEIGHT));
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
