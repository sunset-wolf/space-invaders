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
    
    // True if it is touching Alien
    private boolean touchingAlien = false;
    
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
            checkAlienCollision();
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
            final SpaceGame world = (SpaceGame) getWorld();
            world.addShot(true, getX(), getY() - getImage().getHeight()/2);
        }
    }
    
    /**
     * Check if spaceship is colliding with alien.
     */
    private void checkAlienCollision() {
        if (isTouching(Alien.class) && touchingAlien == false) {
            touchingAlien = true;
            final SpaceGame world = (SpaceGame) getWorld();
            world.setLives(-1);
        } else {
            touchingAlien = false;
        }
    }
    
    /**
     * Move spaceship horizontally.
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
