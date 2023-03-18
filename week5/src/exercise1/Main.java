package exercise1;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        HashMap<String,Account> accountHashMap = new HashMap<>();

        Account account1 = new Account("Jose","Calle Pitagoras",100.0,"1234567",Hold.FRAUD);
        Account account2 = new Account("Adrian","Calle Pitagoras",200.0,"7654321",Hold.FRAUD);

        accountHashMap.put(account1.getAccountNumber(),account1);
        accountHashMap.put(account2.getAccountNumber(),account2);

        accountHashMap.forEach((clave, account) -> {
            System.out.println(clave+ " "+ account);
        });
    }
}
