package com.softtron.springmvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtron.springmvc.daos.OrderDao;
import com.softtron.springmvc.domains.TOrder;
@Service
public class UserService {
	@Autowired
	OrderDao orderDao;

	public void task() {
		TOrder order = new TOrder();
		order.setOrderNum("666");
		orderDao.insert(order);
		order.setOrderNum("777");
//		int i = 1/0;
		orderDao.insert(order);
	}
}
