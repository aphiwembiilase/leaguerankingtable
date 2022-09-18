package game;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TeamTest {

	Team team;
	
	@Before
	public void setUp(){
		team = new Team();
	}
	
	@Test
	public void TestGetPoint() {
		System.out.println("1 win plus 1 draw should be equal to 4 points");
		team.setWin();
		team.setDraw();
		team.setPoint();
		assertEquals(4, team.getPoint());
		
	}
	
	//public void
	

}
