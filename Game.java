public class Game {
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

    protected int winningStrategy(Field field, Type type)
    {
        if(field.isWinning() == type)
        {
            return 1;
        }

        if(field.isWinning() != type && field.isWinning() != Type.BLANK)
        {
            return -1;
        }

        if(field.isFilled() && field.isWinning() == Type.BLANK)
        {
            return 0;
        }

        int win = 0;

        for(int i = 0; i < 3; ++ i)
        {
            for(int j = 0; j < 3; ++ j)
            {
                int value = 0;
                if(field.fillCell(i, j, Type.values()[1 - type.ordinal()]))
                {
                    int next = winningStrategy(field, Type.values()[1 - type.ordinal()]);
                    field.fillCell(i, j, Type.BLANK);
                    if(next > 0)
                    {
                        return -1;
                    }else
                    {
                        value -= next;
                    }
                }

                win = Integer.max(win, value);
            }
        }

        return win;
    }
}
