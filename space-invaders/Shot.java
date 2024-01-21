import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Shot who destroys everythig possible.
 * 
 * @author Gabriel Franz and Cornel Forster
 * @version 1.0
 */
public class Shot extends MoveableActor
{
    private int movingSpeed = -3;
    private boolean movingUp;
    
    public Shot(boolean movingUp) {
        super(0,movingUp ? -3 : 3);
        this.movingUp = movingUp;
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
