package com.GingerHelen.data;

import java.util.Objects;

public class Coordinates {
    private int x;
    private long y;
    public Coordinates(int x, long y) {
        this.x = x;
        this.y = y;
    }
    public Coordinates() {
    }
    public int getX() {
        return x;
    }
    public long getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(long y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinates{" + "x=" + x
                + ", y=" + y + "}";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Coordinates that = (Coordinates) o;
        return Double.compare(that.x, x) == 0 && (y == that.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
