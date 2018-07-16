import java.util.Scanner;
public class HillCipher {
    public static void main(String[] args) {
        // TODO code application logic here
        int [][]a={{6,24,1},{13,16,10},{20,17,15}};
        int [][]b={{8,5,10},{21,8,21},{21,12,8}};
        int i,j, t=0;
        int []c=new int[40];
        int []d=new int[40];
        System.out.println("Enter the plain text");
        Scanner sc=new Scanner(System.in);
        String txt=sc.next();
        char k[];
        k=txt.toCharArray();
        int []l=new int[9];
        for(i=0;i<txt.length();i++){
        l[i]=k[i]-65;
        System.out.println(l[i]);
        }
        for(i=0;i<3;i++)
        {
            t=0;
            for(j=0;j<3;j++)
                {
                t=t+(a[i][j]*l[j]);
                }
            d[i]=t%26;
        }
        System.out.println("\nEncrypted Cipher Text :");
        for(i=0;i<3;i++){
        char m=(char) ((char)d[i]+65);
        System.out.print(m);
        }
        for(i=0;i<3;i++)
        {
            t=0;
            for(j=0;j<3;j++){
                t=t+(b[i][j]*d[j]);
            }
        c[i]=t%26;
        }
        System.out.println("\nDecrypted Cipher Text :");
        for(i=0;i<3;i++){
        char m=(char) ((char)c[i]+65);
        System.out.print(m);
        }
        System.out.println();
    }
    
}

