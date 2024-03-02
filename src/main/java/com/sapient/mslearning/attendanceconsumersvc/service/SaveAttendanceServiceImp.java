package com.sapient.mslearning.attendanceconsumersvc.service;

import com.sapient.mslearning.attendanceconsumersvc.domain.Attendance;
import com.sapient.mslearning.attendanceconsumersvc.entity.AttendanceEntity;
import com.sapient.mslearning.attendanceconsumersvc.enums.AttendanceStatusEnum;
import com.sapient.mslearning.attendanceconsumersvc.repository.AttendanceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Optional;

@Service
public class SaveAttendanceServiceImp implements ISaveAttendanceService {
    Logger logger = LoggerFactory.getLogger(SaveAttendanceServiceImp.class);
    @Autowired
    AttendanceRepository repository;

    @Override
    public void saveAttendance(Attendance attendance) {
        logger.info("Saving data into database attendanceId:{}", attendance.getEmpId());
        AttendanceEntity attendanceEntity = getAttendanceEntity(attendance);
        repository.save(attendanceEntity);
    }

    private AttendanceEntity getAttendanceEntity(Attendance attendance) {
        AttendanceEntity attendanceEntity = new AttendanceEntity();
        attendanceEntity.setEmpId(attendance.getEmpId());
        attendanceEntity.setAttendanceStatus(attendance.getAttendanceStatus().equalsIgnoreCase(AttendanceStatusEnum.Present.name()) ?
                AttendanceStatusEnum.Present : AttendanceStatusEnum.Absent);
        attendanceEntity.setDate(Optional.of(attendance.getDate()).isPresent() ?
                attendance.getDate() : new Date(System.currentTimeMillis()));
        attendanceEntity.setRemark(Optional.of(attendance.getRemark()).isPresent() ?
                attendance.getRemark().isBlank()?"No remark":attendance.getRemark() : "No remark");
        attendanceEntity.setTotalMins(attendance.getTotalMins());
        return attendanceEntity;
    }
}
