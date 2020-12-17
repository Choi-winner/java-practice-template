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
	static int[] prime_numbers = new int[200]; // 소수가 저장될 공간.
	static prime_number_fider found = new prime_number_fider();
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
				prime_numbers[j] = nat_num;// nat_num == i 인 것은 소수이므로 저장.
				j++;				
			}	
		}
	}

	
	
	
	
}