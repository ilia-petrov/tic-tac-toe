public class PlayerVsComputerEasy extends Game
{
    public void play()
    {
        int player = (int)(Math.random() * 2);

        while(this.field.isWinning() == Type.BLANK && !this.field.isFilled())
        {
            if(player % 2 == 0)
            {
                int newX, newY;
                do
                {
                    newX = (int)(Math.random() * 3);
                    newY = (int)(Math.random() * 3);
                } while (!this.field.fillCell(newX, newY, Type.CIRCLE));
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
