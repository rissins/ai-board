package com.rissins.aiboard.entity

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import org.hibernate.annotations.DynamicUpdate
import org.hibernate.annotations.SQLDelete
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.OffsetDateTime

@Entity
@Table
@EntityListeners(AuditingEntityListener::class)
@DynamicUpdate
@SQLDelete(sql = "UPDATE post SET deleted = true, deleted_at = sysdate() WHERE id = ?")
class Post(
    val title: String,
    val content: String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    var view: Int = 0

    @CreationTimestamp
    lateinit var createdAt: OffsetDateTime

    @UpdateTimestamp
    lateinit var updatedAt: OffsetDateTime

    var deleted: Boolean = false

    lateinit var deletedAt: OffsetDateTime

    fun plusView() = this.view++
}
