package com.kay.Tikkit.enums;

public enum Product {
	
	HIMS("HIMS"),
	TALLY("Tally"),
	OTHERS("Others");
	
	private final String label;
	
	Product(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
	
	public static Product fromLabel(String label) {
		
		for(Product product :values()) {
			if(product.label.equalsIgnoreCase(label)) {
				return product;
			}
		}
		throw new IllegalArgumentException("Unknow Product lable " + label);
	}

}
