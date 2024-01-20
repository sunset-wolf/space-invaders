import greenfoot.*;

public class MoveableActor extends Actor {

    /**
     * Move actor vertical with the given moving speed.
     */
    protected void moveVertical(int movingSpeed) {
        final int worldWidth = getWorld().getWidth();
        if (getX() + 5 >= worldWidth) {
            setLocation(getX() , getY() + movingSpeed - worldWidth);
        } else {
            setLocation(getX(), getY() +  movingSpeed);
        }
    }
    
    /**
     * Move spaceship horizontally.
     */
    protected void moveHorizontal(int movingSpeed, boolean directionIsRight) {
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
