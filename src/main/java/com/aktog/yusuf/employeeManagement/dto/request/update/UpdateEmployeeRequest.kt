package com.aktog.yusuf.employeeManagement.dto.request.update

data class UpdateEmployeeRequest(
    val name: String,
    val surname: String,
    val addressId: String? = "",
    val departmentId: String? = "",
)
