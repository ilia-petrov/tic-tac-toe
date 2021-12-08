public class PlayerVsComputerHard extends Game
{
    public void play()
    {
        int player = (int)(Math.random() * 2);

        while(this.field.isWinning() == Type.BLANK && !this.field.isFilled())
        {
            if(player % 2 == 0)
            {
                int newX = 0, newY = 0, maxChances = 0;

                for(int i = 0; i < 3; ++ i)
                {
                    for(int j = 0; j < 3; ++ j)
                    {
                        if(!field.fillCell(i, j, Type.CIRCLE))
                        {
                            continue;
                        }
                        int next = winningStrategy(field, Type.CIRCLE);
                        field.fillCell(i, j, Type.BLANK);
                        if(next >= maxChances)
                        {
                            maxChances = next;
                            newX = i;
                            newY = j;
                        }
                    }
                }

                field.fillCell(newX, newY, Type.CIRCLE);
            } else
            {
                UI.nextMove(field, Type.CROSS);
            }
            ++ player;
        }

        result = calculateResult();
        UI.winningMessage(field, result);
    }
}
