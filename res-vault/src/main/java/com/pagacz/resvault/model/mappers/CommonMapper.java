package com.pagacz.resvault.model.mappers;

import com.pagacz.resvault.entity.Book;
import com.pagacz.resvault.entity.Course;
import com.pagacz.resvault.entity.Movie;
import com.pagacz.resvault.model.BookResponse;
import com.pagacz.resvault.model.CourseResponse;
import com.pagacz.resvault.model.MovieResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CommonMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "courseName", target = "courseName")
    @Mapping(source = "link", target = "link")
    @Mapping(source = "language", target = "language")
    @Mapping(source = "platform", target = "platform")
    CourseResponse courseToDto(Course course);

    MovieResponse movieToDto(Movie movie);

    BookResponse bookToDto(Book book);
}
