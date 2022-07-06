package com.aktog.yusuf.employeeManagement.dto.request.update

import java.time.LocalDate

data class UpdateDepartmentRequest @JvmOverloads constructor(
    val name: String,
    val creationDate: LocalDate,
    val employeeIds: Set<String>? = HashSet()
)