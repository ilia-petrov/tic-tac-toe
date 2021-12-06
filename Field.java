public class Field {
    private static final int SIZE = 3;

    private Cell[][] field;

    public Field() {
        this.field = new Cell[SIZE][SIZE];
        for (int i = 0; i < SIZE; ++ i) {
            for (int j = 0; j < SIZE; ++ j) {
                this.field[i][j] = new Cell();
            }
        }
    }

    public Type isWinning() {
        for (int i = 0; i < SIZE; ++ i) {
            if (this.field[i][0].getCell() == this.field[i][1].getCell()
                    && this.field[i][0].getCell() == this.field[i][2].getCell()) {
                return this.field[i][0].getCell();
            }
            if (this.field[0][i].getCell() == this.field[1][i].getCell()
                    && this.field[0][i].getCell() == this.field[2][i].getCell()) {
                return this.field[0][i].getCell();
            }
        }
        if (this.field[0][0].getCell() == this.field[1][1].getCell()
                && this.field[0][0].getCell() == this.field[2][2].getCell()) {
            return this.field[0][0].getCell();
        }
        if (this.field[0][2].getCell() == this.field[1][1].getCell()
                && this.field[0][2].getCell() == this.field[2][0].getCell()) {
            return this.field[0][2].getCell();
        }

        return Type.BLANK;
    }

    public boolean fillCell(int x, int y, Type type) {
        if(type.equals(Type.BLANK))
        {
            this.field[x][y].setCell(type);
            return true;
        }
        if (this.field[x][y].getCell() != Type.BLANK) {
            return false;
        }
        this.field[x][y].setCell(type);
        return true;
    }

    public boolean isFilled() {
        boolean filled = true;
        for (int i = 0; i < SIZE; ++ i) {
            for (int j = 0; j < SIZE; ++ j) {
                if (this.field[i][j].getCell() == Type.BLANK) {
                    filled = false;
                    break;
                }
            }
        }
        return filled;
    }

    public boolean isIn(int x, int y)
    {
        return (0 <= x && x <= 2) && (0 <= y && y <= 2);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("  1   2   3\n");
        for (int i = 0; i < SIZE; ++ i) {
            sb.append(i + 1);
            sb.append(this.field[i][0].toString());
            sb.append("|");
            sb.append(this.field[i][1].toString());
            sb.append("|");
            sb.append(this.field[i][2].toString());
            sb.append("\n");
            if (i < SIZE - 1) {
                sb.append(" -----------\n");
            }
        }
        return sb.toString();
    }
}
