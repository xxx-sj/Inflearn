# @Configuration

Config class 에서 class level에 Configuration annotation을 달게되면 CGLIB lib를 사용하여 byte code 조작으로 
proxy class가 생기게되며, 싱글톤을 보장해준다. 
하지만, configuration annotation 없이 @Bean만으로 spring bean을 만들게 되면, class 내에 정의된 bean들이 순수 class instance로
생성되며, 만약 여러개의 동일한 class의 instance를 생성하게 된다면, CGLIB와 다르게, 여러번 호출되는 것을 확인할 수 있다.


```java

public class Config {

  @Bean
  public repoA repoA() {
    return new RepoA();
  }
  
  @Bean
  public repoB repoB() {
    return new RepoB(repoA());
  }
}
```
한번은 repoA method로 repoA를 등록할 때 1번, repoB에서 repoA를 호출하면서 한번 더 해서 2개의 instance가 생성되어 버린다.


##### 출처: https://www.inflearn.com/course/lecture?courseSlug=%EC%8A%A4%ED%94%84%EB%A7%81-%ED%95%B5%EC%8B%AC-%EC%9B%90%EB%A6%AC-%EA%B8%B0%EB%B3%B8%ED%8E%B8&unitId=55366&category=questionDetail&tab=curriculum
