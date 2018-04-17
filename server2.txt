
package pkg2phase;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class server {
    public static void main(String[] args) throws IOException
    {
        int a,b,c,ch,ch1,ch2;
        String str1 ="R",str2 ="R";
        System.out.println("-----------SERVER--------------");
        ServerSocket ss=new ServerSocket(6666);
        Socket s1=ss.accept();
        Socket s2=ss.accept();
     
        DataInputStream din1=new DataInputStream(s1.getInputStream());
        DataOutputStream dout1=new DataOutputStream(s1.getOutputStream());
        
        
        DataInputStream din2=new DataInputStream(s2.getInputStream());
        DataOutputStream dout2=new DataOutputStream(s2.getOutputStream());
        do
        {
        ch=din1.readInt();
        switch(ch)
        {
            
            case 1:
                    a=din1.readInt();
                    b=din1.readInt();
                    c=din1.readInt();
                    System.out.println("Addition by client 1 is:"+c);
                    
                    ch1=din1.readInt();
                    switch(ch1)
                    {
                        case 1: 
                            System.out.println("<READY T> from CLIENT 1");
                            
                            str1=din1.readUTF();
                            break;
                        case 2: 
                            System.out.println("<NO T> from CLIENT 1");
                            
                            str1=din1.readUTF();
                            break;
                            
                    }
                    
                    break;
            case 2:
                    a=din2.readInt();
                    b=din2.readInt();
                    c=din2.readInt();
                    System.out.println("Addition by client 2 is:"+c);
                    ch2=din2.readInt();
                    switch(ch2)
                    {
                        case 1: 
                            System.out.println("<READY T> from CLIENT 1");
                            
                            str1=din2.readUTF();
                            break;
                        case 2: 
                            System.out.println("<NO T> from CLIENT 1");
                            
                            str1=din2.readUTF();
                            break;
                            
                    }
                    break;   
        }
    }while(ch<3);
        if(str1.equals("R") && str2.equals("R"))
        {
            System.out.println("<COMMIT T> FROM CLIENT");
        }
        else
        {
           System.out.println("<ABORT T> FROM CLIENT"); 
        }
         din1.close();
         din2.close();
         s1.close();
         s2.close();
    }
}
