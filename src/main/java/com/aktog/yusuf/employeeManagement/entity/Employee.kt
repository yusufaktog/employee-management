package com.aktog.yusuf.employeeManagement.entity

import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

data class Employee @JvmOverloads constructor(
    @Id
    @Column(name = "employee_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id:String? = "",

    @OneToMany(mappedBy = "ownerName", fetch = FetchType.LAZY)
    val addresses: Set<Address>? = HashSet(),

    val name:String,
    val surname:String,

    @OneToOne()
    val department:Department,


)
