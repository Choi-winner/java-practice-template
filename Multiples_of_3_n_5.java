package tutorials.practices;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

// Find the sum of all the multiples of 3 or 5 below 1000.
public class Multiples_of_3_n_5 {

	public static void main(String[] args) {
		int LIMIT = 1000;
		int sum = 0;
 
		prime_number_fider.fider(LIMIT); // find prime numbers up to LIMIT

		for(int a : prime_number_fider.prime_numbers_set) { // experiment for prime numbers
			System.out.println(a);
		}
		
/*		for(int a = 0; ; a++) {
			for(int b = 0; ; b++) {
				for(int c = 0; ; c++) {
					for(int d = 0; ; d++) {
						for(int e = 0; ; e++) {
							for(int f = 0; ; f++) {
								for(int g = 0; ; g++) {
									for(int h = 0; ; h++) {
										
									}
									
								}
								
							}
							
						}
						
					}
					
				}
			}
		}
*/	
		// static class in which 3 and 5 are multiplied by prime numbers
		
		HashSet<Integer> MultiplesOf_3; // Multiples of 3
		HashSet<Integer> MultiplesOf_5; // Multiples of 5
 		

		for(int i = 1; i <= LIMIT; i++) {
			
			
		}
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


