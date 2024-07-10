import java.util.regex.Pattern
import java.util.stream.IntStream

class CpfValidator private constructor() {
    init {
        throw IllegalStateException("Utility class")
    }

    companion object {
        @JvmStatic
        fun cpfIsValid(cpf: String?): Boolean {
            if (cpf.isNullOrEmpty()) {
                throw NullPointerException("CPF cannot be null or empty")
            }

            val cpfClean = cpf.replace("\\D".toRegex(), "")

            if (cpfClean.length != 11) {
                return false
            }

            val pattern = Pattern.compile("(\\d)\\1{10}")
            val matcher = pattern.matcher(cpfClean)

            if (matcher.find()) {
                return false
            }

            val cpfArray = cpfClean.chars().map { codePoint: Int -> Character.getNumericValue(codePoint) }.toArray()

            val sum1 = IntStream.range(0, 9).map { i: Int -> cpfArray[i] * (10 - i) }.sum()
            val sum2 = IntStream.range(0, 10).map { i: Int -> cpfArray[i] * (11 - i) }.sum()

            val validator1 = if (sum1 % 11 < 2) 0 else 11 - (sum1 % 11)
            val validator2 = if (sum2 % 11 < 2) 0 else 11 - (sum2 % 11)

            return cpfArray[9] == validator1 && cpfArray[10] == validator2
        }
    }
}
