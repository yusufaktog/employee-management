package com.aktog.yusuf.employeeManagement.dto

import com.fasterxml.jackson.annotation.JsonInclude

data class AddressDto @JvmOverloads constructor(

    val id: String? = "",
    val country: String,
    val city: String,
    val street: String,
    val buildingNumber: Int,
    val apartmentNumber: Int,
    val zipCode: Int,

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    val employeeIds:Set<String>? = HashSet()
)
