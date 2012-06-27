package edu.uis.mastermind.model;

/**
 * The Player class represents a single player in 2 player game mode.
 * <p>
 * The Player class has attributes for the player's name and the player's score.
 * In addition, addition, the player class has a single method to accumulate the
 * score after each game. (Requirement 6.)
 */
public class Player {
	private String name;
	private int score = 0;

	/**
	 * Constructor
	 * 
	 * @param name
	 */
	public Player(String name) {
		this.name = name;
	}

	/**
	 * Returns the Player's name.
	 * 
	 * @return player's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the Player's name.
	 * 
	 * @param name
	 *            player's name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the Player's score. (Requirement 6.8)
	 * 
	 * @return player's score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Updates the Player's score by adding the in coming score to the current
	 * score. (Requirement 6.7)
	 * 
	 * @param score
	 *            points to add to player's score
	 */
	public void updateScore(int score) {
		this.score += score;
	}

	/**
	 * Reset the score back to zero.
	 */
	public void resetScore() {
		this.score = 0;
	}
}
