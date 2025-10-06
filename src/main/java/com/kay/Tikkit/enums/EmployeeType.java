package com.kay.Tikkit.enums;

public enum EmployeeType {
	
	PERMANENT("Permanent"),
	CONSULTANT("Consultant"),
	FTC("FTC"),
	CONTRACT("Contract");

	private final String label;
	
	EmployeeType(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
	
	public static EmployeeType fromLabel(String label) {
        for (EmployeeType type : values()) {
            if (type.label.equalsIgnoreCase(label)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown EmployeeType label: " + label);
    }
}
