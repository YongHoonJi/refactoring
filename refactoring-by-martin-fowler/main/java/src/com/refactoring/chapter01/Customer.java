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
		Enumeration<Rental> rentals = this._rentals.elements();
		String result = this.getName() + " 고객님의 대여료 리스트\n";
		
		while(rentals.hasMoreElements()){
			Rental each = rentals.nextElement();
			// 최신물을 이틀 이상 대여하면 보너스 포인트 지급
			//이번에 대여하는 비디오 정보와 대여료를 출력
			result += "\t" + each.getMovie().getTitle()+ "\t" +
			String.valueOf(each.getCharge()) + "\n";
		}
		
		// footer 행 추가
		AccumulatedRentalNumbers total = this.getTotalNumbers();
		result += "누적 대여료:" + String.valueOf(total.getTotalCharge()) + "\n";
		result += "적립 포인트:" + String.valueOf(total.getTotalFrequentRentalPoints()) + "\n";
		return result;
	}
	
	// 현재까지 누적된 총 대여료
	private AccumulatedRentalNumbers getTotalNumbers(){
		double totalCharge = 0;
		int totalFrequentRentalPoints = 0;
		Enumeration<Rental> rentals = _rentals.elements();
		while(rentals.hasMoreElements()){
			Rental each = (Rental)rentals.nextElement();
			totalCharge += each.getCharge();
			totalFrequentRentalPoints += each.getFrequentRentalPoints();
		}
		return new AccumulatedRentalNumbers(totalCharge, totalFrequentRentalPoints);
	}
	
	public class AccumulatedRentalNumbers{
		private double _totalCharge;
		private int _totalFrequentRentalPoints;
		
		public AccumulatedRentalNumbers(double totalCharge, int totalFrequentRentalPoints){
			this._totalCharge = totalCharge;
			this._totalFrequentRentalPoints = totalFrequentRentalPoints;
		}

		public double getTotalCharge() {
			return _totalCharge;
		}

		public int getTotalFrequentRentalPoints() {
			return _totalFrequentRentalPoints;
		}
	}
}
