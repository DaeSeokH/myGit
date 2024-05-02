//링 버퍼로 큐 만들기

public class IntQueue {
	private int[] que; // 큐 배열, 본체 참조 변수
	private int capacity; // 큐 용량
	private int front; // 맨 앞의 요소 커서, 데이터가 나오는 쪽, 맨 앞 요소의 인덱스
	private int rear; // 맨 뒤의 요소 커서, 데이터를 넣는 쪽, 맨 뒤에 넣은 요소 하나 뒤 인덱스, 인큐 데이터 저장될 요소 인덱스 미리 준비
	private int num; // 현재 데이터 갯수

	// 실행 시 예외: 큐가 비어 있음
	public class EmptyIntQueueException extends RuntimeException{
		public EmptyIntQueueException() {
		}
	}

	// 실행 시 예외: 큐가 가득 참
	public class OverflowIntQueueException extends RuntimeException{
		public OverflowIntQueueException() {

		}
	}
	//생성자
	public IntQueue(int maxlen) {
		num=front=rear=0;
		capacity = maxlen;
		try {
			que = new int[capacity]; // 큐 본체 배열 생성
		}catch (OutOfMemoryError e) {
			capacity = 0;
		}
	}

	//큐에 데이터 인큐
	public int enque(int x) throws OverflowIntQueueException {
		if(num >= capacity)
			throw new OverflowIntQueueException();
		que[rear++] = x;
		num++;
		if(rear == capacity) // rear 가 큐용량이랑 같을 때
			rear = 0;
		return x;
	}

	//큐에서 데이터 디큐
	public int deque() throws EmptyIntQueueException {
		if(num <=0)
			throw new EmptyIntQueueException(); // 큐가 비어 있음
		int x = que[front++];
		num--;
		if(front == capacity) // front 가 큐용량이랑 같을 때
			front = 0;
		return x;
	}

	// 큐에서 프런트 데이터를 들여다봄, 맨 앞의 데이터, 다음 디큐할 때 꺼낼 데이터
	public int peek() throws EmptyIntQueueException{
		if(num <= 0)
			throw new EmptyIntQueueException(); // 큐가 비어 있음
		return que[front];
	}

	//큐를 비움
	public void clear() {
		num = front = rear = 0;
	}


	// 큐에서 x 검색, 인덱스를 반환 (없으면 -1 반환)
	public int indexOf(int x) {
		for(int i =0; i < num; i++) {
			int idx = (i + front) % capacity;
			if(que[idx] == x)	// 검색 성공
				return idx;
		}
		return -1;				// 검색 실패
	}

	// 큐의 용량
	public int getCapacity() {
		return capacity;
	}

	// 큐에 쌓여 있는 데이터 개수를 반환
	public int size() {
		return num;
	}

	// 큐가 비어있는지 체크
	public boolean isEmpty() {
		return num <= 0;
	}

	//큐가 가득 찾는지 체크
	public boolean isFull() {
		return num >= capacity;
	}

	// 큐 안의 모든 데이터 프런트 부터 리어 순으로 출력
	public void dump() {
		if(num <= 0)
			System.out.println("큐가 비어있음");
		else {
			for(int i = 0; i<num; i++)
				System.out.println(que[(i + front) % capacity] + " ");
			System.out.println();
		}
	}
}
