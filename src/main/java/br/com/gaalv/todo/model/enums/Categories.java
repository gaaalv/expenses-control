package br.com.gaalv.todo.model.enums;

import lombok.*;

@AllArgsConstructor
@Getter
public enum Categories implements IdentifiableEnum{

    FOOD(1, "Food"),
    TRANSPORT(2, "Transport"),
    HOUSING(3, "Housing"),
    HEALTH(4, "Health"),
    EDUCATION(5, "Education"),
    ENTERTAINMENT(6, "Entertainment"),
    UTILITIES(7, "Utilities (Power, Water, Internet)"),
    SHOPPING(8, "Shopping/Clothing"),
    SERVICES(9, "Services/Subscriptions"),
    OTHERS(99, "Others");

    private final int id;
    private final String desc;
}