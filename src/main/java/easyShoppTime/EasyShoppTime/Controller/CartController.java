package easyShoppTime.EasyShoppTime.Controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

/**
 * Controlador para gerenciar o carrinho de compras.
 * Este controlador lida com as requisições HTTP para criar, ler, atualizar e deletar itens no carrinho de compras.
 */

@RestController
@SpringBootApplication
@ComponentScan(basePackages = "easyShoppTime.EasyShoppTime")
public class CartController {
	
	@Autowired
	private CartService cart;
    /**
     * Endpoint da página inicial.
     * 
     * @return uma mensagem de boas-vindas
     */

    @RequestMapping("/")
    String home() {
    	return "Hello World";
    }
    /**
     * Método principal para iniciar a aplicação Spring Boot.
     * 
     * @param args argumentos da linha de comando
     */
    
    public static void main(String[] args) {
		SpringApplication.run(CartController.class, args);
	}

     /**
     * Obtém uma lista de todas as tarefas no carrinho.
     * 
     * @return um ResponseEntity contendo a lista de tarefas ou status 404 se a lista estiver vazia
     */
    
	@GetMapping
	 @CrossOrigin(origins = "http://127.0.0.1:5500")
	public ResponseEntity<List<Task>> list() {
		if(cart.list().isEmpty()) {
			return ResponseEntity.notFound().build(); 
		}
		return ResponseEntity.ok(cart.list());
	}

    /**
     * Adiciona uma nova lista.
     * 
     * @param item o item a ser adicionado
     * @return um ResponseEntity com status CREATED
     */
	
    @PostMapping("/change/{id}")
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public ResponseEntity<Void> changeList(@PathVariable("id") Integer id) {
    	cart.changeList(id);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * Adiciona um novo item ao carrinho.
     * 
     * @param item o item a ser adicionado
     * @return um ResponseEntity com status CREATED
     */
	
    @PostMapping("/")
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public ResponseEntity<Void> create(@RequestBody Item item) {
    	item.defaultAtributes();
    	cart.create(item);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    /**
     * Atualiza uma tarefa existente no carrinho.
     * 
     * @param title o título da tarefa a ser atualizada
     * @param item a tarefa atualizada
     * @return um ResponseEntity com status OK ou NOT FOUND se a tarefa não for encontrada
     */

    @PutMapping("/edit/{title}")
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public ResponseEntity<Void> updateTask(@PathVariable("title") String title, @RequestBody Item item) {
        cart.edit(title, item);
        return ResponseEntity.ok().build();
    }
/**
     * Exclui uma tarefa do carrinho.
     * 
     * @param title o título da tarefa a ser excluída
     * @return um ResponseEntity com status NO CONTENT ou NOT FOUND se a tarefa não for encontrada
     */
    
    @DeleteMapping("/delete/{title}")
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public ResponseEntity<Void> deleteTask(@PathVariable("title") String title) {
        cart.delete(title);
        return ResponseEntity.ok().build();
    }
}
