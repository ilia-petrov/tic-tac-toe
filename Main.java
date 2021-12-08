public class Main {
    public static void main(String[] args) {
        boolean endGame = false;

        while (!endGame) {
            int mode = UI.selectMode();
            Game game;
            switch (mode) {
                case 1 ->
                {
                    game = new PVP();
                    game.play();
                }
                case 2 -> {
                    game = new PlayerVsComputerEasy();
                    game.play();
                }
                case 3 -> {
                    game = new PlayerVsComputerHard();
                    game.play();
                }
                case 4 -> endGame = true;
                default -> System.out.println("Incorrect mode!");
            }
        }
    }
}
