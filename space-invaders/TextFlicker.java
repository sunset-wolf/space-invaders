import greenfoot.*;

public class TextFlicker extends Actor {
    private String textMessage;
    private final boolean flickerOn;
    private final boolean isUpdatable;

    private int smallTextSize;
    private int bigTextSize;
    private int count = 0;
    private boolean textSmall = true;
    private Color colour;
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
