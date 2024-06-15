package com.gonomad.template.domain.common.exception

import org.springframework.http.HttpStatus

open class DomainException(
    val errorMessage: ErrorMessage = DEFAULT_ERROR_MESSAGE,
    val detail: String = "",
    val status: HttpStatus = DEFAULT_HTTP_STATUS,
    override val cause: Throwable? = null,
) : RuntimeException(detail.ifBlank { errorMessage.message.ifBlank { DEFAULT_DETAIL } }, cause) {

    companion object {
        val DEFAULT_ERROR_MESSAGE = ErrorMessage.COMMON_ERROR
        val DEFAULT_HTTP_STATUS = HttpStatus.INTERNAL_SERVER_ERROR
        const val DEFAULT_DETAIL = "서버 내부 에러가 발생했습니다."
    }

    constructor(errorMessage: ErrorMessage) : this(errorMessage, DEFAULT_DETAIL, DEFAULT_HTTP_STATUS, null)
    constructor(errorMessage: ErrorMessage, cause: Throwable?) : this(errorMessage, DEFAULT_DETAIL, DEFAULT_HTTP_STATUS, cause)
    constructor(errorMessage: ErrorMessage, detail: String) : this(errorMessage, detail, DEFAULT_HTTP_STATUS, null)
    constructor(errorMessage: ErrorMessage, detail: String, cause: Throwable?) : this(errorMessage, detail, DEFAULT_HTTP_STATUS, cause)
    constructor(errorMessage: ErrorMessage, statue: HttpStatus) : this(errorMessage, DEFAULT_DETAIL, statue, null)
    constructor(errorMessage: ErrorMessage, statue: HttpStatus, cause: Throwable?) : this(errorMessage, DEFAULT_DETAIL, statue, cause)
    constructor(errorMessage: ErrorMessage, statue: HttpStatus, detail: String) : this(errorMessage, detail, statue, null)
    constructor(errorMessage: ErrorMessage, statue: HttpStatus, detail: String, cause: Throwable?) : this(errorMessage, detail, statue, cause)
    constructor(detail: String) : this(DEFAULT_ERROR_MESSAGE, detail, DEFAULT_HTTP_STATUS, null)
    constructor(detail: String, cause: Throwable?) : this(DEFAULT_ERROR_MESSAGE, detail, DEFAULT_HTTP_STATUS, cause)
    constructor(detail: String, errorMessage: ErrorMessage) : this(errorMessage, detail, DEFAULT_HTTP_STATUS, null)
    constructor(detail: String, errorMessage: ErrorMessage, cause: Throwable?) : this(errorMessage, detail, DEFAULT_HTTP_STATUS, cause)
    constructor(detail: String, errorMessage: ErrorMessage, status: HttpStatus) : this(errorMessage, detail, status, null)
    constructor(detail: String, errorMessage: ErrorMessage, status: HttpStatus, cause: Throwable?) : this(errorMessage, detail, status, cause)
    constructor(statue: HttpStatus, detail: String) : this(DEFAULT_ERROR_MESSAGE, detail, statue, null)
    constructor(statue: HttpStatus, detail: String, cause: Throwable?) : this(DEFAULT_ERROR_MESSAGE, detail, statue, cause)
    constructor(statue: HttpStatus, errorMessage: ErrorMessage, detail: String) : this(errorMessage, detail, statue, null)
    constructor(statue: HttpStatus, errorMessage: ErrorMessage, detail: String, cause: Throwable?) : this(errorMessage, detail, statue, cause)
}
