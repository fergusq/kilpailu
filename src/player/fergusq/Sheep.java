package player.fergusq;

import java.util.Random;

import static java.util.stream.Collectors.toList;

import game.action.Action;
import game.action.MoveAction;
import game.action.SplitAction;
import game.action.WaitAction;
import game.character.CharacterAI;
import game.character.OwnCharacterInfo;
import game.map.Area;
import util.Pair;

public class Sheep extends CharacterAI {

    private static final int MAX_HP = 100;

    private Random rnd = new Random();

    public Sheep(OwnCharacterInfo character) {
        super(character);
    }

    @Override
    public Action nextAction(Area environment) {
        if (rnd.nextDouble() < 0.6) {
            return new WaitAction();
        }
        var emptyNeighbours =
            Pair.range(Pair.of(-1, -1), Pair.of(1, 1))
            .filter(coords -> coords.first != 0 || coords.second != 0)
            .filter(coords -> coords.feed(environment::getCellAt).get().isEmpty())
            .collect(toList());
        if (emptyNeighbours.isEmpty()) {
            return new WaitAction();
        } else {
            return emptyNeighbours.get(rnd.nextInt(emptyNeighbours.size())).feed(ownCharacter.getHp() >= MAX_HP*2 ? SplitAction::new : MoveAction::new);
        }
	}
}