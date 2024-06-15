package com.gonomad.template.domain.common.exception

enum class ErrorMessage(val message: String) {
    // COMMON
    COMMON_ERROR("일시적으로 오류가 발생했습니다."),
    NOT_FOUND_DATA("데이터가 존재하지 않습니다."),
    FORBIDDEN_RESOURCE("접근 권한이 없습니다"),

    UNKNOWN("잠시 후 다시 시도해주세요."),

    UNAUTHORIZED("인증에 실패했습니다."),
    ILLEGAL_STATE("올바르지 않은 상태입니다."),
    INVALID_PARAMETER("invalid password reset code"),
    ;
}
