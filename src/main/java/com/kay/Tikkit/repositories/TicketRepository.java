package com.kay.Tikkit.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kay.Tikkit.entity.Ticket;
import com.kay.Tikkit.enums.TicketPriority;
import com.kay.Tikkit.enums.TicketStatus;
import com.kay.Tikkit.enums.TicketType;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
	
	Optional<Ticket> findByTicketNumber(String ticketnumber);
	
	Page<Ticket> findByTicketStatus(TicketStatus ticketStatus, Pageable pageable);
	
	Page<Ticket> findByTicketType(TicketType ticketType, Pageable pageable);
	
	Page<Ticket> findByTicketPriority(TicketPriority ticketPriority, Pageable pageable);
	
	Page<Ticket> findAll(Specification<Ticket> specification, Pageable pageable);

	Optional<Ticket> findTopByOrderByTicketIdDesc();

	Long countByToDepartmentDepartmentId(Long departmentId);
	
	@Query("""
	        SELECT t FROM Ticket t
	        LEFT JOIN FETCH t.ticketHistory th
	        LEFT JOIN FETCH t.comments c
	        WHERE t.ticketId = :ticketId
	    """)
	    Optional<Ticket> findByTicketIdWithHistoryAndComments(@Param("ticketId") Long ticketId);

}
