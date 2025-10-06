package com.kay.Tikkit.enums;

public enum Title {
	
	MR("Mr"),
	MRS("Mrs"),
	MS("Ms"),
	MISS("Miss"),
	DR("Dr");
	
	private final String label;
	
	Title(String label) {
		this.label = label;
	}
	
	public String getLabel() {
	    return label;
	}

	
	public static Title fromLabel(String label) {
		for(Title title : values()) {
			if(title.label.equalsIgnoreCase(label)) {
				return title;
			}
		}
		throw new IllegalArgumentException("Unknown Title label " + label);
	}

}
