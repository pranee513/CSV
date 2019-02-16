/**
 * Created by pbathini on 2/15/2019.
 */
public class Product implements Comparable<Product> {
	public String Category, part, Description, UOM;
	public double price, discount;

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	@Override
	public String toString() {
		return "Product{" + "Category='" + Category + '\'' + ", part='" + part + '\'' + ", Description='" + Description
				+ '\'' + ", UOM='" + UOM + '\'' + ", price=" + price + ", discount=" + discount + '}';
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getUOM() {
		return UOM;
	}

	public void setUOM(String UOM) {
		this.UOM = UOM;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public Product(String Category, String part, String Description, String UOM, double price, double discount) {
		super();
		this.Category = Category;
		this.part = part;
		this.Description = Description;
		this.UOM = UOM;

		this.price = price;
		this.discount = discount;
	}

	@Override
	public int compareTo(Product o) {

		return (this.price) - (o.price) > 0 ? 1 : -1;

	}
}