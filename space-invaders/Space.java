import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Space where the magic or the clashes happens.
 * 
 * @author Gabriel Franz and Cornel Forster
 * @version 1.0
 */
public class Space extends World
{
    // The height of the world.
    public static final int HEIGHT = 500;    
    // The width of the world.
    public static final int WIDTH = 300;
    
    /**
     * Constructor for objects of class Space.
     */
    public Space()
    {    
        super(WIDTH, HEIGHT, 1); 
        setBackground();
    }

    /**
     * Set the background of the world.
     */
    private void setBackground() {
        GreenfootImage background = getBackground();
        background.setColor(Color.BLACK);
        background.fill();
        Greenfoot.setSpeed(50);
        createStars(1000);
    }
    
    /**
     * Create random stars.
     * 
     * @param number The number of stars.
     */
    private void createStars(int number) {
        GreenfootImage background = getBackground();             
        for (int i=0; i < number; i++) {            
             int x = Greenfoot.getRandomNumber(getWidth());
             int y = Greenfoot.getRandomNumber(getHeight());
             int color = 150 - Greenfoot.getRandomNumber(120);
             background.setColorAt(x, y, new Color(color,color,color));
        }
    }
}
