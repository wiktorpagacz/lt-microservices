package com.pagacz.resvault.model;

import lombok.Data;

@Data
public class BookRequest {
    private String title;
    private String author;
    private boolean audiobook;
    private boolean ebook;
    private String language;
}
