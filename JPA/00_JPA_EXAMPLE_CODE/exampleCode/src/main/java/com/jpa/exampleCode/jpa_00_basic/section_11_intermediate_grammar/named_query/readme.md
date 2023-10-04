# Named쿼리

엔티티 위에 @NamedQuery를 이용하여 동적쿼리를 미리 작성하는 것이다.

```java
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(
        name = "Member.findnByUsername",
        query = "select m from Member m where m.username = :useranme"
)
public void Member {}


em.createNamedQuery("Member.findByUsername", Member.class)
...
```

### Named쿼리 -정적쿼리
- 정적쿼리
- 어노테이션, XML에 정의
- 어플리케이션 로딩 시점에 초기화 후 재사용
  - 어플리케이션 로딩 시점에 쿼리를 SQL로 파싱하여 캐싱해둔다.
- 애플리케이션 로딩 시점에 쿼리를 검증

스프링 데이터 JPA에서는 인터페이스 위에 @Query로 선언할 수 있다.
```java
public interface ... extends JpaRepository<> {
  
    @Query("select m from Member m where m.username = :username")
    void test(String username);
}
```

##### 출처: https://www.inflearn.com/course/lecture?courseSlug=ORM-JPA-Basic&unitId=21731&tab=curriculum