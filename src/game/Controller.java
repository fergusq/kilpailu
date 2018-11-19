package game;

import java.util.List;

import game.action.Action;
import game.character.Character;
import game.map.Cell;
import game.map.Map;

public class Controller {
    private final Map map;

    public Controller(Map map) {
        this.map = map;
    }

    public void runGame() {
        boolean livingCharacter;
        do {
            livingCharacter = false;
            List<Cell> cells = map.getCells();
            for (Cell cell : cells) {
                if (cell.getCharacter().isPresent()) {
                    Character character = cell.getCharacter().get();
                    Action action = character.getAI().nextAction(map.getEnvironmentOf(character));
                    if (action.validate(map, character)) {
                        action.perform(map, character);
                    }
                    if (character.getHp() <= 0) {
                        cell.removeCharacter();
                        continue;
                    }
                    livingCharacter = true;
                }
            }
        } while (livingCharacter);
    }
}