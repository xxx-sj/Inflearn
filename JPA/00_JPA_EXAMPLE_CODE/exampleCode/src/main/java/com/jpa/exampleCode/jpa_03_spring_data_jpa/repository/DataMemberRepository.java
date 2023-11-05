package com.jpa.exampleCode.jpa_03_spring_data_jpa.repository;

import com.jpa.exampleCode.jpa_03_spring_data_jpa.dto.DataMemberDto;
import com.jpa.exampleCode.jpa_03_spring_data_jpa.entity.DataMember;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface DataMemberRepository extends JpaRepository<DataMember, Long>, DataCustomMemberRepository {

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

    //인자로 Pageable을 넘기면 페이징 쿼리가 된다.
    //반환타입에 따라 total count를 날리지 말지를 결정한다.
    //pageable구현체로는 pageRequest를 많이 사용한다.

    @Query(value="select m from DataMember m left join m.team t", countQuery = "select count(m.username) from DataMember m")
    Page<DataMember> findByAge(int age, Pageable pageable);

    Slice<DataMember> findUserSliceByAge(int age, Pageable pageable);


    @Modifying(clearAutomatically = true)
    @Query("update DataMember m set m.age = m.age + 1 where m.age >= :age")
    int bulkAgePlus(@Param("age") int age);

    @Query("select m from DataMember  m left join fetch m.team t")
    List<DataMember> findMemberFetchJoin();

    @Override
//    @Query("select m from DataMember  m left join fetch m.team t")
    @EntityGraph(attributePaths = {"team"})
    List<DataMember> findAll();


    @EntityGraph(attributePaths = {"team"})
    @Query("select m from DataMember m")
    List<DataMember> findMemberEntityGraph();


    @EntityGraph(attributePaths = {"team"})
    List<DataMember> findEntityGraphByUsername(@Param("username") String username);

    @QueryHints(value = @QueryHint(name = "org.hibernate.readOnly", value = "true"))
    DataMember findReadOnlyByUsername(String username);


    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<DataMember> findLockByUsername(String username);

}
