package com.kay.Tikkit.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kay.Tikkit.entity.Attachment;
import com.kay.Tikkit.entity.Ticket;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, Long> {

	List<Attachment> findByTicket(Ticket ticket);

}
