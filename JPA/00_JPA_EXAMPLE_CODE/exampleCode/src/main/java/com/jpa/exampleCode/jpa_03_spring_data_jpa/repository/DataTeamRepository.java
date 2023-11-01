package com.jpa.exampleCode.jpa_03_spring_data_jpa.repository;

import com.jpa.exampleCode.jpa_03_spring_data_jpa.entity.DataTeam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataTeamRepository extends JpaRepository<DataTeam, Long> {
}
