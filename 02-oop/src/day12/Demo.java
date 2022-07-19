package day12;

public class Demo {
	public static void main(String[] args) {
		Button btn1 = new Button("btn-login");
		Button btn2 = new Button("btn-logout");
		
		btn1.display();
		btn1.onClick();
		btn1.onDoubleClick();
		
		System.out.println();
		btn2.display();
		btn2.onClick();
		btn2.onDoubleClick();
		
		// interface is abstract type.so, it can't create object.
		//OnClickListener obj = new OnClickListener(); 
	}
}
