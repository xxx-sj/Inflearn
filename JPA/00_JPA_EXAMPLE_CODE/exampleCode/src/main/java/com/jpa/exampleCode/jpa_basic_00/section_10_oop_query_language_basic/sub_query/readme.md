# 서브쿼리

쿼리에서도 동일하게 메인쿼리에서 사용하던 엔티티를 서브쿼리에서 사용할 시에 성능이 저하된다.
- select m from Member m
  where m.age > (select avg(m2.age) from Member m2)
- select m from Member m
  where (select count(o) from Order o where m = o.member) > 0

### JPA 서브 쿼리 한계
- JPA는 WHERE, HAVING 절에서만 사용 가능
- SELECT 절도 가능
- FROM 절의 서브 쿼리는 JPQL에서 불가능 [하이버네이트 6 가능
  - 조인으로 풀 수 있으면 풀어서 해결

##### 출처: https://www.inflearn.com/course/lecture?courseSlug=ORM-JPA-Basic&unitId=21723&tab=curriculum