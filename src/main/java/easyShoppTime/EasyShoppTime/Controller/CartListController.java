package easyShoppTime.EasyShoppTime.Controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/")
@RestController
@SpringBootApplication
public class CartListController {

	 public static void main(String[] args) {
         SpringApplication.run(CartListController.class, args);
   }
}
