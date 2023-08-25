package com.main;

import java.util.Scanner;

import com._class.Car;

public class Main {
	public static void main(String[] args) {
		Car car = new Car("Hyndai", 2.5f);
		
//		car.setSwitchOn(true);
//		
//		car.accerlate();
//		car.accerlate();
//		car.accerlate();
//		
//		System.out.println(car.getfSpeed());
//		System.out.println(car.getfFuel());
//		
//		car.accerlate();
//		car.accerlate();
//		car.accerlate();
//		
//		System.out.println(car.getfSpeed());
//		System.out.println(car.getfFuel());
//		
//		car._break();
//		
//		System.out.println(car.getfSpeed());
//		System.out.println(car.getfFuel());
		
		Scanner sc = new Scanner(System.in);
		car.setSwitchOn(true);
		
		while(true) {
			float ret = car.accerlate();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(car);
			if(ret==0) {
				System.out.println("연료량이 다 떨어졌습니다 연료를 채우겠습니까? (연료량/n)");
				String input = sc.nextLine();
				char inputChar = input.charAt(0); 
				if(inputChar == 'n') {
					System.out.println("연료 보충 안함");
					break;
				} else {
					float inputFlue = Float.parseFloat(input);
					System.out.println("연료량 "+ inputFlue +" 보충");
					car.setfFuel(inputFlue);
				}
				
			}
		}
		
		sc.close();
		car.switchOff();
		
	}
}
