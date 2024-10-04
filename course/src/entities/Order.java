package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities_enum.OrderStatus;

public class Order {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Client client;
	private Date moment;
	private OrderStatus status;
	
	private List<OrderItems> items = new ArrayList<>();
	

	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public List<OrderItems> getItems() {
		return items;
	}


	public void addItem(OrderItems item) {
		items.add(item);
	}
	
	public void removeItem(OrderItems item) {
		items.remove(item);
	}
	

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}
	
	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}


	public double total() {
		double sum = 0.0;
		for (OrderItems item : items) {
			sum += item.subTotal();
		}
		
		return sum;
		
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: ");
		sb.append(sdf.format(moment) + "\n");
		sb.append("Order status: ");
		sb.append(status + "\n");
		sb.append("Client: ");
		sb.append(client +"\n");
		sb.append("Order moment: \n");

		for (OrderItems item : items) {
			sb.append(item + "\n");
		}
		
		sb.append("Total Price: $");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
		
	}

	
}
