package com.example.movieinfoservice.resources;

import com.example.movieinfoservice.models.Movie;
import com.example.movieinfoservice.models.MovieSummary;
import com.example.movieinfoservice.repositories.MovieRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    @Value("${api.key}")
    private String apiKey;

    private RestTemplate restTemplate;

    @Autowired
    MovieRepository movieRepository;

    public MovieResource(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
        Optional<Movie> optionalMovie = movieRepository.findById(movieId);

        Movie movie;
        if(optionalMovie.isEmpty()){
            // Get the movie info from TMDB
            final String url = "https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey;
            MovieSummary movieSummary = restTemplate.getForObject(url, MovieSummary.class);
            movie = new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());
            movieRepository.save(movie);
            System.out.println("not cached");
        }
        else {
            movie = optionalMovie.get();
            System.out.println("cached");
        }



        return movie;
    }
}
