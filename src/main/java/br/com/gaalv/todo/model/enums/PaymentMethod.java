package br.com.gaalv.todo.model.enums;

import lombok.*;

@AllArgsConstructor
@Getter
public enum PaymentMethod implements IdentifiableEnum{

    PIX(1, "Pix", Installments.SINGLE_PAYMENT),
    DEBIT(2, "Debit", Installments.SINGLE_PAYMENT),
    CREDIT(3, "Credit", Installments.MULTIPLE_PAYMENTS),
    CASH(4, "Money", Installments.SINGLE_PAYMENT);

    private final int id;
    private final String desc;
    private final Installments installments;

    public boolean allowInstallments() {
        return this.getInstallments() == Installments.MULTIPLE_PAYMENTS;
    }
}
