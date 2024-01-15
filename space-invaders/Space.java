import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the Space world class.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Space extends World
{
    private static final int HEIGHT = 500;
    private static final int WIDTH = 300;
    /**
     * Constructor for objects of class Space.
     * 
     */
    public Space()
    {    
        // Create a new world with the height and width defined in this class.
        super(WIDTH, HEIGHT, 1); 
        setBackground();
        addObject(new Spaceship(), WIDTH/2, HEIGHT/8*7);
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
     * @param number The number of stars.
     */
    private void createStars(int number) 
    {
        GreenfootImage background = getBackground();             
        for (int i=0; i < number; i++) {            
             int x = Greenfoot.getRandomNumber(getWidth());
             int y = Greenfoot.getRandomNumber(getHeight());
             int color = 150 - Greenfoot.getRandomNumber(120);
             background.setColorAt(x, y, new Color(color,color,color));
        }
    }
}
