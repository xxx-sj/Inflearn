# 페치 조인 - 기본

- JPQL에서 성능 최적화를 위해 제공하는 기능
- 연관된 엔티티나 컬렉션을 SQL 한번에 함께 조회하는 기능
- join fetch 명령어
- [LEFT [OUTER] | INNER ] JOIN FETCH 

- 회원을 조히하면서 연관ㄴ된 팀도 함께 조회
- JQPL
  - select m from Member m join fetch m.team
- SQL
  - select m.*, t.* from member m  inner join team t on team_id = t.id

##### 출처: https://www.inflearn.com/course/lecture?courseSlug=ORM-JPA-Basic&unitId=21742&tab=curriculum