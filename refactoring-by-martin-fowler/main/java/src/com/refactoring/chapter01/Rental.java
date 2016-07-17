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
	
	public double getCharge(){
		return this._movie.getCharge(this._daysRented);
	}
	
	public int getFrequentRentalPoints(){
		return this._movie.getFrequentRentalPoints(this._daysRented);
	}
	
}
