import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CpfValidatorTest {

    @Test
    fun `test valid CPF`() {
        val cpf = "12345678909"
        assertTrue(CpfValidator.cpfIsValid(cpf))
    }

    @Test
    fun `test invalid CPF with repeated digits`() {
        val cpf = "11111111111"
        assertFalse(CpfValidator.cpfIsValid(cpf))
    }

    @Test
    fun `test invalid CPF with incorrect validation digits`() {
        val cpf = "12345678901"
        assertFalse(CpfValidator.cpfIsValid(cpf))
    }

    @Test
    fun `test invalid CPF with less than 11 digits`() {
        val cpf = "123456789"
        assertFalse(CpfValidator.cpfIsValid(cpf))
    }

    @Test
    fun `test invalid CPF with more than 11 digits`() {
        val cpf = "123456789012"
        assertFalse(CpfValidator.cpfIsValid(cpf))
    }

    @Test
    fun `test null CPF`() {
        val cpf: String? = null
        assertThrows(NullPointerException::class.java) {
            CpfValidator.cpfIsValid(cpf)
        }
    }

    @Test
    fun `test empty CPF`() {
        val cpf = ""
        assertThrows(NullPointerException::class.java) {
            CpfValidator.cpfIsValid(cpf)
        }
    }
}