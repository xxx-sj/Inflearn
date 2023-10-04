# 엔티티 직접 사용

### 엔티티 직접 사용 - 기본 키 값
- JPQL에서 엔티티를 직접 사용하면 SQL에서 해당 엔티티의 기본 키 값을 사용
  - JPQL
    - select count(m.id) from Member m 
    - select count(m) from Member m
  - SQL
    - select count(m.id) as cnt from Member m
- 엔티티를 파라미터로 전달하여도 식별자가 넘어간다.
  - select m from Member m where m = :member
  - select m from Member m where m.id = ?
- 외래 키에도 엔티티 사용도 동일하게 외래키 값을 사용한다.
    
##### 출처: https://www.inflearn.com/course/lecture?courseSlug=ORM-JPA-Basic&unitId=21730&tab=curriculum&category=questionDetail