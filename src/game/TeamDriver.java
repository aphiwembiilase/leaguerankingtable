package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class TeamDriver {

	public static void main(String[] args) {
		
		FileReader fileReader = null;
		try {
			fileReader = new FileReader("sample_Input.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Scanner fileInput = new Scanner(fileReader);
		List<Team> teamList = new ArrayList<>();
		List<Game> gameList = new ArrayList<>();
		String gameType = "League";
		Set<Team> set = new LinkedHashSet<>();
		
		for (int i = 0; fileInput.hasNextLine(); i++) {

			String fileLine = fileInput.nextLine();
			Scanner lineInput = new Scanner(fileLine);

			Team homeTeam = new Team();
			Team awayTeam = new Team();

			int homeTeamScore = 0;
			int awayTeamScore = 0;

			for (int j = 0; lineInput.hasNext(); j++) {
				// Collecting team names and keeping track
				// of the results for each game played.
				String textPerWord = lineInput.next();
				if (homeTeamScore == 0) 
				{
					if (textPerWord.charAt(textPerWord.length() - 1) != ',') 
					{
						if(homeTeam.getName() != null)
						{
							homeTeam.setName(homeTeam.getName() + " " + textPerWord);	
						}
						else
						{
							homeTeam.setName("" + textPerWord);
						}

					} else 
					{
						textPerWord = textPerWord.replaceAll(",", "");
						homeTeamScore = Integer.parseInt(textPerWord.trim());
					}
				} else if (awayTeamScore == 0) 
				{
					if (lineInput.hasNext())
					{
						if(awayTeam.getName() != null)
						{
							awayTeam.setName(awayTeam.getName() + " " + textPerWord.trim());
						}else
						{
							awayTeam.setName("" + textPerWord.trim());
						}
					}
					else {
						awayTeamScore = Integer.parseInt(textPerWord.trim());
					}
				}
			}
			
			Game g = new Game(homeTeam, awayTeam, homeTeamScore, awayTeamScore, gameType);	
			gameList.add(g);
			
			set.add(homeTeam);
			set.add(awayTeam);
			
			teamList = new ArrayList<Team>(set);
			lineInput.close();
		}
		
		fileInput.close();
		
		setTeamData(teamList, gameList);
		Collections.sort(teamList);
		Collections.reverse(teamList);
		int count = 1;
		for (Team t : teamList) {
			System.out.println(count+""+t);
			count ++;
		}
	}
	
	public static void setTeamData(List<Team> teamList, List<Game> gameList){
		
		for (int k = 0; k < teamList.size(); k++) {
			
			// For each team, update results on each game played.
			for(int l = 0;l < gameList.size(); l++)
			{
					updateTeamResultsPerGame(gameList, l, teamList, k);
					
			}
		}

	}
	
	public static void updateTeamResultsPerGame(List<Game> gameList, int gameAtIndex, List<Team> teamList, int teamAtIndex ){
		
		if(teamList.get(teamAtIndex).equals(gameList.get(gameAtIndex).getForHomeTeam()))
		{
			if(gameList.get(gameAtIndex).getHomeTeamScore() > gameList.get(gameAtIndex).getAwayTeamScore())
			{	//Home team wins
				teamList.get(teamAtIndex).setWin();
				teamList.get(teamAtIndex).setPoint();
			
			}else if(gameList.get(gameAtIndex).getHomeTeamScore() < gameList.get(gameAtIndex).getAwayTeamScore())
			{	//Home team loses
				teamList.get(teamAtIndex).setLose();
			}else if(gameList.get(gameAtIndex).getHomeTeamScore() == gameList.get(gameAtIndex).getAwayTeamScore())
			{	//A draw
				teamList.get(teamAtIndex).setDraw();
				teamList.get(teamAtIndex).setPoint();
			}
		}else if(teamList.get(teamAtIndex).equals(gameList.get(gameAtIndex).getForAwayTeam()))
		{
			if(gameList.get(gameAtIndex).getHomeTeamScore() > gameList.get(gameAtIndex).getAwayTeamScore())
			{	
				teamList.get(teamAtIndex).setLose();

			}else if(gameList.get(gameAtIndex).getHomeTeamScore() < gameList.get(gameAtIndex).getAwayTeamScore())
			{	
				teamList.get(teamAtIndex).setWin();
				teamList.get(teamAtIndex).setPoint();

			}else if(gameList.get(gameAtIndex).getHomeTeamScore() == gameList.get(gameAtIndex).getAwayTeamScore())
			{	
				teamList.get(teamAtIndex).setDraw();
				teamList.get(teamAtIndex).setPoint();
			}

		}
	}
	

}
