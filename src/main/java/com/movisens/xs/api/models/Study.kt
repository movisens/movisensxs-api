package com.movisens.xs.api.models

import com.google.gson.annotations.Expose

data class Study(
    @field:Expose val id: Int,
    @field:Expose val name: String
)