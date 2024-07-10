import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class EmailValidatorTest {

    @Test
    fun `test valid email`() {
        val email = "test@example.com"
        assertTrue(EmailValidator.isEmail(email))
    }

    @Test
    fun `test invalid email with missing @ symbol`() {
        val email = "testexample.com"
        assertFalse(EmailValidator.isEmail(email))
    }

    @Test
    fun `test invalid email with multiple @ symbols`() {
        val email = "test@example@com"
        assertFalse(EmailValidator.isEmail(email))
    }

    @Test
    fun `test invalid email with consecutive dots in domain`() {
        val email = "test@example..com"
        assertFalse(EmailValidator.isEmail(email))
    }

    @Test
    fun `test invalid email with dot at the end of local part`() {
        val email = "test.@example.com"
        assertFalse(EmailValidator.isEmail(email))
    }

    @Test
    fun `test invalid email with digit after @ symbol`() {
        val email = "test@1example.com"
        assertFalse(EmailValidator.isEmail(email))
    }

    @Test
    fun `test invalid email with digit after last dot`() {
        val email = "test@example.1com"
        assertFalse(EmailValidator.isEmail(email))
    }

    @Test
    fun `test invalid email with duplicate domain parts`() {
        val email = "test@example.com.com"
        assertFalse(EmailValidator.isEmail(email))
    }

    @Test
    fun `test invalid email with special character at the beginning`() {
        val email = "!test@example.com"
        assertFalse(EmailValidator.isEmail(email))
    }

    @Test
    fun `test invalid email with empty local part`() {
        val email = "@example.com"
        assertFalse(EmailValidator.isEmail(email))
    }
}