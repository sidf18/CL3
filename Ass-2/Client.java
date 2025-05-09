import java.rmi.Naming;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            ConcatInterface stub = (ConcatInterface) Naming.lookup("rmi://localhost/ConcatService");

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter first string: ");
            String str1 = sc.nextLine();
            System.out.print("Enter second string: ");
            String str2 = sc.nextLine();

            String result = stub.concatenate(str1, str2);
            System.out.println("Concatenated result: " + result);
        } catch (Exception e) {
            System.out.println("Client error: " + e);
        }
    }
}




//how to run in windows
//1- javac *.java (compile all files)
//2-rmiregistry(Start the RMI Registry in terminal 1)
// 3- java Server (Run the Server (in terminal 2)
//4- java Client  (Run the Client (in terminal 3)



/*for ubuntu same as windows 
 If you get a command not found, install the JDK:
sudo apt update
sudo apt install default-jdk
 */


