package easyShoppTime.EasyShoppTime.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project_interfaces.Task;

/**
 * Representa um item no carrinho de compras.
 * Implementa a interface Task, que representa uma tarefa.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item implements Task{

	private Integer userID;
    private String userUuid;
    private String title;
    private String tag;
    private String description;
    private int status;
    private int qtd;
    private int priority;
    private Boolean isDelete;
    private Boolean isDone;
    private String typeTask;


	public Item(String userUuid, String title, String tag, int qtd) {
		super();
		this.userUuid = userUuid;
		this.title = title;
		this.tag = tag;
		this.qtd = qtd;
		defaultAtributes();
	}

  /**
     * Define os atributos padrão para o item.
     * Inicializa o status de conclusão como falso e o tipo de tarefa como "default".
     */

	public void defaultAtributes() {
		this.userID = null;
		this.description = "";
		this.typeTask = "Compra";
		this.status = 1;
		this.priority = 0;
		this.isDelete = false;
		this.isDone = false;
	}


	public int getQtd() {
		return qtd;
	}


	public void setQtd(int qtd) {
		this.qtd = qtd;
	}


	// Getters e Setters para userID
    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    // Getters e Setters para userUuid
    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    // Getters e Setters para title

      /**
     * Obtém o título do item.
     * 
     * @return o título
     */

    public String getTitle() {
        return title;
    }

        /**
     * Define o título do item.
     * 
     * @param title o título a ser definido
     */

    public void setTitle(String title) {
        this.title = title;
    }

    // Getters e Setters para tag
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    // Getters e Setters para description

    
    /**
     * Obtém a descrição do item.
     * 
     * @return a descrição
     */

    public String getDescription() {
        return description;
    }

/**
     * Define a descrição do item.
     * 
     * @param description a descrição a ser definida
     */

    public void setDescription(String description) {
        this.description = description;
    }

    // Getters e Setters para status
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    // Getters e Setters para priority
    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    // Getters e Setters para isDelete

  /**
     * Verifica se o item está concluído.
     * 
     * @return true se o item estiver concluído, false caso contrário
     */

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    // Getters e Setters para isDone
    public Boolean getIsDone() {
        return isDone;
    }

     /**
     * Define o status de conclusão do item.
     * 
     * @param isDone o status de conclusão a ser definido
     */

    public void setIsDone(Boolean isDone) {
        this.isDone = isDone;
    }

    // Getters e Setters para typeTask

    /**
     * Obtém o tipo da tarefa.
     * 
     * @return o tipo da tarefa
     */

    public String getTypeTask() {
        return typeTask;
    }

    /**
     * Define o tipo da tarefa.
     * 
     * @param typeTask o tipo a ser definido
     */

    public void setTypeTask(String typeTask) {
        this.typeTask = typeTask;
    }

}
