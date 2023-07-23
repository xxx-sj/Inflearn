# 벌크 연산
- entity를 콕찝어서 하는 sql이 아닌, 업데이트 딜리트 쿼리

- 재고가 10개 미만인 모든 상품의 가격을 10% 상승하려면
- JPA변경 감지 기능으로 실행하려면 너무 많은 SQL 실행
  - 재고가 10개 미만인 상품 조회
  - 상품 엔티티의 가격을 10% 증가
  - 트랜잭션 커밋 시점에 변경감지로 인한 업데이트
- 변경된 데이타가 100건이라면 100번의 업데이트 문이 실행된다.


### 예제
- 쿼리 한번에 여러 테이블 로우 실행
- executeUpdate()의 결과는 엔티티 수 반환
- UPDATE, DELETE 지원
- INSERT(insert into ..select, 하이버네이트 지원)

- spring-data-jpa에서는 @Modifying어노테이션을 사용하면 clearAutomaically하게 해준다.


##### 출처: https://www.inflearn.com/course/lecture?courseSlug=ORM-JPA-Basic&unitId=21732&tab=curriculum