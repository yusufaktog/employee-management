package com.aktog.yusuf.employeeManagement.dto

data class EmployeeDto @JvmOverloads constructor(
    val id:String? = "",
    val name : String,
    val surname: String,
    val addressIds: Set<String>? = HashSet(),
    val departmentId:String? = ""
)
