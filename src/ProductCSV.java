
/**
 * Created by pbathini on 2/15/2019.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ProductCSV {

	public static final String CSV_PATH = "resources/csv.txt";
	private static final int COLUMN_COUNT = 6;
	public static ArrayList<String> aList = new ArrayList<String>();

	public static void main(String[] args) throws IOException {

		readAllLinesFromFile(CSV_PATH);
		System.out.println("Unsorted:\n");
		for (String product : aList) {
			System.out.println(product + "\n");
		}

		ArrayList<Product> products = convertToProducts(aList);
		System.out.println("##########################");
		System.out.println("SORTED BY PRICE:\n");
		for (Product product : products) {
			System.out.println(product.toString());
		}
	}

	public static ArrayList<String> readAllLinesFromFile(String path) throws IOException {

		// using try with resource, Java 7 feature to close resources
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				aList.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return aList;

	}

	public static ArrayList<Product> convertToProducts(ArrayList<String> productStrings) {
		ArrayList<Product> Products = new ArrayList<>();
		// removing header from CSV
		productStrings.remove(0);
		for (String productString : productStrings) {
			String[] parts = productString.split("\\s*,\\s*");
			if (parts.length == COLUMN_COUNT) {
				String Category = parts[0].trim();
				String part = parts[1].trim();
				String Description = parts[2].trim();
				String UOM = parts[3].trim();
				double price = Double.parseDouble(parts[4].trim().replace("$", ""));
				double discount = Double.parseDouble(parts[5].trim().replace("%", ""));
				Products.add(new Product(Category, part, Description, UOM, price, discount));
			} else {
				System.out.println("Invalid Records" + Arrays.toString(parts) + "\n");
			}
		}

		Collections.sort(Products, new Comparator<Product>() {

			@Override
			public int compare(Product o1, Product o2) {
				return o1.compareTo(o2);
			}
		});
		return Products;
	}
}
