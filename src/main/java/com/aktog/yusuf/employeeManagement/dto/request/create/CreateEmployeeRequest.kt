package com.aktog.yusuf.employeeManagement.dto.request.create

import org.jetbrains.annotations.NotNull
import javax.validation.constraints.NotBlank

data class CreateEmployeeRequest @JvmOverloads constructor(

    @field:NotBlank
    val name:String,

    @field:NotBlank
    val surname:String,

    @field:NotBlank
    val addressId:String? = "",

    @field:NotBlank
    val departmentId:String? = "",
)
