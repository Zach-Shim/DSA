public class Test {
	public static void main(String[] args) {		
		// test LinkedStack
		Stack<String> s2 = new LinkedStack<String>();
		s2.push("hello");
		s2.push("how");
		s2.push("are");
		s2.push("you?");
		System.out.println("toString: " + s2);
		
		// for-each loop uses Iterator
		for (String str : s2) {
			System.out.println("for-each loop: " + str);
		}
		
		while (!s2.isEmpty()) {
			System.out.println("pop: " + s2.pop());
		}
		
		// System.out.println(s.pop());  // EmptyStackException
	}
}