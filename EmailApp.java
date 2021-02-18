package emailApp;

public class EmailApp {
    public static void main(String[] args) {
        Email email1 = new Email("Daniel", "Brunescu");
        email1.setAlternateEmail("bdanok@gmail.com");
        System.out.println(email1.showInfo());
    }
}
