package br.com.gaalv.todo.dto;

import br.com.gaalv.todo.model.enums.Categories;
import br.com.gaalv.todo.model.enums.PaymentMethod;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@AllArgsConstructor
public class ExpenseResponse {

    private String name;
    private BigDecimal price;
    private PaymentMethod paymentMethod;
    private Categories categories;
    private LocalDate date;
    private int installments;

    private final static DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public String toString() {

        return String.format("Date: %s || Name: %s || Price: %f || Payment Method: %s in %dx || Categories: %s",
                this.date.format(format),
                this.name,
                this.price.setScale(2, RoundingMode.HALF_UP).doubleValue(),
                this.paymentMethod.getDesc(),
                this.installments,
                this.categories.getDesc());
    }
}