# 값 타입의 비교

- 인스턴스가 달라도 그 안에 값이 같으면 같은 것으로 봐야한다.
```java
int a = 10;
int b = 10;
a == b; true
```
와 같이 인스턴스인 임베디드 타입을 비교해도 동일한 값으로 봐야한다.
```java
Address a = new Address("1");
Address b = new Address("2");
a == b; true
```

- 동일성 비교: 인스턴스의 참조 값을 비교 ==
- 동등성 비교: 인스턴스의 값을 비교, eqauls()
- 값 타입은 a.equals(b)를 사용해서 동등성 비교를 해야한다.
- eqauls() 메서드를 재정의 한다.

##### 출처: https://www.inflearn.com/course/lecture?courseSlug=ORM-JPA-Basic&unitId=21715&tab=curriculum