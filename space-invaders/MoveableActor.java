import greenfoot.*;
import java.util.List;

public class MoveableActor extends Actor {
    protected int horizontalSpeed;
    protected int verticalSpeed;
    protected SpaceGame world = (SpaceGame) getWorld();

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
            // Move the spaceshipt to the other side.
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
                // Remove the collided object
                world.removeObject(collisionObject);
            }
            if (scoreToAdd != 0) {
                // Update the score
                world.setScore(scoreToAdd);
            }
            return true;
        }
        return false;
    }
}
