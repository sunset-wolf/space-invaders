import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * SpceDashboard where the game can be choosen.
 * 
 * @author Gabriel Franz and Cornel Forster
 * @version 1.0
 */
public class SpaceDashboard extends Space
{

    /**
     * Constructor for objects of class SpaceDashboard.
     * 
     */
    public SpaceDashboard()
    {    
        addFlyingAliens();
        addTextMessages();
    }
    
    /**
     * Creates the sidelines with the aliens.
     */
    private void addFlyingAliens() {
        int counter = 0;
        int[] xPositions = {WIDTH / 10 * 1, WIDTH / 10 * 9};
        
        while(counter < 15) {
            for(AlienColour alienColour : AlienColour.values()) {
                // Add alien on left and right side.
                for(int position : xPositions) {
                    addObject(new Alien(alienColour), position, HEIGHT / 15 * (counter + 1));
                }
                counter++;
            }   
        }
    }
    
    /**
     * Add the text messages.
     */
    private void addTextMessages() {
        addObject(new TextFlicker("SPACE-INVADERS", TextSizing.BIG, true, Color.GREEN), WIDTH / 2, HEIGHT / 15 * 2);
        addObject(new TextFlicker("Choose your game", TextSizing.MIDDLE, true, Color.WHITE), WIDTH / 2, HEIGHT / 15 * 3);
    }
}
