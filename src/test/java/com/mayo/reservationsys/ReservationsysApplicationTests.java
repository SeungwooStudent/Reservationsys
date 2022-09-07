package com.mayo.reservationsys;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ReservationsysApplicationTests {

	@Test
	void test() {
		String date = "2022-08-01";
		String m = date.split("-")[1];
		System.out.println("m : " + m);
		int month = Integer.parseInt(m);
		System.out.println("month : " + month);
		month ++;
		date = "2022-0" + month + "-01";
		System.out.println("date : " + date);
	}

}
