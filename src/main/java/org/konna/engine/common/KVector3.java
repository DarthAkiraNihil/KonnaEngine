package org.konna.engine.common;

import java.util.Objects;

public class KVector3 {
    public int x, y, z;

    public static final KVector3 InvalidPlace = new KVector3(
        Integer.MAX_VALUE,
        Integer.MAX_VALUE,
        Integer.MAX_VALUE
    );
    public KVector3(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KVector3 that = (KVector3) o;
        return x == that.x && y == that.y && z == that.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }
}
