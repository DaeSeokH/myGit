import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchTesterPratice6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("요솟수: ");
		int num = sc.nextInt(); // 요솟수 입력
		int [] x = new int[num];
		
		System.out.println("오름차순 입력");
		
		System.out.println("x[0]: ");
		x[0] = sc.nextInt();
		
		for(int i =1; i < num; i++) {
			do {
			System.out.println("x["+i+"]: ");
			x[i] = sc.nextInt();
			}while(x[i] < x[i-1]);
		}
		
		System.out.println("검색할 값: ");
		int ky = sc.nextInt();
		
		int idx = Arrays.binarySearch(x,ky);
		
		if (idx < 0) {
			System.out.println(idx); // idx 는 -삽입포인트-1 으로 만약 1,3,5 배열에서 2 입력시 -2 반환
			int insPoint = -idx - 1; // insPoint 는 1
			System.out.printf("삽입 포인트는 %d입니다.\n", insPoint);
			System.out.printf("x[%d]의 바로 앞에 %d을(를) 삽입하면 배열의 정렬상태가 유지", insPoint, ky);
		} else
			System.out.println("그 값은 x[" + idx + "]에 존재");
	}
	
}
