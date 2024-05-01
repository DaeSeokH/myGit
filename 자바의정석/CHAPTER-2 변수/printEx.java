
public class printEx {
	public static void main(String[] args) {
		
		System.out.println(10.0/3);
		
		System.out.printf("%d%n", 15);  //15
		System.out.printf("%#o%n", 15); //017
		System.out.printf("%#x%n", 15); //0xf
		System.out.printf("%s%n", Integer.toBinaryString(15)); //1111
		
		float f = 123.456789f;
		System.out.printf("%f%n",f); // 123.456787 7자리만 정밀 즉 123.4567
		System.out.printf("%e%n",f); // 1.234568e+02 , 7자리
		System.out.printf("%g%n",f); // 123.457 , 소수점 포함 7자리
		
		double f2 = 123.456789;
		System.out.printf("%f%n",f2); //123.456789 15자리 정밀 f2가 모두 출력
		
		System.out.printf("[%5d]%n",10); // [   10] 오른쪽 정렬 5자리
		System.out.printf("[%5d]%n",1234567); // [1234567] 5자리, 초과도 출력
		System.out.printf("[%-5d]%n",10); // [10   ] 왼쪽 정렬 5자리
		System.out.printf("[%05d]%n",10); // [00010] 오른쪽 정렬 5자리 빈 공간 0
		
		double d = 1.23456789;
		System.out.printf("%f%n",d); // 1.234568
		// %f 는 자리수를 쓰지 않으면 전부다 보여주지 않음
		
		System.out.printf("%14.10f%n",d); //  1.2345678900
		// 총 14자리, 소수점 10자리
		
		System.out.printf("%14.6f%n",d); //      1.234568 정수 14자리, 소수 6자리
		System.out.printf("%.6f%n",d); // 1.234568 소수점 6자리
		
		System.out.printf("[%s]%n","www.codechobo.com"); // [www.codechobo.com]
		System.out.printf("[%20s]%n","www.codechobo.com"); // [   www.codechobo.com]
		System.out.printf("[%-20s]%n","www.codechobo.com"); // [www.codechobo.com   ]
		System.out.printf("[%.10s]%n","www.codechobo.com"); // [www.codech] 왼쪽부터 10 글자만
	}
}
