package game;

public class Team implements Comparable<Team> {

	public final int POINT_PER_WIN = 3;
	public final int POINT_PER_DRAW = 1;
	public final int ONE_WIN = 1;
	public final int ONE_LOSE = 1;
	public final int ONE_DRAW = 1;

	private int id;
	private String name;
	private int win;
	private int lose;
	private int draw;
	private int point;

	public Team() {
	}

	public int getWin() {
		return win;
	}

	public void setWin() {
		this.win = this.win + ONE_WIN;

	}

	public int getLose() {
		return lose;
	}

	public void setLose() {
		this.lose = this.lose + ONE_LOSE;
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw() {
		this.draw = this.draw + ONE_DRAW;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint() {
		this.point = (this.POINT_PER_WIN * getWin()) + getDraw();

	}

	public boolean equals(Object obj) {
		if (obj instanceof Team) {
			Team tempTeam = (Team) obj;
			if (this.name.equals(tempTeam.getName())) {
				return true;
			}
		}
		return false;
	}

	public int hashCode() {
		return this.name.hashCode();
	}

	public int compareTo(Team t) {
		int pComp = ((Integer) this.point).compareTo(t.getPoint());
		if (pComp != 0) {
			return pComp;
		}
		return this.name.compareTo(t.getName());

	}

	public String toString() {
		String details = ". " + this.name + ", " + this.point + " Pts, "
				+ this.win + " Wins, " + this.lose + " Loses, " + this.draw
				+ " Draws";
		if (this.point == 1) {
			details = ". " + this.name + ", " + this.point + " Pt, " + this.win
					+ " Wins, " + this.lose + " Loses, " + this.draw + " Draws";
		}
		return details;
	}

}
