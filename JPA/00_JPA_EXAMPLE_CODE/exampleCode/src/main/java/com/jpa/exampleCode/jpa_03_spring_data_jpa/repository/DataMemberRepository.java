package com.jpa.exampleCode.jpa_03_spring_data_jpa.repository;

import com.jpa.exampleCode.jpa_03_spring_data_jpa.dto.DataMemberDto;
import com.jpa.exampleCode.jpa_03_spring_data_jpa.entity.DataMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface DataMemberRepository extends JpaRepository<DataMember, Long> {

    List<DataMember> findByUsername(String username);


    //이름이 없는 네임드 쿼리와 같다.
    @Query("select m from DataMember  m where m.username = :username and m.age = :age")
    List<DataMember> findUser(@Param("username") String username, @Param("age") int age);

    //값으로 가져오기
    @Query("select m.username from DataMember m")
    List<String> findUSernameList();
    
    //DTO로 가져오기
    @Query("select new com.jpa.exampleCode.jpa_03_spring_data_jpa.dto.DataMemberDto(m.id, m.username, t.name) from DataMember m join m.team t")
    List<DataMemberDto> findMemberDto();


    //컬렉션 파라미터 바인딩
    @Query("select m from DataMember m where m.username in :names")
    List<DataMember> findByNames(@Param("names") Collection<String> names);
}
