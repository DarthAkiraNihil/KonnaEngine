package org.konna.engine.common;

public class KCoordinates {
    public int x, y, z;

    public static final KCoordinates InvalidPlace = new KCoordinates(
        Integer.MAX_VALUE,
        Integer.MAX_VALUE,
        Integer.MAX_VALUE
    );
    public KCoordinates(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
