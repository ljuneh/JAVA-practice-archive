package springjdbc.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import springjdbc.dto.StockInfoDto;

@Component
public class AdminService {
	@Autowired
	private DisplayStockService displayStockService;

	public void setDisplayStockService(DisplayStockService displayStockService) {
		this.displayStockService = displayStockService;
	}

	public void runMenu(Scanner sc) {
		int inputNumber;
		while(true) {
			inputNumber = -1;
			displayMainMenu();
			try {
				inputNumber = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("번호 올바르게 입력하세요");
				continue;
			}
			
			if (inputNumber == 1) {
				System.out.println("재고 보기");
				showStock();
			} else if(inputNumber == 2) {
				System.out.println("전체 재고 초기화");
				initStock();
			} else if(inputNumber == 6) {
				System.out.println("시스템 종료");
				break;
			}
		}
	}
	
	private static void displayMainMenu() {
		System.out.println("===========================================");
		System.out.println("(1) 재고 보기");
		System.out.println("(2) 전체 재고 초기화");
		System.out.println("(6) 종료");
		System.out.println("===========================================");
		System.out.print("번호 입력 : ");
	}
	
	private void showStock() {
		List<StockInfoDto> stockInfoDtoList = displayStockService.retStock();
		for(StockInfoDto stockInfoDto : stockInfoDtoList) {
			System.out.println(stockInfoDto);
		}
	}
	
	private void initStock() {
		displayStockService.initStock();
	}
	
}
