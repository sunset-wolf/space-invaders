import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Shot who destroys everythig possible.
 * 
 * @author Gabriel Franz and Cornel Forster
 * @version 1.0
 */
public class Shot extends Actor
{
    private int movingSpeed = -3;
    private boolean movingUp;
    
    public Shot(boolean movingUp) {
        this.movingUp = movingUp;
        this.movingSpeed = movingUp ? -3 : 3;
    }
    
    /**
     * Act method which runs in endless loop.
     */
    public void act()
    {
        moveHorizontal();
    }
    
    /**
     * Move Shot horizontal with the moving speed initialized.
     */
    private void moveHorizontal() {
        final World world = getWorld();
        if(movingUp && getY() == 0 || !movingUp && getY() + 1 == getWorld().getHeight()) {
           world.removeObject(this); 
        }
        else {
            setLocation(getX(), getY() + movingSpeed);
        }   
    }
}
