package br.com.gaalv.todo.repository.impl;

import br.com.gaalv.todo.model.Expense;
import br.com.gaalv.todo.repository.ExpenseRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ExpenseMemoryRepository implements ExpenseRepository {

    private final List<Expense> expensesList = new ArrayList<>();
    private long contId = 1;


    @Override
    public void saveExpense(Expense expense) {

        if(expense.getId() == null) {

            expense.setId(contId++);
            expensesList.add(expense);
        } else {

            updateExpense(expense);
        }
    }

    @Override
    public boolean deleteExpense(Expense expense) {return  expensesList.removeIf(e -> e.getId().equals(expense.getId()));}

    @Override
    public void updateExpense(Expense expense) {

        searchById(expense.getId()).ifPresent(oldExpense -> {

            int index = expensesList.indexOf(oldExpense);
            expensesList.set(index, expense);
        });
}

    @Override
    public List<Expense> readExpense() {return Collections.unmodifiableList(expensesList);}

    @Override
    public int total() {return expensesList.size();}

    @Override
    public Optional<Expense> searchById(long id) {

        return expensesList.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();
    }
}
