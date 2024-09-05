package class11.exercise.JediGalaxy;

public class Galaxy {
    private Field field;

    public Galaxy(Field field) {
        this.field = field;
    }

    public int getLength() {
        return field.getLength();
    }

    public int getRowLength(int row) {
        return field.getRowLength(row);
    }

    public void setStar(int row, int col, int newValue) {
        field.setNewValue(row, col, newValue);
    }

    public int getStar(int row, int col) {
        return field.getValue(row, col);
    }
}
