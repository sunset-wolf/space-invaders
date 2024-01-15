import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Spaceship which destroys aliens.
 * 
 * @author Gabriel Franz and Cornel Forster
 * @version 1.0
 */
public class Spaceship extends Actor
{
    private int movingSpeed;
    
    /**
     * Constructor to initialize the actor.
     */
    public Spaceship() {
        this.movingSpeed = 5;
    }
    /**
     * Act method which runs in endless loop.
     */
    public void act()
    {
        checkKeys();
    }
    
    /**
     * Check the user's interaction with the game.
     */
    private void checkKeys() {
        if(Greenfoot.isKeyDown("right")) {
            moveVertical(true);
        }
        
        if(Greenfoot.isKeyDown("left")) {
            moveVertical(false);
        }
    }
    
    /**
     * Move spaceship vertically.
     */
    private void moveVertical(boolean directionIsRight) {
        // Check if the spaceship is at the edge of a side.
        if((directionIsRight && getX() > 295) || !directionIsRight && getX() < 5) {
            // Move the spaceshipt to the other side.
            setLocation(300 - getX(), getY());
        }
        if(directionIsRight) {
            setLocation(getX() + movingSpeed, getY());  
        } 
        else {
            setLocation(getX() - movingSpeed, getY());  
        }
    }
}
