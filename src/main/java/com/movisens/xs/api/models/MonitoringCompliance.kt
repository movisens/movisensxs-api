package com.movisens.xs.api.models

import com.google.gson.annotations.Expose

class MonitoringCompliance(
    probandId: Long,
    date: String,
    name: String,
    message: String,
    includeInMail: Boolean,
    @field:Expose private val category: Category,
    @field:Expose private val value: Int
) : Monitoring(probandId, date, MonitoringType.COMPLIANCE, name, message, includeInMail) {
    enum class Category {
        FORMS, MOBILE_SENSING, SENSORS
    }
}