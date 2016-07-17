package com.refactoring.chapter01;

public class Rental {
	
	private Movie _movie;
	private int _daysRented;
	
	
	public Rental(Movie movie, int daysRented){
		this._movie = movie;
		this._daysRented = daysRented;
	}

	public Movie getMovie() {
		return _movie;
	}

	public int getDaysRented() {
		return _daysRented;
	}
	
	// 비디오 종류별 대여료 계산 기능을 빼내어 별도의 함수로 작성
	// 하지만 amountFor메서드의 정보들을 보면 모두 Rental의 것이다. 
	public double getCharge() {
		double result = 0;
		switch(getMovie().getPriceCode()){
			case Movie.REGULAR:
				result += 2;
				if(this._daysRented > 2)
					result += (this._daysRented - 2) * 1.5;
				break;
			case Movie.NEW_RELEASE:
				result += this._daysRented * 3;
				break;
			case Movie.CHILDRENS:
				result += 1.5;
				if(this._daysRented > 3)
					result += (this._daysRented - 3) * 1.5;
				break;
		}
		return result;
	}
}
