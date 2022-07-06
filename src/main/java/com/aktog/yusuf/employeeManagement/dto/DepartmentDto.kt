package com.aktog.yusuf.employeeManagement.dto

import java.time.LocalDateTime

data class DepartmentDto @JvmOverloads constructor(
    val id:String? = "",
    val name:String,
    val creationDate:LocalDateTime,
    val employeeIds:Set<String>? = HashSet()
)
