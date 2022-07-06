package com.aktog.yusuf.employeeManagement.dto.request.create

data class CreateEmployeeRequest @JvmOverloads constructor(
    val name:String,
    val surname:String,
    val addressId:String? = "",
    val departmentId:String? = "",
)
