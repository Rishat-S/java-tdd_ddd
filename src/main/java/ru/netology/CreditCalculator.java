package ru.netology;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CreditCalculator {

    public static final int SCALE_RATE = 13;

    public static BigDecimal monthlyPayment(double initialAmount, double rateForAccrualPeriod, int period) {
        BigDecimal interestRate = new BigDecimal(rateForAccrualPeriod)
                .divide(new BigDecimal(period), SCALE_RATE, RoundingMode.HALF_UP);
        BigDecimal x5 = interestRate.add(new BigDecimal(1));
        BigDecimal x4 = x5.pow(period);
        BigDecimal x3 = x4.subtract(new BigDecimal(1));
        BigDecimal x2 = interestRate.divide(x3, SCALE_RATE, RoundingMode.HALF_UP);
        BigDecimal x1 = interestRate.add(x2);
        BigDecimal monthlyPayment = new BigDecimal(initialAmount).multiply(x1);
        return monthlyPayment.setScale(SCALE_RATE, RoundingMode.HALF_UP);
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
