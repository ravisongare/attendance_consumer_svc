package com.sapient.mslearning.attendanceconsumersvc.repository;

import com.sapient.mslearning.attendanceconsumersvc.entity.AttendanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends JpaRepository<AttendanceEntity,Integer> {

}
