package secondObligatoryHomework;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ListOfTeams implements WorkWithTeams, WorkWithFiles {
	private ArrayList<Team> teams;

	public ListOfTeams() {
		this.setTeams(new ArrayList<>());
	}

	public void addTeam(Team inputTeam) {
		this.getTeams().add(inputTeam);
		System.out.printf("Team %s from %s with %d players added to list of teams.%n", inputTeam.getName(),
				inputTeam.getOriginCity(), inputTeam.getNumberOfPlayers());
	}

	public void removeTeam(Team inputTeam) {
		String teamName = inputTeam.getName();

		if (findTeam(teamName, false) == -1) {
			System.out.printf("Error: The team %s you are trying to remove is not in the list of teams!%n", teamName);
		} else {
			this.getTeams().remove(inputTeam);
			System.out.printf("Team %s removed from list of teams.%n", teamName);
		}
	}

	public int findTeam(String teamName) {
		return findTeam(teamName, true);
	}

	public int findTeam(String teamName, Boolean printConsoleMessage) {
		for (int i = 0; i < this.getTeams().size(); i++) {
			if (this.getTeams().get(i).getName().equals(teamName)) {
				if (printConsoleMessage)
					System.out.printf("Team %s is in the list of teams on position %d.%n", teamName, i + 1);
				return i;
			}
		}
		if (printConsoleMessage)
			System.out.printf("Team %s is not in the list of teams.%n", teamName);
		return -1;
	}

	public void readFromFile(String fileName) {
		try {
			File file = new File(fileName);
			Scanner scanner = new Scanner(file);

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] parts = line.split(",");

				if (parts.length == 3) {
					String name = parts[0];
					String originCity = parts[1];
					int numberOfPlayers = Integer.parseInt(parts[2]);

					Team team = new Team(name, originCity, numberOfPlayers);
					teams.add(team);
				}
			}
			scanner.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void printTeamScores() {
		for (int i = 0; i < teams.size(); i++) {
			Team currentTeam = teams.get(i);
			System.out.printf("Score: %s - %d %n", currentTeam.getName(), currentTeam.getScore());
		}
	}

	public void printTeamScores(int[] indexes, CompetitionFund fund) {
		System.out.printf("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ %n");
		System.out.printf("~~~ Tournament final results ~~~ %n");
		System.out.printf("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ %n %n");
		for (int i = 0; i < indexes.length; i++) {
			Team currentTeam = teams.get(indexes[i]);
			if (fund.getPriceList()[i] != 0) {
				System.out.printf("%d. place %d points - %s +%.2f Euros %n", i + 1, currentTeam.getScore(), currentTeam.getName(), fund.getPriceList()[i]);
			}
			else {
				System.out.printf("%d. place %d points - %s %n", i + 1, currentTeam.getScore(), currentTeam.getName());
			}
			
		}
	}

	public void sortByScore(CompetitionFund fund) {
		int n = teams.size();

		int[] scoreArray = new int[n];
		int[] index = new int[n];

		for (int i = 0; i < n; i++) {
			int score = teams.get(i).getScore();
			scoreArray[i] = score;
			index[i] = i;
		}

		sort(n, scoreArray, index);
		printTeamScores(index, fund);
	}

	private void sort(int n, int[] score, int[] index) {
		for (int j = 1; j < n; j++) {
			for (int i = 0; i < n - j; i++) {
				if (score[i + 1] > score[i]) { // Changed to sort in descending order
					swap(score, i);
					swap(index, i);
				}
			}
		}
	}

	private void swap(int[] array, int i) {
		int temp = array[i];
		array[i] = array[i + 1];
		array[i + 1] = temp;
	}

	public ArrayList<Team> getTeams() {
		return this.teams;
	}

	public void setTeams(ArrayList<Team> teams) {
		this.teams = teams;
	}
}