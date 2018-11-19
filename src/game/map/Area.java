package game.map;

import java.util.Optional;

/**
 * Represents an area of the map relative to a point.
 */
public class Area {
    private Map map;
    private int x;
    private int y;
    private int radius;

    Area(Map map, int x, int y, int radius) {
        this.map = map;
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public Optional<CellInfo> getCellAt(int dx, int dy) {
        if (dx < -radius || dx > radius || dy < radius || dy > radius) {
            return Optional.empty();
        }

        return Optional.of(map.getCellAt(x + dx, y + dy));
    }
}