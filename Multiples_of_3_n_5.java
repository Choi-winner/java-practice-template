package tutorials.practices;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

// Find the sum of all the multiples of 3 or 5 below 1000.
public class Multiples_of_3_n_5 {

	public static void main(String[] args) {
		int LIMIT = 50;
		// int sum = 0;
 
		prime_number_fider.fider(LIMIT); // find prime numbers up to LIMIT

		
		TreeSet<Integer> prime_set = new TreeSet<Integer>();
		prime_set = prime_number_fider.prime_numbers_set;
		for(int a : prime_set) { // experiment for prime numbers
			System.out.println(a);
		}
		
		// static class in which 3 and 5 are multiplied by prime numbers
		TreeSet<Integer> MultiplesOf_3 = new TreeSet<Integer>();
		MultiplesOf_3 =	MultipleFider.Multiplier(3, prime_set, LIMIT);  // Multiples of 3
		//LinkedHashSet<Integer> MultiplesOf_5 = new LinkedHashSet<Integer>();
		//MultiplesOf_3 =	MultipleFider.Multiplier(5, prime_set, LIMIT);  // Multiples of 5
 		
		//LinkedHashSet<Integer> MultiplesOf_3_n_5 = new LinkedHashSet<Integer>();
		//MultiplesOf_3_n_5.addAll(MultiplesOf_3);
		//MultiplesOf_3_n_5.addAll(MultiplesOf_5);
		
		
		Iterator<Integer> iter_Mul_Of_3 = MultiplesOf_3.iterator();
		System.out.println("the multiples are: ");
		while(iter_Mul_Of_3.hasNext()) {
		System.out.println(iter_Mul_Of_3.next());
		
		
		
		}
		
		
		// sum all the elements in MultiplesOf_3_n_5
		
		
	}

}


class prime_number_fider{ 
	static TreeSet<Integer> prime_numbers_set = new TreeSet<Integer>(); // �Ҽ��� ����� ����.
	static void fider(int LIMIT) {
		for(int nat_num = 1; nat_num <= LIMIT; nat_num++) { //1���� limit������ �Ҽ� Ž���ؼ� array�� ���
			int i = 2; //i�� nat_num�� ���� �ڿ���. 2���� �����ؼ� nat_num-1���� ������ �������� �ʴ� nat_num�� �Ҽ��̴�.
			for(i = 2; i < nat_num; i++) {
				if(nat_num%i == 0) // nat_num �� �Ҽ��� �ƴϴ�.
					break; // nat_num�� �������� ���� �ڿ����� üũ�Ѵ�.
			} // inside for���� ������ ����� nat_num�� ���μ��̴�.
			if(i != nat_num) // nat_num�� i�� �ٸ��� ���� for������ break�� ���� Ż��� ��. 
				continue; // ���� nat_num�� �Ҽ��� �ƴϹǷ� �������� �ʰ� nat_num+1���� Ž�� �����.
			else {
				prime_numbers_set.add(nat_num);// nat_num == i �� ���� �Ҽ��̹Ƿ� ����.
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
	static TreeSet<Integer> Multiplier(int n, TreeSet<Integer> p_set, int LIMIT) {
		TreeSet<Integer> Result_Set = new TreeSet<Integer>(); // multiples are in the result set.		
		TreeSet<Integer> p_set_for_next = new TreeSet<Integer>(); // p_set_for_next is the temporal prime set for
		Iterator<Integer> iter_prime_num = p_set.iterator(); // We need to extract smallest 'p's 1 by 1
		int p = 1;
		int num_multiple = 1; // num will be a multiple 
		int i = 0; // i will be the indices
		
		
		p_set_for_next = p_set;
		// ���� ���� �Ҽ� p�� �����ϰ�, n�� p�� �ŵ������� num_multiple�� �����Ѵ�. �� num_multiple�� Result_set�� ����ȴ�.
		if(iter_prime_num.hasNext()) { // It provides elements in the same order I had inserted in.
			p = iter_prime_num.next(); // p is the smallest prime number in the prime set. 2
			System.out.println("p = "+p); // 2
			while(num_multiple < LIMIT) {
				num_multiple = (n*((int)(Math.pow(p,i)))); //  3*(2^0), 3*(2^1), 3*(2^2), ...
				System.out.println("n = "+n +"/  p = "+p+ "/  i = "+i  +" =>=> "+num_multiple);
	
				if(num_multiple < LIMIT) {
					Result_Set.add(num_multiple); // 1. "Result_Set" = {3, 6, 12, 24, ...} // 2. "Result_Set" = {3, 9, 27, 81, ...}
					System.out.println("num_multiple = "+num_multiple + " was added");
				}
					
				i++;
			}

			p_set_for_next.remove(p); // Used prime number is eliminated from the prime number set. �Ʒ��� while���� �̰ɷ� ��ü�� �� �ִ�.
			System.out.println("the new prime set has made.");
			/*
			while(iter_prime_num.hasNext()) { // To convert Iterator to LinkedHashSet
				int temp_p = iter_prime_num.next();
				p_set_for_next.add(temp_p); // The "p_set_for_next" has lost the smallest prime number.
				System.out.println("temp_p = "+temp_p);
			} // "p_set_for_next" = {3, 5, 7, 11, ...} <- 2 was eliminated
			*/
			
			
		}

		Iterator<Integer> iter_natural_num = Result_Set.iterator();
		while(iter_natural_num.hasNext()) { // iter_natural_num�� ���� ���Ұ� ���� ������ ��� ���� ���� ����.
			int temp_natural_num = iter_natural_num.next();
			/*if(n == temp) // If the 'temp' is same as 'n', the iteration will not end. <- it was an error.
				continue;
			else
				n = temp; // n is the new original number. 	
			*/	
			n = temp_natural_num;
			System.out.println("-------------------start------------------\nThe input of new method: n = "+temp_natural_num);
			Iterator<Integer> new_p_iter = p_set_for_next.iterator();
			int k = 1;
			while(new_p_iter.hasNext()) {
				System.out.println("The new prime number "+k+" : "+new_p_iter.next());
				k++;
			}
			System.out.println("-------------------end!!--------------------");
			/*if(Result_Set.size() == 1) // Get lid of meaningless iterations
			{
				System.out.println("Break!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				break; // go to return
			}
			*/
			
			
			
			Result_Set.addAll(MultipleFider.Multiplier(n, p_set_for_next, LIMIT)); // n = 3, "p_set_for_next" = {3, 5, 7, 11, ...}, LIMIT = 1000

		}
		System.out.println("\nReturning result: ");
		Iterator<Integer> Result_temp = Result_Set.iterator();
		while(Result_temp.hasNext())
			System.out.println(Result_temp.next());
		return Result_Set;
	}
	

}


