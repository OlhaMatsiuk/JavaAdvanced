package ua.lviv.lgs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Supplier;

public class Cinema {

	private TreeMap<Days, Schedule> DS = new TreeMap<>();
	private Time open;
	private Time close;

	Days[] days = Days.values();
	ArrayList<Movie> listMovie = new ArrayList<>();

	public Cinema() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Створіть свій кінотеатр!\n\n");
		System.out.println("Коли відривається ваш кінотеатр?\n");
		System.out.print("Година: ");
		int hourOp = sc.nextInt();
		System.out.print("Хвилини: ");
		int minOp = sc.nextInt();
		System.out.println();

		System.out.println("Коли закривається ваш кінотеатр?\n");
		System.out.print("Година: ");
		int hourCl = sc.nextInt();
		System.out.print("Хвилини: ");
		int minCl = sc.nextInt();
		System.out.println();

		this.open = new Time(hourOp, minOp);
		this.close = new Time(hourCl, minCl);
		
		for(int i = 0; i < days.length; i++) {
			Schedule sch = new Schedule();
			DS.put(days[i], sch);
		}

	}

	Supplier<Movie> addMovie = () -> {

		Scanner sc = new Scanner(System.in);
		System.out.print("Введіть назву фільму: ");
		String title = sc.nextLine();
		System.out.println();

		System.out.print("Введіть тривалість фільму: ");
		int duration = sc.nextInt();
		System.out.println();

		return new Movie(title, duration);
	};

	Supplier<Time> addTime = () -> {

		Scanner sc = new Scanner(System.in);
		System.out.print("Введіть годину початку: ");
		int hour = sc.nextInt();
		System.out.println();

		System.out.print("Введіть хвилину початку: ");
		int min = sc.nextInt();
		System.out.println();

		if (hour < open.getHour() || hour == open.getHour() && min < open.getMin())
			return new Time(open.getMin(), open.getHour());
		else
			return new Time(min, hour);

	};

	public void printSchedule() {

		for (Map.Entry<Days, Schedule> entry : DS.entrySet()) {
			Days key = entry.getKey();
			Schedule value = entry.getValue();
			System.out.println(key + "\n   " + value + "\n");
			System.out.println("-------------------------------");
		}
	}

	public void allMovie() {
		for (Movie m : listMovie) {
			System.out.println(m.getTitle());
		}
	}

	public void addMovie() {

		Scanner sc = new Scanner(System.in);

		Movie movie = addMovie.get();
		listMovie.add(movie);
		System.out.print("Введіть номер дня сеансу: ");
		int day = sc.nextInt() - 1;
		Time time = addTime.get();
		Seance seance = new Seance(movie, time);
		DS.get(days[day]).getSchedule().add(seance);
		
		System.out.println("Фільм та сеанс додано!");
	}

	public void addSeance() {

		System.out.println("Якщо ви хочете додати сеанс до існуючого фільму натисніть 1, "
				+ "\nякщо дадати новий фільм тоді 2! : ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		if (num == 1) {

			System.out.print("Введіть назву фільму: ");
			String movie = sc.next();

			for (Movie m : listMovie) {

				{
					if (m.getTitle().equalsIgnoreCase(movie)) {

						System.out.print("Введіть номер дня сеансу: ");
						int day = sc.nextInt() - 1;
						Time time = addTime.get();
						Seance seance = new Seance(m, time);
						DS.get(days[day]).getSchedule().add(seance);

					}

				}

			}
		}

		if (num == 2) {

			Movie movie = addMovie.get();
			listMovie.add(movie);
			System.out.print("Введіть номер дня сеансу: ");
			int day = sc.nextInt() - 1;
			Time time = addTime.get();
			Seance seance = new Seance(movie, time);
			DS.get(days[day]).getSchedule().add(seance);
			
			System.out.println("Фільм додано");

		}

		System.out.println("Сеанс додано!");

	}

	public void removeMovie() throws Exception {

		Scanner sc = new Scanner(System.in);
		System.out.print("Введіть назву фільму: ");
		String title = sc.next();

		for (Days d : days) {
			
			DS.get(d).removeSeanceS(title);
			
		}
	}

	public void removeSeance() {

		Scanner sc = new Scanner(System.in);
		System.out.print("Введіть номер дня сеансу: ");
		int day = sc.nextInt()-1;
		System.out.print("Введіть назву фільму: ");
		String title = sc.next();
		DS.get(days[day]).removeSeanceS(title);
	}

	

}
