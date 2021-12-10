public class PlayerVsComputerEasy extends Game
{
    public void play()
    {
        int player = (int)(Math.random() * 2);

        while(this.field.isWinning() == Type.BLANK && !this.field.isFilled())
        {
            if(player % 2 == 0)
            {
                randomMove(field, Type.CIRCLE);
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
