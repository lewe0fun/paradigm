package maze;

public class Point {
    private int x;
    private int y;
    private int value;
    private String type;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(int x, int y, String type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public Point(int x, int y, int value) {
        this(x, y);
        this.value = value;
        if (value == 1) this.type = "wall";
        if (value == 0) this.type = "pass";
    }

    public int getX() {
        return x;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return " " + value + " ";
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }
}
