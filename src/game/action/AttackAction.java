package game.action;

import game.map.Map;
import game.character.Character;

/**
 * Attack action tries to move a specific amount of hitpoints from the opponent to the character.
 * If the opponent has less or equal amount of strength than the character, the attack fails and
 * the character loses the specified amount of hit points (the opponent does not gain them).
 * 
 * Attacking costs 1 strength.
 */
public class AttackAction implements Action {
    private final int dx;
    private final int dy;
    private final int hp;

    public AttackAction(int dx, int dy, int hp) {
        this.dx = dx;
        this.dy = dy;
        this.hp = hp;
    }

    @Override
    public boolean validate(Map map, Character character) {
        if (dx < -1 || dx > 1 || dy < -1 || dy > 1 || hp <= 0) {
            return false;
        }

        return map.getCellAt(character.getX() + dx, character.getY() + dy).getCharacter().isPresent();
    }

    @Override
    public void perform(Map map, Character character) {
        Character opponent = map.getCellAt(character.getX() + dx, character.getY() + dy).getCharacter().get();
        if (character.getStrength() > opponent.getStrength()) {
            opponent.changeHpBy(-hp);
            character.changeHpBy(hp);
        } else {
            character.changeHpBy(-hp);
        }
        character.changeStrengthBy(-1);
    }
}