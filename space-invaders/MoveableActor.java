import greenfoot.*;

public class MoveableActor extends Actor {
    
    protected int horizontalSpeed;
    protected int verticalSpeed;

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
}
