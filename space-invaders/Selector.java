import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Selector here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Selector extends Actor
{
    public Selector() {
        GreenfootImage image = getImage();
        image.scale(image.getWidth(), image.getHeight());      
        setImage(image);
    }
}
