package br.com.gaalv.todo.controller;

import br.com.gaalv.todo.service.ExpenseService;

public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {

        this.expenseService = expenseService;
    }

    public void start() {}
}
