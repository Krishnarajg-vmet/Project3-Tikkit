package com.kay.Tikkit.enums;

public enum TicketStatus {

	NEW("New"),
	OPEN("Open"),
	IN_PROGRESS("In Progress"),
	RE_OPEN("Re-Open"),
	RESOLVED("Resolved"),
	CLOSED("Closed");
	
	private final String label;
	
	TicketStatus(String label) {
		this.label = label;
	}
	
	public String getLable() {
		return label;
	}
	
	public static TicketStatus fromLable(String label) {
		for(TicketStatus ts : values()) {
			if(ts.label.equalsIgnoreCase(label)) {
				return ts;
			}
		}
		throw new IllegalArgumentException("Unknown Ticket Status " + label);
	}
}
