package org.konna.engine.mechanic.location;

public class KTile {

    private final int id;
    private final String name;
    private final boolean passable, transparent;

    public KTile(int id, String name, boolean passable, boolean transparent) {
        this.id = id;
        this.name = name;
        this.passable = passable;
        this.transparent = transparent;
    }

    public boolean isPassable() {
        return passable;
    }

    public boolean isTransparent() {
        return transparent;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
