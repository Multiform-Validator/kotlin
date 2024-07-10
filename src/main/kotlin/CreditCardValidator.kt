class CreditCardValidator private constructor() {
    init {
        throw IllegalStateException("Utility class")
    }

    companion object {
        private const val INPUT_VALUE_CANNOT_BE_EMPTY = "Input value cannot be empty."

        @JvmStatic
        fun isCreditCardValid(creditCard: String?): Boolean {
            require(!creditCard.isNullOrEmpty()) { INPUT_VALUE_CANNOT_BE_EMPTY }

            val creditCardString = creditCard.replace("\\D".toRegex(), "")

            if (creditCardString.length < 13 || creditCardString.length > 19) {
                return false
            }

            var sum = 0
            var alternate = false

            for (i in creditCardString.length - 1 downTo 0) {
                var n = creditCardString.substring(i, i + 1).toInt()

                if (alternate) {
                    n *= 2

                    if (n > 9) {
                        n = (n % 10) + 1
                    }
                }

                sum += n
                alternate = !alternate
            }

            return sum % 10 == 0
        }

        @JvmStatic
        fun identifyFlagCard(cardNumber: String?): String {
            require(!cardNumber.isNullOrEmpty()) { "The input should be a string." }

            val flags = arrayOf(
                arrayOf("Visa", "^4[0-9]{12}(?:[0-9]{3})?$"),
                arrayOf("Mastercard", "^5[1-5][0-9]{14}$"),
                arrayOf("American Express", "^3[47][0-9]{13}$"),
                arrayOf("Discover", "^6(?:011|5[0-9]{2})[0-9]{12}$"),
                arrayOf("JCB", "^(?:2131|1800|35[0-9]{3})[0-9]{11}$"),
                arrayOf("Diners Club", "^3(?:0[0-5]|[68][0-9])[0-9]{11}$"),
                arrayOf("Maestro", "^(?:5[0678][0-9]{2}|6304|6390|67[0-9]{2})[0-9]{12,15}$"),
                arrayOf("UnionPay", "^(62|88)[0-9]{14,17}$"),
                arrayOf("Elo", "^63[789][0-9]{13}$"),
                arrayOf("Hipercard", "^(3841[0-9]{12}|60[0-9]{14})$")
            )

            for (flag in flags) {
                if (cardNumber.matches(flag[1].toRegex())) {
                    return flag[0]
                }
            }

            return "Unknown"
        }
    }
}
