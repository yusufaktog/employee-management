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

    @ManyToMany(mappedBy = "addresses", fetch = FetchType.LAZY)
    val employees:Set<Employee>? = HashSet()

) {


    override fun toString(): String {
        return "Address(id=$id, country='$country', city='$city', street='$street'," +
                " buildingNumber=$buildingNumber, apartmentNumber=$apartmentNumber, zipCode=$zipCode)"
    }

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
        if (zipCode != other.zipCode) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + country.hashCode()
        result = 31 * result + city.hashCode()
        result = 31 * result + street.hashCode()
        result = 31 * result + buildingNumber
        result = 31 * result + apartmentNumber
        result = 31 * result + zipCode
        return result
    }
}
