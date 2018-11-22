package game.character;

import game.action.Action;
import game.map.Area;

/**
 * An artificial intelligence that controls characters.
 */
public abstract class CharacterAI {

    protected final OwnCharacterInfo ownCharacter;

    public CharacterAI(OwnCharacterInfo ownCharacter) {
        this.ownCharacter = ownCharacter;
    }

    /**
     * Given the character's current environment, determines the next action.
     */
    public abstract Action nextAction(Area environment);
}