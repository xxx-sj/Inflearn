# 임베디드 타입

- 주로 기본 값 타입을 모아서 만들어서 복합 값 타입이라고도 함.
- int, String과 같은 값타입으로 변경되면 추적이 불가능
```java

class Address {
    String city;
    String street;
    String zipcode;
}
```

- @Embeddable: 값 타입을 정의하는 클래스에 사용
- @Embedded: 값 타입을 사용하는 곳에 표시
- 기본 생성자 필수
- 재 사용이 가능하며
- 높은 응집도를 갖고있다. [ 의미가 비슷한 프로퍼티의 모음 ]
- isWork()와 같은 해당 값 타입만 사용하는 의미 있는 메서드 작성 가능
- 값 타입을 소유한 엔티티에 생명주기를 의존한다.
- 임베디드 타입은 엔티티를 프로퍼티로 가질 수 있다.
  - 이 때는 임베디드타입을 사용하는 엔티티에 FK값으로 임베디드가 가지고 있는
  - 엔티티의 PK가 들어가게 된다.



### 속성 재정의 @AttributeOverride
- 같은 타입을 한 엔티티에서 사용하면 컬럼이 중복되어 오류가 발생됨.
- @AttributeOverrides, @AttributeOverride를 사용해서 컬럼명 속성 재정의

##### 출처: https://www.inflearn.com/course/lecture?courseSlug=ORM-JPA-Basic&unitId=21713&tab=curriculum