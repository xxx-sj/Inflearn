# component annotation

이 전 수동 주입과는 다르게 class level에 @component [@service, @repository, @controller ...]를 작성해주고, 
@Annotation을 사용하면 자동으로 spring bean으로 등록해준다.

이 전 코드
```java

@configuration
public class config {

  @Bean
  public A a() {
    return A();
  }
  
  @Bean
  public B b() {
    return B(A());
  }
}
```

이 후
```java
@configuration
@componentScan
public class config {
}


---

@component
public class ServiceImpl implementes service {

  //@Autowired 
  private A a;
  
  @Autowired (ac.getBean(A.class))
  public ServiceImpl(A a) {
    this.a = a; 
  }

}
```

@Autowired를 사용할 수 있는 곳은 [ 필드, 생성자, setter ] 가 있다.

스프링빈의 기본 이름은 클래스명을 사용하되, 맨 앞글자만 소문자를 사용한다. [ 따로 설정하지 않았다면 // @service("serviceExmaple") ]

##### 출처: https://www.inflearn.com/course/lecture?courseSlug=%EC%8A%A4%ED%94%84%EB%A7%81-%ED%95%B5%EC%8B%AC-%EC%9B%90%EB%A6%AC-%EA%B8%B0%EB%B3%B8%ED%8E%B8&unitId=55368&category=questionDetail&tab=curriculum
