package exception

class ErrorException(message: String?, cause: Throwable?) : Exception(message, cause) {
    constructor(message: String) : this(message, null)
    constructor(cause: Throwable) : this(null, cause)
}
