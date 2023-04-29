package com.skilldistillery.filmquery.app;

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
		  
	  }
    
  }
  
  private void ByFilmId() {
	  System.out.println("Enter the film ID: ");
	  
  }

}
