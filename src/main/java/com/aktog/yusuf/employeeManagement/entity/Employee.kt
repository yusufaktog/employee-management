package com.aktog.yusuf.employeeManagement.entity

import org.hibernate.annotations.GenericGenerator
import java.util.Date
import javax.persistence.*

@Entity
data class Employee @JvmOverloads constructor(
    @Id
    @Column(name = "employee_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id:String? = "",
    val name:String,
    val surname:String,
    val email:String,
    val birthDate:Date,
    val salary:Int,

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "employee_addresses",
        joinColumns = [JoinColumn(name = "employee_id", referencedColumnName = "employee_id")],
        inverseJoinColumns = [JoinColumn(name = "address_id", referencedColumnName = "address_id")]
    )
    val addresses: Set<Address>,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="department_id")
    val department:Department,
) {
    override fun toString(): String {
        return "Employee(id=$id, name='$name', surname='$surname', salary=$salary)"
    }
}
