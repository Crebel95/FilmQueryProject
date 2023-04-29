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
//    app.test();
    app.launch();
  }

  private void test() {
	  Actor actor = db.findActorById(5);
	  if (actor != null) {
		  	System.out.println(actor);
	  }
	  else {
		  System.out.println("No such actor found!");
	  }
	 
	  
//    Film film = db.findFilmById(1);
//    System.out.println(film);
  }

  private void launch() {
    Scanner input = new Scanner(System.in);
    
    startUserInterface(input);
    
    input.close();
  }

  private void startUserInterface(Scanner input) {
	  
	  System.out.println("Welcome to the Main Menu! /n Select one of the options below: ");
	  System.out.println("1. Look up a film by its ID");
	  System.out.println("2. Look up a film by a keyword");
	  System.out.println("3. Exit the application");
	  int selection = input.nextInt();
	  
	  if (selection == 1) {
		  byFilmId();
	  }
    
  }
  private void byFilmId() {
	  Scanner sc = new Scanner(System.in);
	  System.out.println("Enter the film's ID: ");
	  int selection = sc.nextInt();
	  Film film = db.findFilmById(selection);
	  
	  if (film != null) {
		  System.out.println(film.getTitle());
		  System.out.println(film.getDesc());
		  System.out.println(film.getLangId());
		  System.out.println(film.getReleaseYear());
		  System.out.println(film.getRating());
		  List<Actor> actors = db.findActorsByFilmId(film.getFilmId());
		  
		  if(actors != null) {
			  for(Actor actor : actors) {
				  System.out.println(actor.getFirstName() + " " + actor.getLastName());
			  } 
				  
			  } else {
				  System.out.println("There is no film associated with this ID");
		  }
	  }
  }
  
  

}
