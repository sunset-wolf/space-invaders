import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

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
    private int score = 0;
    private SpaceGameLevel level;
    
    /**
     * Constructor for objects of class SpaceGame.
     */
    public SpaceGame(SpaceGameLevel level)
    {    
        addSpaceship();
        this.level = level;
        createLevel();
        displayLives();
        displayScore(score);
    }

    /**
     * Creates the level
     */
    private void createLevel() {
        switch(level) {
            case BEGINNER:
                for(int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        addObject(new Alien(AlienColour.GREEN, 1), WIDTH / 4 * (x + 1), HEIGHT / 15 * (y + 1));
                    }                
                }
                break;
            case MEDIUM:
                for(int x = 0; x < 4; x++) {
                    for (int y = 0; y < 4; y++) {
                        if(x % 2 == 0) {
                            addObject(new Alien(AlienColour.GREEN, 1), WIDTH / 5 * (x + 1), HEIGHT / 15 * (y + 1));
                        } else {
                            addObject(new Alien(AlienColour.VIOLETT, 1), WIDTH / 5 * (x + 1), HEIGHT / 15 * (y + 1));
                        }
                    }               
                }
                break;
            case HARD:
                for(int x = 0; x < 5; x++) {
                    for (int y = 0; y < 5; y++) {
                        if(x % 3 == 0) {
                            addObject(new Alien(AlienColour.GREEN, 1), WIDTH / 6 * (x + 1), HEIGHT / 15 * (y + 1));
                        } else if(y % 2 == 0) {
                            addObject(new Alien(AlienColour.VIOLETT, 1), WIDTH / 6 * (x + 1), HEIGHT / 15 * (y + 1));
                        } else {
                            addObject(new Alien(AlienColour.WHITE, 1), WIDTH / 6 * (x + 1), HEIGHT / 15 * (y + 1));
                        }
                    }                
                }
                break;
            case PRO:
                for(int x = 0; x < 7; x++) {
                    for (int y = 0; y < 7; y++) {
                        if(y % 3 == 0) {
                            addObject(new Alien(AlienColour.GREEN, 1), WIDTH / 8 * (x + 1), HEIGHT / 15 * (y + 1));
                        } else if(x % 2 == 0) {
                            addObject(new Alien(AlienColour.VIOLETT, 1), WIDTH / 8 * (x + 1), HEIGHT / 15 * (y + 1));
                        } else {
                            addObject(new Alien(AlienColour.WHITE, 1), WIDTH / 8 * (x + 1), HEIGHT / 15 * (y + 1));
                        }
                    }                
                }
                break;
        }
    }
    
    /**
     * Creates a new Spaceship.
     */
    private void addSpaceship() {
        addObject(new Spaceship(true), WIDTH/2, HEIGHT/8*7);
    }
    
    /**
     * Add aliens to the game.
     */
    private void addAliens() {
        int alienCount = 3;
        for (int i = 1; i < alienCount+1; i++) {
            addObject(new Alien(AlienColour.GREEN, 2), WIDTH / alienCount*i - (WIDTH /alienCount)/2, HEIGHT/2);
        }
    }
    
    /**
     * Act method which runs in endless loop.
     */
    public void act() {
        checkForEnd();
    }
    
    /**
     * Check if level game is finished.
     */
    private void checkForEnd() {
        if(getObjects(Alien.class).isEmpty()) {
            backToDashboard("Level succesfully finished", true);
        }
        
        if(score < -150 || lives <= 0) {
            backToDashboard("Failed to finish level", false);
        }
    }
    
    /**
     * Go back to the dashboard and display final message.
     * 
     * @param endMessage The final message.
     * @param levelSuccessfullyFinished If userfinished level.
     */
    private void backToDashboard(String endMessage, boolean levelSuccessfullyFinished) {
        Color displayColour = levelSuccessfullyFinished ? Color.GREEN : Color.RED;
        addObject(new TextFlicker(endMessage, TextSizing.BIG, false, true, displayColour), WIDTH / 2, HEIGHT / 2);
        Greenfoot.delay(100);
        Greenfoot.setWorld(new SpaceDashboard());
    }
    
    /**
     * Display the amount of the user.
     */
    private void displayLives() {
        for(int x = 0; x < lives; x++) {
            addObject(new Spaceship(false), WIDTH/10*(x+1), HEIGHT/26*1);
        }
    }
    
    private void displayScore(int score) {
        addObject(new TextFlicker("Score: ", TextSizing.MIDDLE, false, false, Color.WHITE), WIDTH/10*7, HEIGHT/30*1);
        addObject(new TextFlicker(String.valueOf(score), TextSizing.MIDDLE, false, true, Color.WHITE), WIDTH/10*9, HEIGHT/30*1);
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
    
    /**
     * Set lives variable new
     * 
     * @param newLives The amount.
     */
    public void setLives(int newLives) {
        this.lives += newLives;
        
        // Remove existing Spaceship objects.
        removeObjects(getObjects(Spaceship.class));
        displayLives();
        Greenfoot.delay(25);
        addSpaceship();    
    }
    
    public int getLives() {
        return lives;
    }
    
    public void setScore(int newScore) {
        this.score += newScore;
    }
    
    public int getScore() {
        return score;
    }
}
