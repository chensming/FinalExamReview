//第三题
import java.util.StringTokenizer;
import java.util.Scanner;

class NumberException extends Exception{
	private static final long serialVersionUID = 1L;
	public NumberException(String msg){
		super(msg);
	}
}

abstract class Graphics{
	public double area(){ return 0.0;}
}


//正方形
class Square extends Graphics{
	private double a;
	public Square(double a){
		this.a = a;
	}
	public double area(){
		return a * a;
	}
}

//长方形
class Rectangle extends Graphics{
	private double a;
	private double b;
	public Rectangle(double a, double b) {
		this.a = a;
		this.b = b;
	}

	public double area(){
		return a * b;
	}
}

//三角形
class Triangle extends Graphics{
	private double a;
	private double b;
	private double c;

	public Triangle(double a, double b, double c){
		this.a = a;
		this.b = b;
		this.c = c;
	}
	public double area(){
		double s = (a + b + c) / 2;
			return Math.sqrt(a * (s - a) * (s - b) * (s - c));	
	}
}


public class ZeroException{
	@SuppressWarnings("resource")
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		System.out.println("请输入一行参数");
		String str = in.nextLine();
		StringTokenizer st = new StringTokenizer(str);

		double []a = new double[4];
		// System.out.println("----- 通过空格分隔 ");
		int i = 0;
		while (st.hasMoreElements()) {
			//            System.out.println(st.nextElement());
			i = i + 1;
			a[i] = Double.parseDouble((String) st.nextElement()) ;
		}
		System.out.println("参数的个数: " + i);



		try {
			if(i == 0) {
				throw new NumberException("输入的参数不能为零");
			}
			else if(i == 1) {
				//			double a = Double.parseDouble(str);
				Square s = new Square(a[1]);
				System.out.println("正方形的面积: " + s.area());
			}
			else if(i == 2) {
				Rectangle r = new Rectangle(a[1], a[2]);
				System.out.println("长方形的面积: " + r.area());
			}
			else if(i == 3) {
				if( a[1] + a[2] <= a[3] || a[1] + a[3] <= a[2] || a[2] + a[3] <= a[1]) {
					System.out.println("这不是一个三角形");
					System.exit(1);
				}
				Triangle t = new Triangle(a[1], a[2], a[3]);
				System.out.println("三角形的面积: " + t.area());
			}
			else {
				System.out.println("输入的参数太多");
			}

		} catch (NumberException e) {
			System.out.println(e.getMessage());
		}

		in.close();
	}
}