package com.sapient.mslearning.attendanceconsumersvc.service;

import com.sapient.mslearning.attendanceconsumersvc.domain.Attendance;
import com.sapient.mslearning.attendanceconsumersvc.entity.AttendanceEntity;
import com.sapient.mslearning.attendanceconsumersvc.repository.AttendanceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceService {
    Logger logger = LoggerFactory.getLogger(AttendanceService.class);
    @Autowired
    AttendanceRepository attendanceRepository;
    public Attendance getAttendanceDeatils(int empId) {

        logger.info("Inside getAttendanceDeatils with empId : {}",empId);
        AttendanceEntity attendanceEntity = attendanceRepository.getById(empId);
       Attendance attendance = mapAttendance(attendanceEntity);
       return attendance;
    }

    private Attendance mapAttendance(AttendanceEntity attendanceEntity) {
        Attendance attendance = new Attendance();
        attendance.setEmpId(attendanceEntity.getEmpId());
        attendance.setAttendanceStatus(attendanceEntity.getAttendanceStatus());
        attendance.setTotalMins(attendanceEntity.getTotalMins());
        attendance.setDate(attendanceEntity.getDate());
        attendance.setRemark(attendanceEntity.getRemark());
        return attendance;
    }
}
