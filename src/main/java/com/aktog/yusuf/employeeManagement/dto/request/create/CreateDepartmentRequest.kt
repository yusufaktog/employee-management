package com.aktog.yusuf.employeeManagement.dto.request.create

import com.fasterxml.jackson.annotation.JsonInclude
import java.time.LocalDate
import java.time.LocalDateTime
import javax.validation.constraints.NotBlank
import javax.validation.constraints.PastOrPresent

data class CreateDepartmentRequest @JvmOverloads constructor(

    @field:NotBlank
    val name:String,

    @field:PastOrPresent
    val creationDate: LocalDateTime,

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    val employeeIds:Set<String>? = HashSet()
)
