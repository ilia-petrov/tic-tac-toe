public class Cell {
    private Type cell;

    public Cell() {
        this.cell = Type.BLANK;
    }

    public Type getCell() {
        return cell;
    }

    public void setCell(Type cell) {
        this.cell = cell;
    }

    @Override
    public String toString() {
        String res;
        if (this.cell == Type.BLANK) {
            res = "   ";
        } else if (this.cell == Type.CIRCLE) {
            res = " o ";
        } else {
            res = " X ";
        }
        return res;
    }
}
