public abstract class Game {
    protected int result;
    protected Field field;

    public Game() {
        this.field = new Field();
    }

    protected int calculateResult()
    {
        return switch (field.isWinning())
                {
                    case BLANK -> 0;
                    case CIRCLE -> 1;
                    case CROSS -> 2;
                };
    }

    protected int evaluateBoard(Field field, Type type)
    {
        if(field.isWinning() == type)
        {
            return 10;
        }

        if(field.isFilled() && field.isWinning() == Type.BLANK)
        {
            return 0;
        }

        if(field.isWinning() != Type.BLANK && field.isWinning() != type)
        {
            return -10;
        }

        int best = -1000;
        for(int i = 0; i < 3; ++ i)
        {
            for(int j = 0; j < 3; ++ j)
            {
                if(!field.fillCell(i, j, type))
                {
                    continue;
                }

                int currentPosition = evaluateBoard(field, Type.values()[1 - type.ordinal()]);
                field.fillCell(i, j, Type.BLANK);
                best = Integer.max(best, -currentPosition);
            }
        }

        return best;
    }

    int[] winningMove(Field field, Type type)
    {
        int iValid = 0, jValid = 0, iMax = -1, jMax = -1;
        double maxWinning = 1000;
        for(int i = 0; i < 3; ++ i)
        {
            for(int j = 0; j < 3; ++ j)
            {
                if(!field.fillCell(i, j, type))
                {
                    continue;
                }
                iValid = i;
                jValid = j;
                double currentPosition = evaluateBoard(field, Type.values()[1 - type.ordinal()]);
                field.fillCell(i, j, Type.BLANK);
                if(currentPosition < maxWinning)
                {
                    iMax = i;
                    jMax = j;
                    maxWinning = currentPosition;
                }
            }
        }

        if(iMax == -1)
        {
            return new int[]{iValid, jValid};
        }
        return new int[]{iMax, jMax};
    }

    protected void randomMove(Field field, Type type)
    {
        int newX, newY;
        do
        {
            newX = (int)(Math.random() * 3);
            newY = (int)(Math.random() * 3);
        } while (!field.fillCell(newX, newY, type));
    }

    public abstract void play();
}
