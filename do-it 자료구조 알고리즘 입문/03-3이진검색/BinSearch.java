import java.util.Scanner;

//이진검색

public class BinSearch {
	// 배열 a , 요소수 n , key 값
	static int binSearch(int[] a, int n, int key) {
		int pl = 0; // 첫 인덱스
		int pr = n - 1; // 끝 인덱스
		
		do {
			int pc = (pl + pr) / 2; // 중앙 요소 인덱스를 구한다.
			if(a[pc] == key)
				return pc;  // 검색 성공하면 해당 인덱스를 반환
			else if(a[pc] < key)
				pl = pc +1; // 검색범위 첫 인덱스를 중앙 다음으로 잡는다. 절반으로 좁힌다.
			else
				pr = pc -1; // 검색범위 중앙 인덱스를 중앙 앞으로 잡는다. 절반으로 좁힌다.
			
		}while(pl <=pr); // pl이 pr 이하일때 만 반복
		
		return -1; // 검색 실패 반환
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("요솟수: ");
		int num = sc.nextInt();
		int[]x = new int[num]; //요소수 num 개의 배열
		
		System.out.println("오름차순으로 입력");
		
		System.out.println("x[0] : ");
		x[0] = sc.nextInt();
		
		for(int i = 1; i < num; i++) {
			do {
				System.out.println("x["+i+"]: ");
				x[i] = sc.nextInt();
			}while(x[i] < x[i-1]); // 앞의 요소보다 작은지 확인 후 맞으면 다시 입력
		}
		
		System.out.println("검색할 값: ");
		int ky = sc.nextInt();
		
		int idx = binSearch(x, num, ky); //배열 x 에서 값이 ky인 요소 검색
		
		if(idx == -1)
			System.out.println("그 값의 요소가 없습니다.");
		else
			System.out.println("값은 x["+idx+"]에 있습니다.");
		
		
		
	}
	
}
