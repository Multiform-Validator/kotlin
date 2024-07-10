import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ValidatorTest {

    @Test
    fun `test isAscii with valid ASCII value`() {
        val value = "Hello World"
        assertTrue(Validator.isAscii(value))
    }

    @Test
    fun `test isAscii with non-ASCII value`() {
        val value = "こんにちは"
        assertFalse(Validator.isAscii(value))
    }

    @Test
    fun `test isBase64 with valid Base64 value`() {
        val value = "SGVsbG8gV29ybGQ="
        assertTrue(Validator.isBase64(value))
    }

    @Test
    fun `test isBase64 with invalid Base64 value`() {
        val value = "Hello World"
        assertFalse(Validator.isBase64(value))
    }

    @Test
    fun `test isCEP with valid CEP`() {
        val cep = "12345-678"
        assertTrue(Validator.isCEP(cep))
    }

    @Test
    fun `test isCEP with invalid CEP`() {
        val cep = "123456789"
        assertFalse(Validator.isCEP(cep))
    }

    @Test
    fun `test isDate with valid date`() {
        val date = "2022-01-01"
        assertTrue(Validator.isDate(date))
    }

    @Test
    fun `test isDate with invalid date`() {
        val date = "01-01-2022"
        assertFalse(Validator.isDate(date))
    }

    @Test
    fun `test isDecimal with valid decimal value`() {
        val value = "3.14"
        assertTrue(Validator.isDecimal(value))
    }

    @Test
    fun `test isDecimal with invalid decimal value`() {
        val value = "3.14.15"
        assertFalse(Validator.isDecimal(value))
    }

    @Test
    fun `test isMACAddress with valid MAC address`() {
        val macAddress = "00:11:22:33:44:55"
        assertTrue(Validator.isMACAddress(macAddress))
    }

    @Test
    fun `test isMACAddress with invalid MAC address`() {
        val macAddress = "00:11:22:33:44"
        assertFalse(Validator.isMACAddress(macAddress))
    }

    @Test
    fun `test isMD5 with valid MD5 value`() {
        val value = "d41d8cd98f00b204e9800998ecf8427e"
        assertTrue(Validator.isMD5(value))
    }

    @Test
    fun `test isMD5 with invalid MD5 value`() {
        val value = "Hello World"
        assertFalse(Validator.isMD5(value))
    }

    @Test
    fun `test isNumber with valid number`() {
        val value = "12345"
        assertTrue(Validator.isNumber(value))
    }

    @Test
    fun `test isNumber with invalid number`() {
        val value = "12345a"
        assertFalse(Validator.isNumber(value))
    }

    @Test
    fun `test isPort with valid port number`() {
        val port = 8080
        assertTrue(Validator.isPort(port))
    }

    @Test
    fun `test isPort with invalid port number`() {
        val port = -1
        assertFalse(Validator.isPort(port))
    }

    @Test
    fun `test isPostalCode with valid postal code`() {
        val postalCode = "12345"
        assertTrue(Validator.isPostalCode(postalCode))
    }

    @Test
    fun `test isPostalCode with invalid postal code`() {
        val postalCode = "ABCDE"
        assertFalse(Validator.isPostalCode(postalCode))
    }

    @Test
    fun `test isTime with valid time`() {
        val time = "12:34"
        assertTrue(Validator.isTime(time))
    }

    @Test
    fun `test isTime with invalid time`() {
        val time = "25:00"
        assertFalse(Validator.isTime(time))
    }
}