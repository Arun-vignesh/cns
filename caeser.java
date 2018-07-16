import java.util.Scanner;
public class caeser{
static String Caeser(String value,int shift){
char[]buffer=value.toCharArray();
for(int i=0;i<buffer.length;i++){
char letter=buffer[i];
letter=(char)(letter+shift);
if(letter>'z'){
letter=(char)(letter-26);
}
else if(letter<'a'){
letter=(char)(letter+26);
}
buffer[i]=letter;
}
return new String(buffer);
}
public static void main(String args[]){
System.out.println("Enter the String You want to encrypt");
Scanner sc=new Scanner(System.in);
String s=sc.next();
System.out.println("Enter the key String");
int i=sc.nextInt();
System.out.println("The entered String is "+s);
String b=Caeser(s,i);
System.out.println("The encrypted text is "+b);
}
}
