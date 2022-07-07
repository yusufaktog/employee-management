package com.aktog.yusuf.employeeManagement.dto.request.update

import com.fasterxml.jackson.annotation.JsonInclude
import java.time.LocalDate
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Past

data class UpdateDepartmentRequest @JvmOverloads constructor(
    @field:NotBlank
    val name: String,

    @field:Past
    val creationDate: LocalDate,

    @field:NotEmpty
    val employeeIds: Set<String>? = HashSet(),

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    val addressId: String?  = ""
)