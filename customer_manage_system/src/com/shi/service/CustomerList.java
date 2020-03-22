package com.shi.service;

import com.shi.bean.Customer;

/**
 * 
 * @ClassName: CustomerList
 * @Description: TODO(CustomerList为Customer对象的管理模块，内部用数组管理一组Customer对象，
 *               并提供相应的添加、修改、删除和遍历方法， 供CustomerView调用)
 * @author 千文sea
 * @date 2020年3月22日
 *
 */
public class CustomerList {

	private Customer[] customers; // 保存客戶對象的數組
	private int total = 0; // 记录已保存的客户数量

	/**
	 * 
	 * 构造器，用来初始化customers数组
	 *
	 * @param totalCustomer:指定customer数组的最大空间
	 */
	public CustomerList(int totalCustomer) {
		customers = new Customer[totalCustomer];
	}

	/**
	 * 
	 * @Title: addCustomer 
	 * @Description:TODO(将参数customer添加到数组中最后一个客户对象记录之后) 
	 * @param @param customer 
	 * @param @return 参数 
	 * @return boolean 返回类型 添加成功返回true；false表示数组已满，无法添加 @throws
	 */
	public boolean addCustomer(Customer customer) {

		if (total >= customers.length)
			return false;
		customers[total++] = customer;
		return true;
	}

	/**
	 * 
	 * @Title: replaceCustomer 
	 * @Description: TODO(用参数customer替换数组中由index指定的对象) 
	 * @param @param index 
	 * @param @paramcust 
	 * @param @return 参数 
	 * @return boolean 返回类型
	 * 替换成功返回true；false表示索引无效，无法替换 @throws
	 */
	public boolean replaceCustomer(int index, Customer cust) {

		if (index >= total || index < 0)
			return false;
		customers[index] = cust;
		return true;
	}

	/**
	 * 
	 * @Title: deleteCustomer 
	 * @Description:
	 * TODO(从数组中删除参数index指定索引位置的客户对象记录) 
	 * @param @param index 
	 * @param @return
	 * 参数 
	 * @return boolean 返回类型 删除成功返回true；false表示索引无效，无法删除 @throws
	 */
	public boolean deleteCustomer(int index) {

		if (index >= total || index < 0)
			return false;
		for (int i = index; i < total - 1; i++)
			customers[i] = customers[i + 1];
		customers[--total] = null;
		return true;
	}

	/**
	 * 
	 * @Title: getAllCustomers
	 * @Description: TODO(返回数组中记录的所有客户对象)
	 * @param @return 参数 
	 * @return Customer[] 返回类型 @throws
	 */
	public Customer[] getAllCustomers() {
		Customer[] cust = new Customer[total];
		for (int i = 0; i < total; i++)
			cust[i] = customers[i];
		return cust;
	}

	/**
	 * 
	 * @Title: getCustomer 
	 * @Description: TODO(获取指定位置的客户) 
	 * @param @param index 
	 * @param @return 参数
	 * @return Customer 返回类型 如果找到了则返回元素，如果没找到则返回null @throws
	 */
	public Customer getCustomer(int index) {
		if (index >= total || index < 0)
			return null;
		return customers[index];
	}

	/**
	 * 
	 * @Title: getTotal 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @return 参数 
	 * @return int 返回类型 返回客户数量 
	 */
	public int getTotal() {
		return total;
	}

}
