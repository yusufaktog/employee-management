package com.aktog.yusuf.employeeManagement.dto.request.update

import com.fasterxml.jackson.annotation.JsonInclude
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty

data class UpdateDepartmentRequest @JvmOverloads constructor(

    @field:NotBlank
    val name: String,

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    val addressId: String?  = ""
)