package com.pageNation.pagenationdata.entity;

import com.pageNation.pagenationdata.enums.Designation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Table
@Entity
public class Employee {
@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
@Column(nullable = false)
private  String name;
@Column(length = 18-60)
private  int age;
@Column(nullable = false)
private  String city;

@Column(name = "phone_number")
private  String phoneNumber;

private Float salary ;
@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "department_id")
    private Department department;
@Enumerated(EnumType.ORDINAL )
    private Designation designation;
}
