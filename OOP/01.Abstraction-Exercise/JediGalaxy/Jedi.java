package class11.exercise.JediGalaxy;

public class Jedi {
    private Galaxy galaxy;
    private long points;

    public Jedi(Galaxy galaxy) {
        this.galaxy = galaxy;
        this.points = 0;
    }

    public void collectStars(int row, int col) {
        while (row >= 0 && col < galaxy.getRowLength(1)) {
            if (row < galaxy.getLength() && col >= 0 && col < galaxy.getRowLength(0)) {
                points += galaxy.getStar(row, col);
            }
            col++;
            row--;
        }
    }

    public long getPoints() {
        return points;
    }
}
