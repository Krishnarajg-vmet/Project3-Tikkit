package com.kay.Tikkit.enums;

public enum TicketType {
	
	DOUBT("Doubt"),
	ISSUE("Issue"),
	REQUIREMENT("Requirement"),
	MODIFICATION("Modification"),
	TASK("Task");
	
	private final String label;
	
	TicketType(String label){
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
	
	public static TicketType fromLabel(String label) {
		for(TicketType tt : values()) {
			if(tt.label.equalsIgnoreCase(label)) {
				return tt;
			}
		} throw new IllegalArgumentException("Unknown Ticket Type" + label);
	}

}
