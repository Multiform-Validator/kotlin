import java.util.*
import java.util.regex.Pattern

class EmailValidator private constructor() {
    init {
        throw IllegalStateException("Utility class")
    }

    companion object {
        @JvmStatic
        fun isEmail(email: String?): Boolean {
            if (email == null) {
                throw NullPointerException("Email cannot be null")
            }

            val startsWithSpecialChar = Pattern.compile("^[^a-zA-Z0-9]")

            if (startsWithSpecialChar.matcher(email).find()) {
                return false
            }

            val regex = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")

            if (!regex.matcher(email).find()) {
                return false
            }

            val beforeAt = email.indexOf("@")
            val afterAt = email.indexOf("@") + 1
            val afterLastDot = email.lastIndexOf(".")

            if (Character.isDigit(email[afterAt])) {
                return false
            }

            if (Character.isDigit(email[afterLastDot])) {
                return false
            }

            if (email.substring(0, beforeAt).contains("..")) {
                return false
            }

            if (email.substring(0, beforeAt).endsWith(".")) {
                return false
            }

            val parts = email.split("\\.".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()

            if (parts.size > 2 && parts[parts.size - 2] == parts[parts.size - 3]) {
                return false
            }

            // Check if there is more than one @
            if (email.split("@".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray().size - 1 > 1) {
                return false
            }

            if (email.substring(afterAt).contains("..")) {
                return false
            }

            val domainParts =
                email.split("@".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[1].split("\\.".toRegex())
                    .dropLastWhile { it.isEmpty() }
                    .toTypedArray()
            val uniqueDomainParts: Set<String> = HashSet(Arrays.asList(*domainParts))

            return domainParts.size == uniqueDomainParts.size
        }
    }
}
