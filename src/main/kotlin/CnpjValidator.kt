import java.util.*

class CnpjValidator private constructor() {
    init {
        throw IllegalStateException("Utility class")
    }

    companion object {
        private fun calculateFirstVerifier(cnpjBase: IntArray): Int {
            val weight = intArrayOf(5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2)
            var sum = 0

            for (i in 0..11) {
                sum += cnpjBase[i] * weight[i]
            }
            val remainder = sum % 11

            return if (remainder < 2) 0 else 11 - remainder
        }

        private fun calculateSecondVerifier(cnpjBase: IntArray, firstVerifier: Int): Int {
            val weight = intArrayOf(6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2)
            var sum = 0

            for (i in 0..11) {
                sum += cnpjBase[i] * weight[i]
            }
            sum += firstVerifier * weight[12]

            val remainder = sum % 11

            return if (remainder < 2) 0 else 11 - remainder
        }

        @JvmStatic
        fun cnpjIsValid(cnpj: String?): Boolean {
            if (cnpj.isNullOrEmpty()) {
                throw NullPointerException("CNPJ cannot be null or empty")
            }

            val cnpjClean = cnpj.replace("\\D".toRegex(), "")

            if (cnpjClean.isEmpty()) {
                return false
            }

            if (cnpjClean.length != 14) {
                return false
            }

            // Convert the string to an array of integers
            val cnpjArray = cnpjClean.chars().map { codePoint: Int -> Character.getNumericValue(codePoint) }.toArray()

            // Calculate the first verifier and second verifier
            val cnpjBase = Arrays.copyOfRange(cnpjArray, 0, 12)
            val firstVerifier = calculateFirstVerifier(cnpjBase)

            val cnpjBaseWithFirstVerifier = cnpjBase.copyOf(cnpjBase.size + 1)
            cnpjBaseWithFirstVerifier[cnpjBaseWithFirstVerifier.size - 1] = firstVerifier

            val secondVerifier = calculateSecondVerifier(cnpjBaseWithFirstVerifier, firstVerifier)

            return cnpjArray[12] == firstVerifier && cnpjArray[13] == secondVerifier
        }
    }
}
