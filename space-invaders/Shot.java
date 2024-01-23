import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Shot who destroys everythig possible.
 * 
 * @author Gabriel Franz and Cornel Forster
 * @version 1.0
 */
public class Shot extends MoveableActor
{
    // The amount of movement speed
    private int movingSpeed = -3;
    
    // If the shot is moving up or down
    private boolean movingUp;
    
    /**
     * Constructor for the bullet
     */
    public Shot(boolean movingUp) {
        super(0,movingUp ? -3 : 3);
        this.movingUp = movingUp;
        Greenfoot.playSound("Shot.mp3");
    }
    
    /**
     * Act method which runs in endless loop.
     */
    public void act()
    {
        moveWithSpeed();
        if(hasCollisionWith(Alien.class, true, 100) || hasCollisionWith(EndLine.class, false, -10)) {
            getWorld().removeObject(this);
        }
    }
}
