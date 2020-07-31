package com.example.rabbitmqreceiver.repository;

import com.example.rabbitmqreceiver.domain.MessageLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageLogRepository extends JpaRepository<MessageLog,String> {

}
