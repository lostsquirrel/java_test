package test.others;

import java.util.Scanner;

class ATM {
	private User user;

	public ATM() {
		user = new User();
		// 如果说我们实现了文件或是数据库，那么下一步动作
		// 应该是读取文件或数据库，把用户名，密码，帐户的值
		// 赋给user对象。现在我们只能使用假数据
		this.user.setName("zs");
		this.user.setPassword("12345");
		this.user.setAccount(1000f);
	}

	// 运行ATM
	public void run() {
		this.welcome();
		int num = 0;// 计数器，为登陆次数计数，不能超过3次
		while (num < 3) {// 三次登陆机会
			num++;
			boolean flag = this.login();
			if (flag) {// 登陆成功
				System.out.println("欢迎你，" + this.user.getName());
				while (true) {// 提供反复选择操作
					int choice = this.item();
					switch (choice) {// 对于具体的选择具体处理
					case 0:
						this.queryMoney();
						break;
					case 1:
						this.storeMoney();
						break;
					case 2:
						this.getMoney();
						break;
					case 3:
						this.changePWD();
						break;
					default:
						this.exit();
						break;
					}
				}
			} else {
				if (num == 3) {
					System.out.println("登陆失败，你的机会已用完，卡被没收。");
					break;
				}
				System.out.println("登陆失败，请确定后重新登陆。");
				System.out.println("你还有" + (3 - num) + "次机会！");
			}

		}

	}

	// 存钱
	private void storeMoney() {
		Scanner scan = new Scanner(System.in);
		System.out.print("请输入你存钱的金额：");
		float money = scan.nextFloat();
		if (money <= 0) {
			System.out.println("输入错误，110正在赶来的途中");
		} else {
			money += this.user.getAccount();
			this.user.setAccount(money);
		}
		System.out.println("操作已完成，你当前金额是" + this.user.getAccount() + "元!");
//		scan.close();
	}

	// 取钱
	private void getMoney() {
		Scanner scan = new Scanner(System.in);
		System.out.print("请输入你取钱的金额：");
		float money = scan.nextFloat();
		if (money <= 0) {
			System.out.println("输入错误，110正在赶来的途中");
		} else if (money > this.user.getAccount()) {
			System.out.println("余额不足，强行取钱是抢劫行为");
		} else {
			money = this.user.getAccount() - money;
			this.user.setAccount(money);
		}
		System.out.println("操作已完成，你当前金额是" + this.user.getAccount() + "元!");
//		scan.close();
	}

	// 查询帐户
	private void queryMoney() {
		System.out.println("你当前金额是" + this.user.getAccount() + "元!");
	}

	// 修改密码
	private void changePWD() {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入原密码：");
		String oldPWD = scan.nextLine();

		if (oldPWD.equals(this.user.getPassword())) {
			System.out.print("请输入新密码：");
			String newPWD = scan.nextLine();
			System.out.print("请再次输入新密码：");
			String reNewPWD = scan.nextLine();
			if (newPWD.equals(reNewPWD)) {
				this.user.setPassword(newPWD);
				System.out.println("密码修改成功，请好好保存。");
			} else {
				System.out.println("两次密码输入不一致，请重新操作");
			}
		} else {
			System.out.print("原密码错误，请滚吧。");
		}
//		scan.close();
	}

	// 退出系统
	private void exit() {
		System.out.println("谢谢你的使用，再见！");
		System.exit(0);
	}

	// 登陆
	private boolean login() {
		Scanner scan = new Scanner(System.in);
		System.out.print("请输入用户名：");
		String name = scan.nextLine();
		System.out.print("请输入密码：");
		String password = scan.nextLine();

//		scan.close();
		return name.equals(this.user.getName()) && password.equals(this.user.getPassword());

	}

	// 显示欢迎界面
	private void welcome() {
		System.out.println("****************************************");
		System.out.println("****************************************");
		System.out.println("*           欢迎使用我的ATM             *");
		System.out.println("****************************************");
		System.out.println("****************************************");
	}

	// 选择界面
	// 返回值：0---查询、1--存钱、2--取钱、3--修改密码、其它--退出
	private int item() {
		Scanner scan = new Scanner(System.in);
		System.out.println("请选择你要操作的选项");
		System.out.println("0-----查询");
		System.out.println("1-----存钱");
		System.out.println("2-----取钱");
		System.out.println("3-----修改密码");
		System.out.println("其它--退出");
		System.out.println();
		System.out.print("请选择：");
		int choice = 5;
		if (scan.hasNext())
			choice = scan.nextInt();
//		scan.close();
		return choice;
	}
}

class User {
	private String name;
	private String password;
	private float account;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public float getAccount() {
		return account;
	}

	public void setAccount(float account) {
		this.account = account;
	}
}



public class TestMain {
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.run();
	}
}
