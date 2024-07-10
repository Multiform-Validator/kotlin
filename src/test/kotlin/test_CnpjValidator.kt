import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CnpjValidatorTest {

    @Test
    fun `test valid CNPJ`() {
        val cnpj = "93186394000103"
        assertTrue(CnpjValidator.cnpjIsValid(cnpj))
    }

    @Test
    fun `test invalid CNPJ with all repeated digits`() {
        val cnpj = "11111111111111"
        assertFalse(CnpjValidator.cnpjIsValid(cnpj))
    }

    @Test
    fun `test invalid CNPJ with incorrect validation digits`() {
        val cnpj = "12345678000191"
        assertFalse(CnpjValidator.cnpjIsValid(cnpj))
    }

    @Test
    fun `test invalid CNPJ with less than 14 digits`() {
        val cnpj = "1234567800019"
        assertFalse(CnpjValidator.cnpjIsValid(cnpj))
    }

    @Test
    fun `test invalid CNPJ with more than 14 digits`() {
        val cnpj = "123456780001900"
        assertFalse(CnpjValidator.cnpjIsValid(cnpj))
    }

    @Test
    fun `test null CNPJ`() {
        val cnpj: String? = null
        assertThrows(NullPointerException::class.java) {
            CnpjValidator.cnpjIsValid(cnpj)
        }
    }

    @Test
    fun `test empty CNPJ`() {
        val cnpj = ""
        assertThrows(NullPointerException::class.java) {
            CnpjValidator.cnpjIsValid(cnpj)
        }
    }
}