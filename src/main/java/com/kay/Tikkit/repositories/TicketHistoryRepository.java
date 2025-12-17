package com.kay.Tikkit.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

import com.kay.Tikkit.entity.TicketHistory;
import com.kay.Tikkit.entity.Ticket;

@Repository
public interface TicketHistoryRepository extends JpaRepository<TicketHistory, Long> {

    Page<TicketHistory> findByTicket(Ticket ticket, Pageable pageable);

    Page<TicketHistory> findAllByOrderByChangedDtDesc(Pageable pageable);

	Streamable<TicketHistory> findByTicket_TicketIdOrderByChangedDtDesc(Long ticketId);

	Page<TicketHistory> findByTicket_TicketIdOrderByChangedDtDesc(Long ticketId, Pageable topOne);

	List<TicketHistory> findByTicketTicketIdOrderByChangedDtDesc(Long ticketId);
}
