package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();

		Field[] fields = RichSoilLand.class.getDeclaredFields();

		while(!input.equals("HARVEST")) {

			String finalInput = input;

			Field[] filteredFields = Arrays.stream(fields).filter(f -> Modifier.toString(f.getModifiers()).equals(finalInput)).toArray(Field[]::new);
			if(filteredFields.length != 0) {
				Arrays.stream(filteredFields).forEach(f -> System.out.printf("%s %s %s\n", Modifier.toString(f.getModifiers()), f.getType().getSimpleName(), f.getName()));
			} else {
				Arrays.stream(fields).forEach(f -> System.out.printf("%s %s %s\n", Modifier.toString(f.getModifiers()), f.getType().getSimpleName(), f.getName()));
			}
			input = sc.nextLine();
		}
	}
}
