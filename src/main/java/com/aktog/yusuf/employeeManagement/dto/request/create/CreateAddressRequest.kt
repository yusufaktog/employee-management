package com.aktog.yusuf.employeeManagement.dto.request.create

data class CreateAddressRequest(
    val country:String,
    val city:String,
    val street:String,
    val buildingNumber:Int,
    val apartmentNumber:Int,
    val zipCode:Int,
)