package jpaBook.jpaShop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/api")
    public void testMethod() {
        System.out.println("get request !");
    }
}
