
/**
 * @author Rishabh Agarwal
 * http://www.spoj.com/problems/ONP/
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

class Main {
	public static void main(String[] args) throws java.lang.Exception {

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		String s;
		in.nextLine();
		while (t > 0) {
			s = in.nextLine();
			postfix(s);
			t--;
		}
		in.close();

	}

	/**
	 * @param s
	 */
	private static void postfix(String s) {
		// TODO Auto-generated method stub
		Stack<Character> stack = new Stack<>();

		HashMap<Character, Integer> operator = new HashMap<>();
		HashSet<Character> operands = new HashSet<>();
		char m = 'a';
		while (m <= 'z') {
			operands.add(m);
			m++;
		}

		operator.put('+', 0);
		operator.put('-', 1);
		operator.put('*', 2);
		operator.put('/', 3);
		operator.put('^', 4);
		StringBuilder ans = new StringBuilder("");
		char p;
		char c[] = s.toCharArray();
		int i = 0;
		while (i < c.length) {
			p = c[i];
			if (operands.contains(p)) {
				ans.append(p);
			} else if (p == '(') {
				stack.push(p);
			} else if (operator.keySet().contains(p)) {
				while (!stack.isEmpty() && stack.peek() != '(' && operator.get(stack.peek()) > operator.get(p)) {
					ans.append(stack.pop());
				}
				stack.push(p);
			} else {
				while (!stack.isEmpty() && stack.peek() != '(') {
					ans.append(stack.pop());
				}
				stack.pop();
			}

			i++;
		}
		while (!stack.isEmpty()) {
			ans.append(stack.pop());
		}
		System.out.println(ans);

	}
}
