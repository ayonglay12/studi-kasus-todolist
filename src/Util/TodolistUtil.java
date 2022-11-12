
package Util;
import java.util.Scanner;

public class TodolistUtil {
    
    public static String input(String pilih){
        Scanner input = new Scanner(System.in);
        System.out.print(pilih + " : ");
        String data = input.nextLine();
        return data;
    }
    
}
