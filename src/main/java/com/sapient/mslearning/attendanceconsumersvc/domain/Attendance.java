package com.sapient.mslearning.attendanceconsumersvc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Attendance implements Serializable {
    int empId;
    String attendanceStatus;
    Date date;
    double totalMins;
    String remark;
}
