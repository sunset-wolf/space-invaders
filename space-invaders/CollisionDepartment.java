import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * This class check the collision between all objects.
 * 
 * @author Gabriel Franz and Cornel Forster
 * @version 1.0
 */
public class CollisionDepartment extends Actor
{
    private List<Actor> allActors = null;
    private SpaceGame world = (SpaceGame) getWorld();

    /**
     * Act - do whatever the CollisionDepartment wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        List<Actor> allActors = world.getObjects(Actor.class);
        
        for(Actor singleActor : allActors) {
            if(singleActor instanceof MoveableActor) {
                 checkForCollision(EndLine.class);
            }
        }
    }
    
    private void checkForCollision (Class collisionClass) {
    Actor collisionObject = getOneIntersectingObject(collisionClass);
    if (collisionObject != null) {
        if(collisionObject instanceof MoveableActor) {
            // Remove the collided object
            world.removeObject(collisionObject);
            if (5 != 0) {
                // Update the score
                world.setScore(-5);
            }
        }
        // Remove the shot object only if it is still in the world
        //return true;
        //removeMyObject();
    }
    //return false;
    }
}
