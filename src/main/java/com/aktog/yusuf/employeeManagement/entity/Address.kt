package com.aktog.yusuf.employeeManagement.entity

import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

data class Address @JvmOverloads constructor(
    @Id
    @Column(name = "address_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id:String? = "",
    val country:String,
    val city:String,
    val street:String,
    val buildingNumber:Int,
    val apartmentNumber:Int,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="employee_id", referencedColumnName = "employee_id")
    val employee:Employee

) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Address

        if (id != other.id) return false
        if (country != other.country) return false
        if (city != other.city) return false
        if (street != other.street) return false
        if (buildingNumber != other.buildingNumber) return false
        if (apartmentNumber != other.apartmentNumber) return false
        if ( (employee.name + employee.surname) != (employee.name + employee.surname) ) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + country.hashCode()
        result = 31 * result + city.hashCode()
        result = 31 * result + street.hashCode()
        result = 31 * result + buildingNumber
        result = 31 * result + apartmentNumber
        result = 31 * result + ( (employee.name + employee.surname).hashCode() )
        return result
    }

    override fun toString(): String {
        return "$employee.name $employee.surname\n$street, no:$buildingNumber, aptNo:$apartmentNumber\n$city, $country"
    }
}
