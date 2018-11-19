package game.action;

import game.map.Map;
import game.character.Character;

/**
 * Actions represent things characters can do on their turn.
 */
public interface Action {
    /**
     * Validates that the character is actually capable under the rules of the game
     * to perform the action.
     * 
     * @param map The current situation of the game.
     * @param character The character that attempts to perform the action.
     * @return {@code true} if the character is capable of performing the action, {@code false} otherwise
     */
    public boolean validate(Map map, Character character);

    /**
     * Performs the action.
     * 
     * @param map The current situation of the game.
     * @param character The character that performs the action.
     */
    public void perform(Map map, Character character);
}