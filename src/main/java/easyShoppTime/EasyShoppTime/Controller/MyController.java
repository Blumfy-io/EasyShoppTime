package easyShoppTime.EasyShoppTime.Controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@SpringBootApplication
public class MyController {

    @RequestMapping("/")
    String home() {
    	return "Hello World";
    }
    
    public static void main(String[] args) {
		SpringApplication.run(MyController.class, args);
	}
}
