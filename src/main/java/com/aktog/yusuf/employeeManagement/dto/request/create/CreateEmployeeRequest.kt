package com.aktog.yusuf.employeeManagement.dto.request.create

import org.jetbrains.annotations.NotNull
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Positive

data class CreateEmployeeRequest(

    @field:NotBlank
    val name:String,

    @field:NotBlank
    val surname:String,

    @field:Positive
    val salary:Int,

)
