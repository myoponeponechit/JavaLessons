package day11;

public class ProductService extends DatabaseUtil{

	@Override
	public void insert() {
		System.out.println("insert product to table");
		
	}

	@Override
	public void update() {
		System.out.println("update product to product table");
		
	}

	@Override
	public boolean delete(int id) {
		System.out.println("delete product where id = " + id);
		return false;
	}

	@Override
	public Object findById(int id) {
		System.out.println("select * from product table where id = " + id);
		return null;
	}

}
