package com.aktog.yusuf.employeeManagement.entity

import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Entity
data class Address @JvmOverloads constructor(
    @Id
    @Column(name = "address_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id:String? = " ",
    val country:String,
    val city:String,
    val street:String,
    val buildingNumber:Int,
    val apartmentNumber:Int,
    val zipCode:Int,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="employee_id")
    val employee:Employee? = null

) {

    override fun toString(): String {
        return "$employee.name $employee.surname\n$street, no:$buildingNumber, aptNo:$apartmentNumber\n$city, $country\n$zipCode"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Address

        if (id != other.id) return false
        if (employee != other.employee) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + (employee?.hashCode() ?: 0)
        return result
    }
}
