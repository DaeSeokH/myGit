import java.util.Scanner;

//선형검색(순차검색)
//배열에서 원하는 키값을 갖는 요소를 만날 때까지 맨 앞부터 순서대로 요소를 검색
// 배열과 요솟수 키값을 받는 함수로 받고 함수에서 while 문을 이용해 인덱스를 증가시키면서 key 값을 찾는다.

public class SeqSearch {
	
	//선형검색 함수
	static int seqSearch(int[]a, int n, int key) { // 배열 a , 요솟수 n, 값 key
		int i = 0; // 인덱스
		while(true) {
			if(i == n) // 인덱스가 요솟수와 같을 때 
				return -1; // 검색실패, -1 반환
			
			if(a[i] == key) // a의 값이 key 와 같을때
				return i; // 검색성공, 인덱스 반환
			i++;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("요솟수: ");
		int num = sc.nextInt();
		int[] x = new int[num]; // num개의 요솟수 가진 배열 생성
		
		for(int i=0;i<num;i++) { // 요소 값 입력
			System.out.println("x["+i+"]:");
			x[i] = sc.nextInt();
		}
		
		System.out.println("검색할 값: ");
		int ky = sc.nextInt();
		
		int idx = seqSearch(x, num, ky); //검색시작
		
		if(idx == -1) {
			System.out.println("요소가 없습니다.");
		}else {
			System.out.println("그 값은 x["+idx+"]에 있습니다.");
		}
		
		
		
	}
}
