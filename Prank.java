/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prank;

import java.util.*;
import java.io.*;

public class Prank 
{
public int path[][] = new int[10][10];
public double pagerank[] = new double[10];
  
public void calc(double n)
{    
 double init;
 double c=0; 
 double temp[] = new double[10];
 int i,j,u=1,k=1;
 init = 1/n;
 System.out.printf(" n value:"+n+"\t init value :"+init+"\n");
 for(i=1;i<=n;i++)
   this.pagerank[i]=init;
   System.out.printf("\n Initial PageRank Values , 0th Step \n");
    for(i=1;i<=n;i++)
   System.out.printf(" Page Rank of "+i+" is :\t"+this.pagerank[i]+"\n");
   
   
   while(u<=2)
   {
    for(i=1;i<=n;i++)
    {  temp[i]=this.pagerank[i];
          this.pagerank[i]=0;
       }
     
 for(j=1;j<=n;j++)
        for(i=1;i<=n;i++)
     if(this.path[i][j] == 1)
     {  k=1;c=0; 
           while(k<=n)
     {
       if(this.path[i][k] == 1 )
                   c=c+1;
     k=k+1;
     } 
             this.pagerank[j]=this.pagerank[j]+temp[i]*(1/c);    
      } 
   
  System.out.printf("\n After "+u+"th Step \n"); 
     for(i=1;i<=n;i++) 
      System.out.printf(" Page Rank of "+i+" is :\t"+this.pagerank[i]+"\n"); 
   
     u=u+1;
    } 
}
 public static void main(String args[])
    {
        int nodes,i,j,cost;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the Number of WebPages \n");
        nodes = in.nextInt();
        Prank p = new Prank();
        System.out.println("Enter the Adjacency Matrix with 1->PATH & 0->NO PATH Between two WebPages: \n");
        for(i=1;i<=nodes;i++)
          for(j=1;j<=nodes;j++)
          {
            p.path[i][j]=in.nextInt();
            if(j==i)
              p.path[i][j]=0;
          }
        p.calc(nodes);
    
           
    }   
 
}

/*
 OUTPUT:
Enter the Number of WebPages 

4
Enter the Adjacency Matrix with 1->PATH & 0->NO PATH Between two WebPages: 

0 1 1 0
0 0 0 1
1 1 0 1
0 0 1 0
 n value:4.0	 init value :0.25

 Initial PageRank Values , 0th Step 
 Page Rank of 1 is :	0.25
 Page Rank of 2 is :	0.25
 Page Rank of 3 is :	0.25
 Page Rank of 4 is :	0.25

 After 1th Step 
 Page Rank of 1 is :	0.08333333333333333
 Page Rank of 2 is :	0.20833333333333331
 Page Rank of 3 is :	0.375
 Page Rank of 4 is :	0.3333333333333333

 After 2th Step 
 Page Rank of 1 is :	0.125
 Page Rank of 2 is :	0.16666666666666666
 Page Rank of 3 is :	0.375
 Page Rank of 4 is :	0.3333333333333333
BUILD SUCCESSFUL (total time: 1 minute 58 seconds)

 */