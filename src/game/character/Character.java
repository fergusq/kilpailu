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
    private int strength;

    public final int maxStrength;

    public Character(Player player, int x, int y, int hp, int maxStrength, int strength) {
        this.player = player;
        this.ai = player.getNewAI();
        this.x = x;
        this.y = y;
        this.hp = hp;
        this.maxStrength = maxStrength;
        this.strength = strength;
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
     * Adds or removes the given amount of hit points.
     * 
     * @param amount the amount hit points to be added, either positive or negative
     */
    public void changeHpBy(int amount) {
        this.hp += amount;
    }

    /**
     * @return The strength of the character.
     */
    public int getStrength() {
        return strength;
    }

    /**
     * Sets the strength of the character.
     * 
     * @param strength the new strength
     */
    public void setStrength(int strength) {
        if (strength > maxStrength) {
            strength = maxStrength;
        } else if (strength < 0) {
            strength = 0;
        }
        this.strength = strength;
    }

    /**
     * Changes the strength of the character by a given number.
     * 
     * @param amount the amount of strength to be added
     */
    public void changeStrengthBy(int amount) {
        if (strength + amount > maxStrength) {
            strength = maxStrength;
        } else if (strength + amount < 0) {
            strength = 0;
        } else {
            strength += amount;
        }
    }
}