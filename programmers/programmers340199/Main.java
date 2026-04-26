public class Main {
    public static void main(String[] args){
        Solution sol = new Solution();

        int[] wallet = {50, 50};
        int[] bill = {100, 241};

        System.out.println(sol.solution(wallet,bill));
    }

    static class Solution {
        public int solution(int[] wallet, int[] bill) {
            int answer = 0;
            int smaller_bill = bill[0] < bill[1] ? bill[0] : bill[1];
            int bigger_bill = bill[0] > bill[1] ? bill[0] : bill[1];
            int smaller_wallet = wallet[0] < wallet[1] ? wallet[0] : wallet[1];
            int bigger_wallet = wallet[0] > wallet[1] ? wallet[0] : wallet[1];

            while (smaller_bill>smaller_wallet||bigger_bill>bigger_wallet){
                bigger_bill/=2;
                if(bigger_bill<smaller_bill){
                    int swap = bigger_bill;
                    bigger_bill = smaller_bill;
                    smaller_bill = swap;
                }

                answer++;
            }
            return answer;
        }
    }
}
