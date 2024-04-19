import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PhysExamSearch {
	
	
		static class PhyscData{
			private String name;
			private int height;
			private double vision;

			public PhyscData(String name, int height, double vision) {
				this.name = name;
				this.height = height;
				this.vision = vision;
			}

			@Override
			public String toString() {
				return "PhscData [name=" + name + ", height=" + height + ", vision=" + vision + "]";
			}
			
			//키 오름차순 정렬
			public static final Comparator<PhyscData> HIGHT_ORDER = new HeightOrderComparator();
			
			//첫 번째 인수가 더 크면 양수
			//첫 번째 인수가 더 작으면 음수
			//같으면 0
			private static class HeightOrderComparator implements Comparator<PhyscData>{
				@Override
				public int compare(PhyscData o1,PhyscData o2) {
					return (o1.height > o2.height)? 1:
						(o1.height < o2.height)? -1:0;
				}
			}
		}
		
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			PhyscData[]x = {
					new PhyscData("가",161,0.3),
					new PhyscData("나",165,0.1),
					new PhyscData("다",170,0.2),
					new PhyscData("라",175,0.5)
			};
			
			System.out.println("찾는 키 입력");
			
			int height = sc.nextInt();
			int idx = Arrays.binarySearch	(x, // 배열
											new PhyscData("", height, 0.0), // 키
											PhyscData.HIGHT_ORDER // 의해 검색
											);
			
			if(idx < 0)
				System.out.println("없습니다.");
			else {
				System.out.println("그 값은 x["+idx+"]에 있습니다.");
				System.out.println(x[idx]);
			}
		}
		
		
		
	}
