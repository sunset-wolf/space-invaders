import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * SpceDashboard where the game can be choosen.
 * 
 * @author Gabriel Franz and Cornel Forster
 * @version 1.0
 */
public class SpaceDashboard extends Space
{
    private static final int LEVELCOUNT = 3;
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
        addObject(new TextFlicker("Level 1", TextSizing.MIDDLE, false, Color.WHITE), WIDTH / 2, HEIGHT / 15 * 5);
        addObject(new TextFlicker("Level 2", TextSizing.MIDDLE, false, Color.WHITE), WIDTH / 2, HEIGHT / 15 * 6);
        addObject(new TextFlicker("Level 3", TextSizing.MIDDLE, false, Color.WHITE), WIDTH / 2, HEIGHT / 15 * 7);
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
            
            boolean nodown = false;
            boolean noup = false;
            
            if (selectedLevel <= 1) {
                noup = true;
            } else if (selectedLevel >= LEVELCOUNT) {
                nodown = true;
            } else {
                noup = false;
                nodown = false;
            }
            
            if (!keyPressed && !nodown && Greenfoot.isKeyDown("down")) {
                selector.setLocation(selectorX,selectorY+HEIGHT/15);
                selectedLevel += 1;
                keyPressed = true;
            }
            if (!keyPressed && !noup && Greenfoot.isKeyDown("up")) {
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
                    Greenfoot.setWorld(new SpaceGame());
                }
                // Add more levels
            }
        }
    }
}

