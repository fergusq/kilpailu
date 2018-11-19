package game.character;

import game.Player;
import game.PlayerInfo;

/**
 * Publicly available information about characters.
 */
public interface CharacterInfo {

    Player getPlayer();

    /**
     * @return The player that owns this character.
     */
    public default PlayerInfo getPlayerInfo() {
        return getPlayer();
    }

    /**
     * @return The X coordinate of the character.
     */
    public int getX();

    /**
     * @return The Y coordinate of the character.
     */
    public int getY();

    /**
     * @return The hit points of the character.
     */
    public int getHp();
}