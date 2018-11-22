package game.character;

/**
 * Publicly available information about characters.
 */
public interface OwnCharacterInfo extends CharacterInfo {

    /**
     * @return The hit points of the character.
     */
    public int getHp();

    /**
     * @return The hit points of the character.
     */
    public int getStrength();
}