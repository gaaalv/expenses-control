package br.com.gaalv.todo.model;

import br.com.gaalv.todo.model.enums.Categories;
import br.com.gaalv.todo.model.enums.PaymentMethod;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Expense {

    private Long id;
    private String name;
    private BigDecimal price;
    private PaymentMethod paymentMethod;
    private Categories categories;
    private LocalDate date;
    private int installments;
}
