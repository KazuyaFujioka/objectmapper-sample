package com.example.domain.type;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Objects;

/**
 * 金額
 */
public class Amount {

    @NotNull(message = "金額を指定してください")
    BigDecimal value;

    public Amount(BigDecimal value) {
        this.value = value;
    }

    @Override
    public String toString() {
        if(Objects.isNull(value)) return "";
        NumberFormat format = NumberFormat.getCurrencyInstance();
        return format.format(value);
    }

    private Amount() {
    }
}