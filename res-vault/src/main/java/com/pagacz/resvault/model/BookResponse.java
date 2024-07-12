package com.pagacz.resvault.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookResponse {

    private long id;
    private String title;
    private String author;
    private boolean audiobook;
    private boolean ebook;
    private String language;
}
