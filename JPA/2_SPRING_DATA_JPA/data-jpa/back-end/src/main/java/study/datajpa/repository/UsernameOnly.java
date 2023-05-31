package study.datajpa.repository;


import org.springframework.beans.factory.annotation.Value;

public interface UsernameOnly {
    String getUsername();
    Integer getAge();

//    @Value("#{target.username + ' ' + target.age}")
//    String getUsername();
}
