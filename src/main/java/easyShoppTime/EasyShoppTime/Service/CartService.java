package easyShoppTime.EasyShoppTime.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import project_interfaces.Task;
import project_interfaces.TaskList;

@Service
public class CartService implements TaskList {

	private List<Task> itens = new ArrayList<>();

	@Override
	public void done(String title) {
		findByTitle(title).setIsDone(true);

	}

	@Override
	public void create(Task task) {
		itens.add(task);

	}

	@Override
	public List<Task> list() {
		return itens;
	}

	@Override
	public void delete(String title) {
		itens.remove(findByTitle(title));
	}

	@Override
	public void edit(String title, Task task) {
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

	public Task findByTitle(String title) {
		return itens.stream().filter(item -> item.getTitle().equals(title)).findFirst().orElse(null);
	}

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
