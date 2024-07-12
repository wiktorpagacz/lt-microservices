package com.pagacz.resvault.entity;

import com.pagacz.resvault.entity.enums.Language;
import com.pagacz.resvault.entity.enums.Platform;
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
@Table(name = "MOVIE")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "RATE")
    private Integer rate;
    @Column(name = "LANGUAGE")
    @Enumerated(EnumType.STRING)
    private Language language;
    @Column(name = "DIRECTOR")
    private String director;
    @Column(name = "GENRE")
    private String genre;
    @Column(name = "LENGTH")
    private Integer length;
    @Column(name = "SERIES")
    private Boolean series;
}
