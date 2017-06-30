package tw.jdbcprac;

public class JDBC170618Prac001 {

	public static void main(String[] args) {
		p1 obj = new JDBC170618Prac0011();
		obj.m1();
		System.out.println("=============================");
		
		JDBC170618Prac0011 obj2 = (JDBC170618Prac0011)obj;
		obj2.m1();
		obj2.m3();
		System.out.println("=============================");
		
		p1 obj11 = new JDBC170618Prac0011();
		p1 obj22 = new JDBC170618Prac0012();
		main2(obj11);
		main2(obj22);

	}
	
	static void main2(p1 anyobj){
		anyobj.m1();
		if(anyobj instanceof JDBC170618Prac0011){
			((JDBC170618Prac0011)anyobj).m3();
		}
		else if(anyobj instanceof JDBC170618Prac0012){
			((JDBC170618Prac0012)anyobj).m4();
		}
	}

}

interface p1{
	void m1();
}

class JDBC170618Prac0011 implements p1{
	public void m1(){System.out.println("A");}
	void m3(){System.out.println("A1");}
}

class JDBC170618Prac0012 implements p1{
	public void m1(){System.out.println("B");}
	void m4(){System.out.println("B1");}
}