public class PlayerVsComputerCustomDifficulty extends Game {

	@Override
	public void play() {
		int difficulty = UI.selectDifficulty();
		int player = (int)(Math.random() * 2);
		while(this.field.isWinning()==Type.BLANK &&!this.field.isFilled()) {
			if(player%2 == 0) {
				if(difficulty<=(int)(Math.random()*10)) {
					randomMove(field,Type.CROSS);
				} else {
					int[] coordinates = winningMove(field, Type.CROSS);
					field.fillCell(coordinates[0], coordinates[1], Type.CROSS);
				}
			} else {
				UI.nextMove(field, Type.CIRCLE);
			}
			player ++;
		}
	}

}
