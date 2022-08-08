package inheritance;


public class Ex4 {

	public static void main(String[] args) {
		
		new G();
		System.out.println("----------");
		new P();
		System.out.println("----------");
		new C();
		
		String str1 = "abc";
		System.out.println(System.identityHashCode(str1));
		String str2 = "abc";
		System.out.println(System.identityHashCode(str2));
		String str3 = new String("abc");
		System.out.println(System.identityHashCode(str3));
		String str4 = new String("abc");
		System.out.println(System.identityHashCode(str4));
		System.out.println("--------------------------");
		
		str1 = str1 + "de";
		System.out.println(System.identityHashCode(str1));
		str2 += "de";
		System.out.println(System.identityHashCode(str2));
		String str5 = "abcde";
		System.out.println(System.identityHashCode(str5));
		
		System.out.println(str1);
		System.out.println(str5);
		System.out.println(str1 == str5);
		
		
		System.out.println("----------");
		System.out.println(str1 == str2);
		System.out.println(str2 == str3);
		System.out.println(str3 == str4);
		
		
	}

}

class G {	// 할아버지
	public G() {
		super();
		System.out.println("G 생성됨");
	}
}

class P extends G {	// 아버지
	public P() {
		super();
		System.out.println("P 생성됨");
	}
}

class C extends P {	// 나
	public C() {
		super();
		System.out.println("C 생성됨");
	}
}







