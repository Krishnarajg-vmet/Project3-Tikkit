package com.kay.Tikkit.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kay.Tikkit.entity.Ticket;
import com.kay.Tikkit.entity.TicketHistory;

@Repository
public interface TicketHistoryRepository extends JpaRepository<TicketHistory, Long> {

	List<TicketHistory> findByTicket(Ticket ticket);

}
