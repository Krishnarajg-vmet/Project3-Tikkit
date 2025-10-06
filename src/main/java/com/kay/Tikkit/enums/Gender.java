package com.kay.Tikkit.enums;

public enum Gender {
	
	MALE("Male"),
	FEMALE("Female"),
	OTHERS("Others");
	
	private final String label;
	
	Gender(String label){
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
	
	public static Gender fromLable(String label) {
		for(Gender gender : values()) {
			if(gender.label.equalsIgnoreCase(label)) {
				return gender;
			}
		}
		throw new IllegalArgumentException("Unknown Gender label: " + label);
	}

}
