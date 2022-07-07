package com.aktog.yusuf.employeeManagement.dto.request.update

import com.fasterxml.jackson.annotation.JsonInclude
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty

data class UpdateEmployeeRequest @JvmOverloads constructor(
    @field:NotBlank
    val name: String,

    @field:NotBlank
    val surname: String,

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    val addressIds: List<String>? = ArrayList(),

    @field:NotBlank
    val departmentId: String? = "",
)
