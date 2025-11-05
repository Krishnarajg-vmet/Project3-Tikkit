package com.kay.Tikkit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kay.Tikkit.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
	
	

}
