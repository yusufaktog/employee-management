package com.aktog.yusuf.employeeManagement.dto

import com.fasterxml.jackson.annotation.JsonInclude
import java.time.LocalDateTime

data class DepartmentDto @JvmOverloads constructor(

    val id:String? = "",
    val name:String,
    val creationDate:LocalDateTime,

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    val employeeIds:Set<String>? = HashSet()
)
