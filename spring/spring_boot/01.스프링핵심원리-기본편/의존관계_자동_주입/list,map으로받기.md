# spring bean을 list, map으로 받기

여러개의 구현 spring bean 이 있을 때 생성자에 list<InterA>, 또는 Map<String, Inter>로 여러 개의 spring bean 구현체를 받을 수 있다.
  
  
```java
 public class InterA {}
  
  @Component
  public class ImpleA implements InterA {
  
  }
  
  @Component
  public class ImpleB implements InterA {
  
  }
  
  public class Main {
    private final List<InterA> list;
    private final Map<String, InterA> map;
    public Main(List<InterA> list, Map<String, InterA> map) {
      this.list = list;
      this.map = map;
    }
  }
```
  list 같은 경우 여러 개의 spring bean이 들어가게 되고, map은 key가 spring bean name이, value로는 구현 객체가 들어가게 된다.

##### 출처: https://www.inflearn.com/course/lecture?courseSlug=%EC%8A%A4%ED%94%84%EB%A7%81-%ED%95%B5%EC%8B%AC-%EC%9B%90%EB%A6%AC-%EA%B8%B0%EB%B3%B8%ED%8E%B8&unitId=55380&category=questionDetail&tab=curriculum
