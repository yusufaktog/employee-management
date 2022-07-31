package com.aktog.yusuf.employeeManagement.dto.request.create

import java.util.Date
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Past
import javax.validation.constraints.Positive

data class CreateEmployeeRequest(

    @field:NotBlank
    val name:String,

    @field:NotBlank
    val surname:String,

    @field:Email
    val email:String,

    @field:Past
    val birthDate:Date,

    @field:Positive
    val salary:Int,

)
