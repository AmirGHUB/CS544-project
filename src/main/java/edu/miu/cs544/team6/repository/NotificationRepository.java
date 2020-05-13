package edu.miu.cs544.team6.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.miu.cs544.team6.domain.EmailNotification;
import edu.miu.cs544.team6.enums.ENotificationStatus;

@Repository
public interface NotificationRepository extends JpaRepository<EmailNotification, Integer> {

	List<EmailNotification> findByStatus(ENotificationStatus status);

}
