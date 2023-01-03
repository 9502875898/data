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
public class Department {
@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
@Column(length = 60,name = "dept_name")
private  String  deptName;

@Column(name = "office_time")
private String OfficeTimes;
@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "employee_id")
    private Employee employee;
@Enumerated
    private Designation designation;


}
