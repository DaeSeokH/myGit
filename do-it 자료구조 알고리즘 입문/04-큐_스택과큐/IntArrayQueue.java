// int형 고정 길이 큐(링 버퍼를 사용하지 않고 구현)

public class IntArrayQueue {
	private int [] que;			// 큐의 본체
	private int capacity;		// 큐의 용량
	private int num;				// 현재 데이터 개수

	//큐가 비어있음
	public class EmptyIntArrayQueueException extends RuntimeException {
		public EmptyIntArrayQueueException() { }
	}

	//큐가 가득참
	public class OverflowIntArrayQueueException extends RuntimeException {
		public OverflowIntArrayQueueException() { }
	}


	//생성자
	public IntArrayQueue(int maxlen) {
		num = 0;
		capacity = maxlen;
		try {
			que = new int[capacity];			// 큐 본체용 배열을 생성
		} catch (OutOfMemoryError e) {		// 생성할 수 없음
			capacity = 0;
		}
	}

	//인큐
	public int enque(int x) throws OverflowIntArrayQueueException {
		if (num >= capacity)
			throw new OverflowIntArrayQueueException();			// 큐가 가득 참
		que[num++] = x;
		return x;
	}

	//디큐
	public int deque() throws EmptyIntArrayQueueException {
		if (num <= 0)
			throw new EmptyIntArrayQueueException();				// 큐가 비어 있음
		int x = que[0]; // 선입 선출
		for (int i = 0; i < num - 1; i++)
			que[i] = que[i + 1]; // 값을 하나씩 앞으로 땡긴다.
		num--;
		return x;
	}

	//큐 데이퍼 피크 맨앞 데이터 보기
	public int peek() throws EmptyIntArrayQueueException {
		if (num <= 0)
			throw new EmptyIntArrayQueueException();			// 큐가 비어 있음
		return que[num - 1];
	}

	//큐 x 검색
	public int indexOf(int x) {
		for (int i = 0; i < num; i++)
			if (que[i]  == x)					// 검색 성공
				return i;
		return -1;									// 검색 실패
	}

	//큐 비우기
	public void clear() {
		num = 0;
	}

	//큐 용량
	public int capacity() {
		return capacity;
	}

	//큐 데이터 수
	public int size() {
		return num;
	}

	//큐 비어있는지?
	public boolean isEmpty() {
		return num <= 0;
	}

	//큐 가득인지?
	public boolean isFull() {
		return num >= capacity;
	}

	//맨앞부터 맨끝 출력
	public void dump() {
		if (num <= 0)
			System.out.println("큐가 비어 있습니다.");
		else {
			for (int i = 0; i < num; i++)
				System.out.print(que[i] + " ");
			System.out.println();
		}
	}
}

