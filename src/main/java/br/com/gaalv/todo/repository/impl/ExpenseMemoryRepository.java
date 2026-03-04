package br.com.gaalv.todo.repository.impl;

import br.com.gaalv.todo.model.Expense;
import br.com.gaalv.todo.repository.ExpenseRepository;

import java.util.*;

public class ExpenseMemoryRepository implements ExpenseRepository {

    private final Map<Long, Expense> expensesMap = new LinkedHashMap<>();
    private long contId = 1;


    @Override
    public void saveExpense(Expense expense) {

        if(expense.getId() == null) {
            expense.setId(contId++);
            expensesMap.put(expense.getId(), expense);
        } else {
            updateExpense(expense);
        }
    }

    @Override
    public boolean deleteExpense(Expense expense) {return expensesMap.remove(expense.getId()) != null;}

    @Override
    public void updateExpense(Expense expense) {expensesMap.replace(expense.getId(), expense);}

    @Override
    public List<Expense> findAll() {return List.copyOf(expensesMap.values());}

    @Override
    public int total() {return expensesMap.size();}

    @Override
    public Optional<Expense> findById(long id) {return Optional.ofNullable(expensesMap.get(id));}
}
