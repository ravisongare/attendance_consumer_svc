package com.sapient.mslearning.attendanceconsumersvc;

import com.sapient.mslearning.attendanceconsumersvc.domain.Attendance;
import com.sapient.mslearning.attendanceconsumersvc.service.ISaveAttendanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @Autowired
    ISaveAttendanceService attendanceService;
    Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
    @KafkaListener(topics = "NewTopic6", groupId = "groupId")
    public void consume(Attendance attendance) {
        logger.info("Received attendance from kafka topic = " + attendance);
        attendanceService.saveAttendance(attendance);

    }
}
