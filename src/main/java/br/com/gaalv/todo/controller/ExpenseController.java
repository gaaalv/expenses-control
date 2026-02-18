package br.com.gaalv.todo.controller;

import br.com.gaalv.todo.service.ExpenseService;

import java.util.Scanner;

public class ExpenseController {

    private final ExpenseService expenseService;
    private final Scanner scanner;


    public ExpenseController(ExpenseService expenseService, Scanner scanner) {

        this.expenseService = expenseService;
        this.scanner = scanner;
    }

    public void start() {}
}
