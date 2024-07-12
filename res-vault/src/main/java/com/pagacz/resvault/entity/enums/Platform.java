package com.pagacz.resvault.entity.enums;

public enum Platform {
    UDEMY("UDEMY"), PLURALSIGHT("PLURALSIGHT"), YOUTUBE("YOUTUBE"),
    CODECADEMY("CODECADEMY"), LINKEDIN("LINKEDIN"), OTHER("OTHER");

    private String name;

    Platform(String name) {
        this.name = name;
    }

    public String getPlatformName() {
        return this.name;
    }
}