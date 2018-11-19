package game.map;

import java.util.Optional;

import game.character.Character;

public class Cell implements CellInfo {

    public enum CellType {
        FLOOR,
        WALL;
    }

    private CellType type;
    private Optional<Character> character;

    public Cell(CellType type) {
        this.type = type;
        this.character = Optional.empty();
    }

    public CellType getType() {
        return this.type;
    }

    public Optional<Character> getCharacter() {
        return this.character;
    }

    public void removeCharacter() {
        this.character = Optional.empty();
    }

    public void setCharacter(Character character) {
        if (this.character.isPresent()) {
            throw new RuntimeException("Trying to add a character to a cell that already has a character.");
        }

        this.character = Optional.of(character);
    }
}