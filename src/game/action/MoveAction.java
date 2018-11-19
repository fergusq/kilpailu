package game.action;

import game.map.Map;
import game.character.Character;

public class MoveAction implements Action {

    private final int dx;
    private final int dy;

    public MoveAction(int dx, int dy) {
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
        map.getCellOf(character).removeCharacter();
        character.setX(character.getX() + dx);
        character.setY(character.getY() + dy);
        map.getCellOf(character).setCharacter(character);

        // moving costs 1 HP
        character.reduceHp(1);
    }
}