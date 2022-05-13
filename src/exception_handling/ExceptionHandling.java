package exception_handling;

import java.util.Scanner;

public class ExceptionHandling {
    Scanner scanner = new Scanner(System.in);

    public int checkInputOfInteger(String line){
        boolean check = false;
        int out = 0;
        do {
            try {
                System.out.print(line);
                String input = scanner.nextLine();
                out = Integer.parseInt(input);
                check = true;
            } catch (NumberFormatException e) {
                System.out.println("---------------------------------");
                System.out.println("Nhập sai định dạng!!!");
            }
        } while (!check);
        return out;
    }
}
