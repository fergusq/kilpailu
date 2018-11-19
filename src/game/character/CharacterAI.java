package game.character;

import game.action.Action;
import game.map.Area;

/**
 * An artificial intelligence that controls characters.
 */
public abstract class CharacterAI {

    protected final CharacterInfo characterInfo;

    public CharacterAI(CharacterInfo characterInfo) {
        this.characterInfo = characterInfo;
    }

    /**
     * Given the character's current environment, determines the next action.
     */
    public abstract Action nextAction(Area environment);
}