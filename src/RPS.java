import java.util.Random;
import java.util.Scanner;

public class RPS {
	public enum PICKS {
		ROCK, PAPER, SCISSORS
	};

	public enum GAMESTATE {
		PLAYERPICK, AIPICK, FINISH
	};

	public enum WINNER {
		PLAYERWIN, AIWIN, DRAW
	};

	private PICKS player;
	private boolean isPlaying;
	private Scanner sc;
	private GAMESTATE gs;
	private WINNER currentWinner;
	private PICKS aiPick;

	public RPS() {
		gs = GAMESTATE.PLAYERPICK;
		sc = new Scanner(System.in);
		isPlaying = true;
		
		gameLoop();
	}

	public void pickPlayer(PICKS player) {
		this.player = player;
	}

	public WINNER pickWinner(int value) {
		WINNER winner;
		if (player.ordinal() == value)
			winner = WINNER.DRAW;

		else if (player == PICKS.PAPER && value == 0)
			winner = WINNER.PLAYERWIN;

		else if (player == PICKS.ROCK && value == 2)
			winner = WINNER.PLAYERWIN;

		else if (player == PICKS.SCISSORS && value == 1)
			winner = WINNER.PLAYERWIN;
		else {
			winner = WINNER.AIWIN;
		}
		return winner;

	}

	// This is the main game loop
	public void gameLoop() {
		while (isPlaying) {

			switch (gs.ordinal()) {
			case 0: // If the player is picking
				System.out.println("Pick Rock, Paper or Scissors");
				String input = sc.next().toUpperCase();
				if (input.equals("ROCK")) {
					player = PICKS.ROCK;
					gs = GAMESTATE.AIPICK;
				} else if (input.equals("PAPER")) {
					player = PICKS.PAPER;
					gs = GAMESTATE.AIPICK;
				}
				if (input.equals("SCISSORS")) {
					player = PICKS.SCISSORS;
					gs = GAMESTATE.AIPICK;
				}
				break;

			case 1:
				Random r = new Random();
				int value =r.nextInt(2);
				if( value == 0) {
					aiPick = PICKS.ROCK;
				}
				
				if(value == 1) {
					aiPick = PICKS.PAPER;
				}
				
				if(value == 2) {
					aiPick = PICKS.SCISSORS;
				}
				currentWinner = pickWinner(aiPick.ordinal());
				gs = GAMESTATE.FINISH;
				break;

			case 2:
				System.out.println("PLAYER PICKED : " + player.name());
				System.out.println("AI PICKED : " + aiPick.name());
				System.out.println("Winner : " + currentWinner.name());
				gs = GAMESTATE.PLAYERPICK;
				break;

			}

		}
	}

}
