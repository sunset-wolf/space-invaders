import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class EndLine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndLine extends Actor
{
    // If is at the bottom of the world.
    public boolean isAtBottom;
    
    /**
     * Constructor for the EndLine.
     */
    public EndLine(boolean isAtBottom) {
        this.isAtBottom = isAtBottom;
    }
    
    /**
     * Act method which runs in endless loop.
     */
    public void act() {
        if(isAtBottom) {
            checkForRespawningActors();
        }
    }

    /**
     * Check if there are actos which have to be respawned.
     */
    private void checkForRespawningActors() {
        List<MoveableActor> actors =  getIntersectingObjects(MoveableActor.class);
        if(!actors.isEmpty()) {
            final int worldHeight = getWorld().getHeight();
            for(MoveableActor singleActor : actors) {
                singleActor.setLocation(singleActor.getX(), worldHeight / 90 * 7);
            }
        }
    }
    
}
