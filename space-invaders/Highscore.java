/**
 * Write a description of class Highscore here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Highscore  
{
    // The highscore value
    private static int highscore;

    /**
     * Constructor for objects of class Highscore
     */
    public Highscore(int highscore)
    {
        if (this.highscore < highscore) {
            this.highscore = highscore;
        }
    }
    
    public static int getHighscore() {
       return highscore;
    }
}
