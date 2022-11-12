package Service;

import Repository.TodolistRepository;
import Entity.Todolist;

public class TodolistServiceImpl implements TodolistService {

    TodolistRepository todolistRepository;

    public TodolistServiceImpl(TodolistRepository todolistRepository) {
        this.todolistRepository = todolistRepository;
    }

    @Override
    public void showTodolist() {
        Todolist[] data = todolistRepository.getAll();
        System.out.println("TODO LIST");
        for (var i = 0; i < data.length; i++) {
            if (data[i] != null) {
                System.out.println(i + 1 + ". " + data[i].getTodo());
            }
        }
        System.out.println("");
    }

    @Override
    public void addTodolist(String todo) {
        todolistRepository.addTodolist(new Todolist(todo));
        System.out.println("SUKSES MENAMBAH : " + todo);
    }

    @Override
    public void removeTodolist(Integer number) {
        boolean valid = todolistRepository.removeTodolist(number);
        if (valid) {
            System.out.println("SUKSES MENGHAPUS : " + number);
        } else {
            System.out.println("GAGAL MENGHAPUS : " + number);
        }
    }

}
