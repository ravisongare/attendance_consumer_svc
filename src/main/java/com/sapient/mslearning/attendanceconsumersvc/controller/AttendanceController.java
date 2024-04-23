package com.sapient.mslearning.attendanceconsumersvc.controller;

import com.sapient.mslearning.attendanceconsumersvc.domain.Attendance;
import com.sapient.mslearning.attendanceconsumersvc.service.AttendanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AttendanceController {

    Logger logger = LoggerFactory.getLogger(AttendanceController.class);

    @Autowired
    AttendanceService service;

    @GetMapping("hello")
    String hello() {
        return "Hello World from consumer";
    }

//    @GetMapping("employee/{empId}")
//    ResponseEntity<Attendance> getEmployeeAttandance(@PathVariable("empId") int empId) {
//        logger.info("Inside getEmployeeAttandance with empId : {}", empId);
//        Attendance attendance = service.getAttendanceDeatils(empId);
//        Optional<Attendance> optionalAttendance = Optional.of(attendance);
//        if (optionalAttendance.isPresent())
//          //  return   optionalAttendance.get();
//            return ResponseEntity.ok(optionalAttendance.get());
//        else
//            return ResponseEntity.notFound().build();
//    }

    @QueryMapping
    Attendance getEmployeeAttendance(@Argument int empId) {
        logger.info("Inside getEmployeeAttendance with empId : {}", empId);
        Attendance attendance = service.getAttendanceDeatils(empId);
        return attendance;
    }
    @QueryMapping
    Attendance getDummyEmployeeAttendance(@Argument int empId) {
        logger.info("Inside getEmployeeAttendance with empId : {}", empId);
        Attendance attendance = new Attendance(1,"abs",null,60.0,"on bunk");

        return attendance;
    }

}
