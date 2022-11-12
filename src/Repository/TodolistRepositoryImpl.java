package Repository;

import Entity.Todolist;

public class TodolistRepositoryImpl implements TodolistRepository {

    private Todolist[] data = new Todolist[10];

    @Override
    public Todolist[] getAll() {
        return data;
    }

    public boolean isFull() {
        boolean isFull = false;
        if (data[data.length - 1] != null) {
            isFull = true;
        }
        return isFull;
    }

    public void ifFull() {
        boolean ifFull = isFull();
        if (ifFull) {
            var temp = data;
            data = new Todolist[data.length * 2];
            for (var i = 0; i < temp.length; i++) {
                data[i] = temp[i];
            }
        }
    }

    @Override
    public void addTodolist(Todolist todo) {
        ifFull();
        for (var i = 0; i < data.length; i++) {
            if (data[i] == null) {
                data[i] = todo;
                break;
            }
        }
    }

    @Override
    public boolean removeTodolist(Integer number) {
        //cek apakah nomor yang dipilih melebihi panjang array
        if (number > data.length) {
            return false;
        } else //cek apakah number yang dipilih ada isinya
        if (data[number - 1] == null) {
            return false;
        } else if (number == data.length) {
            data[number - 1] = null;
        } else {
            for (int i = number; i < data.length; i++) {
                data[i - 1] = null;
                data[i - 1] = data[i];
                data[i] = null;
            }
        }
        return true;
    }

}
