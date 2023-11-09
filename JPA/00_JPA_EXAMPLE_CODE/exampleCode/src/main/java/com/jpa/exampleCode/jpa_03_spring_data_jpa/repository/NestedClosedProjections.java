package com.jpa.exampleCode.jpa_03_spring_data_jpa.repository;

public interface NestedClosedProjections {
    String getUsername();
    TeamInfo getTeam();
    interface TeamInfo {
        String getName();
    }
}
