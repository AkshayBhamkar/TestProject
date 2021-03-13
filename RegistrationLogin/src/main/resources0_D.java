public class D
{
D()
{
System.out.println("Constructor AAAA");
}
static
{
System.out.println("Static Block");
}
{
System.out.println("Non Static");
}
public void sum()
{
System.out.println("  sum Method");
}
public static void main(String args[])
{
System.out.println(" Main");
D d=new D();
d.sum();



}



}