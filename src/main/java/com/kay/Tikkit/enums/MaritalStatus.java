package com.kay.Tikkit.enums;

public enum MaritalStatus {
	
	MARRIED("Married"),
	SINGLE("Single");
	
	private final String label;
	
	MaritalStatus(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
	
	public static MaritalStatus fromLabel(String label) {
		
		for(MaritalStatus status : values()) {
			if(status.label.equalsIgnoreCase(label)) {
				return status;
			}
		}
		throw new IllegalArgumentException("Unknown MaritalStatus label: " + label);
		
	}

}
