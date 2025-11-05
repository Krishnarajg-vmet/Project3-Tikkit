package com.kay.Tikkit.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kay.Tikkit.entity.Comment;
import com.kay.Tikkit.entity.Ticket;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{
	
	List<Comment> findByTicket(Ticket ticket);

}
