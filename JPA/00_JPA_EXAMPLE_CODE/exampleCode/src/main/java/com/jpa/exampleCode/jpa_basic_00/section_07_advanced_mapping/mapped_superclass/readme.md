# mapped superclass

- 다른 엔티티들에 공통적으로 들어가는 컬럼을 정의할 때 사용한다.
- 해당 mapped superclass는 엔티티로 생성되지 않는다.

- 엔티티끼리의 extends는 해당 엔티티가 @Entity를 갖고 있거나 또는
@MappedSuperclass 어노테이션이 선언되어있어야 가능하다.


##### 출처: https://www.inflearn.com/course/lecture?courseSlug=ORM-JPA-Basic&unitId=21706&tab=curriculum