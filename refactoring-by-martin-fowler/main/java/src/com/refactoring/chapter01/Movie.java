package com.refactoring.chapter01;

public class Movie {
	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	private String _title;
	private int _priceCode;
	
	
	public Movie(String title, int priceCode){
		this._title = title;
		this._priceCode = priceCode;
	}

	public String getTitle() {
		return _title;
	}

	public int getPriceCode() {
		return _priceCode;
	}

	public void setPriceCode(int _priceCode) {
		this._priceCode = _priceCode;
	}
	
	// 비디오 종류별 대여료 계산 기능을 빼내어 별도의 함수로 작성
	public double getCharge(int daysRented) {
		double result = 0;
		switch(this.getPriceCode()){
			case Movie.REGULAR:
				result += 2;
				if(daysRented > 2)
					result += (daysRented - 2) * 1.5;
				break;
			case Movie.NEW_RELEASE:
				result += daysRented * 3;
				break;
			case Movie.CHILDRENS:
				result += 1.5;
				if(daysRented > 3)
					result += (daysRented - 3) * 1.5;
				break;
		}
		return result;
	}
	
	public int getFrequentRentalPoints(int daysRented) {
		if((this.getPriceCode() == Movie.NEW_RELEASE )
				&& daysRented > 1){
			return 2;
		}else 
			return 1;
	}
}
