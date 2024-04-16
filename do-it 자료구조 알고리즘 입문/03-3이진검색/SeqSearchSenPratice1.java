import java.util.Scanner;

public class SeqSearchSenPratice1 {
	//선형검색 함수
		static int seqSearch(int[]a, int n, int key) { // 배열 a , 요솟수 n, 값 key
			//int i = 0; // 인덱스
			int i; // 인덱스 선언
			
			a[n] = key; // ****보초 추가****
			
/*			while(true) {		
				if(a[i] == key) // 검색 성공
					break;
				i++;
			}*/
			
			for(i = 0 ; a[i] != key; i++);
			//한줄로 간결하게 수정됨
			
			
			
			return i == n? -1 : i;
		}
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("요솟수: ");
			int num = sc.nextInt();
			int[] x = new int[num+1]; // num개의 요솟수 가진 배열 생성 + 보초 추가(+1) ****
			
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
