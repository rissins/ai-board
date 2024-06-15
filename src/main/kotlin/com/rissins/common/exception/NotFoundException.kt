package com.rissins.common.exception

import com.gonomad.template.domain.common.exception.DomainException
import com.gonomad.template.domain.common.exception.ErrorMessage
import org.springframework.http.HttpStatus
import kotlin.reflect.KClass

class NotFoundException : DomainException {
    constructor(
        clazz: KClass<*>,
        extId: String = "",
        detail: String = "",
        errorMessage: ErrorMessage = ErrorMessage.NOT_FOUND_DATA,
    ) : super(
        "${clazz.simpleName!!.uppercase()}를 찾을 수 없습니다.${appendExtId(extId)}${appendDetail(detail)}",
        errorMessage,
        HttpStatus.NOT_FOUND,
    )

    constructor(
        clazz: KClass<*>,
        id: Long,
        detail: String = "",
        errorMessage: ErrorMessage = ErrorMessage.NOT_FOUND_DATA,
    ) : super(
        "${clazz.simpleName!!.uppercase()}를 찾을 수 없습니다.${appendId(id)}${appendDetail(detail)}",
        errorMessage,
        HttpStatus.NOT_FOUND,
    )

    constructor(
        detail: String,
        errorMessage: ErrorMessage = ErrorMessage.NOT_FOUND_DATA,
        cause: Throwable? = null,
    ) : super(errorMessage, detail, cause)

    companion object {
        fun appendId(id: Long): String {
            return " id => $id"
        }

        fun appendExtId(extId: String): String {
            return if (extId.isNotBlank()) " extId => $extId" else ""
        }

        private fun appendDetail(detail: String): String {
            return if (detail.isNotBlank()) ", detail => $detail" else ""
        }
    }
}
