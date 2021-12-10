import java.util.Scanner;

public class UI
{
    public static void winningMessage(Field field, int result)
    {
        System.out.println(field);
        if (result == 1) {
            System.out.println("O wins!");
        } else if (result == 2) {
            System.out.println("X wins!");
        } else {
            System.out.println("Draw!");
        }
    }

    public static void nextMove(Field field, Type turn)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println(field);
        if (turn == Type.CIRCLE) {
            System.out.println("O turn!");
        } else {
            System.out.println("X turn!");
        }

        boolean changeTurn = false;
        do
        {
            System.out.println("Please enter the coordinates of the cell you want to fill!");

            String[] tokensString = scanner.nextLine().split("\\s+");
            int[] tokens = {Integer.parseInt(tokensString[0]) - 1, Integer.parseInt(tokensString[1]) - 1};

            if(!field.isIn(tokens[0], tokens[1]))
            {
                System.out.println("Coordinates are outside the field!");
                continue;
            }

            changeTurn = field.fillCell(tokens[0], tokens[1], turn);
            if(!changeTurn)
            {
                System.out.println("This cell is already filled!");
            }
        }while (!changeTurn);
    }

    public static int selectMode()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello, do you want to play vs a player, or a computer?");
        System.out.println("For player, enter 1");
        System.out.println("For easy computer, enter 2");
        System.out.println("For hard computer, enter 3");
        System.out.println("For custom difficulty, enter 4");
        System.out.println("To end the game, enter 5");
        
        return Integer.parseInt(scanner.nextLine());
    }
    public static int selectDifficulty() {
    	Scanner scanner = new Scanner(System.in);
    	int difficulty;
    	do {
	    	System.out.println("Select a difficulty from 0 to 10: ");
	    	difficulty = scanner.nextInt();
    	} while(difficulty<0||difficulty>10);
    	return difficulty;
    }
}
