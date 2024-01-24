import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The selector for choosing a level. 
 * 
 * @author Gabriel Franz and Cornel Forster
 * @version 1.0
 */
public class Selector extends Actor
{
    public Selector() {
        GreenfootImage image = getImage();
        image.scale(image.getWidth(), image.getHeight());      
        setImage(image);
    }
}
