package tutorials.practices;

import java.util.Iterator;
//import java.util.Iterator;
//import java.util.LinkedHashSet;
import java.util.TreeSet;

// Find the sum of all the multiples of 3 or 5 below 1000.
public class Multiples_of_3_n_5 {
enum STATUS { INITIALIZE, END, STEP1, STEP2, STEP3;	}

	public static void main(String[] args) {
		int LIMIT = 1000;
		int sum = 0;

		prime_number_fider.fider(LIMIT); // find prime numbers up to LIMIT

		TreeSet<Integer> prime_set = new TreeSet<Integer>();

		prime_set = prime_number_fider.prime_numbers_set;
		System.out.println("The prime set under the LIMIT("+LIMIT+") : "+prime_set);
		// Prime numbers were made perfectly.
		
		// The 'prime_set' should be copied.
		TreeSet<Integer> prime_set_for3 = new TreeSet<Integer>();
		prime_set_for3.addAll(prime_set);
		TreeSet<Integer> prime_set_for5 = new TreeSet<Integer>();
		prime_set_for5.addAll(prime_set);
		
		// The I/O of static method 'MultipleFider.fider'
		// 1. Input: initial_number(3 or 5) , set of prime numbers , LIMIT
		// 2. Ouput: MultiplesOf_3 is the ouput.
		
		TreeSet<Integer> MultiplesOf_3 = new TreeSet<Integer>(); // 'MultiplesOf_3' is the 
		MultiplesOf_3 = MultipleFider.finder(3, prime_set_for3, LIMIT);

		TreeSet<Integer> MultiplesOf_5 = new TreeSet<Integer>();
		MultiplesOf_5 = MultipleFider.finder(5, prime_set_for5, LIMIT);
	
		TreeSet<Integer> MultiplesOf_3n5 = new TreeSet<Integer>();
		MultiplesOf_3n5.addAll(MultiplesOf_3);
		MultiplesOf_3n5.addAll(MultiplesOf_5);
		System.out.println("\n\nThe result set: "+MultiplesOf_3n5);
		
		Iterator<Integer> iter_for_sum = MultiplesOf_3n5.iterator();
		while(iter_for_sum.hasNext()) {
			sum += iter_for_sum.next();
		}
		System.out.println("\nThe sum of all multiples of 3 and 5 is "+sum);

	} // main end

}

class prime_number_fider {
	static TreeSet<Integer> prime_numbers_set = new TreeSet<Integer>(); // 소수가 저장될 공간.

	static void fider(int LIMIT) {
		for (int nat_num = 1; nat_num <= LIMIT; nat_num++) { // 1부터 limit까지의 소수 탐색해서 array로 출력
			int i = 2; // i는 nat_num을 나눌 자연수. 2부터 시작해서 nat_num-1까지 나누어 떨어지지 않는 nat_num은 소수이다.
			for (i = 2; i < nat_num; i++) {
				if (nat_num % i == 0) // nat_num 은 소수가 아니다.
					break; // nat_num을 증가시켜 다음 자연수를 체크한다.
			} // inside for문을 무사히 통과한 nat_num은 소인수이다.
			if (i != nat_num) // nat_num과 i가 다르면 내부 for문에서 break에 의해 탈출된 것.
				continue; // 따라서 nat_num은 소수가 아니므로 저장하지 않고 nat_num+1부터 탐색 재시작.
			else {
				prime_numbers_set.add(nat_num);// nat_num == i 인 것은 소수이므로 저장.
			}
		}
	}
}


// The spec of static method 'MultipleFider.fider'
// 1. Input: initial_number(3 or 5) , set of prime numbers , LIMIT
// 2. Ouput: 'MultiplesOf_n' is the ouput.
class MultipleFider {
	enum STATUS { INITIALIZE, END, STEP1, STEP2, STEP3;	}
	 static TreeSet<Integer> finder(int initial_num, TreeSet<Integer> prime_set1, int LIMIT) {
		TreeSet<Integer> MultiplesOf_n_by2 = new TreeSet<Integer>(); // 'n' is the initial number, 3 or 5.
		TreeSet<Integer> MultiplesOf_n = new TreeSet<Integer>();
		STATUS status = STATUS.INITIALIZE;
		int cont = 1;
		while(cont == 1) {
			switch (status) {
			case INITIALIZE: // Make a set of multiples of '2', the smallest prime number.
				int p_init = prime_set1.first(); // The smallest prime number, 2 will be entered in 'p_init'.
				prime_set1.remove(p_init); // remove 2.
				int multiple;
				
				for(int i = 0; i < LIMIT ; i++) {
					multiple = initial_num*((int)(Math.pow(p_init, i)));
					if(multiple < LIMIT)
						MultiplesOf_n_by2.add(multiple);
					else
						break; // break the 'for' loop.
				} 
				MultiplesOf_n.addAll(MultiplesOf_n_by2);
				status = STATUS.STEP1;
				break;
			case STEP1:
				int p = prime_set1.first(); // The next smallest element, 3 will be entered in 'p'. 
				prime_set1.remove(p);
				TreeSet<Integer> Temp_set = new TreeSet<Integer>();
				Iterator<Integer> Iter_multiples = MultiplesOf_n.iterator();
				while(Iter_multiples.hasNext()) { // {3, 6, 12, 24, ...} 가 하나씩 나온다.
					int n;
					n = Iter_multiples.next();
					
					for(int i = 0; ; i++) {
						int result = n*(int)(Math.pow(p, i));
						if(result < LIMIT)
							Temp_set.add(result);
						else {
							break; // If the result should exceed LIMIT, it may break the for loop.
						}
					} // for end		
				} // while end
				
				MultiplesOf_n.addAll(Temp_set); // In the iteration, the Temporal_treeset helps to remove the error.
				status = STATUS.STEP2;
				break;
			case STEP2: // Preparing some settings to implement another STEP1.
				if(prime_set1.size() == 0) // The prime set is sold out.
					status = STATUS.END;
				else
					status = STATUS.STEP1;
				break;
			
			case END:
				cont = 0; // escape while loop.
				System.out.println("End! The result multiples of "+initial_num+" : "+MultiplesOf_n);
				break;	
			default:
				cont = 0;
				break;
			} // switch end
		} // while end
		return MultiplesOf_n;
	} // method end
}



