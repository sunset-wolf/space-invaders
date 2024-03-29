import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Alien which destroys the spaceship.
 * 
 * @author Gabriel Franz and Cornel Forster
 * @version 1.0
 */
public class Alien extends MoveableActor
{
    // The speed of the alien.
    private int movingSpeed;
    
    // How many lives the alien has.
    private int lives;
    
    // Counter for the shiver.
    private int count;
    
    // How much the aliens will shiver.
    private int shiverAmount = 5;
    
    // Variable for the color of the alien.
    private AlienColour colour;
    
    /**
     * Constructor to initialize the actor.
     */
    public Alien(AlienColour colour) {
        super(0,2);
        this.colour = colour;
        setAlienSpecifications();
    }
    
    /**
     * Set the image for the alien.
     */
    private void setAlienSpecifications() {
        switch(colour) {
            case GREEN:
                lives = 1;
                setImage("alien-green.png");
                break;
            case WHITE:
                lives = 3;
                setImage("alien-white.png");
                break;
            case VIOLETT:
                lives = 2;
                setImage("alien-violett.png");
                break; 
        }
    }
    
    /**
     * Update the live score of the alien.
     */
    public void updateAlienLives(int liveToAdd) {
        lives = lives + liveToAdd;
        checkLives();
    }
    
    /**
     * Check if alien has still lives.
     */
    private void checkLives() {
        if(lives <= 0) {
            Greenfoot.playSound("Alien-Death.mp3");
            getWorld().removeObject(this);
        }
    }
    
    /**
     * Make alien go left and right
     */
    private void moveLeftAndRight() {
        if (count % 20 == 0) {
            setLocation(getX() + shiverAmount, getY());
        } else if (count % 10 == 0) {
            setLocation(getX() - shiverAmount, getY());
        }
        count++;
    }

    /**
     * Act method which runs in endless loop.
     */
    public void act()
    {
        moveWithSpeed();
        moveLeftAndRight();
    }
}
