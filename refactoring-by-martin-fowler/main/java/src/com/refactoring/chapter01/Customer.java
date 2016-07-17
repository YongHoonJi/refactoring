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
		int frequentRenterPoints = 0;
		Enumeration<Rental> rentals = this._rentals.elements();
		String result = this.getName() + " 고객님의 대여료 리스트\n";
		
		while(rentals.hasMoreElements()){
			Rental each = rentals.nextElement();
			
			// 최신물을 이틀 이상 대여하면 보너스 포인트 지급
			frequentRenterPoints += each.getFrequentRentalPoints(frequentRenterPoints);
			
			//이번에 대여하는 비디오 정보와 대여료를 출력
			result += "\t" + each.getMovie().getTitle()+ "\t" +
			String.valueOf(each.getCharge()) + "\n";
			// 현재까지 누적된 총 대여료
		}
		
		// footer 행 추가
		result += "누적 대여료:" + String.valueOf(this.getTotalCharge()) + "\n";
		result += "적립 포인트:" + String.valueOf(frequentRenterPoints) + "\n";
		return result;
	}
	
	private double getTotalCharge(){
		double result = 0;
		Enumeration<Rental> rentals = _rentals.elements();
		while(rentals.hasMoreElements()){
			Rental each = (Rental)rentals.nextElement();
			result += each.getCharge();
		}
		return result;
	}

}
