package com.aktog.yusuf.employeeManagement.entity

import org.hibernate.annotations.GenericGenerator
import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.Id

data class Department(
    @Id
    @Column(name = "department_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id:String? = " "
)
