package inheritance;

public class Test1 {

	public static void main(String[] args) {
		ItwillBank ib = new ItwillBank();
		ib.accountNo = "111-1111-111";
		ib.ownerName = "홍길동";
		ib.balance = 100000;
		
		ib.showAccountInfo();
		
		ib.deposit(50000);
		System.out.println("출금된 금액 : " + ib.withdraw(100000) + "원");
		System.out.println("--------------------");
		ib.contract("자동차");
		System.out.println(ib.insureName);
		
	}

}


class Account {
	String accountNo;
	String ownerName;
	int balance;
	
	// 멤버 정보를 출력하는 showAccountInfo() 메서드
	public void showAccountInfo() {
		System.out.println("계좌번호: " + this.accountNo);
		System.out.println("예금주명: " + this.ownerName);
		System.out.println("현재잔고: " + this.balance);
	}
	
	// 입금 기능(전달받은 입금금액(amount)을 현재잔고 balace에 누적) deposit() 메서드
	public void deposit(int amount) {
		balance += amount;
		System.out.println("입금금액 : " + amount + "원");
		System.out.println("현재잔고 : " + balance);
	}
	
	// 출금 기능 (매개변수 금액을 전달받아, 금액만큼 리턴) withdraw() 메서드
	public int withdraw(int amount) {
		if(amount > balance) {	// X
			System.out.println("출금할 금액 : " + amount + "원");
			System.out.println("잔액이 부족하여 출금 불가! (현재잔고 : " + balance + "원)");
			return 0;
			
		} else {	// O
			balance -= amount;
			System.out.println("출금할 금액 : " + amount + "원");
			System.out.println("출금 후 현재잔고 : " + balance + "원");
			return amount;
		}
	}
}

/* Account 클래스를 상속받은 ItwillBank 클래스 정의
 * => 은행계좌 기본기능 + 보험관리 기능 추가
 * - 멤버변수: 보험명(insureName, 문자열)
 * - 메서드: contract() 메서드 (파라미터 보험명(insureName), 리턴값 없음)
 * 			=> 전달받은 보험명을 멤버변수에 저장하고
 *   		   "계약하신 보험명 : XXX 보험" 출력
 * */
class ItwillBank extends Account {
	String insureName;
	public void contract(String insureName) {
		this.insureName = insureName;
		System.out.println("계약하신 보험명 : " + this.insureName + " 보험");
	}
}












