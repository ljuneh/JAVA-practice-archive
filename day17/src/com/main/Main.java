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
				System.out.println("���ᷮ�� �� ���������ϴ� ���Ḧ ä��ڽ��ϱ�? (���ᷮ/n)");
				String input = sc.nextLine();
				char inputChar = input.charAt(0); 
				if(inputChar == 'n') {
					System.out.println("���� ���� ����");
					break;
				} else {
					float inputFlue = Float.parseFloat(input);
					System.out.println("���ᷮ "+ inputFlue +" ����");
					car.setfFuel(inputFlue);
				}
				
			}
		}
		
		sc.close();
		car.switchOff();
		
	}
}
