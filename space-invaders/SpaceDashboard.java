import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * SpceDashboard where the game can be choosen.
 * 
 * @author Gabriel Franz and Cornel Forster
 * @version 1.0
 */
public class SpaceDashboard extends Space
{
    private static final int LEVELCOUNT = 4;
    private int selectedLevel = 1;
    private boolean keyPressed = false;
    private boolean keyDown = false;
    /**
     * Constructor for objects of class SpaceDashboard.
     * 
     */
    public SpaceDashboard()
    {    
        addFlyingAliens();
        addTextMessages();
        addSelector();
    }
    
    /**
     * Act method which runs in endless loop.
     */
    public void act() {
        changeSelector();
    }
    
    /**
     * Creates the sidelines with the aliens.
     */
    private void addFlyingAliens() {
        int counter = 0;
        int[] xPositions = {WIDTH / 10 * 1, WIDTH / 10 * 9};
        
        while(counter < 12) {
            for(AlienColour alienColour : AlienColour.values()) {
                // Add alien on left and right side.
                for(int position : xPositions) {
                    addObject(new Alien(alienColour, 0), position, HEIGHT / 15 * (counter + 2));
                }
                counter++;
            }   
        }
    }
    
    /**
     * Add the text messages.
     */
    private void addTextMessages() {
        addObject(new TextFlicker("SPACE-INVADERS", TextSizing.BIG, true, false, Color.GREEN), WIDTH / 2, HEIGHT / 15 * 2);
        addObject(new TextFlicker("Choose your game", TextSizing.MIDDLE, true, false, Color.WHITE), WIDTH / 2, HEIGHT / 15 * 3);
        addObject(new TextFlicker("Level 1", TextSizing.MIDDLE, false, false, Color.WHITE), WIDTH / 2, HEIGHT / 15 * 5);
        addObject(new TextFlicker("Level 2", TextSizing.MIDDLE, false, false, Color.WHITE), WIDTH / 2, HEIGHT / 15 * 6);
        addObject(new TextFlicker("Level 3", TextSizing.MIDDLE, false, false, Color.WHITE), WIDTH / 2, HEIGHT / 15 * 7);
        addObject(new TextFlicker("Level 4", TextSizing.MIDDLE, false, false, Color.WHITE), WIDTH / 2, HEIGHT / 15 * 8);
    }
    
    /**
     * Add selector.
     */
    private void addSelector() {
        addObject(new Selector(), WIDTH / 3, HEIGHT / 15 * 5);
    }
    
    /**
     * Change selector
     */
    public void changeSelector() {
        Class<Selector> selectorClass = Selector.class;
        Selector selector = null;
        
        for (Actor object : getObjects(Selector.class)) {
            if (object.getClass() == selectorClass) {
                selector = (Selector) object;
                break;
            }
        }
        
        if (selector != null) {
            int selectorX = selector.getX();
            int selectorY = selector.getY();
            
            boolean noDown = false;
            boolean noUp = false;
            
            if (selectedLevel <= 1) {
                noUp = true;
            } else if (selectedLevel >= LEVELCOUNT) {
                noDown = true;
            } else {
                noUp = false;
                noDown = false;
            }
            
            if (!keyPressed && !noDown && Greenfoot.isKeyDown("down")) {
                selector.setLocation(selectorX,selectorY+HEIGHT/15);
                selectedLevel += 1;
                keyPressed = true;
            }
            if (!keyPressed && !noUp && Greenfoot.isKeyDown("up")) {
                selector.setLocation(selectorX,selectorY-HEIGHT/15);
                selectedLevel -= 1;
                keyPressed = true;
            }
            
            if (!Greenfoot.isKeyDown("down")&&!Greenfoot.isKeyDown("up")) {
                // Reset the flag when the key is released
                keyPressed = false;
            }
            if (Greenfoot.isKeyDown("enter")) {
                keyDown = true;
            }
            
            if ((!Greenfoot.isKeyDown("enter")) && keyDown == true) {
                // Define which level to start
                if (selectedLevel == 1) {
                    Greenfoot.setWorld(new SpaceGame(SpaceGameLevel.BEGINNER));
                }
                else if(selectedLevel == 2) {
                    Greenfoot.setWorld(new SpaceGame(SpaceGameLevel.MEDIUM));
                }
                else if(selectedLevel == 3) {
                    Greenfoot.setWorld(new SpaceGame(SpaceGameLevel.HARD));
                }
                else if(selectedLevel == 4) {
                    Greenfoot.setWorld(new SpaceGame(SpaceGameLevel.PRO));
                }
            }
        }
    }
}

