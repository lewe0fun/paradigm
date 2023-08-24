package maze;

import java.util.Random;

public class Maze {
    private Point[][] matrix;
    private Random random = new Random();

    public Maze(int h, int w) {
        this.matrix = genMaze(h, w);
    }

    public Maze() {
        int h = random.nextInt(3, 10);
        int w = random.nextInt(3, 10);
        this.matrix = genMaze(h, w);
    }

    private Point[][] genMaze(int h, int w) {
        Point[][] result = new Point[h][w];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                if (i==0||j==0||i==result[i].length-1||j==result[i].length-1)result[i][j]=new Point(i, j, 1);
                else result[i][j] = new Point(i, j, random.nextInt(2));
            }
        }
        return result;
    }
    public void setStart(Point start){
        this.matrix[start.getY()][start.getX()].setType("start");
    }
    public void setExit(Point start){
        this.matrix[start.getY()][start.getX()].setType("exit");
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Лабиринт " + this.matrix.length + " на " + this.matrix[0].length + ":\n");
        for (Point[] points : this.matrix) {
            for (Point point : points) {
                if(point.getType().equals("start"))result.append(" H ");
                else if(point.getType().equals("exit"))result.append(" B ");
                else result.append(point);
            }
            result.append('\n');
        }
        return result.toString();
    }
}
