package com.aktog.yusuf.employeeManagement.dto.request.update

data class UpdateAddressRequest(
    val country:String,
    val city:String,
    val street:String,
    val buildingNumber:Int,
    val apartmentNumber:Int,
    val zipCode:Int,
)