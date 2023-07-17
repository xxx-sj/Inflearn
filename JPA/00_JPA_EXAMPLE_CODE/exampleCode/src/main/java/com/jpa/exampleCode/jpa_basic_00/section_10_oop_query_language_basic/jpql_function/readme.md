# JPQL 함수

- sql의 기본 함수들도 사용가능하다.

### 사용자 정의 함수 호출
- 하이버네이트는 사용 전 방언에 추가해야 한다.
  - 사용하는 DB방언을 상속받고, 사용자 정의 함수를 등록한다.
  - select function('group_concat', i.name) from Item i

##### 출처: https://www.inflearn.com/course/lecture?courseSlug=ORM-JPA-Basic&unitId=21726&tab=curriculum