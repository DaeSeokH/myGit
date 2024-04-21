import java.util.Scanner;

//선형검색(순차검색)
//배열에서 원하는 키값을 갖는 요소를 만날 때까지 맨 앞부터 순서대로 요소를 검색
//for문으로 구현 코드가 좀 더 간결하다.

public class SeqSearchFor {
	
	//선형검색 함수
	static int seqSearch(int[]a, int n, int key) { // 배열 a , 요솟수 n, 값 key

		for(int i = 0; i < n; i++) 
			if(a[i] == key)
				return i;
		return -1;
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
