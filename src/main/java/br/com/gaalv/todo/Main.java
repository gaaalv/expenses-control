package br.com.gaalv.todo;

import br.com.gaalv.todo.controller.ExpenseController;
import br.com.gaalv.todo.repository.impl.ExpenseMemoryRepository;
import br.com.gaalv.todo.repository.ExpenseRepository;
import br.com.gaalv.todo.service.ExpenseService;

public class Main {
    static void main() {

        ExpenseRepository repo = new ExpenseMemoryRepository();

        ExpenseService service = new ExpenseService(repo);

        ExpenseController controller = new ExpenseController(service);

        controller.start();
    }
}
