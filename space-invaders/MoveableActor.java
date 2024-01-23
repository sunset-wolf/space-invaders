import greenfoot.*;
import java.util.List;

/**
 * This actor is for the movement of the objects
 * 
 * @author Gabriel Franz and Cornel Forster
 * @version 1.0
 */

public class MoveableActor extends Actor {
    // The horizontal speed
    protected int horizontalSpeed;
    
    // The vertical speed
    protected int verticalSpeed;

    /**
     * Constructor for the MoveableActor
     */
    public MoveableActor(int horizontalSpeed, int verticalSpeed) {
        this.horizontalSpeed = horizontalSpeed;
        this.verticalSpeed = verticalSpeed;
    }
    
    /**
     * Move spaceship horizontally.
     */
    protected void moveWithSpeed() {
        // Check if the spaceship is at the edge of a side.
        int worldWidth = getWorld().getWidth();
        if((horizontalSpeed > 0 && getX() > worldWidth - 2) || horizontalSpeed < 0 && getX() < 2) {
            // Move the spaceship to the other side.
            setLocation(worldWidth - getX(), getY() + verticalSpeed);
        }
        else {
            setLocation(getX() + horizontalSpeed, getY() + verticalSpeed);
        }
    }

    /**
     * Remove all intersecting actors of a specific class.
     * 
     * @param collisionClass The class of the actors to check for collision.
     * @param collisionObjectToRemove If collision object should be removed.
     * @param scoreToAdd The score to add to the world.
     */
    protected boolean hasCollisionWith(Class collisionClass, boolean collisionObjectToRemove, int scoreToAdd) {
        SpaceGame world = (SpaceGame) getWorld();
        Actor collisionObject = getOneIntersectingObject(collisionClass);
    
        if (collisionObject != null) {
            if(collisionObject instanceof Actor && collisionObjectToRemove) {
                if(this instanceof Spaceship && collisionObject instanceof Alien ) {
                handleCaseSpaceshipAlienCollision((Alien) collisionObject);
                }
                else if(this instanceof Shot && collisionObject instanceof Alien) {
                     handleCaseShotAlienCollision((Alien) collisionObject);
                }
                else {
                    // Remove the collided object.
                    world.removeObject(collisionObject); 
                }
            }
            if (scoreToAdd != 0) {
                // Update the score.
                world.setScore(scoreToAdd);
            }
            return true;
        }
        return false;
    }

    /**
     * Handle the case between the spaceship and an alien collision.
     * 
     * @param collisionObject The collided object.
     */    
    private void handleCaseSpaceshipAlienCollision(Alien collisionObject) {
        boolean positionOccupied = false;
        while(!positionOccupied) {
            collisionObject.setLocation(collisionObject.getX(), collisionObject.getY() - 100 - Greenfoot.getRandomNumber(200));
            if(getOneObjectAtOffset(collisionObject.getX(), collisionObject.getY(), null) == null) {
                positionOccupied = true;
            }
        } 
    }
    
    /**
     * Handle the case between the shot and an alien collision.
     * 
     * @param collisionObject The collided object.
     */    
    private void handleCaseShotAlienCollision(Alien collisionObject) {
        collisionObject.updateAlienLives(-1);
    }
}
