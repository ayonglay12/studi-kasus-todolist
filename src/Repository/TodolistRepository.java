
package Repository;
import Entity.Todolist;

public interface TodolistRepository {
  
    Todolist[] getAll();
    void addTodolist(Todolist todo);
    boolean removeTodolist(Integer number);
    
}
