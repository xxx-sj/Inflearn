package com.jpa.exampleCode.jpa_03_spring_data_jpa.repository;

import com.jpa.exampleCode.jpa_03_spring_data_jpa.entity.DataMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataMemberRepository extends JpaRepository<DataMember, Long> {
}
