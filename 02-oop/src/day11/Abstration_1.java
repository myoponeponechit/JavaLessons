package day11;

public class Abstration_1 {
	public static void main(String[] args) {
		DatabaseUtil db_util = new ProductService();
		db_util.insert();
		
		ProductService p_service = new ProductService();
		p_service.connectDatabase();
		p_service.insert();
		p_service.update();
		p_service.delete(1001);
		p_service.findById(1002);
	}
}
