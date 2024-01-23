import greenfoot.*;

/**
 * In this class the flicker on the startscreen will happen
 * 
 * @author Gabriel Franz and Cornel Forster
 * @version 1.0
 */

public class TextFlicker extends Actor {
    // This is the text displayed.
    private String textMessage;
    
    // If the flicker is on or off.
    private final boolean flickerOn;
    
    // If the flicker can update its message dynamically.
    private final boolean isUpdatable;

    // The image of the small text.
    private GreenfootImage smallImage;
    
    // The image of the big text.
    private GreenfootImage bigImage;
    
    // Counter for flicker.
    private int count = 0;
    
    // If the text is small or big.
    private boolean textSmall = true;
    
    // The color of the text.
    private Color colour;
    
    // The size of the text.
    private TextSizing textSizing;

    public TextFlicker(String textMessage, TextSizing textSizing, boolean flickerOn, boolean isUpdatable, Color colour) {
        this.textMessage = textMessage;
        this.textSizing = textSizing;
        this.flickerOn = flickerOn;
        this.isUpdatable = isUpdatable;
        this.colour = colour;
        createTextImages();
        setImage(smallImage);
    }
    
    /**
     * Act method which runs in endless loop.
     */
    public void act() {
        if (flickerOn) {
            if(count % 25 == 0) {
                // Check which image should be displayed.
                GreenfootImage imageToDisplay = textSmall ? smallImage : bigImage;
                setImage(imageToDisplay);
                textSmall = !textSmall;
            }
            count++;
            checkForCounterReset();
        }
        
        if (isUpdatable) {
            final SpaceGame world = (SpaceGame) getWorld();
            textMessage = String.valueOf(world.getScore());
            createTextImages();
            setImage(smallImage);
        }
    }
    
    /**
     * Check if counter can be resetted.
     */    
    private void checkForCounterReset() {
        count = count < 25 ? count: 0;
    }

    /**
     * Create the two images of the text.
     */
    private void createTextImages() {
        int textSize = getTextSize();
        smallImage = new GreenfootImage(textMessage, textSize, colour, null);
        // + 4 is the difference between the text sizes.
        bigImage = new GreenfootImage(textMessage, textSize + 4, colour, null);
    }

    /**
     * Define the text size.
     */
    private int getTextSize() {
        switch (textSizing) {
            case SMALL:
                return 16;
            case MIDDLE:
                return 19;
            case BIG:
                return 22;
            default:
                return 19;
        }
    }
    
    public String getTextMessage() {
        return textMessage;
    }
}
