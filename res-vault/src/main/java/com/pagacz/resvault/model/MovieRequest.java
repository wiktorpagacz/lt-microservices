package com.pagacz.resvault.model;

import com.pagacz.resvault.entity.enums.Language;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class MovieRequest {

    private String name;
    private Integer rate;
    private String language;
    private String director;
    private String genre;
    private Integer length;
    private Boolean series;
}
