package game.map;

import game.map.Cell.CellType;

import java.util.ArrayList;
import java.util.List;

import game.character.Character;

public class Map {
    private Cell[][] cells;

    public Map(int width, int height) {
        this.cells = new Cell[width][height];
    }

    public List<Cell> getCells() {
        List<Cell> ans = new ArrayList<>();
        for (Cell[] column : cells) {
            for (Cell cell : column) {
                ans.add(cell);
            }
        }
        return ans;
    }

    public Cell getCellAt(int x, int y) {
        return cells[x][y];
    }

    public Cell getCellOf(Character character) {
        return getCellAt(character.getX(), character.getY());
    }

    public Area getEnvironmentOf(Character character) {
        return new Area(this, character.getX(), character.getY(), 2);
    }

    public boolean isEmpty(int x, int y) {
        Cell cell = getCellAt(x, y);
        return cell.getType() == CellType.FLOOR && !cell.getCharacter().isPresent();
    }
}