package com.aktog.yusuf.employeeManagement.dto

import com.fasterxml.jackson.annotation.JsonInclude
import java.util.*
import kotlin.collections.HashSet

data class EmployeeDto @JvmOverloads constructor(

    val id:String? = "",
    val name : String,
    val surname: String,
    val email:String,
    val birthDate: Date,
    val salary:Int,

    val departmentName:String? = "",

    val addressIds: Set<String>? = HashSet(),

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    val departmentId:String? = ""
)
