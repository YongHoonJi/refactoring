package com.refactoring.chapter01;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
	
	private String _name;
	private Vector<Rental> _rentals = new Vector<Rental>();
	
	
	public Customer(String name){
		this._name = name;
	}
	
	public void addRental(Rental arg){
		_rentals.add(arg);
	}
	
	public String getName(){
		return this._name;
	}
	
	public String statement(){
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Enumeration<Rental> rentals = this._rentals.elements();
		String result = this.getName() + " 고객님의 대여료 리스트 \n";
		
		while(rentals.hasMoreElements()){
			double thisAmount = 0;
			Rental each = rentals.nextElement();
			
			// 비디오 종류별로 대여료 계
			thisAmount = amountFor(each);
			// 적립 포트를 1 포인트 증
			frequentRenterPoints ++;
			// 최신물을 이틀 이상 대여하면 보너스 포인트 지급
			if((each.getMovie().getPriceCode() == Movie.NEW_RELEASE )
					&& each.getDaysRented() > 1){
				frequentRenterPoints ++;
			}
			
			//이번에 대여하는 비디오 정보와 대여료를 출력
			result += "\t" + each.getMovie().getTitle()+ "\t" +
			String.valueOf(thisAmount) + "\n";
			// 현재까지 누적된 총 대여료
			totalAmount += thisAmount;
		}
		
		// footer 행 추가
		result += "누적 대여료:" + String.valueOf(totalAmount) + "\n";
		result += "적립 포인트:" + String.valueOf(frequentRenterPoints) + "\n";
		return result;
	}
	
	// 비디오 종류별 대여료 계산 기능을 빼내어 별도의 함수로 작
	private double amountFor(Rental aRental) {
		double result = 0;
		switch(aRental.getMovie().getPriceCode()){
			case Movie.REGULAR:
				result += 2;
				if(aRental.getDaysRented() > 2)
					result += (aRental.getDaysRented() - 2) * 1.5;
				break;
			case Movie.NEW_RELEASE:
				result += aRental.getDaysRented() * 3;
				break;
			case Movie.CHILDRENS:
				result += 1.5;
				if(aRental.getDaysRented() > 3)
					result += (aRental.getDaysRented() - 3) * 1.5;
				break;
		}
		return result;
	}
}
