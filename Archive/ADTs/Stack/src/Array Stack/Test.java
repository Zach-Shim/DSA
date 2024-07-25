public class Test {
    public static void main(String[] args) {
		Stack<Integer> s = new ArrayStack<Integer>();
		s.push(42);
		s.push(-17);
		s.push(29);
		s.push(5);
		s.push(5983275);
		s.push(1234);
        System.out.println("toString: " + s);
		
        // for-each loop uses Iterator
		for (int n : s) {
			System.out.println("for-each loop: " + n);
		}

        while (!s.isEmpty()) {
			System.out.println(s.pop());
		}
		// System.out.println(s.pop());  // EmptyStackException
	}

}
