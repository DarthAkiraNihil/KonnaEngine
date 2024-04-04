package org.konna.engine.common;

import java.util.Objects;

public class KVector2 {
    public int x, y;

    public static final KVector2 InvalidPlace = new KVector2(
        Integer.MAX_VALUE,
        Integer.MAX_VALUE
    );
    public KVector2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public KVector2(KVector2 copy) {
        this.x = copy.x;
        this.y = copy.y;
    }

    public void add(KVector2 other) {
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
        KVector2 that = (KVector2) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

}
