package com.rissins.aiboard.jpa

import com.rissins.common.exception.NotFoundException
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.repository.NoRepositoryBean
import org.springframework.data.repository.findByIdOrNull

inline fun <reified T, ID> JpaCustomRepository<T, ID>.findByIdOrThrow(
    id: ID,
    errorMsg: String = "${T::class.simpleName}를 찾을 수 없습니다. id => $id",
): T {
    return this.findByIdOrNull(id) ?: throw NotFoundException(errorMsg)
}

@NoRepositoryBean
interface JpaCustomRepository<T, ID> : JpaRepository<T, ID>, JpaSpecificationExecutor<T>
