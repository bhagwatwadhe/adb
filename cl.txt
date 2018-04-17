
package pkg2phase;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class client {
  
    public static void main(String[] args) throws UnknownHostException, IOException
    {
        int ch,a,b,c,ch1,ch2;
        System.out.println("-----------CLIENT--------------");
        
        Socket s1=new Socket("localhost",6666);
        Socket s2=new Socket("localhost",6666);
        
        Scanner sc=new Scanner(System.in);
        DataInputStream din1=new DataInputStream(s1.getInputStream());
        DataOutputStream dout1=new DataOutputStream(s1.getOutputStream());
        
        DataInputStream din2=new DataInputStream(s2.getInputStream());
        DataOutputStream dout2=new DataOutputStream(s2.getOutputStream());
        
       do
       {
        System.out.println("\n1.CLIENT 1\n2.CLINET 2\n3.EXIT");
        System.out.println("Enter UR choice plz!!!");
        ch=sc.nextInt();
        dout1.writeInt(ch);
        switch(ch)
        {
            case 1:
                    System.out.println("CLINET 1");
                    System.out.println("Enter a:");
                    a=sc.nextInt();
                    dout1.writeInt(a);
                    System.out.println("Enter b:");
                    b=sc.nextInt();
                    dout1.writeInt(b);
                    c=a+b;
                    dout1.writeInt(c);
                    System.out.println("Addition by client 1 is:"+c);
                    
                    System.out.println("\n1.<READY T>\n2.<NOT T>");
                    System.out.println("Enter UR choice plz!!!");
        ch1=sc.nextInt();
        dout1.writeInt(ch1);
        switch(ch1)
        {
            case 1:
                    System.out.println("<READY T from CLIENT 1");
                    String str1="R";
                    dout1.writeUTF(str1);
                    break;
            case 2:
                    System.out.println("<READY T from CLIENT 1");
                    String str2="N";
                    dout1.writeUTF(str2);
                    break;
           
        }
                    break;
            case 2:
                    System.out.println("CLINET 2");
                    System.out.println("Enter a:");
                    a=sc.nextInt();
                    dout2.writeInt(a);
                    System.out.println("Enter b:");
                    b=sc.nextInt();
                    dout2.writeInt(b);
                    c=a+b;
                    dout2.writeInt(c);
                    System.out.println("Addition by client 2 is:"+c);
                    System.out.println("\n1.<READY T>\n2.<NOT T>");
                    System.out.println("Enter UR choice plz!!!");
        ch2=sc.nextInt();
        dout2.writeInt(ch2);
        switch(ch2)
        {
            case 1:
                    System.out.println("<READY T from CLIENT 2");
                    String str1="R";
                    dout2.writeUTF(str1);
                    break;
            case 2:
                    System.out.println("<READY T from CLIENT 2");
                    String str2="N";
                    dout2.writeUTF(str2);
                    break;
           
        }
                    break;
        }
       }while(ch<3);
        dout1.close();
        dout2.close();
        s1.close();
        s2.close();
    }
    
}
