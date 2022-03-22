package com.movisens.xs.api.models

import com.google.gson.annotations.Expose

class Message {
    @Expose
    var id: Long = 0

    @Expose
    var creationDate: String? = null

    @Expose
    var message: String? = null

    @Expose
    var isMessageRead = false

    @Expose
    var isFromProband = false

    @Expose
    var sendingUserEmail: String? = null
    override fun toString(): String {
        return "Message{" +
                "id=" + id +
                ", creationDate='" + creationDate + '\'' +
                ", message='" + message + '\'' +
                ", messageRead=" + isMessageRead +
                ", fromProband=" + isFromProband +
                ", sendingUserEmail='" + sendingUserEmail + '\'' +
                '}'
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Message

        if (id != other.id) return false
        if (creationDate != other.creationDate) return false
        if (message != other.message) return false
        if (isMessageRead != other.isMessageRead) return false
        if (isFromProband != other.isFromProband) return false
        if (sendingUserEmail != other.sendingUserEmail) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + (creationDate?.hashCode() ?: 0)
        result = 31 * result + (message?.hashCode() ?: 0)
        result = 31 * result + isMessageRead.hashCode()
        result = 31 * result + isFromProband.hashCode()
        result = 31 * result + (sendingUserEmail?.hashCode() ?: 0)
        return result
    }
}