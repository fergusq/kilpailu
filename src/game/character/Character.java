package game.character;

import game.Player;

/**
 * Represents a character in the game.
 */
public class Character implements CharacterInfo {
    private Player player;
    private CharacterAI ai;
    private int x;
    private int y;
    private int hp;

    public Character(Player player, int x, int y, int hp) {
        this.player = player;
        this.ai = player.getNewAI();
        this.x = x;
        this.y = y;
        this.hp = hp;
    }

    @Override
    public Player getPlayer() {
        return player;
    }

    /**
     * @return The AI that controls this character.
     */
    public CharacterAI getAI() {
        return ai;
    }

    @Override
    public int getX() {
        return x;
    }

    /**
     * Sets the X coordinate of the character.
     * 
     * @param x the new X coordinate
     */
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    /**
     * Sets the Y coordinate of the character.
     * 
     * @param y the new Y coordinate
     */
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getHp() {
        return hp;
    }

    /**
     * Sets the hit points of the character.
     * 
     * @param hp the new hit point number
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     * Removes the given amount from the hit points of the character.
     * 
     * @param amount the amount points to be removed
     */
    public void reduceHp(int amount) {
        this.hp -= amount;
    }
}