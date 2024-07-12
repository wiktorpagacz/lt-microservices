package com.pagacz.resvault.service;

import com.pagacz.resvault.entity.Movie;
import com.pagacz.resvault.entity.enums.Language;
import com.pagacz.resvault.exception.ResVaultCustomException;
import com.pagacz.resvault.model.MovieRequest;
import com.pagacz.resvault.model.MovieResponse;
import com.pagacz.resvault.model.mappers.CommonMapper;
import com.pagacz.resvault.repository.MovieRepository;
import lombok.extern.log4j.Log4j2;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.beans.BeanUtils.copyProperties;

@Log4j2
@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    CommonMapper mapper = Mappers.getMapper(CommonMapper.class);

    public Long saveMovie(MovieRequest movieRequest) {
        log.info("Adding Movie...");
        Movie movie
                = Movie.builder()
                .name(movieRequest.getName())
                .rate(movieRequest.getRate())
                .language(Language.valueOf(movieRequest.getLanguage()))
                .director(movieRequest.getDirector())
                .series(movieRequest.getSeries())
                .genre(movieRequest.getGenre())
                .length(movieRequest.getLength())
                .build();
        movieRepository.save(movie);
        log.info("Movie created");
        return movie.getId();
    }

    public MovieResponse getMovieById(long movieId) {
        log.info("Get the book for bookId: {}", movieId);
        Movie movie
                = movieRepository.findById(movieId)
                .orElseThrow(() -> new ResVaultCustomException("Movie with given id not found", "MOVIE_NOT_FOUND"));
        MovieResponse movieResponse = mapper.movieToDto(movie);
        return movieResponse;
    }
}