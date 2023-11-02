package com.jpa.exampleCode.jpa_03_spring_data_jpa.repository;

import com.jpa.exampleCode.jpa_03_spring_data_jpa.entity.DataMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DataMemberRepository extends JpaRepository<DataMember, Long> {

    List<DataMember> findByUsername(String username);


    //이름이 없는 네임드 쿼리와 같다.
    @Query("select m from DataMember  m where m.username = :username and m.age = :age")
    List<DataMember> findUser(@Param("username") String username, @Param("age") int age);
}
