package com.kay.Tikkit.enums;

public enum DepartmentType {

	MEDICAL("Medical"),
	NON_MEDICAL("Non-Medical");
	
	private final String label;
	
	DepartmentType(String label){
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
	
	public static DepartmentType fromLabel(String label) {
        for (DepartmentType type : values()) {
            if (type.label.equalsIgnoreCase(label)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown DepartmentType label: " + label);
    }
}
