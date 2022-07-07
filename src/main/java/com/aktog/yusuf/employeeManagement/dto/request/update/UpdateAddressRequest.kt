package com.aktog.yusuf.employeeManagement.dto.request.update

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Positive

data class UpdateAddressRequest @JvmOverloads constructor(
    @field:NotBlank
    val country: String? = "",

    @field:NotBlank
    val city: String? = "",

    @field:NotBlank
    val street: String? = "",

    @field:Positive
    val buildingNumber: Int? = 1,

    @field:Positive
    val apartmentNumber: Int? = 1,

    @field:Positive
    val zipCode: Int? = 1,
)