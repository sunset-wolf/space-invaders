import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the Space world class.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Space extends World
{
    private static int height = 500;
    private static int width = 300;
    /**
     * Constructor for objects of class Space.
     * 
     */
    public Space()
    {    
        // Create a new world with the height and width defined in this class.
        super(width, height, 1); 
        addObject(new Spaceship(), width/2, height/8*7);
    }
}
