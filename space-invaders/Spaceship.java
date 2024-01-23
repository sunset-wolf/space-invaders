import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Spaceship which destroys aliens.
 * 
 * @author Gabriel Franz and Cornel Forster
 * @version 1.0
 */
public class Spaceship extends MoveableActor
{
    // The speed a spaceship can move.
    private int movingSpeed;
    
    // The counter for the act method.  
    private int actCounter = 0;
    
    // True if user interaction is allowed.
    private boolean isAllowedToInteract;
    
    // True if it is touching Alien
    private boolean touchingAlien = false;
    
    // True if user's last interaction was to move right. 
    private boolean lastMoveWasRight = true;
    
    /**
     * Constructor to initialize the actor.
     */
    public Spaceship(boolean isAllowedToInteract) {
        super(5,0);
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
        if (Greenfoot.isKeyDown("right")) {
            checkForHorizontalSpeedUpdate(true);
            moveWithSpeed();
        }
        
        if (Greenfoot.isKeyDown("left")) {
            checkForHorizontalSpeedUpdate(false);
            moveWithSpeed();
        }
        
        if (Greenfoot.isKeyDown("Space") && checkShootability()) {
            final SpaceGame world = (SpaceGame) getWorld();
            world.addShot(true, getX(), getY() - getImage().getHeight() / 2);
        }
    }
    
    /**
     * Check if horizontalSpeed has to be updated.
     */
    private void checkForHorizontalSpeedUpdate(boolean actualMoveWasRight) {
        if (lastMoveWasRight != actualMoveWasRight) {
            horizontalSpeed = -horizontalSpeed;
            lastMoveWasRight = actualMoveWasRight;
        }
    }

    /**
     * Check if spaceship is colliding with alien.
     */
    private void checkAlienCollision() {
        if(hasCollisionWith(Alien.class, true, -50)) {
            final SpaceGame world = (SpaceGame) getWorld();
            world.setLives(-1);
            Greenfoot.playSound("User-Death.mp3");
            world.removeObject(this);
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
