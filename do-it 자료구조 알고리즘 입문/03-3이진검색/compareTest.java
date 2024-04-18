import java.util.Arrays;
import java.util.Comparator;

public class compareTest {
	
	static class compareT {
		private String name;
		private int age;

		public compareT(String name, int age) {
			this.name = name;
			this.age = age;
		}
		@Override
		public String toString() {
			return "compareT [name=" + name + ", age=" + age + "]";
		}
		
		public static final Comparator<compareT>COMP = new comp();
		
		public static class comp implements Comparator<compareT>{
			@Override
			public int compare(compareT o1,compareT o2) {
				System.out.println("<<"+o1.name+">> 와  <<"+o2.name+">> 를 비교");
				return (o1.age > o2.age)? 1:
					   (o1.age < o2.age)? -1:0;
			}
		}
		public static void main(String[] args) {
			compareT[] co = {
					new compareT("가",14),
					new compareT("나",13),
					new compareT("다",11),
					new compareT("라",15)
			};
			Arrays.sort(co, COMP);
		}
	}

}
