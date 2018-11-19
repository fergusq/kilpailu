package game.action;

import game.character.Character;
import game.map.Map;

public class WaitAction implements Action {
    @Override
    public boolean validate(Map map, Character character) {
        return true;
    }

    @Override
    public void perform(Map map, Character character) {
        // waiting does nothing, but costs 1 HP
        character.reduceHp(1);
    }
}