import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Alien which destroys the spaceship.
 * 
 * @author Gabriel Franz and Cornel Forster
 * @version 1.0
 */
public class Alien extends MoveableActor
{
    private int movingSpeed;
    private AlienColour colour;
    
    /**
     * Constructor to initialize the actor.
     */
    public Alien(AlienColour colour) {
        this.movingSpeed = 2;
        this.colour = colour;
        setAlienImage();
    }
    
    /**
     * Set the image for the alien.
     */
    private void setAlienImage() {
        switch(colour) {
            case GREEN:
                setImage("alien-green.png");
                break;
            case WHITE:
                setImage("alien-white.png");
                break;
            case VIOLETT:
                setImage("alien-violett.png");
                break; 
        }
    }

    /**
     * Act method which runs in endless loop.
     */
    public void act()
    {
        moveVertical(movingSpeed);
        checkShotTouching();
    }
        
    private void checkShotTouching() {
        if (isTouching(Shot.class)) {
            final SpaceGame world = (SpaceGame) getWorld();
            world.setScore(100);
            getWorld().removeObject(this);
        }
    }
}
