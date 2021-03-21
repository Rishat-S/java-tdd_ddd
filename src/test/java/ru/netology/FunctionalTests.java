package ru.netology;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 *  Sum = 1000 c.u. (conventional units)
 *  Percent = 20%
 *  Period (month) = 12 month
 *  Monthly payment =sum*((percent/period)+((percent/period)/((1+(percent/period))^period-1)))
 *  Total amount = monthly payment * period
 *  Overpayment = total amount - sum
 *
 * */

public class FunctionalTests {

    public static final double INITIAL_AMOUNT = 1000;
    public static final double RATE_FOR_ACCRUAL_PERIOD = 0.2;
    public static final int PERIOD = 12;

    @Test
    void monthlyPaymentCalculation() {
        BigDecimal monthlyPayment = CreditCalculator.monthlyPayment(INITIAL_AMOUNT, RATE_FOR_ACCRUAL_PERIOD, PERIOD);
        assertEquals("92.6345058971000", monthlyPayment.toString());
    }

    @Test
    void calculationOfTheTotalAmountToBeReturnedToTheBank() {
        BigDecimal totalAmount = CreditCalculator.totalAmountPayment(INITIAL_AMOUNT, RATE_FOR_ACCRUAL_PERIOD, PERIOD);
        assertEquals("1111.6140707652000", totalAmount.toString());
    }

    @Test
    void calculationOfOverpaymentForTheWholePeriod() {
        BigDecimal overpayment = CreditCalculator.overpayment(INITIAL_AMOUNT, RATE_FOR_ACCRUAL_PERIOD, PERIOD);
        assertEquals("111.6140707652000", overpayment.toString());
    }
}
