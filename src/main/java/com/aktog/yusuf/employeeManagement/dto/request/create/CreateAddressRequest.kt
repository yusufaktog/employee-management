package com.aktog.yusuf.employeeManagement.dto.request.create

import org.jetbrains.annotations.NotNull
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Positive

data class CreateAddressRequest(

    @field:NotBlank
    val country:String,

    @field:NotBlank
    val city:String,

    @field:NotBlank
    val street:String,

    @field:Positive
    val buildingNumber:Int,

    @field:Positive
    val apartmentNumber:Int,

    @field:Positive
    val zipCode:Int,
)