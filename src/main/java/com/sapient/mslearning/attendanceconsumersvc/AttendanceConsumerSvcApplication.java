package com.sapient.mslearning.attendanceconsumersvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;


@SpringBootApplication
public class AttendanceConsumerSvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(AttendanceConsumerSvcApplication.class, args);
	}

}
