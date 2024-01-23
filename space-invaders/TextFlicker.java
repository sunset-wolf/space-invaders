import greenfoot.*;

/**
 * In this class the flicker on the startscreen will happen
 * 
 * @author Gabriel Franz and Cornel Forster
 * @version 1.0
 */

public class TextFlicker extends Actor {
    // This is the text displayed
    private String textMessage;
    
    // If the flicker is on or off
    private final boolean flickerOn;
    
    // If the flicker can update its message dynamically
    private final boolean isUpdatable;

    // The size of the small text
    private int smallTextSize;
    
    // The size of the big text
    private int bigTextSize;
    
    // Counter for flicker
    private int count = 0;
    
    // If the text is small or big
    private boolean textSmall = true;
    
    // The color of the text
    private Color colour;
    
    // The soze of the text
    private TextSizing textSizing;

    public TextFlicker(String textMessage, TextSizing textSizing, boolean flickerOn, boolean isUpdatable, Color colour) {
        this.textMessage = textMessage;
        this.textSizing = textSizing;
        this.flickerOn = flickerOn;
        this.isUpdatable = isUpdatable;
        this.colour = colour;
        defineTextSizes();
        setImage(createTextImage());
    }
    
    /**
     * Act method which runs in endless loop.
     */
    public void act() {
        if (flickerOn) {
            if(count % 25 == 0) {
                setImage(createTextImage());
                textSmall = !textSmall;   
            }
            count++;
            checkForCounterReset();
        }
        
        if (isUpdatable) {
            final SpaceGame world = (SpaceGame) getWorld();
            textMessage = String.valueOf(world.getScore());
            setImage(createTextImage());
        }
    }
    
    /**
     * Check if counter can be resetted.
     */    
    private void checkForCounterReset() {
        count = count < 25 ? count: 0;
    }

    /**
     * Create the image of the text.
     */
    private GreenfootImage createTextImage() {
        int textSize = textSmall ? smallTextSize : bigTextSize;
        return new GreenfootImage(textMessage, textSize, colour, null);
    }

    /**
     * Define the text size.
     */
    private void defineTextSizes() {
        int differenceOfSize = 4;
        switch (textSizing) {
            case SMALL:
                smallTextSize = 16;
                break;
            case MIDDLE:
                smallTextSize = 19;
                break;
            case BIG:
                smallTextSize = 22;
                break;
        }
        bigTextSize = smallTextSize + differenceOfSize;
    }
}
