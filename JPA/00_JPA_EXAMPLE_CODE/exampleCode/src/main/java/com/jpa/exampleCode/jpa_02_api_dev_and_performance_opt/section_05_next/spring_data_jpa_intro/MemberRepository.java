package com.jpa.exampleCode.jpa_02_api_dev_and_performance_opt.section_05_next.spring_data_jpa_intro;

import com.jpa.exampleCode.jpa_02_api_dev_and_performance_opt.entity.Jpa2Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Jpa2Member, Long> {

    //select m from JpaMember m where m.name = :name
    List<Jpa2Member> findByName(String name);
}
