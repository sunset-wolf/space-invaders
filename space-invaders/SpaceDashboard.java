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
        createTextMessages();
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
     * Creates the text messages.
     */
    private void createTextMessages() {
        displayTextMessage("SPACE-INVADERS", 25, Color.GREEN, WIDTH / 2, HEIGHT / 15 * 2);
        displayTextMessage("choose your game", 20, Color.WHITE, WIDTH / 2, HEIGHT / 15 * 3);
    }
    
    /**
     * Display the text message with the specific text size and at the specific position
     * 
     * @param textMessage the message itself.
     * @param textSize the text size of the message.
     * @param colour The colour of the message.
     * @param xPosition The x-position of the message.
     * @param yPosition The y-position of the message.
     */
    private void displayTextMessage(String textMessage, int textSize, Color colour, int xPosition, int yPosition) {
        GreenfootImage textImage = new GreenfootImage(textMessage, textSize, colour, null);
        getBackground().drawImage(textImage, xPosition - textImage.getWidth() / 2, yPosition - textImage.getHeight() / 2);
    }

}
