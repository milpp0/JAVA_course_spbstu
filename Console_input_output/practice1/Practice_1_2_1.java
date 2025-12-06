package practice1;

import java.util.Scanner;

public class Practice_1_2_1 {
	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			String name = scan.next();
			System.out.println("Привет, " + name);
		}
    }
}