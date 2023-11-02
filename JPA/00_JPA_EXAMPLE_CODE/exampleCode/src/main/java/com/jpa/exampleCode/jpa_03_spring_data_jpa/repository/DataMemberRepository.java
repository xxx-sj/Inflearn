package com.jpa.exampleCode.jpa_03_spring_data_jpa.repository;

import com.jpa.exampleCode.jpa_03_spring_data_jpa.dto.DataMemberDto;
import com.jpa.exampleCode.jpa_03_spring_data_jpa.entity.DataMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

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

    //메서드 이름 쿼리 :: 컬렉션
    //빈 컬렉션을 반환한다.
    List<DataMember> findListByUsername(String username);

    //단건 조회 시 다중으로 조회되면 오류발생
    //메서드 이름 쿼리 :: 단건
    DataMember findMemberByUsername(String username);
    //메서드 이름 쿼리 :: optional
    Optional<DataMember> findOptionalByUsername(String username);
}
