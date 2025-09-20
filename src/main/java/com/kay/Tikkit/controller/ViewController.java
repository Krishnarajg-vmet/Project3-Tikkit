package com.kay.Tikkit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
	
	@GetMapping("/countries")
	public String countryPage() {
		return "countries-list";
	}
	
	@GetMapping("/create/countries")
	public String countryCreationPage() {
		return "countries-create";
	}
	
	@GetMapping("/update/countries")
	public String countryUpdatePage() {
		return "countries-update";
	}
	
	@GetMapping("/states")
	public String statePage() {
		return "states-list";
	}
	
	@GetMapping("/create/states")
	public String stateCreationPage() {
		return "states-create";
	}
	
	@GetMapping("/update/states")
	public String stateUpdatePage() {
		return "states-update";
	}
	
	@GetMapping("/districts")
	public String districtPage() {
		return "districts-list";
	}
	
	@GetMapping("/create/districts")
	public String districtCreationPage() {
		return "districts-create";
	}
	
	@GetMapping("/update/districts")
	public String districtsUpdatePage() {
		return "districts-update";
	}
	
	@GetMapping("/cities")
	public String cityPage() {
		return "cities-list";
	}
	
	@GetMapping("/create/cities")
	public String cityCreationPage() {
		return "cities-create";
	}
	
	@GetMapping("/update/cities")
	public String cityUpdatePage() {
		return "cities-update";
	}
	
	@GetMapping("/areas")
	public String areaPage() {
		return "areas-list";
	}
	
	@GetMapping("/create/areas")
	public String areaCreationPage() {
		return "areas-create";
	}
	
	@GetMapping("/update/areas")
	public String areaUpdatePage() {
		return "areas-update";
	}

}
