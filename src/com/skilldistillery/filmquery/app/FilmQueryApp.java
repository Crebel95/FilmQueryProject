package com.skilldistillery.filmquery.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
		app.launch();
	}

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {
		int selection;

		do {
			dividingLine();
			System.out.println("Welcome to the Main Menu! \nSelect one of the options below: \n ");
			System.out.println("1. Look up a film by its ID");
			System.out.println("2. Look up a film by a keyword");
			System.out.println("3. Exit the application");
			dividingLine();
			selection = input.nextInt();

			if (selection == 1) {
				byFilmId();
			}
			if (selection == 2) {
				byKeyword();
			}
			if (selection == 3) {
				System.exit(selection);
			}

			else if (selection <= 0 || selection >= 4) {
				System.err.print("Invalid selection. Please enter a valid number to continue.");
			}
		} while (selection != 3);
	}

	private void byFilmId() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the film's ID: ");
		int IDselection = sc.nextInt();
		Film film = db.findFilmById(IDselection);

		if (film != null) {
			System.out.println("Title:        " + film.getTitle());
			System.out.println("Description:  " + film.getDesc());
			System.out.println("Release Year: " + film.getReleaseYear());
			System.out.println("Rating:       " + film.getRating());
			transformLanguageId(film.getLangId());
			System.out.print("Actor name:   ");
			List<Actor> actors = db.findActorsByFilmId(film.getFilmId());

			if (actors != null) {
				for (Actor actor : actors) {
					System.out.println(actor.getFirstName() + " " + actor.getLastName());
				}

			} else {
				System.out.println("There is no film associated with this ID");
			}
		}
	}

	private void byKeyword() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a keyword: ");
		String KeySelection = sc.nextLine();
		List<Film> films = db.findFilmByKeyword(KeySelection);

		if (films != null) {
			for (Film film : films) {
				
				System.out.println("Title:        " + film.getTitle());
				System.out.println("Description:  " + film.getDesc());
				System.out.println("Release Year: " + film.getReleaseYear());
				System.out.println("Rating:       " + film.getRating());
				transformLanguageId(film.getLangId());
				System.out.print("Actor name:   ");
				List<Actor> actors = db.findActorsByFilmId(film.getFilmId());
				

				if (actors != null) {
					for (Actor actor : actors) {
						System.out.println(actor.getFirstName() + " " + actor.getLastName());
					}

				} else {
					System.out.println("There is no film associated with this ID");
				}
				dividingLine();
			}
		}
	}

	public void transformLanguageId(int langId) {
		
		if (langId == 1) {
			System.out.println("Language:     English");
		}
		if (langId == 2) {
			System.out.println("Language:     Italian");
		}
		if (langId == 3) {
			System.out.println("Language:     Japanese");
		}
		if (langId == 4) {
			System.out.println("Language:     Mandarin");
		}
		if (langId == 5) {
			System.out.println("Language:     French");
		}
		if (langId == 6) {
			System.out.println("Language:     German");
		}
	}
	
	public void dividingLine() {
		System.out.println("--------------------------------------------");
	}

}
