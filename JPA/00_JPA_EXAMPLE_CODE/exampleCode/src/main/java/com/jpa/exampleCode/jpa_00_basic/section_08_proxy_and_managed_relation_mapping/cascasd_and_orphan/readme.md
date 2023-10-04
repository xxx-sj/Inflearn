# 영속성 전이(CASCADE)와 고아객체

- 특정 엔티티를 영속 상태로 만들 때 연관된 엔티티도 함계 영속 
 상태로 만들고 싶을 때 
- 부모 엔티티를 저장할 때 자식 엔티티도 함께 저장
- 자식 엔티티를 부모 엔티티 하나에서만 관계가 있을 때 사용
- 다중으로 자식 엔티티를 관리하는 엔티티에서 영속성 전이를 사용할 경우
- 예기치 못한 상황이 발생할 수 있음

부모 엔티티에서 자식 엔티티를 매핑한 곳에 cascade = CascadeType.ALL을 
통해 영속성 전이를 사용할 수 있다.


### 고아객체
- 부모 엔티티와 연관관계가 끊어진 자식 엔티티를 자동으로 삭제
- orphanRemoval = true 를 통해 사용가능
- parent.getChildList().remove(0);
- 연관관계가 끊어지면 DELETE문이 나감.
- 위와 동일하게 참조하는 곳이 하나일 때사용해야함.
- 연관관계가 여러곳에 있을경우 사용하면 안된다.
- 부모가 삭제되면 자식도 삭제된다 .

#### 출처: https://www.inflearn.com/course/lecture?courseSlug=ORM-JPA-Basic&unitId=21710&tab=curriculum