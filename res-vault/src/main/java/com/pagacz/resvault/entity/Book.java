package com.pagacz.resvault.entity;

import com.pagacz.resvault.entity.enums.Language;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "BOOK")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "AUTHOR")
    private String author;
    @Column(name = "AUDIOBOOK")
    private boolean audiobook;
    @Column(name = "EBOOK")
    private boolean ebook;
    @Column(name = "LANGUAGE")
    @Enumerated(EnumType.STRING)
    private Language language;
}
