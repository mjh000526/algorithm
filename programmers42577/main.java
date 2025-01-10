import java.util.Arrays;

public class main {
    public static void main(String[] args){
        String[] phone_book = {"119", "97674223", "1195524421"};
        Arrays.sort(phone_book);
        for(int i=1;i<phone_book.length;i++){
            if (phone_book[i].startsWith(phone_book[i - 1])) {
                System.out.println("false");
            }
        }
        System.out.println("true");
    }
}
