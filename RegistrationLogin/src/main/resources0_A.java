public class A{
public A(){
System.out.println("constructor");

}
public A(int i){
System.out.println("constructor int ");

}
public A(String s){
System.out.println("constructor string");

}
static {
System.out.println("static block ");
}
{
System.out.println("non static block");
}

public void sum()
{
System.out.println("hello");
}
public static void main(String []args)
{
System.out.println("main===");
A a=new A();
A a1=new A(5);
A a2=new A("asds");
a.sum();
a1.sum();
System.out.println("main end");

}


}