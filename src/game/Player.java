package game;

import java.util.function.Supplier;

import game.character.CharacterAI;

public class Player implements PlayerInfo {
    private String name;
    private Supplier<CharacterAI> ai;

    public Player(String name, Supplier<CharacterAI> ai) {
        this.name = name;
        this.ai = ai;
    }

    @Override
    public String getName() {
        return name;
    }

    /**
     * @return A new character AI instance.
     */
    public CharacterAI getNewAI() {
        return ai.get();
    }
}