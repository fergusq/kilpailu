package game.action;

import game.character.Character;
import game.map.Map;

/**
 * Split action clones the character and gives half of the hit points to the clone.
 */
public class SplitAction implements Action {
    private final int dx;
    private final int dy;

    public SplitAction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    @Override
    public boolean validate(Map map, Character character) {
        if (dx < -1 || dx > 1 || dy < -1 || dy > 1) {
            return false;
        }

        return map.isEmpty(character.getX() + dx, character.getY() + dy);
    }

    @Override
    public void perform(Map map, Character character) {
        int newHp = character.getHp() / 2;
        character.setHp(newHp);

        Character clone = new Character(
            character.getPlayer(),
            character.getX() + dx,
            character.getY() + dy,
            newHp,
            character.maxStrength,
            character.getStrength()
        );
        map.getCellOf(clone).setCharacter(clone);
    }
}