package com.bora.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bora.consumer.model.Message;

public interface ProfileAMQPRepository extends JpaRepository<Message, Long> {

}
