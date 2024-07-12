package com.pagacz.resvault.model;

import lombok.Data;

@Data
public class CourseRequest {

    private String courseName;
    private String link;
    private Integer rate;
    private String language;
    private String platform;
}
