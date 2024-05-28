package easyShoppTime.EasyShoppTime.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import project_interfaces.Task;
import project_interfaces.TaskList;

/**
 * Serviço para gerenciar o carrinho de compras.
 * Implementa a interface TaskList, que define os métodos para manipulação de tarefas.
 */

@Service
public class CartService implements TaskList {

	private List<List<Task>> lists = new ArrayList<>();

	private List<Task> itens = null;
	

	public void createList(List<Task> list) {
		lists.add(list);
		itens = list;
	}

	public void changeList(int index) {
        if (index >= 0 && index < lists.size()) {
            itens = lists.get(index);
        } else {
        	createList(new ArrayList<>());
        }
	}

	 /**
     * Marca uma tarefa como concluída.
     * 
     * @param title o título da tarefa a ser marcada como concluída
     */

	@Override
	public void done(String title) {
		if(itens == null) createList(new ArrayList<>());
		findByTitle(title).setIsDone(true);

		 /**
     * Adiciona uma nova tarefa ao carrinho.
     * 
     * @param task a tarefa a ser adicionada
     */

	}

	@Override
	public void create(Task task) {
		if(itens == null) createList(new ArrayList<>());
		itens.add(task);

	}

	/**
     * Lista todas as tarefas no carrinho.
     * 
     * @return uma lista de tarefas
     */

	@Override
	public List<Task> list() {
		return itens;
	}

	/**
     * Remove uma tarefa do carrinho.
     * 
     * @param title o título da tarefa a ser removida
     */

	@Override
	public void delete(String title) {
		if(itens == null) createList(new ArrayList<>());
		itens.remove(findByTitle(title));
	}

	/**
     * Edita uma tarefa existente no carrinho.
     * 
     * @param title o título da tarefa a ser editada
     * @param task a tarefa com as novas informações
     */

	@Override
	public void edit(String title, Task task) {
		if(itens == null) createList(new ArrayList<>());
		Task original = findByTitle(title);

		Class<?> classe = original.getClass();

		Field[] fields = classe.getDeclaredFields();

		for (Field field : fields) {
			field.setAccessible(true);
			try {
				Object newValue = field.get(task);
				if (newValue != null) {
					field.set(original, newValue);
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				throw new RuntimeException("Failed to edit task", e);
			}
		}
	}
	/**
     * Encontra uma tarefa pelo título.
     * 
     * @param title o título da tarefa
     * @return a tarefa com o título fornecido, ou null se não encontrada
     */


	public Task findByTitle(String title) {
		return itens.stream().filter(item -> item.getTitle().equals(title)).findFirst().orElse(null);
	}
	/**
     * Finaliza a sessão atual e salva o estado do carrinho.
     * 
     * TODO: Implementar o método para salvar o estado do carrinho no banco de dados para histórico do usuário.
     */

	public void finish() {
		// TODO Esse é o metodo que vai salvar a lista no bancco de dados para que o
		// usuario tenha seu historico de compras
		

	}

	@Override
	public void start(String title) {
		// TODO metodo sem utilidade

	}

	@Override
	public void stop(String title) {
		// TODO metodo sem utilidade

	}

}
