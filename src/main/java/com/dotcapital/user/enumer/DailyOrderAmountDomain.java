package com.dotcapital.user.enumer;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
public class DailyOrderAmountDomain {

    private Long entityId;
    private BigDecimal maxAmount;
    private BigDecimal counterAmount;
    private LocalDate counterDate;

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public BigDecimal getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(BigDecimal maxAmount) {
        this.maxAmount = maxAmount;
    }

    public BigDecimal getCounterAmount() {
        return counterAmount;
    }

    public void setCounterAmount(BigDecimal counterAmount) {
        this.counterAmount = counterAmount;
    }

    public LocalDate getCounterDate() {
        return counterDate;
    }

    public void setCounterDate(LocalDate counterDate) {
        this.counterDate = counterDate;
    }
}
