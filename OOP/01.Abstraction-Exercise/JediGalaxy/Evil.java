package class11.exercise.JediGalaxy;

public class Evil {
    private Galaxy galaxy;

    public Evil(Galaxy galaxy) {
        this.galaxy = galaxy;
    }

    public void destroyStars(int row, int col) {
        while (row >= 0 && col >= 0) {
            if (row >= 0 && row < galaxy.getLength() && col >= 0 && col < galaxy.getRowLength(row)) {
                galaxy.setStar(row, col, 0);
            }
            row--;
            col--;
        }
    }
}
