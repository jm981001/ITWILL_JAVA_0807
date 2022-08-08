package inheritance;

public class Test3 {

	public static void main(String[] args) {
		ItwillBank2 ib = new ItwillBank2();
		ib.grade = 0;	// 일반회원
		ib.deposit(50000);
		System.out.println("출금된 금액 : " + ib.withdraw(100000));
		
		System.out.println("----------------------------------");
		ItwillBank2 ib2 = new ItwillBank2();
		ib2.grade = 1;	// VIP회원
		
		ib2.deposit(50000);
		System.out.println("출금된 금액 : " + ib2.withdraw(1000000));
		
	}

}

class Account2 {
	String accountNo;
	String ownerName;
	int balance;
	
	public void showAccountInfo() {
		System.out.println("계좌번호 : " + accountNo);
		System.out.println("예금주명 : " + ownerName);
		System.out.println("현재잔고 : " + balance);
	}
	
	public void deposit(int amount) {
		balance += amount;
		System.out.println("입금금액 : " + amount + "원");
		System.out.println("현재잔고 : " + balance + "원");
	}
	
	public int withdraw(int amount) {
		if(amount > balance) {	// X
			System.out.println("출금할 금액 : " + amount + "원");
			System.out.println("잔액이 부족하여 출금 불가! (현재잔고: " + balance + "원)");
			return 0;
		} else { // O
			balance -= amount;
			System.out.println("출금할 금액 : " + amount + "원");
			System.out.println("출금 후 현재 잔고 : " + balance + "원");
			return amount;
		}
	}
}

/*
 * ItwillBank2 클래스 정의 - Account2 클래스 상속
 * - 멤버변수 등급(grade, 정수)
 * 		(0: 일반회원, 1: VIP회원)
 * - 출금 기능(withdraw()) 메서드 오버라이딩 수행
 * 	 => 1. VIP회원일 경우: 잔고가 부족하더라도 무조건 출금하도록 구현
 *      은행 잔고에 관계없이 무조건 출금 수행 (마이너스 통장)
 *      2. 일반 회원일 경우: 부모클래스 (Account2)의 출금기능을 그대로 사용
 * */
class ItwillBank2 extends Account2 {
	int grade;
	
	// Alt + Shift + S -> V
	@Override
	public int withdraw(int amount) {
		
		if(grade == 1) { // VIP 회원일때
			balance -= amount;
			System.out.println("출금할 금액 : " + amount + "원");
			System.out.println("출금 후 현재 잔고 : " + balance + "원");
		} else if(grade == 0) { // 일반회원
			return super.withdraw(amount);
		}
		
		return amount;
		
		
	}
}












