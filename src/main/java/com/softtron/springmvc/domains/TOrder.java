package com.softtron.springmvc.domains;

public class TOrder {
	private String orderNum;

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	@Override
	public String toString() {
		return "TOrder [orderNum=" + orderNum + "]";
	}
	

}
