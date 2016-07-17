package com.refactoring.chapter01;

abstract class Price {
	abstract int getPriceCode();

	// 비디오 종류별 대여료 계산 기능을 빼내어 별도의 함수로 작성
	public double getCharge(int daysRented) {
		double result = 0;
		switch (this.getPriceCode()) {
		case Movie.REGULAR:
			result += 2;
			if (daysRented > 2)
				result += (daysRented - 2) * 1.5;
			break;
		case Movie.NEW_RELEASE:
			result += daysRented * 3;
			break;
		case Movie.CHILDRENS:
			result += 1.5;
			if (daysRented > 3)
				result += (daysRented - 3) * 1.5;
			break;
		}
		return result;
	}
}
