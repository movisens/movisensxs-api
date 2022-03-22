package com.movisens.xs.api.models

import com.google.gson.annotations.Expose

class MonitoringFeedback(
    probandId: Long,
    date: String,
    type: MonitoringType,
    name: String,
    message: String,
    includeInMail: Boolean
) : Monitoring(probandId, date, type, name, message, includeInMail) {
    @Expose
    var sendAsInAppMessage = false
}