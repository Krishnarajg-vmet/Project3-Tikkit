package com.kay.Tikkit.enums;

public enum TicketPriority {
	
	CRITICAL("Critical"),
	HIGH("High"),
	LOW("Low"),
	NORMAL("Normal");
	
	private final String label;
	
	TicketPriority(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
	
	public static TicketPriority fromLable(String label) {
		for(TicketPriority tp : values()) {
			if(tp.label.equalsIgnoreCase(label)) {
				return tp;
			}
		}
		throw new IllegalArgumentException("Unknown Ticket Priority " + label);
	}

}
