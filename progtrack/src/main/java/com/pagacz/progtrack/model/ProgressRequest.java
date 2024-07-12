package com.pagacz.progtrack.model;

import lombok.Data;

import java.util.Map;

@Data
public class ProgressRequest {

    private Long resourceId;
    private Long userId;
    private String progressType;
    private Map<String, String> progressData;
}
