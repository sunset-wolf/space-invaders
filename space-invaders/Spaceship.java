import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Spaceship which destroys aliens.
 * 
 * @author Gabriel Franz and Cornel Forster
 * @version 1.0
 */
public class Spaceship extends Actor
{
    // The speed a spaceship can move.
    private int movingSpeed;
    
    // The counter for the act method.  
    private int actCounter = 0;
    
    // True if user interaction is allowed.
    private boolean isAllowedToInteract;
    
    /**
     * Constructor to initialize the actor.
     */
    public Spaceship(boolean isAllowedToInteract) {
        this.movingSpeed = 5;
        this.isAllowedToInteract = isAllowedToInteract;
        setSpaceshipImage();
    }
    
    /**
     * Set the image of the spaceship
     */
    private void setSpaceshipImage() {
        if(!isAllowedToInteract) {
            GreenfootImage image = getImage();
            image.scale(image.getWidth()/2, image.getHeight()/2);      
            setImage(image);
        }
    }
    
    /**
     * Act method which runs in endless loop.
     */
    public void act() {
        if(isAllowedToInteract) {
            checkKeys();
            actCounter++;
        }
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
        
        if(Greenfoot.isKeyDown("Space") && checkShootability()) {
            final Space world = (Space) getWorld();
             world.addShot(true, getX(), getY() - getImage().getHeight()/2);
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
    
    /**
     * If spaceship is able to fire a shot.
     */
    private boolean checkShootability() {
        if(actCounter == 0 || actCounter % 5 == 0) {
            return true;
        }
        return false;
    }
}
