package com.aktog.yusuf.employeeManagement.entity

import org.hibernate.annotations.GenericGenerator
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Department(
    @Id
    @Column(name = "department_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id:String? = " ",

    val name:String,
    val creationDate: LocalDateTime,

    val address: Address,

    @OneToMany(mappedBy = "department")
    val employees: Set<Employee>? = HashSet()

) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Department

        if (id != other.id) return false
        if (name != other.name) return false
        if (creationDate != other.creationDate) return false
        if (employees != other.employees) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + name.hashCode()
        result = 31 * result + creationDate.hashCode()
        result = 31 * result + (employees?.hashCode() ?: 0)
        return result
    }
}
