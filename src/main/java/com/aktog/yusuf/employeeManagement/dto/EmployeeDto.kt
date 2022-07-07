package com.aktog.yusuf.employeeManagement.dto

import com.fasterxml.jackson.annotation.JsonInclude

data class EmployeeDto @JvmOverloads constructor(
    val id:String? = "",
    val name : String,
    val surname: String,

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    val addressIds: Set<String>? = HashSet(),

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    val departmentId:String? = ""
)
