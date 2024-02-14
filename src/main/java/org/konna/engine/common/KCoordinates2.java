package org.konna.engine.common;

import java.util.Objects;

public class KCoordinates2 {
    public int x, y;

    public static final KCoordinates2 InvalidPlace = new KCoordinates2(
        Integer.MAX_VALUE,
        Integer.MAX_VALUE
    );
    public KCoordinates2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public KCoordinates2(KCoordinates2 copy) {
        this.x = copy.x;
        this.y = copy.y;
    }

    public void add(KCoordinates2 other) {
        this.add(other.x, other.y);
    }

    public void add(int x, int y) {
        this.x += x;
        this.y += y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KCoordinates2 that = (KCoordinates2) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

}
