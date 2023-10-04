# JPQL 타입  표현과 기타식

- 문자: 'HELLO', 'She''s'
- 숫자: 10L, 10D, 10F
- boolean: TRUE, FALSE
- enum: (패키지명 포함).enumClassName
- 엔티티 타입: TYPE(m) = Member(상속 관계에서 사용)
  - 상위 엔티티를 조회할 때 where절에 type(i) 을 통해 DTYPE을 챙겨주게 된다.
```jpaql
em.createQuery("select i from Section07Item01 i where type(i) = Section07Book01", Section07Item01.class)
                .getResultList();
```
```sql
    select
        section07i0_.id as id2_12_,
        section07i0_.name as name3_12_,
        section07i0_.price as price4_12_,
        section07i0_1_.artist as artist1_10_,
        section07i0_2_.author as author1_11_,
        section07i0_2_.isbn as isbn2_11_,
        section07i0_3_.actor as actor1_14_,
        section07i0_3_.director as director2_14_,
        section07i0_.dtype as dtype1_12_ 
    from
        section07item01 section07i0_ 
    left outer join
        section07album01 section07i0_1_ 
            on section07i0_.id=section07i0_1_.id 
    left outer join
        section07book01 section07i0_2_ 
            on section07i0_.id=section07i0_2_.id 
    left outer join
        section07movie01 section07i0_3_ 
            on section07i0_.id=section07i0_3_.id 
    where
        section07i0_.dtype='B'
```

### 기타
- exists, in, and, or, not
- =, >, >=, <= <>
- BETWEEN, LIKE, IS NULL

##### 출처: https://www.inflearn.com/course/lecture?courseSlug=ORM-JPA-Basic&unitId=21724&category=questionDetail&tab=curriculum