package inheritance;

public class Ex1 {

	public static void main(String[] args) {
		/*
		 * 상속 (Inheritance)
		 * - 슈퍼클래스(부모)의 모든 멤버를 서브클래스(자식)에세 물려반다 선언없이 사용하는 것
		 *   => 상속을 받은 서브클래스에서 별도의 선언 및 정의 없이도
		 *      슈퍼클래스가 가진 멤버변수나 메서드 등을 자신의 멤버처럼 사용가능
		 *   => 상속을 활용하면 코드 중복이 제거되며, 유지 보수에 용이해진다!
		 * - 슈퍼클래스(Super Class) = 부모클래스(조상클래스) = 상위클래스
		 *   서브클래스(Sub Class) = 자식클래스(자손클래스) = 하위클래스 = 파생클래스
		 * - 서브클래스 정의 시 서브클래스명 뒤에 extends 키워드를 사용하고
		 *   extends 키워드 뒤에 슈퍼클래스의 이름을 명시함
		 *   => 슈퍼클래스가 가진 멤버를 물려받아 서브클래스에서 멤버를 추가하므로
		 *      기존 클래스를 확장(extends)하는 개념으로 사용됨   
		 * - private 접근제한자가 적용된 멤버는 상속 대상에서 제외됨!
		 * - 생성자는 상속되지 않음
		 *   (생성자는 자신의 클래스이름과 동일해야하는데 생성자가 상속되면 이름이 다르다!)
		 * - 자바는 "단일 상속만 지원" 하므로 동시에 2개 이상의 클래스를 상속 받을 수 없음
		 *   (class 서브클래스명 extends 슈퍼클래스1, 슈퍼클래스2 {} 형태로 상속 불가능! )
		 * - 클래스 정의 시 별도의 extends 키워드를 사용하지 않으면 (상속 명시하지 않으면)
		 *   자동으로 java.lang.Object 클래스를 상속받게 됨
		 *   => 따라서, Object 클래스는 모든 자바 클래스의 최상위 클래스이다!
		 *   => 즉, 모든 클래스에서 Object 클래스의 멤버에 접근 가능!
		 * 
		 * */
		Child c = new Child();
		c.childPrn();	// 서브클래스 Child에서 직접 정의한 메서드
		
		// Child 클래스는 자신의 클래스 내의 멤버뿐만 아니라
		// 슈퍼클래스인 Parent 클래스로 부터 상속받은 멤버도 선언없이 사용 가능!
		c.name = "홍길동";
		c.parentPrn();
		
		// 슈퍼클래스 Parent 인스턴스 생성
		Parent p = new Parent();
		p.name = "이순신";
		p.parentPrn();
		
		// 단, 슈퍼클래스에서 서브클래스의 멤버에 접근 불가능하다!
//		p.childPrn(); // 서브클래스의 멤버는 접근 불가능 하므로 오류 발생!
		System.out.println("=================================");
		
		System.out.println("----- 아버지 -----");
		아버지 아버지 = new 아버지();
		System.out.println(아버지.car); 
		아버지.drawWell();
		// 슈퍼클래스인 할아버지의 멤버 접근 (아버지 인스턴스를 통해 접근)
		System.out.println(아버지.house);
		아버지.singWell();

		System.out.println("----- 나 -----");
		나 나 = new 나();
		System.out.println(나.pc);
		나.programmingWell();
		
		// 슈퍼클래스인 아버지와 그의 슈퍼클래스인 할아버지의 모든 멤버에 접근
		System.out.println(나.house); // 할아버지
		System.out.println(나.car);   // 아버지
		나.singWell();	// 할아버지
		나.drawWell();	// 아버지
	}

}
// ---------------------------------------------------------------------------
class 할아버지 {
	String house = "이층집";
	public void singWell() {
		System.out.println("노래를 잘한다!");
	}
}

// 아버지 클래스 정의 - 할아버지 클래스로부터 상속
// => 멤버변수: car(문자열) -> "자동차" 로 초기화
// => 메서드: drawWell() 메서드 정의(파라미터 없음, 리턴값 없음) "그림을 잘 그린다!" 출력
class 아버지 extends 할아버지 {
	String car = "자동차";
	public void drawWell() {
		System.out.println("그림을 잘 그린다!");
	}
}


// 나 클래스 정의 - 아버지 클래스로부터 상속
// => 멤버변수: pc(문자열) -> "컴퓨터" 로 초기화
// => 메서드: programmingWell() 메서드 정의(파라미터 없음, 리턴값 없음) "프로그래밍을 잘 한다!" 출력

// 슈퍼클래스가 아버지가 될 경우 아버지의 슈퍼클래스인 할아버지의 멤버도 상속 됨
class 나 extends 아버지 {
	String pc = "컴퓨터";
	public void programmingWell() {
		System.out.println("프로그래밍을 잘 한다!");
	}
}



// ---------------------------------------------------------------------------
// 슈퍼클래스 Parent 정의
class Parent { // extends Object 가 생략되어 있음 (자동으로 Object 클래스를 상속 받음)
	String name;
	public void parentPrn() {
		System.out.println("슈퍼클래스 Parent의 parentPrn()");
	}
}

// 슈퍼클래스 Parent를 상속받는 서브클래스 Child 정의
// => 서브클래스명(Child) 뒤에 extends 슈퍼클래스명 (Parent)를 붙여서 상속
class Child extends Parent {
	public void childPrn() {
		System.out.println("서브클래스 Child의 childPrn()");
	}
}











