
import Repository.TodolistRepository;
import Repository.TodolistRepositoryImpl;
import Service.TodolistService;
import Service.TodolistServiceImpl;
import View.TodolistView;

public class Main {

    public static void main(String[] args) {
        TodolistRepository todolistRepository = new TodolistRepositoryImpl();
        TodolistService todolistService = new TodolistServiceImpl(todolistRepository);
        TodolistView todolistView = new TodolistView(todolistService);
        todolistView.showtodolist();
    }
}
