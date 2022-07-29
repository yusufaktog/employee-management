package com.aktog.yusuf.employeeManagement.entity

import org.hibernate.annotations.GenericGenerator
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
    val salary:Int,

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    val addresses: Set<Address>,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="department_id")
    val department:Department,
)
