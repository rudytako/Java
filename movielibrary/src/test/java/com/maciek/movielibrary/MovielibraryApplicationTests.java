package com.maciek.movielibrary;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MovieLibraryApplicationTests {
	@Autowired
	private MovieRepository movieRepository;

	@Test
	void getById_NotExistingMovie_ReturnNull() {
		MovieController movieController = new MovieController();
		movieController.movieRepository = movieRepository;

		// Try to get a movie with id = 5 that does not exist
		assertNull(movieController.getById(5));
	}

	@Test
	void update_NotExistingMovie_ReturnZero() {
		MovieController movieController = new MovieController();
		movieController.movieRepository = movieRepository;

		Movie updatedMovie = new Movie();
		updatedMovie.setName("Updated Movie");
		updatedMovie.setRating(4);

		assertEquals(0, movieController.update(5, updatedMovie));
	}

}
