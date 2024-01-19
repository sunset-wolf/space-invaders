import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * SpaceGame where the game is played.
 * 
 * @author Gabriel Franz and Cornel Forster
 * @version 1.0
 */
public class SpaceGame extends Space
{
    // The amount of lives for the user;
    private int lives = 3;
    
    /**
     * Constructor for objects of class SpaceGame.
     */
    public SpaceGame()
    {    
        addObject(new Spaceship(true), WIDTH/2, HEIGHT/8*7);
        addObject(new Alien(AlienColour.GREEN), WIDTH/2, HEIGHT/2);
        displayLives();
    }
    
    public void act() {
        displayLives();
    }
    
    /**
     * Display the amount of the user.
     */
    private void displayLives() {
        for(int x = 0; x < lives; x++) {
            addObject(new Spaceship(false), WIDTH/10*(x+1), HEIGHT/15*1);
        }
    }

    /**
     * Add a shot object.
     * 
     * @param movingUp If shot moves up.
     * @param xPosition The starting x-position.
     * @param yPosition The starting y-position.
     */
    public void addShot(boolean movingUp, int xPosition, int yPosition) {
        addObject(new Shot(movingUp), xPosition, yPosition);
    }
    
    public void setLives(int newLives) {
        this.lives -= newLives;
    }
}
