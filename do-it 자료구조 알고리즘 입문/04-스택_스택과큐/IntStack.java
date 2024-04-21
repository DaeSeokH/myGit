
public class IntStack {
	private int[]stk; // 스택 배열
	private int capacity; // 스택 용량
	private int ptr; // 스택 포인터

	public class EmptyISException extends RuntimeException{ // 빈 스택 예외
		public EmptyISException() {
		}
	}
	
	public class OverflowISException extends RuntimeException{ // 풀 스택 예외
		public OverflowISException() {
			
		}
	}

	//생성자
	public IntStack(int maxlen) {
		ptr = 0;
		capacity = maxlen;
		try {
			stk = new int[capacity]; // 스택 본체 배열 생성
		}catch(OutOfMemoryError e) { // 생성 에러
			capacity = 0;
		}
	}
	
	// 스택 x push
	public int push(int x) throws OverflowISException{
		if(ptr >= capacity)
			throw new OverflowISException();
		return stk[ptr++] = x; // 반환 값은 stk[ptr++]
	}
	
	// 스택 데이터 pop, top 데이터 꺼냄
	public int pop() throws EmptyISException{
		if(ptr <=0)
			throw new EmptyISException();
		return stk[--ptr];
	}
	
	// 스택 데이터 피크, top 데이터 봄
	public int peek() throws EmptyISException{
		if(ptr <= 0)
			throw new EmptyISException();
		return stk[ptr -1]; // 보기만 하므로 ptr 값을 변경하지 않는다.
	}
	
	//스택 비우기
	public void clear() {
		ptr = 0;
	}
	
	// 스택 x를 찾고 인덱스 반환, 없으면 -1 반환
	public int indexOf(int x) {
		for(int i = ptr -1; i>=0; i--)
			if(stk[i] == x)
				return i;
		return -1;
	}
	
	// 스택 용량 값 반환
	public int getCapacity() {
		return capacity;
	}
	
	// 스택 데이터 갯수 반환
	public int size() {
		return ptr;
	}
	
	//스택 비어있는지
	public boolean isEmpty() {
		return ptr <= 0;
	}
	
	//스택 가득 찼는지
	public boolean isFull() {
		return ptr >= capacity;
	}
	
	//스택 bottom 부터 top 순서로 출력
	public void dump() {
		if(ptr <=0)
			System.out.println("스택이 비어 있습니다.");
		else {
			for(int i = 0; i < ptr; i++)
				System.out.println(stk[i]+" ");
			System.out.println();
		}
	}
}


