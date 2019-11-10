package com.softtron.springmvc.daos;

import java.util.Set;

import com.softtron.springmvc.domains.TOrder;

public interface OrderDao {
	
    public Set<TOrder> getOrders();
    
    public void insert(TOrder order);
    
}
