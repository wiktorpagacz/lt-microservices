package com.pagacz.resvault.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseResponse {

    private long id;
    private String courseName;
    private String link;
    private Integer rate;
    private String language;
    private String platform;
}
