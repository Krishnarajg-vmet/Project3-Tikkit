package com.kay.Tikkit.events;

import com.kay.Tikkit.entity.Ticket;
import org.springframework.context.ApplicationEvent;

public class TicketUpdatedEvent extends ApplicationEvent {
	
	private static final long serialVersionUID = 1L;

    private final Ticket ticket;

    public TicketUpdatedEvent(Object source, Ticket ticket) {
        super(source);
        this.ticket = ticket;
    }

    public Ticket getTicket() {
        return ticket;
    }
}
