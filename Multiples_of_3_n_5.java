package tutorials.practices;

import java.util.Iterator;
import java.util.LinkedHashSet;

// Find the sum of all the multiples of 3 or 5 below 1000.
public class Multiples_of_3_n_5 {

	public static void main(String[] args) {
		int LIMIT = 1000;
		int sum = 0;
 
		prime_number_fider.fider(LIMIT); // find prime numbers up to LIMIT

		
		LinkedHashSet<Integer> prime_set = new LinkedHashSet<Integer>();
		prime_set = prime_number_fider.prime_numbers_set;
		for(int a : prime_set) { // experiment for prime numbers
			System.out.println(a);
		}
		
		// static class in which 3 and 5 are multiplied by prime numbers
		LinkedHashSet<Integer> MultiplesOf_3 = new LinkedHashSet<Integer>();
		MultiplesOf_3 =	MultipleFider.Multiplier(3, prime_set, LIMIT);  // Multiples of 3
		LinkedHashSet<Integer> MultiplesOf_5 = new LinkedHashSet<Integer>();
		MultiplesOf_3 =	MultipleFider.Multiplier(5, prime_set, LIMIT);  // Multiples of 5
 		
		LinkedHashSet<Integer> MultiplesOf_3_n_5 = new LinkedHashSet<Integer>();
		MultiplesOf_3_n_5.addAll(MultiplesOf_3);
		MultiplesOf_3_n_5.addAll(MultiplesOf_5);
		
		
		// sum all the elements in MultiplesOf_3_n_5
		
		
	}

}


class prime_number_fider{ 
	static LinkedHashSet<Integer> prime_numbers_set = new LinkedHashSet<Integer>(); // 소수가 저장될 공간.
	static void fider(int limit) {
		int j = 0;
		for(int nat_num = 1; nat_num <= limit; nat_num++) { //1부터 limit까지의 소수 탐색해서 array로 출력
			int i = 2; //i는 nat_num을 나눌 자연수. 2부터 시작해서 nat_num-1까지 나누어 떨어지지 않는 nat_num은 소수이다.
			for(i = 2; i < nat_num; i++) {
				if(nat_num%i == 0) // nat_num 은 소수가 아니다.
					break; // nat_num을 증가시켜 다음 자연수를 체크한다.
			} // inside for문을 무사히 통과한 nat_num은 소인수이다.
			if(i != nat_num) // nat_num과 i가 다르면 내부 for문에서 break에 의해 탈출된 것. 
				continue; // 따라서 nat_num은 소수가 아니므로 저장하지 않고 nat_num+1부터 탐색 재시작.
			else {
				prime_numbers_set.add(nat_num);// nat_num == i 인 것은 소수이므로 저장.
				j++;
			}
		}
	}
}


/* Idea for finding multiples from a natural number by multiplying prime numbers
 * 1. "class MultipleFider" will use only one prime number 'p' in the set in each iteration.
 * 2. In each iteration, it returns a set of multiples of a 'n' and powers of 'p'.
 * 3. Each element of result set of previous step will be the new 'n' in next iteration.
 * 4. The next smallest prime number of prime set will be the new 'p' in next iteration.
 */
class MultipleFider{
	int n = 0; // the original number for find multiples
	int p = 0; // the one prime number from a set of prime number
	// Actually 'p' is the smallest prime number in the prime set.
	static LinkedHashSet<Integer> Multiplier(int n, LinkedHashSet<Integer> p_set, int LIMIT) {
		LinkedHashSet<Integer> Result_Set = new LinkedHashSet<Integer>();
	
		// int p = p_set;
		
		LinkedHashSet<Integer> p_set_for_next = new LinkedHashSet<Integer>();
		Iterator<Integer> iter_prime_num = p_set.iterator(); // We need to extract smallest 'p's 1 by 1
		int p = 0;
		int num = 0; // num will be a multiple 
		int i = 0; // i will be the indices
		if(iter_prime_num.hasNext()) { // It provides elements in the same order I had inserted in.
			p = iter_prime_num.next(); // p is the smallest prime number in the prime set.
			while(num < LIMIT) {
				num = (n*(p^(i)));
				if(num < LIMIT)
					Result_Set.add(num);
				i++;
			}
			while(iter_prime_num.hasNext()) {
				p_set_for_next.add(iter_prime_num.next());
			}
			
		}

		Iterator<Integer> iter_natural_num = Result_Set.iterator();
		while(iter_natural_num.hasNext()) { // iter_natural_num의 다음 원소가 없을 때까지 계속 내부 구문 실행.
			n = iter_natural_num.next(); // n is the new original number.		
			Result_Set.addAll(Multiplier(n, p_set_for_next, LIMIT));
			// How to convert Iterator -> LinkedHashSet ??
		}
	
		return Result_Set;
	}
	

}


