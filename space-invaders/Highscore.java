import java.util.HashMap;
import java.util.Map;
/**
 * Thi Highscore storage.
 * 
 * @author Gabriel Franz and Cornel Forster
 * @version 1.0
 */
public class Highscore  
{
    // The highscore values for each level
    private static Map<SpaceGameLevel, Integer> highscores = new HashMap<>();

    /**
     * Constructor for objects of class Highscore
     */
    public Highscore(int score, SpaceGameLevel level) {
        // Check if the current score is higher than the existing high score for the level.
        if (!highscores.containsKey(level) || highscores.get(level) < score) {
            highscores.put(level, score);
        }
    }

    /**
     * Gets the highscore of a level.
     * 
     * @param level The Spacegame level.
     */
    public static int getHighscore(SpaceGameLevel level) {
        // Return the high score for the specified level, or 0 if not available.
        return highscores.getOrDefault(level, 0);
    }
}
