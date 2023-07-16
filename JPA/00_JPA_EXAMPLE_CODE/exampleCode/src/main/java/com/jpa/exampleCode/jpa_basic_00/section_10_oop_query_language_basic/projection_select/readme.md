# 프로젝션 (select)

- select 절에 조회할 대상을 지정하는 것
- 프로젝션 대상: 엔티티, 임베디드, 스칼라 (숫자, 문자 등 기본 데이터 타입)
- select m from Member m -> 엔티티
- select m.team from Member m -> 엔티티
- select m.address from Member m -> 임베디드
- select m.username, m.age from Member m -> 스칼라 타입
- DISTINCT로 중복 제거


##### 출처: https://www.inflearn.com/course/lecture?courseSlug=ORM-JPA-Basic&unitId=21720&tab=curriculum