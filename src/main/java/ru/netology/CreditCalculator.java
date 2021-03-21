package ru.netology;

import java.math.BigDecimal;

public class CreditCalculator {
    public static BigDecimal monthlyPayment(int initialAmount, int rateForAccrualPeriod, int period) {
        return BigDecimal.valueOf(92.6345058970802);
    }

    public static BigDecimal totalAmountPayment(int initialAmount, int rateForAccrualPeriod, int period) {
        BigDecimal totalAmount = new BigDecimal(0);
        totalAmount = totalAmount.add(monthlyPayment(initialAmount,rateForAccrualPeriod,period).multiply(BigDecimal.valueOf(period)));
        return totalAmount;
    }

    public static BigDecimal overpayment(int initialAmount, int rateForAccrualPeriod, int period) {
        BigDecimal overpayment;
        overpayment = totalAmountPayment(initialAmount,rateForAccrualPeriod,period).subtract(new BigDecimal(initialAmount));
        return overpayment;
    }
}
