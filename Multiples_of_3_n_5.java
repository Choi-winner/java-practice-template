package tutorials.practices;
// Find the sum of all the multiples of 3 or 5 below 1000.
public class Multiples_of_3_n_5 {

	public static void main(String[] args) {
		int LIMIT = 1000;
		int sum = 0;
 
		prime_number_fider.fider(100);
		int[] primes = prime_number_fider.prime_numbers;
		System.out.println("primes from "+1+" to "+100+": "+primes[0]);
		System.out.println("primes from "+1+" to "+100+": "+primes[1]);
		System.out.println("primes from "+1+" to "+100+": "+primes[2]);
		System.out.println("primes from "+1+" to "+100+": "+primes[3]);
		System.out.println("primes from "+1+" to "+100+": "+primes[4]);
		System.out.println("primes from "+1+" to "+100+": "+primes[5]);
		
/*
		for(int i = 1; i <= limit; i++) {
			
			
			
			
		}
*/	
		
		
		
		
		
	}

}

class prime_number_fider{
	static int[] prime_numbers = new int[200]; // �Ҽ��� ����� ����.
	static prime_number_fider found = new prime_number_fider();
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
				prime_numbers[j] = nat_num;// nat_num == i �� ���� �Ҽ��̹Ƿ� ����.
				j++;				
			}	
		}
	}

	
	
	
	
}