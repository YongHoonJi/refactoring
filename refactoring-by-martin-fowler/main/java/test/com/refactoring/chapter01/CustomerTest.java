package com.refactoring.chapter01;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerTest {

  @Test
  public void statement() {
	  String expected = "Ji 고객님의 대여료 리스트\n" 
			+"\tGone with wind	3.5\n"
			+"\tThe great Gatby	2.0\n"
			+"\tMalMade	1.5\n"
			+"누적 대여료:7.0\n"
			+"적립 포인트:3\n";
	  Customer customer = new Customer("Ji");
	  customer.addRental(new Rental(new Movie("Gone with wind", Movie.REGULAR), 3));
	  customer.addRental(new Rental(new Movie("The great Gatby", Movie.REGULAR), 1));
	  customer.addRental(new Rental(new Movie("MalMade", Movie.CHILDRENS), 2));
	  Assert.assertEquals(expected, customer.statement());
  }
}
