import java.util.Random;
import java.util.Scanner;

public class RPS {
	public enum PICKS {
		ROCK, PAPER, SCISSORS, LIZARD, SPOCK
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
	
	private int totalGames;
	private int computerWins;
	private int playerWins;
	private int ties;
	private int rock; 
	private int paper;
	private int scissors;
	private int lizard;
	private int spock;
	
	public RPS() {
		gs = GAMESTATE.PLAYERPICK;
		sc = new Scanner(System.in);
		isPlaying = true;
		totalGames = 0;
		computerWins = 0;
		playerWins = 0;
		ties = 0;
		rock = 0;
		paper = 0;
		scissors = 0;
		lizard = 0;
		spock = 0;
		gameLoop();
	}

	public void pickPlayer(PICKS player) {
		this.player = player;
	}

	public WINNER pickWinner(int value) {
		WINNER winner;
		if (player.ordinal() == value)
		{
			winner = WINNER.DRAW;
			ties++;
			
		}

		else if (player == PICKS.PAPER && value == 0)
		{
			winner = WINNER.PLAYERWIN;
			playerWins++;
		
		}
		else if (player == PICKS.PAPER && value == 4)
		{
			winner = WINNER.PLAYERWIN;
			playerWins++;
		
		}

		else if (player == PICKS.ROCK && value == 2)
		{
			winner = WINNER.PLAYERWIN;
			playerWins++;
			
		}
		else if (player == PICKS.ROCK && value == 3)
		{
			winner = WINNER.PLAYERWIN;
			playerWins++;

		}
		

		else if (player == PICKS.SCISSORS && value == 1)
		{
			winner = WINNER.PLAYERWIN;
			playerWins++;

		}
		
		else if (player == PICKS.SCISSORS && value == 3)
		{
			winner = WINNER.PLAYERWIN;
			playerWins++;

		}
		
		else if (player == PICKS.LIZARD && value == 1)
		{
			winner = WINNER.PLAYERWIN;
			playerWins++;

		}
		else if (player == PICKS.LIZARD && value == 4)
		{
			winner = WINNER.PLAYERWIN;
			playerWins++;

		}		
		
		else if (player == PICKS.SPOCK && value == 2)
		{
			winner = WINNER.PLAYERWIN;
			playerWins++;

		}		
		
		else if (player == PICKS.LIZARD && value == 0)
		{
			winner = WINNER.PLAYERWIN;
			playerWins++;

		}		
		
		
		
		
		
		
		else
		{
			computerWins++;
			winner = WINNER.AIWIN;
		}
		return winner;

	}

	// This is the main game loop
	public void gameLoop() {
		while (isPlaying) {

			switch (gs.ordinal()) {
			case 0: // If the player is picking
				System.out.println("Pick Rock, Paper, Scissors, Lizard or Spock");
				String input = sc.next().toUpperCase();
				if (input.equals("ROCK"))
				{
					player = PICKS.ROCK;
					gs = GAMESTATE.AIPICK;
					rock++;
				}
				else if (input.equals("PAPER"))
				{
					player = PICKS.PAPER;
					gs = GAMESTATE.AIPICK;
					paper++;
				}
				if (input.equals("SCISSORS")) 
				{
					player = PICKS.SCISSORS;
					gs = GAMESTATE.AIPICK;
					scissors++;
				}
				if (input.equals("LIZARD")) 
				{
					player = PICKS.LIZARD;
					gs = GAMESTATE.AIPICK;
					lizard++;
				}
				if (input.equals("SPOCK")) 
				{
					player = PICKS.SPOCK;
					gs = GAMESTATE.AIPICK;
					spock++;
				}
				
				if(input.equals("QUIT"))
					isPlaying = false;
				break;

			case 1:
				Random r = new Random();
				int value =r.nextInt(5);
				if( value == 0) {
					aiPick = PICKS.ROCK;
				}
				
				if(value == 1) {
					aiPick = PICKS.PAPER;
				}
				
				if(value == 2) {
					aiPick = PICKS.SCISSORS;
				}
				if(value == 3) {
					aiPick = PICKS.LIZARD;
				}
				if(value == 4) {
					aiPick = PICKS.SPOCK;
				}
				currentWinner = pickWinner(aiPick.ordinal());
				gs = GAMESTATE.FINISH;
				totalGames++;
				break;

			case 2:
				System.out.println("PLAYER PICKED : " + player.name());
				System.out.println("AI PICKED : " + aiPick.name());
				System.out.println("Winner : " + currentWinner.name());
				
				System.out.println("TOTAL GAMES : " + totalGames);
				System.out.println("PLAYER WINS : " + playerWins + " Percent: " + (playerWins * 100 / totalGames) + "%");
				System.out.println("TIES: " + ties + " Percent: " + (ties * 100 / totalGames) + "%");
				System.out.println("COMPUTER WINS : " + computerWins+ " Percent: " + (computerWins * 100 / totalGames) + "%");
				
				System.out.println("Rock count: " + rock + " Percent : " + ((rock * 100)/ totalGames) + "%" );
				System.out.println("Paper count: " + paper + " Percent : " + (paper * 100/ totalGames) + "%" );
				System.out.println("Scissors count: " + scissors + " Percent : " + (scissors * 100/ totalGames) + "%" );
				System.out.println("Lizard count: " + lizard + " Percent : " + (lizard * 100/ totalGames) + "%" );
				System.out.println("Spock count: " + spock + " Percent : " + (spock * 100/ totalGames) + "%" );
				aiLogic();
				gs = GAMESTATE.PLAYERPICK;
				break;

			}

		}
	}
	
	public void aiLogic()
	{
		/* find the highest used piece that the player uses and then 
		 * check to see what beats that piece and then pick it
		 * 
		 * */
		PICKS currentPick;
		currentPick = PICKS.ROCK;
		int itr = 0;
		int [] list ={rock,paper,scissors,lizard,spock}; 
		
		int value = rock;
		
		for(int i = 0; i < list.length; ++i)
		{
			if(list[i] > value)
			{
				itr = i;
				value = list[i];
			}
		}
		
		System.out.println("Current piece +" + itr);
	}

}
