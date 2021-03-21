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

    @Test
    void monthly_payment_calculation() {
        BigDecimal monthlyPayment = CreditCalculator.monthlyPayment(1080, 20, 12);
        assertEquals("92.6345058970802", monthlyPayment.toString());
    }

    @Test
    void calculation_of_the_total_amount_to_be_returned_to_the_bank() {
        BigDecimal totalAmount = CreditCalculator.totalAmountPayment(1080, 20, 12);
        assertEquals("1111.61407076496", totalAmount.toString());
    }

    @Test
    void calculation_of_overpayment_for_the_whole_period() {
        BigDecimal overpayment = CreditCalculator.overpayment(1080, 20, 12);
        assertEquals("111.61407076496", overpayment.toString());
    }
}
