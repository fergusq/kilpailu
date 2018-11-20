package game.action;

import game.character.Character;
import game.map.Map;

/**
 * Waiting increases the strength of the character by 2 by cost of 1 HP.
 */
public class WaitAction implements Action {
    @Override
    public boolean validate(Map map, Character character) {
        return true;
    }

    @Override
    public void perform(Map map, Character character) {
        // waiting increases strength, but costs 1 HP
        character.changeHpBy(-1);
        character.changeStrengthBy(2);
    }
}