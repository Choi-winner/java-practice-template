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
	static LinkedHashSet<Integer> prime_numbers_set = new LinkedHashSet<Integer>(); // �Ҽ��� ����� ����.
	static void fider(int limit) {
		int j = 0;
		for(int nat_num = 1; nat_num <= limit; nat_num++) { //1���� limit������ �Ҽ� Ž���ؼ� array�� ���
			int i = 2; //i�� nat_num�� ���� �ڿ���. 2���� �����ؼ� nat_num-1���� ������ �������� �ʴ� nat_num�� �Ҽ��̴�.
			for(i = 2; i < nat_num; i++) {
				if(nat_num%i == 0) // nat_num �� �Ҽ��� �ƴϴ�.
					break; // nat_num�� �������� ���� �ڿ����� üũ�Ѵ�.
			} // inside for���� ������ ����� nat_num�� ���μ��̴�.
			if(i != nat_num) // nat_num�� i�� �ٸ��� ���� for������ break�� ���� Ż��� ��. 
				continue; // ���� nat_num�� �Ҽ��� �ƴϹǷ� �������� �ʰ� nat_num+1���� Ž�� �����.
			else {
				prime_numbers_set.add(nat_num);// nat_num == i �� ���� �Ҽ��̹Ƿ� ����.
				j++;
			}
		}
	}
}


