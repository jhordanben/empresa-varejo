package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItems;
import entities.Product;
import entities_enum.OrderStatus;

public class Program {
	
	public static void main (String [] args) throws ParseException {
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		
		System.out.println("Enter Client Data: ");
		System.out.println("Name:");
		String Name = sc.nextLine();
		System.out.println("Email:");
		String Email = sc.nextLine();
		System.out.println("Birth Date:");
		Date BirthDate = sdf.parse(sc.next());
		
		Client client = new Client(Name, Email, BirthDate);
		
		System.out.println("Enter Client Data: ");
		System.out.println("Status:");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		Order order = new Order(new Date(), status, client);
		
		System.out.println("How many items to this order? ");
		int n = sc.nextInt();
		for (int i=1; i<=n; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product Name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			
			Product product = new Product(productName, productPrice);
			
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			
			OrderItems orderItems = new OrderItems(quantity, productPrice, product);
			
			order.addItem(orderItems);
		}
		
		System.out.println();
		System.out.println("ORDER SUMARY: ");
		System.out.println(order);
		
		sc.close();
		
		
	}

}
