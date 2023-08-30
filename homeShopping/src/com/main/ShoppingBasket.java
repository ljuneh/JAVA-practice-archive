package com.main;
import java.util.HashMap;

public class ShoppingBasket extends StockInfo{
    private UserInfo userInfo;
    public ShoppingBasket() {
        super();
    }
    public ShoppingBasket(UserInfo userInfo) {
        super();
        this.userInfo = userInfo;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
    @Override
    public void changeStockByKey(int key, int number) {
        super.changeStockByKey(key, number);
        if(getGoodsByKey(key)==null) {
        	System.out.println("바꾸자 하는 상품의 키가 존재하지 않습니다");
        } else {
        	System.out.println(getGoodsByKey(key)+"\n위 상품의 수량이" + getStockByKey(key) + " 으로 변경");
        }
    }

    @Override
    public void removeStockByKey(int key) {
        System.out.println("아래와 같은 상품을 장바구니에서 제거\n" + getGoodsByKey(key));
        super.removeStockByKey(key);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        
        str.append("장바구니 사용자 정보\n"+userInfo.toString()+"\n\n");

        str.append("장바구니 상품 목록 출력\n");
        HashMap<Integer, Integer> goodsStock = getGoodsStock();

        getGoodsList().forEach((key, goods)->{
            String s =  String.format("//장바구니 상품 키: %d, 상품 이름: %s, 상품 갯수: %d, 상품 가격: %d// \n", key, goods.getName(), goodsStock.get(key), goods.getPrice());
            str.append(s);
        });
        
        return str.toString();
    }

}
