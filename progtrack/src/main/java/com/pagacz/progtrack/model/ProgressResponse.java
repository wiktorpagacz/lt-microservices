package com.pagacz.progtrack.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProgressResponse {

    private Long id;
    private Long resourceId;
    private Long userId;
    private String progressType;
    private Map<String, String> progressData;
}
