package ru.netology;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CreditCalculator {

    public static final int SCALE_RATE = 13;

    public static BigDecimal monthlyPayment(double initialAmount, double rateForAccrualPeriod, int period) {
        BigDecimal interestRate = new BigDecimal(rateForAccrualPeriod)
                .divide(new BigDecimal(period), SCALE_RATE, RoundingMode.HALF_UP);
        return new BigDecimal(initialAmount)
                .multiply(interestRate
                        .add(interestRate
                                .divide(interestRate
                                        .add(new BigDecimal(1))
                                        .pow(period)
                                        .subtract(new BigDecimal(1)), SCALE_RATE, RoundingMode.HALF_UP)))
                .setScale(SCALE_RATE, RoundingMode.HALF_UP);
    }

    public static BigDecimal totalAmountPayment(double initialAmount, double rateForAccrualPeriod, int period) {
        BigDecimal totalAmount = new BigDecimal(0);
        totalAmount = totalAmount
                .add(monthlyPayment(initialAmount, rateForAccrualPeriod, period)
                        .multiply(BigDecimal.valueOf(period)));
        return totalAmount.setScale(SCALE_RATE, RoundingMode.HALF_UP);
    }

    public static BigDecimal overpayment(double initialAmount, double rateForAccrualPeriod, int period) {
        BigDecimal overpayment;
        overpayment = totalAmountPayment(initialAmount, rateForAccrualPeriod, period)
                .subtract(new BigDecimal(initialAmount));
        return overpayment.setScale(SCALE_RATE, RoundingMode.HALF_UP);
    }
}
