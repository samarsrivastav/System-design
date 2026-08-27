package food_delivery_app.model;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
	private String id;
	private String name;
	private List<MenuItem> menuItems = new ArrayList<>();

	public Restaurant() {}

	public Restaurant(String id, String name, List<MenuItem> menuItems) {
		this.id = id;
		this.name = name;
		this.menuItems = menuItems;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MenuItem> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}
}
