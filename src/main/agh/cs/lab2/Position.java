package agh.cs.lab2;

public class Position {
    public final int x;
    public final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return new String("(" + this.x + "," + this.y + ")");
    }

    public boolean smaller(Position position) {
        return (this.x <= position.x && this.y <= position.y);
    }

    public boolean larger(Position position) {
        return (this.x >= position.x && this.y >= position.y);
    }

    public Position upperRight(Position position) {
        return new Position((Math.max(this.x, position.x)), (Math.max(this.y, position.y)));
    }

    public Position lowerLeft(Position position) {
        return new Position((Math.min(this.x, position.x)), (Math.min(this.y, position.y)));
    }

    public Position add(Position position) {
        return new Position((this.x + position.x), (this.y + position.y));
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (!(other instanceof Position))
            return false;
        Position that = (Position) other;
        return (this.x == that.x && this.y == that.y);
    }

    @Override
    public int hashCode() {
        int hash = 13;
        hash += this.x * 31;
        hash += this.y * 17;
        return hash;
    }
}
