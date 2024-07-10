class Validator private constructor() {
    init {
        throw IllegalStateException("Utility class")
    }

    companion object {
        private const val INPUT_VALUE_CANNOT_BE_EMPTY = "Input value cannot be empty."

        @JvmStatic
        fun isAscii(value: String?): Boolean {
            require(!value.isNullOrEmpty()) { INPUT_VALUE_CANNOT_BE_EMPTY }

            return value.chars().allMatch { c: Int -> c < 128 }
        }

        @JvmStatic
        fun isBase64(value: String?): Boolean {
            require(!value.isNullOrEmpty()) { INPUT_VALUE_CANNOT_BE_EMPTY }

            return value.matches("^(?:[A-Za-z0-9+/]{4})*(?:[A-Za-z0-9+/]{2}==|[A-Za-z0-9+/]{3}=)?$".toRegex())
        }

        @JvmStatic
        fun isCEP(cep: String): Boolean {
            if (cep.length < 8 || cep.length > 10) {
                return false
            }

            val cepString = cep.replace("\\D".toRegex(), "")

            if (cepString.length != 8) {
                return false
            }

            try {
                cepString.toInt()
            } catch (e: NumberFormatException) {
                return false
            }

            return true
        }

        @JvmStatic
        fun isDate(date: String?): Boolean {
            require(!date.isNullOrEmpty()) { INPUT_VALUE_CANNOT_BE_EMPTY }

            return date.matches("^\\d{4}-\\d{2}-\\d{2}$".toRegex())
        }


        @JvmStatic
        fun isDecimal(value: String?): Boolean {
            require(!value.isNullOrEmpty()) { INPUT_VALUE_CANNOT_BE_EMPTY }

            try {
                val parsedValue = value.toDouble()

                return parsedValue % 1 != 0.0
            } catch (e: NumberFormatException) {
                return false
            }
        }

        @JvmStatic
        fun isMACAddress(macAddress: String?): Boolean {
            require(!macAddress.isNullOrEmpty()) { INPUT_VALUE_CANNOT_BE_EMPTY }

            return macAddress.matches("^([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$".toRegex())
        }

        @JvmStatic
        fun isMD5(value: String?): Boolean {
            require(!value.isNullOrEmpty()) { INPUT_VALUE_CANNOT_BE_EMPTY }

            return value.matches("^[a-fA-F0-9]{32}$".toRegex())
        }

        @JvmStatic
        fun isNumber(value: String?): Boolean {
            require(!value.isNullOrEmpty()) { INPUT_VALUE_CANNOT_BE_EMPTY }

            return value.matches("^-?\\d+$".toRegex())
        }

        @JvmStatic
        fun isPort(port: Int): Boolean {
            return port in 0..65535
        }

        @JvmStatic
        fun isPort(port: String?): Boolean {
            require(!port.isNullOrEmpty()) { INPUT_VALUE_CANNOT_BE_EMPTY }

            try {
                val portNumber = port.toInt()
                return portNumber in 0..65535
            } catch (e: NumberFormatException) {
                return false
            }
        }

        @JvmStatic
        fun isPostalCode(postalCode: String?): Boolean {
            require(!postalCode.isNullOrEmpty()) { "Input value must be a string." }

            val usZipCodeRegex = "^\\d{5}(-\\d{4})?$"
            val canadaPostalCodeRegex = "^[A-Za-z]\\d[A-Za-z] \\d[A-Za-z]\\d$"
            val ukPostalCodeRegex = "^[A-Za-z]{1,2}\\d[A-Za-z\\d]? \\d[A-Za-z]{2}$"
            val francePostalCodeRegex = "^\\d{5}$"
            val netherlandsPostalCodeRegex = "^\\d{4}$"
            val japanPostalCodeRegex = "^\\d{3}-\\d{4}$"
            val spainPostalCodeRegex = "^\\d{5}$"
            val southAfricaPostalCodeRegex = "^\\d{4}$"
            val germanyPostalCodeRegex = "^\\d{5}$"
            val switzerlandPostalCodeRegex = "^\\d{4}$"
            val brazilPostalCodeRegex = "^\\d{5}-\\d{3}$"
            val italyPostalCodeRegex = "^\\d{5}$"
            val usZipCodeOnlyRegex = "^\\d{5}$"

            return postalCode.matches(usZipCodeRegex.toRegex()) ||
                    postalCode.matches(canadaPostalCodeRegex.toRegex()) ||
                    postalCode.matches(ukPostalCodeRegex.toRegex()) ||
                    postalCode.matches(francePostalCodeRegex.toRegex()) ||
                    postalCode.matches(netherlandsPostalCodeRegex.toRegex()) ||
                    postalCode.matches(japanPostalCodeRegex.toRegex()) ||
                    postalCode.matches(spainPostalCodeRegex.toRegex()) ||
                    postalCode.matches(southAfricaPostalCodeRegex.toRegex()) ||
                    postalCode.matches(germanyPostalCodeRegex.toRegex()) ||
                    postalCode.matches(switzerlandPostalCodeRegex.toRegex()) ||
                    postalCode.matches(brazilPostalCodeRegex.toRegex()) ||
                    postalCode.matches(italyPostalCodeRegex.toRegex()) ||
                    postalCode.matches(usZipCodeOnlyRegex.toRegex())
        }

        @JvmStatic
        fun isTime(time: String?): Boolean {
            require(!time.isNullOrEmpty()) { INPUT_VALUE_CANNOT_BE_EMPTY }

            return time.matches("^(?:2[0-3]|1\\d|0?[0-9]):[0-5]\\d(?::[0-5]\\d)?(?: [APap][Mm])?$".toRegex())
        }
    }
}
