package jeopardyProject;

/*
 * Author:	Julian Trujillo & Luke Erickson
 * Date:	12/16/19
 * Period:	7th
 * 
 * Description: Constructs player objects, flips turns, and adds points to player objects	
 */


public class Player {
	private String name;
	private int points;
	private boolean isMyTurn;
	
	
	/**
	 * Description: Default Constructor for Player objects
	 * @param aName
	 * @param aPoints
	 * @param aIsMyTurn
	 */
	public Player(String aName, int aPoints, boolean aIsMyTurn) {
		name = aName;
		points = aPoints;
		isMyTurn = aIsMyTurn;
	}
	
	/**
	 * Description: Adds new points to Player's score to create final score
	 * @param bPoints
	 * @return newPoints
	 */
	public int addPoints(int bPoints) {
		this.points = this.points + bPoints;
		return this.points;
	}
	
	/**
	 * Description: Uses takeTurn() method from Board class to run through a turn, assign point values, and flip turns
	 * @param aBoard
	 * @return isMyTurn
	 */
	public boolean takeMyTurn(Board aBoard) {
		points = this.points;
		int addPoints = aBoard.takeTurn(points);
		this.addPoints(addPoints);
		this.isMyTurn = !this.isMyTurn;
		return this.isMyTurn;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return points
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * @param points
	 */
	public void setPoints(int points) {
		this.points = points;
	}

	/**
	 * @return isMyTurn
	 */
	public boolean isMyTurn() {
		return isMyTurn;
	}

	/**
	 * @param isMyTurn
	 */
	public void setMyTurn(boolean isMyTurn) {
		this.isMyTurn = isMyTurn;
	}
}
