package edu.uis.mastermind.model;

/**
 * The MatchManager class is responsible for managing a single match. It is not
 * concerned with the mechanics of a single game since that is the
 * responsibility of the GameManager. It is however concerned with the mechanics
 * of a match and it keeps track of the various states of a match like:
 * <ul>
 * <li>What is the current round
 * <li>Which game is it within a round
 * <li>Which round is it within a match
 * <li>Which player is the current Code Maker and which is the current Code
 * Breaker
 * </ul>
 * In addition, the MatchManager class is also responsible for setting up each
 * of the 2 players and for adding each player's score after each game. The
 * MatchManager manages the 2 player objects in a 'players' array.
 * 
 */
public class MatchManager {

	private int currentRound = 1;
	private int maxRounds = 3;

	private int currentGame = 1;
	private int maxGames = 2;

	private Player[] players = { new Player("Player 1"), new Player("Player 2") };

	/**
	 * Constructor
	 * 
	 * @param player1Name
	 * @param player2Name
	 */
	public MatchManager(String player1Name, String player2Name) {
		players[0].setName(player1Name);
		players[1].setName(player2Name);
	}

	/**
	 * Returns the player who is the current code maker for a specific game. For
	 * each round Player 1 is always the first code maker.
	 * (Requirement 6.1)
	 * 
	 * @return the current code maker as a Player object
	 */
	public Player getCurrentCodeMaker() {
		int currentCodeMakerIndex = currentGame == 1 ? 0 : 1;
		return players[currentCodeMakerIndex];
	}

	/**
	 * Returns the player who is the current code breaker for a specific game.
	 * For each round Player 2 is always the first code breaker.
	 * (Requirement 6.1)
	 * 
	 * @return the current code breaker as a Player object
	 */
	public Player getCurrentCodeBreaker() {
		int currentCodeBreakerIndex = currentGame == 1 ? 1 : 0;
		return players[currentCodeBreakerIndex];
	}

	/**
	 * Return the maximum number of rounds per match. Currently the maximum
	 * number of rounds is set to 3. (Requirement 6.1.3)
	 * 
	 * @return the maximum rounds
	 */
	public int getMaxRounds() {
		return maxRounds;
	}

	/**
	 * Return the current round for the match.
	 * 
	 * @return current round
	 */
	public int getCurrentRound() {
		return currentRound;
	}

	/**
	 * Start a new round.
	 */
	public void startNewRound() {
		currentGame = 1;
		currentRound++;
	}

	/**
	 * Return the maximum number of games per round. Currently the maximum
	 * number of games per round is set to 2. (Requirement 6.1.2)
	 * 
	 * @return maximum games
	 */
	public int getMaxGamesPerRound() {
		return maxGames;
	}

	/**
	 * Increment the game counter.
	 */
	public void incrementGame() {
		currentGame++;
	}

	/**
	 * Return the current game counter.
	 * 
	 * @return the current game number
	 */
	public int getCurrentGame() {
		return currentGame;
	}

	/**
	 * Set the code maker's score for a game. (Requirement 12.1, Requirement
	 * 12.2)
	 * 
	 * @param score
	 */
	public void setCodeMakerScore(int score) {
		Player currentCodeMaker = getCurrentCodeMaker();
		currentCodeMaker.updateScore(score);
	}

	/**
	 * Return Player 1. (Requirement 6.)
	 * 
	 * @return player 1
	 */
	public Player getPlayer1() {
		return players[0];
	}

	/**
	 * Return Player 2. (Requirement 6.)
	 * 
	 * @return player 2
	 */
	public Player getPlayer2() {
		return players[1];
	}
}
