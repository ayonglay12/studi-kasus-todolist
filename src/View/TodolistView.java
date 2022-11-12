package View;

import Service.TodolistService;
import Util.TodolistUtil;

import Entity.Todolist;
import Repository.TodolistRepository;

public class TodolistView {

    private TodolistRepository todolistRepository;
    private TodolistService todolistService;

    public TodolistView(TodolistService todolistService) {
        this.todolistService = todolistService;
    }

    public void showtodolist() {
        while (true) {
            todolistService.showTodolist();
            System.out.println("Pilihan");
            System.out.println("Tekan 1 : Tambah");
            System.out.println("Tekan 2 : Hapus");
            System.out.println("Tekan x : Keluar");
            var input = TodolistUtil.input("Pilih");
            switch (input) {
                case "1":
                    addTodolist();
                    break;
                case "2":
                    Todolist[] temp = todolistRepository.getAll();
                    if (temp == null) {
                        System.out.println("DATA KOSONG");
                        break;
                    } else {
                        removeTodolist();
                    }
                    break;
                case "x":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak dimengerti");
                    break;
            }
        }
    }

    public void addTodolist() {
        System.out.println("Tambahkan Data Anda - x untuk batal");
        var input = TodolistUtil.input("Kegiatan");
        if ("x".equals(input)) {
            System.out.println("Batal");
        } else {
            todolistService.addTodolist(input);
        }
    }

    public void removeTodolist() {
        System.out.println("Pilih Data - x untuk batal");
        var input = TodolistUtil.input("Nomor");
        if ("x".equals(input) || "X".equals(input)) {
            System.out.println("Batal");
        } else {
            todolistService.removeTodolist(Integer.valueOf(input));
        }
    }

}
