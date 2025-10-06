package com.kay.Tikkit.enums;

public enum EmployeeCategory {
	
	DOCTOR("Doctor"),
	NURSE("Nurse"),
	STAFF("Staff");
	
	private final String label;
	
	EmployeeCategory(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
	
	public static EmployeeCategory fromLabel(String label) {
        for (EmployeeCategory type : values()) {
            if (type.label.equalsIgnoreCase(label)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown EmployeeCategory label: " + label);
    }

}
