package game.map;

import java.util.Optional;

import game.map.Cell.CellType;
import game.character.Character;
import game.character.CharacterInfo;

public interface CellInfo {
    public CellType getType();

    Optional<Character> getCharacter();

    public default Optional<? extends CharacterInfo> getCharacterInfo() {
        return getCharacter();
    }
}