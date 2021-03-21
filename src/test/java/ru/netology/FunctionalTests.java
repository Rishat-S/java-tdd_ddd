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

    public static final int INITIAL_AMOUNT = 1000;
    public static final int RATE_FOR_ACCRUAL_PERIOD = 20;
    public static final int PERIOD = 12;

    @Test
    void monthly_payment_calculation() {
        BigDecimal monthlyPayment = CreditCalculator.monthlyPayment(INITIAL_AMOUNT, RATE_FOR_ACCRUAL_PERIOD, PERIOD);
        assertEquals("92.6345058970802", monthlyPayment.toString());
    }

    @Test
    void calculation_of_the_total_amount_to_be_returned_to_the_bank() {
        BigDecimal totalAmount = CreditCalculator.totalAmountPayment(INITIAL_AMOUNT, RATE_FOR_ACCRUAL_PERIOD, PERIOD);
        assertEquals("1111.6140707649624", totalAmount.toString());
    }

    @Test
    void calculation_of_overpayment_for_the_whole_period() {
        BigDecimal overpayment = CreditCalculator.overpayment(INITIAL_AMOUNT, RATE_FOR_ACCRUAL_PERIOD, PERIOD);
        assertEquals("111.6140707649624", overpayment.toString());
    }
}
