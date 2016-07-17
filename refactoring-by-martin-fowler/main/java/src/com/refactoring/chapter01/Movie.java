package com.refactoring.chapter01;

public class Movie {
	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	private String _title;
	private Price _price;
	
	public Movie(String title, int priceCode){
		this._title = title;
		this.setPriceCode(priceCode);
	}

	public String getTitle() {
		return _title;
	}

	public int getPriceCode() {
		return _price.getPriceCode();
	}
	
	// price code에 맞게 price클래스의 하위 클래스를 생
	public void setPriceCode(int arg) {
		switch(arg){
			case Movie.REGULAR:
				_price = new RegularPrice();
				break;
			case Movie.NEW_RELEASE:
				_price = new NewReleasePrice();
				break;
			case Movie.CHILDRENS:
				_price = new ChildrenPrice();
				break;
			default:
				throw new IllegalArgumentException("Wrong price code");
		}
	}
	
	// 비디오 종류별 대여료 계산 기능을 빼내어 별도의 함수로 작성
	public double getCharge(int daysRented) {
		return _price.getCharge(daysRented);
	}
	
	public int getFrequentRentalPoints(int daysRented) {
		return _price.getFrequentRentalPoints(daysRented);
	}

	public Price getPrice() {
		return _price;
	}

	public void setPrice(Price _price) {
		this._price = _price;
	}
	
	
}
