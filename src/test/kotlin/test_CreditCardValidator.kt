import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CreditCardValidatorTest {

    @Test
    fun `test valid credit card`() {
        val creditCard = "4111111111111111"
        assertTrue(CreditCardValidator.isCreditCardValid(creditCard))
    }

    @Test
    fun `test invalid credit card with less than 13 digits`() {
        val creditCard = "123456789012"
        assertFalse(CreditCardValidator.isCreditCardValid(creditCard))
    }

    @Test
    fun `test invalid credit card with more than 19 digits`() {
        val creditCard = "12345678901234567890"
        assertFalse(CreditCardValidator.isCreditCardValid(creditCard))
    }

    @Test
    fun `test identify Visa card`() {
        val creditCard = "4111111111111111"
        val expectedFlag = "Visa"
        val actualFlag = CreditCardValidator.identifyFlagCard(creditCard)
        assertEquals(expectedFlag, actualFlag)
    }

    @Test
    fun `test identify Mastercard card`() {
        val creditCard = "5123456789012346"
        val expectedFlag = "Mastercard"
        val actualFlag = CreditCardValidator.identifyFlagCard(creditCard)
        assertEquals(expectedFlag, actualFlag)
    }

    @Test
    fun `test identify American Express card`() {
        val creditCard = "378282246310005"
        val expectedFlag = "American Express"
        val actualFlag = CreditCardValidator.identifyFlagCard(creditCard)
        assertEquals(expectedFlag, actualFlag)
    }

    @Test
    fun `test identify Discover card`() {
        val creditCard = "6011111111111117"
        val expectedFlag = "Discover"
        val actualFlag = CreditCardValidator.identifyFlagCard(creditCard)
        assertEquals(expectedFlag, actualFlag)
    }

    @Test
    fun `test identify JCB card`() {
        val creditCard = "3530111333300000"
        val expectedFlag = "JCB"
        val actualFlag = CreditCardValidator.identifyFlagCard(creditCard)
        assertEquals(expectedFlag, actualFlag)
    }

    @Test
    fun `test identify Diners Club card`() {
        val creditCard = "30569309025904"
        val expectedFlag = "Diners Club"
        val actualFlag = CreditCardValidator.identifyFlagCard(creditCard)
        assertEquals(expectedFlag, actualFlag)
    }

    @Test
    fun `test identify Maestro card`() {
        val creditCard = "6304000000000000"
        val expectedFlag = "Maestro"
        val actualFlag = CreditCardValidator.identifyFlagCard(creditCard)
        assertEquals(expectedFlag, actualFlag)
    }

    @Test
    fun `test identify UnionPay card`() {
        val creditCard = "6200000000000000"
        val expectedFlag = "UnionPay"
        val actualFlag = CreditCardValidator.identifyFlagCard(creditCard)
        assertEquals(expectedFlag, actualFlag)
    }

    @Test
    fun `test identify Hipercard card`() {
        val creditCard = "6062826822893889"
        val expectedFlag = "Hipercard"
        val actualFlag = CreditCardValidator.identifyFlagCard(creditCard)
        assertEquals(expectedFlag, actualFlag)
    }

    @Test
    fun `test identify unknown card`() {
        val creditCard = "0000000000000000"
        val expectedFlag = "Unknown"
        val actualFlag = CreditCardValidator.identifyFlagCard(creditCard)
        assertEquals(expectedFlag, actualFlag)
    }
}