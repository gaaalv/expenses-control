package br.com.gaalv.todo;

import br.com.gaalv.todo.controller.ExpenseController;
import br.com.gaalv.todo.repository.impl.ExpenseMemoryRepository;
import br.com.gaalv.todo.service.ExpenseService;

import java.util.Scanner;

public class Main {
    static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        var repository = new ExpenseMemoryRepository();
        var service = new ExpenseService(repository);
        var controller = new ExpenseController(service, sc);

        controller.start();

        sc.close();
    }
}
