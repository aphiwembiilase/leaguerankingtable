package game;

import java.util.List;

public class Game {
	private int id;
	private Team forHomeTeam;
	private Team forAwayTeam;
	private int homeTeamScore;
	private int awayTeamScore;
	private String type; //for feature purposes
	
	public Game(Team forHomeTeam, Team forAwayTeam, int homeTeamScore, int awayTeamScore, String type) {
		this.forHomeTeam = forHomeTeam;
		this.forAwayTeam = forAwayTeam;
		this.homeTeamScore = homeTeamScore;
		this.awayTeamScore = awayTeamScore;
		this.type = type;
	}
	
	public int getHomeTeamScore() {
		return homeTeamScore;
	}

	public void setHomeTeamScore(int homeTeamScore) {
		this.homeTeamScore = homeTeamScore;
	}

	public int getAwayTeamScore() {
		return awayTeamScore;
	}

	public void setAwayTeamScore(int awayTeamScore) {
		this.awayTeamScore = awayTeamScore;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Team getForHomeTeam() {
		return forHomeTeam;
	}

	public void setForHomeTeam(Team forHomeTeam) {
		this.forHomeTeam = forHomeTeam;
	}

	public Team getForAwayTeam() {
		return forAwayTeam;
	}

	public void setForAwayTeam(Team forAwayTeam) {
		this.forAwayTeam = forAwayTeam;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String toString() {
		return this.forHomeTeam.getName() + " " + this.homeTeamScore + ", "
				+ this.forAwayTeam.getName() + " " + awayTeamScore;
	}

}
