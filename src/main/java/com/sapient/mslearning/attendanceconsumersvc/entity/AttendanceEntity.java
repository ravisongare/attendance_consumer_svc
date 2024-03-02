package com.sapient.mslearning.attendanceconsumersvc.entity;

import com.sapient.mslearning.attendanceconsumersvc.enums.AttendanceStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.naming.Name;
import java.io.Serializable;
import java.sql.Date;

@ToString
@Entity(name = "attendance")
//@IdClass(PrimaryKey.class)
@NoArgsConstructor
public class AttendanceEntity implements Serializable {
    @Id
   @Column(name="emp_id")
    int empId;

    @Column(name = "attendance_status",nullable = false)
    String attendanceStatus;

    //@Id
    @Column(name = "date")
    Date date;

    @Column(name = "employee_time_mins")
    double totalMins;

    String Remark;

    public AttendanceEntity(int empId, AttendanceStatusEnum attendanceStatus, Date date, String remark) {
        this.empId = empId;
        this.attendanceStatus = attendanceStatus.name();
        this.date = date;
        Remark = remark;
    }

    public double getTotalMins() {
        return totalMins;
    }

    public void setTotalMins(double totalMins) {
        this.totalMins = totalMins;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getAttendanceStatus() {
        return attendanceStatus;
    }

    public void setAttendanceStatus(AttendanceStatusEnum attendanceStatus) {
        this.attendanceStatus = attendanceStatus.name();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }
}
