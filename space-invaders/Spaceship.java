import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class spaceship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
            moveToDirection(true);
        }
        
        if(Greenfoot.isKeyDown("left")) {
            moveToDirection(false);
        }
    }
    
    /**
     * Move spaceship vertically.
     */
    private void moveToDirection(boolean directionIsRight) {
        // Check if the spaceship is at the edge of a side.
        if((directionIsRight && getX() > 298) || !directionIsRight && getX() < 2) {
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
