package com.pagacz.resvault.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieResponse {

    private long id;
    private String name;
    private Integer rate;
    private String language;
    private String director;
    private String genre;
    private Integer length;
    private Boolean series;
}
