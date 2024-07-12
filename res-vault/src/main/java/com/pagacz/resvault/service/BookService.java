package com.pagacz.resvault.service;

import com.pagacz.resvault.entity.Book;
import com.pagacz.resvault.entity.enums.Language;
import com.pagacz.resvault.exception.ResVaultCustomException;
import com.pagacz.resvault.model.BookRequest;
import com.pagacz.resvault.model.BookResponse;
import com.pagacz.resvault.model.mappers.CommonMapper;
import com.pagacz.resvault.repository.BookRepository;
import lombok.extern.log4j.Log4j2;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.beans.BeanUtils.copyProperties;

@Log4j2
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    CommonMapper mapper = Mappers.getMapper(CommonMapper.class);

    public Long saveBook(BookRequest bookRequest) {
        log.info("Adding Book...");
        Book book
                = Book.builder()
                .title(bookRequest.getTitle())
                .author(bookRequest.getAuthor())
                .ebook(bookRequest.isEbook())
                .audiobook(bookRequest.isAudiobook())
                .language(Language.valueOf(bookRequest.getLanguage()))
                .build();
        bookRepository.save(book);
        log.info("Book created");
        return book.getId();
    }

    public BookResponse getBookById(long bookId) {
        log.info("Get the book for bookId: {}", bookId);
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResVaultCustomException("Book with given id not found", "BOOK_NOT_FOUND"));

        BookResponse bookResponse = mapper.bookToDto(book);
        return bookResponse;
    }

    public BookResponse updateBook(long id, BookRequest bookRequest) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResVaultCustomException("Book with given id not found", "BOOK_NOT_FOUND"));
        book.setAudiobook(bookRequest.isAudiobook());
        book.setAuthor(bookRequest.getAuthor());
        book.setEbook(bookRequest.isEbook());
        book.setTitle(bookRequest.getTitle());
        book.setLanguage(Language.valueOf(bookRequest.getLanguage()));

        bookRepository.save(book);
        return BookResponse.builder()
                .id(id)
                .audiobook(book.isAudiobook())
                .ebook(book.isEbook())
                .author(book.getAuthor())
                .title(book.getTitle())
                .language(book.getLanguage().toString())
                .build();
    }
}
