public class PVP extends Game
{
    public void play() {
        int turn = 0;
        while (this.field.isWinning() == Type.BLANK && !this.field.isFilled()) {
            UI.nextMove(field, ((turn % 2 == 0) ? Type.CIRCLE : Type.CROSS));
            turn ++;
        }

        result = calculateResult();
        UI.winningMessage(field, result);
    }
}
