package easyShoppTime.EasyShoppTime.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import easyShoppTime.EasyShoppTime.Model.Item;
import easyShoppTime.EasyShoppTime.Service.CartService;
import project_interfaces.Task;

@RestController
@SpringBootApplication
@ComponentScan(basePackages = "easyShoppTime.EasyShoppTime")
public class CartController {
	
	@Autowired
	private CartService cart;

    @RequestMapping("/")
    String home() {
    	return "Hello World";
    }
    
    public static void main(String[] args) {
		SpringApplication.run(CartController.class, args);
	}
    
	@GetMapping
	public ResponseEntity<List<Task>> list() {
		if(cart.list().isEmpty()) {
			return ResponseEntity.notFound().build(); 
		}
		return ResponseEntity.ok(cart.list());
	}
	
    @PostMapping("/")
    public ResponseEntity<Void> create(@RequestBody Item item) {
    	item.defaultAtributes();
    	cart.create(item);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @PutMapping("/edit/{title}")
    public ResponseEntity<Void> updateTask(@PathVariable("title") String title, @RequestBody Item item) {
        cart.edit(title, item);
        return ResponseEntity.ok().build();
    }
    
    @DeleteMapping("/delete/{title}")
    public ResponseEntity<Void> deleteTask(@PathVariable("title") String title) {
        cart.delete(title);
        return ResponseEntity.ok().build();
    }
}
