package study;

import java.util.HashMap;
import java.util.Map;
//함수에 들어가는 매개변수에 따른 차이
public class testParameterValue {
	public static void main(String[] args) {
		//*************************
		//**원시타입 int를 매개변수로 전달하는 경우
		//*************************
		int i = 1;
		System.out.println("i의 주소는 "+System.identityHashCode(i)); //i의 주소는 758529971

		testValues(i); //함수내 매개변수 i의 주소는 758529971, 함수내 연산 후 i의 주소는 2104457164
		// i 값의 메모리 주소를 갖는 변수가 함수내에 들어가서 연산 후 새로운 주소값을 가지는 변수가 된다.

		System.out.println("함수 호출 후 i의 주소는 "+System.identityHashCode(i)); //함수 호출 후 기존 int i의 주소는 758529971
		System.out.println(i); // 기존 int i 의 변수, 출력 값 1

/*=========================================================================================================================*/

		//*************************
		//**참조타입 String를 매개변수로 전달하는 경우
		//*************************
		String s = "test1";
		System.out.println("s의 주소는 "+System.identityHashCode(s)); //s의 주소는 1521118594

		testValues(s); //함수내 매개변수 s의 주소는 1521118594, 함수내 연산 후 s의 주소는 1940030785
		// String 은 참조타입 이지만 불변 클래스이므로 내부에서 s를 수정시 새로운 String 참조가 생성된다.

		System.out.println("함수 호출 후 s의 주소는 "+System.identityHashCode(s)); // 함수 호출 후 기존 String s의 주소는 1521118594
		System.out.println(s); // 기존 String s 의 변수, 출력 값 test1

/*=========================================================================================================================*/

		//*************************
		//**참조타입 Map를 매개변수로 전달하는 경우
		//*************************
		Map<String,Integer> m = new HashMap<String,Integer>();
		m.put("1", 1);
		System.out.println("m의 주소는 "+System.identityHashCode(m)); //m의 주소는 1869997857
		testValues(m); //함수내 매개변수 m의 주소는 1869997857, 함수내 연산 후 m의 주소는 1869997857
		//해당 객체의 참조의 전달이 계속 유지된다.

		System.out.println("함수 호출 후 m의 주소는 "+System.identityHashCode(m)); // 함수 호출 후 기존 Map<String,Integer> m의 주소는 1869997857
		System.out.println(m); // 기존 Map<String,Integer> m의 변수, 출력 값 {1=1, 2=2}

	}

	public static int testValues(int i) {
		System.out.println("함수내 매개변수 i의 주소는 "+System.identityHashCode(i));
		i = i+1;
		System.out.println("함수내 연산 후 i의 주소는 "+System.identityHashCode(i));
		return i;
	}
	public static String testValues(String s) {
		System.out.println("함수내 매개변수 s의 주소는 "+System.identityHashCode(s));
		s = "test2";
		System.out.println("함수내 연산 후 s의 주소는 "+System.identityHashCode(s));
		return s;
	}
	public static Map<String,Integer> testValues(Map<String,Integer> m) {
		System.out.println("함수내 매개변수 m의 주소는 "+System.identityHashCode(m));
		m.put("2", 2);
		System.out.println("함수내 연산 후 m의 주소는 "+System.identityHashCode(m));
		return m;
	}

}
