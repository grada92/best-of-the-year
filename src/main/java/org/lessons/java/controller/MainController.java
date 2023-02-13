package org.lessons.java.controller;

import java.util.ArrayList;
import java.util.List;

import org.lessons.java.Movie;
import org.lessons.java.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
	
	@GetMapping()
	public String home(Model model) {
		model.addAttribute("name", "Daniele");
		return "index";
	}
	
	@GetMapping("/movies")
	public String movie(Model model) {
		List<Movie> movies = getBestMovies();
		model.addAttribute("movies", movies);
		return "movies";
	}
	
	@GetMapping("/songs")
	public String song(Model model) {
		List<Song> song = getBestSongs();
		model.addAttribute("songs", song);
		return "songs";
	}
	
	@GetMapping("/movies/{id}") 	
	public String title(Model model, @PathVariable("id") String id ) {
		model.addAttribute("title", getBestMovies().get(Integer.parseInt(id)-1));
		return "titlemovie";
	}
	
	@GetMapping("/songs/{id}") 	
	public String titlesong(Model model, @PathVariable("id") String id ) {
		model.addAttribute("title", getBestSongs().get(Integer.parseInt(id)-1));
		return "titlesong";
	}
	
	
	private List<Movie> getBestMovies(){
		List<Movie> movies = new ArrayList<>();

		Movie movie1 = new Movie("Il Signore degli Anelli", 1);
		movies.add(movie1);
		
		Movie movie2 = new Movie("IronMan", 2);
		movies.add(movie2);
		
		Movie movie3 = new Movie("Avengers", 3);
		movies.add(movie3);
		return movies;
	}
	
	private List<Song> getBestSongs(){
		List<Song> song = new ArrayList<>();

		Song song1 = new Song("Felicità", 1);
		song.add(song1);
		
		Song song2 = new Song("Perdere l'Amore", 2);
		song.add(song2);
		
		Song song3 = new Song("Urlando contro il Cielo", 3);
		song.add(song3);
		return song;
	}
	
	
}
