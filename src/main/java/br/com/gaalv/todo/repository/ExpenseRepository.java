package br.com.gaalv.todo.repository;

import br.com.gaalv.todo.model.Expense;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ExpenseRepository {

     void saveExpense(Expense expense);

     boolean deleteExpense(Expense expense);

     void updateExpense(Expense expense);

     List<Expense> findAll();

     int total();

     Optional<Expense> findById(long id);


}
