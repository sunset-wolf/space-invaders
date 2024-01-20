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
    
    /**
     * Constructor for objects of class SpaceGame.
     */
    public SpaceGame()
    {    
        //addObject(new CollisionDepartment(), 0, 0);
        addObject(new Spaceship(true), WIDTH/2, HEIGHT/8*7);
        addAliens();
        displayLives();
        displayScore(score);
    }
    
    /**
     * Add aliens to the game.
     */
    private void addAliens() {
        int alienCount = 3;
        for (int i = 1; i < alienCount+1; i++) {
            addObject(new Alien(AlienColour.GREEN), WIDTH / alienCount*i - (WIDTH /alienCount)/2, HEIGHT/2);
        }
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
    
    public void setLives(int newLives) {
        this.lives += newLives;
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
