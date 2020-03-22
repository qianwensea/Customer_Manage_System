package com.shi.ui;

import com.shi.bean.Customer;
import com.shi.service.CustomerList;
import com.shi.util.CMUtility;

/**
 * 
     * @ClassName: CustomerView
     * @Description: TODO(CustomerView为主模块，负责菜单的显示和处理用户操作)
     * @author 千文sea
     * @date 2020年3月22日
     *
 */
public class CustomerView {

	CustomerList customerList = new CustomerList(20);

	public CustomerView() {
		Customer cust = new Customer("张三", '男', 30, "010-56251234", "123@email.com");
		customerList.addCustomer(cust);
	}

	/**
	 * 
	     * @Title: main
	     * @Description: TODO(程序入口)
	     * @param @param args 参数
	     * @return void 返回类型
	 */
	public static void main(String[] args) {

		CustomerView test = new CustomerView();
		test.enterMainMenu();
	}

	/**
	 * 
	     * @Title: enterMainMenu
	     * @Description: TODO(显示客户信息界面)
	     * @param  参数
	     * @return void 返回类型
	 */
	public void enterMainMenu() {

		while (true) {
			System.out.println("-----------------客户信息管理软件------------------\n");
			System.out.println("                    1 添加客户");
			System.out.println("                    2 修改客户");
			System.out.println("                    3 删除客户");
			System.out.println("                    4 客户列表");
			System.out.println("                    5 退    出\n");
			System.out.print("                    请选择<1 - 5>: ");

			char c = CMUtility.readMenuSelection();
			switch (c) {
			case '1':
				addNewCustomer();
				break;
			case '2':
				modifyCustomer();
				break;
			case '3':
				deleteCustomer();
				break;
			case '4':
				listAllCustomers();
				break;
			case '5':
				System.out.print("确认是否退出(Y/N):");
				char isExit = CMUtility.readConfirmSelection();
				if (isExit == 'Y')
					return;
			}
		}

	}

	/**
	 * 
	     * @Title: addNewCustomer
	     * @Description: TODO(添加客户操作)
	     * @param  参数
	     * @return void 返回类型
	 */
	private void addNewCustomer() {
		System.out.println("----------------------添加客戶---------------------\n");
		System.out.print("姓名:");
		String name = CMUtility.readString(10);
		System.out.print("性別:");
		char gender = CMUtility.readChar();
		System.out.print("年龄:");
		int age = CMUtility.readInt();
		System.out.print("电话:");
		String phone = CMUtility.readString(13);
		System.out.print("邮箱:");
		String email = CMUtility.readString(21);

		// 将数据封装到对象中
		Customer cust = new Customer(name, gender, age, phone, email);
		boolean isSuccess = customerList.addCustomer(cust);
		if (isSuccess) {
			System.out.println("----------------------添加成功---------------------\n");
		} else {
			System.out.println("----------------------客戶目录已满,添加失败---------------------\n");
		}
	}

	/**
	 * 
	     * @Title: modifyCustomer
	     * @Description: TODO(修改客户操作)
	     * @param  参数
	     * @return void 返回类型
	 */
	private void modifyCustomer() {
		System.out.println("----------------------修改客戶---------------------\n");
		Customer cust;
		int n;
		while (true) {
			System.out.print("请输入要修改的客户编号(输入-1退出): ");
			n = CMUtility.readInt();
			if (n == -1) {
				return;
			}
			cust = customerList.getCustomer(n - 1);
			if (cust == null) {
				System.out.print("无法找到指定客户!");
			} else { // 找到了客户
				break;
			}
		}

		// 修改客户信息
		System.out.print("姓名(" + cust.getName() + "):");
		String name = CMUtility.readString(10, cust.getName());
		System.out.print("性别(" + cust.getGender() + "):");
		char gender = CMUtility.readChar(cust.getGender());
		System.out.print("年龄(" + cust.getAge() + "):");
		int age = CMUtility.readInt(cust.getAge());
		System.out.print("电话(" + cust.getPhone() + "):");
		String phone = CMUtility.readString(15, cust.getPhone());
		System.out.print("邮箱(" + cust.getEmail() + "):");
		String email = CMUtility.readString(25, cust.getEmail());

		Customer cust1 = new Customer(name, gender, age, phone, email);
		customerList.replaceCustomer(n - 1, cust1);
		System.out.println("----------------------修改客戶成功---------------------\n");
	}

	/**
	 * 
	     * @Title: deleteCustomer
	     * @Description: TODO(删除客户操作)
	     * @param  参数
	     * @return void 返回类型
	 */
	private void deleteCustomer() {
		System.out.println("------------------------删除客戶-----------------------\n");
		int n;
		Customer cust;
		while (true) {
			System.out.print("请输入要删除的客户编号(输入-1退出): ");
			n = CMUtility.readInt();
			if (n == -1) {
				return;
			}
			cust = customerList.getCustomer(n - 1);
			if (cust == null) {
				System.out.print("无法找到指定客户!");
			} else { // 找到了客户
				break;
			}
		}
		System.out.print("确认是否删除(Y/N):");
		char isDelete = CMUtility.readConfirmSelection();
		if (isDelete == 'N')
			return;
		customerList.deleteCustomer(n - 1);
		System.out.println("----------------------删除客戶成功---------------------\n");
	}

	/**
	 * 
	     * @Title: listAllCustomers
	     * @Description: TODO(遍历客户操作)
	     * @param  参数
	     * @return void 返回类型
	 */
	private void listAllCustomers() {
		System.out.println("----------------------------客户列表---------------------------\n");
		int total = customerList.getTotal();
		if (total == 0) {
			System.out.println("没有客户记录");
		} else {
			System.out.println("编号\t姓名\t性别\t年龄\t电话\t\t邮箱");
			Customer[] allCustomers = customerList.getAllCustomers();
			for (int i = 0; i < allCustomers.length; i++) {
				System.out.println((i + 1) + "\t" + allCustomers[i].getName() + "\t" + allCustomers[i].getGender()
						+ "\t" + allCustomers[i].getAge() + "\t" + allCustomers[i].getPhone() + "\t"
						+ allCustomers[i].getEmail());
			}
		}
		System.out.println("-------------------------客户列表完成--------------------------\n");
	}

}
