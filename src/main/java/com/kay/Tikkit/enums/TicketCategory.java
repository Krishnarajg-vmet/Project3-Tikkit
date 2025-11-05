package com.kay.Tikkit.enums;

public enum TicketCategory {
	
	NETWORK("Network"),
    HARDWARE("Hardware"),
    SOFTWARE("Software"),
    APPLICATION("Application"),
    HR("HR"),
    FINANCE("Finance"),
    OTHER("Other");
	
	private final String label;
	
	TicketCategory (String label){
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
	
	public static TicketCategory fromLable(String label) {
		for(TicketCategory tc : values()) {
			if(tc.label.equalsIgnoreCase(label)) {
				return tc;
			}
		}
		throw new IllegalArgumentException("Unknown Ticket Status " + label);
	}

}
