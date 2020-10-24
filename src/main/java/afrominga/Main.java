package afrominga;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final String PASSWORD = "S3cret";
        String       password = null;
        int          intentos = 0;

        do {
            System.out.print("Password: ");
            password = scanner.nextLine();

            if (password.equals(PASSWORD)) {
                System.out.println("Acceso Autorizado");
                break;
            } else {
                System.out.println("Acceso Denegado");
                intentos += 1;
            }
        } while (intentos < 3);

        if (intentos == 3) {
            System.out.println("Usted ha intentado " + intentos + " por favor intente nuevamente en 30min.");
        }

        scanner.close();
    }
}
