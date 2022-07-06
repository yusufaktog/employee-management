package com.aktog.yusuf.employeeManagement.dto.request.create

import java.time.LocalDate

data class CreateDepartmentRequest @JvmOverloads constructor(
    val name:String,
    val creationDate:LocalDate,
    val employeeIds:Set<String>? = HashSet()
)
