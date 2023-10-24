package springjdbc.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import springjdbc.dto.DisplayBasketDto;
import springjdbc.dto.InsalesGoodsDto;
import springjdbc.dto.OrderToBasketDto;

@Component
public class UserService {
	
	
	@Autowired
	private InsalesGoodsService insalesGoodsService;
	
	public void setInsalesGoodsService(InsalesGoodsService insalesGoodsService) {
		this.insalesGoodsService = insalesGoodsService;
	}
	
	@Autowired
	private OrderToBasketService orderToBasketService;
	
	public void setOrderToBasketService(OrderToBasketService orderToBasketService) {
		this.orderToBasketService = orderToBasketService;
	}
	
	@Autowired
	private DisplayBasketService displayBasketService;

	public void setDisplayBasketService(DisplayBasketService displayBasketService) {
		this.displayBasketService = displayBasketService;
	}
	
	@Autowired
	private PurchaseGoodsService purchaseGoodsService;

	public void setPurchaseGoodsService(PurchaseGoodsService purchaseGoodsService) {
		this.purchaseGoodsService = purchaseGoodsService;
	}

	public void runMenu(Scanner sc, String id) {
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
				System.out.println("주문 상품 출력");
				showInsalesGoods();
			} else if(inputNumber == 2) {
				System.out.println("주문 선택");
				chooseInsalesGoods(sc, id);
			} else if(inputNumber == 3) {
				System.out.println("주문 취소");
				deleteBasket(sc, id);
			} else if(inputNumber == 4) {
				System.out.println("선택한 상품 출력");
				showBasket(id);
			} else if(inputNumber == 5) {
				System.out.println("주문 확정");
				purchaseGoods(id);
			}
			else if(inputNumber == 6) {
				System.out.println("시스템 종료");
				break;
			}
		}
	} // runmenu
	
	private static void displayMainMenu() {
		System.out.println("===========================================");
		System.out.println("(1) 주문 상품 보기");
		System.out.println("(2) 주문 선택");
		System.out.println("(3) 주문 취소");
		System.out.println("(4) 선택한 상품 출력");
		System.out.println("(5) 주문 확정");
		System.out.println("(6) 종료");
		System.out.println("===========================================");
		System.out.print("번호 입력 : ");
	}
	
	private boolean decideToProceed(String isOrder) {
		if(isOrder.equals("y")) {
			return true;
		} else {
			return false;
		}
	}
	
	private void showInsalesGoods() {
		List<InsalesGoodsDto> insalesGoodsDtoList = insalesGoodsService.retGoods();
		
		for(InsalesGoodsDto insalesGoodsDto: insalesGoodsDtoList) {
			System.out.println(insalesGoodsDto);
		}
	}
	
	private void chooseInsalesGoods(Scanner sc, String id) {
		System.out.print("상품을 주문하시겠습니까? : (y/n) >>> ");
		String isOrder = sc.nextLine();
		
		if(decideToProceed(isOrder)) {
			System.out.print("주문할 상품의 코드를 입력하세요 >>> ");
			String code = sc.nextLine();
			System.out.print("주문할 상품량을 입력하세요");
			int quantity = 0;
			try {
				quantity = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("번호 올바르게 입력하세요. 메뉴로 돌아값니다");
			}
			
			OrderToBasketDto orderToBasketDto = new OrderToBasketDto(code, quantity);
			
			orderToBasketService.orderGoods(orderToBasketDto, id);
		}
	}
	
	private void showBasket(String id) {
		List<DisplayBasketDto> displayBasketDtoList = displayBasketService.retGoods(id);
		
		for(DisplayBasketDto displayBasketDto: displayBasketDtoList) {
			System.out.println(displayBasketDto);
		}
	}
	
	private void deleteBasket(Scanner sc, String id) {
		System.out.print("상품 주문을 취소하시겠습니까? : (y/n) >>> ");
		String isCancel = sc.nextLine();
		
		if(decideToProceed(isCancel)) {
			System.out.print("취소할 상품의 코드를 입력하세요 >>> ");
			String code = sc.nextLine();
			
			orderToBasketService.deleteGoodsInBasketByCode(code, id);
			
		}
	}
	
	private void purchaseGoods(String id) {
		purchaseGoodsService.purchaseGoodsInBasket(id);
	}

}
