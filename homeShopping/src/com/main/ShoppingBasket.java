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
        	System.out.println("�ٲ��� �ϴ� ��ǰ�� Ű�� �������� �ʽ��ϴ�");
        } else {
        	System.out.println(getGoodsByKey(key)+"\n�� ��ǰ�� ������" + getStockByKey(key) + " ���� ����");
        }
    }

    @Override
    public void removeStockByKey(int key) {
        System.out.println("�Ʒ��� ���� ��ǰ�� ��ٱ��Ͽ��� ����\n" + getGoodsByKey(key));
        super.removeStockByKey(key);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        
        str.append("��ٱ��� ����� ����\n"+userInfo.toString()+"\n\n");

        str.append("��ٱ��� ��ǰ ��� ���\n");
        HashMap<Integer, Integer> goodsStock = getGoodsStock();

        getGoodsList().forEach((key, goods)->{
            String s =  String.format("//��ٱ��� ��ǰ Ű: %d, ��ǰ �̸�: %s, ��ǰ ����: %d, ��ǰ ����: %d// \n", key, goods.getName(), goodsStock.get(key), goods.getPrice());
            str.append(s);
        });
        
        return str.toString();
    }

}
