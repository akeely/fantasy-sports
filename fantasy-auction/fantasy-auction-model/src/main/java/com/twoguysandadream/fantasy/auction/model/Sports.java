package com.twoguysandadream.fantasy.auction.model;

public enum Sports {

	BASEBALL("baseball"),
	FOOTBALL("football");
	
	private final String value;
	
	private Sports(String value) {
		this.value=value;
	}
	
	public String getValue() {
		
		return value;
	}
}
