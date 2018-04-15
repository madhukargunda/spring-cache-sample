/**
 * 
 */
package com.study.pattern.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.study.pattern.bo.Customer;
import com.study.pattern.service.CustomerService;

/**
 * @author madhukar
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {
	
	static List<Customer> customerList = new ArrayList<Customer>();
	
	static {
		customerList.add(new Customer("firstName1","lastName1",'M'));
		customerList.add(new Customer("firstName2","lastName2",'M'));	
		customerList.add(new Customer("firstName3","lastName3",'M'));
		customerList.add(new Customer("firstName4","lastName4",'M'));
		
	}

	/* (non-Javadoc)
	 * @see com.study.pattern.service.CustomerService#getAllCustomers()
	 */
	@Override
	public List<Customer> getAllCustomers() {
		return customerList;
	}

}
