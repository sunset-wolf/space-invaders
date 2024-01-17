import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Alien which destroys the spaceship.
 * 
 * @author Gabriel Franz and Cornel Forster
 * @version 1.0
 */
public class Alien extends Actor
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
        moveHorizontal();     
    }
    
    /**
     * Move alien horizontal with the moving speed initialized.
     */
    private void moveHorizontal() {
        final int worldHeight = getWorld().getHeight();
         if(getY() + 5 >= worldHeight) {
            setLocation(getX(), getY() + movingSpeed - worldHeight);
        }
        else {
            setLocation(getX(), getY() + movingSpeed); 
        }
            
    }
}