package ua.lviv.lgs;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		Cinema cinema = new Cinema();

		while (true) {

			Menu();

			switch (sc.nextInt()) {
			case 1: {
				cinema.printSchedule();
				break;
			}
			case 2: {
				cinema.addSeance();
				break;
			}
			case 3: {
				cinema.addMovie();
				break;
			}

			case 4: {
				cinema.removeSeance();
				break;

			}
			case 5: {
				cinema.removeMovie();
				break;
			}
			case 6: {
				cinema.allMovie();
				break;
			}

			}

		}

	}

	static void Menu() {

		System.out.println("\n\n1. Подивитись розклад");
		System.out.println("2. Додати сеанс");
		System.out.println("3. Додати фільм");
		System.out.println("4. Видалити сеанс");
		System.out.println("5. Видалити фільм");
		System.out.println("6. Подивитись список фільмів");

	}
}