public class PlayerVsComputerHard extends Game
{
    public void play()
    {
        int player = (int)(Math.random() * 2);

        while(this.field.isWinning() == Type.BLANK && !this.field.isFilled())
        {
            if(player % 2 == 0)
            {
                int[] nextMove = winningMove(field, Type.CIRCLE);

                field.fillCell(nextMove[0], nextMove[1], Type.CIRCLE);
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
