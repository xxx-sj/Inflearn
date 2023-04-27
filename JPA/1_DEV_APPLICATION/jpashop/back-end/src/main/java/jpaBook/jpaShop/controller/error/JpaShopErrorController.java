package jpaBook.jpaShop.controller.error;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JpaShopErrorController implements ErrorController {

//    @GetMapping("/error")
//    public String redirectRoot() {
//        return "index.html";
//    }
}
