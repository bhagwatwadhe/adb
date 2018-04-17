/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package machinel;

import java.util.Scanner;

public class MachineL {

	public static void main(String[] args) {
		
		float m1=0,m2=0,sum1,sum2,a,b;
		int n=0,i=0,j=0,k=0;
		int items=0;
		boolean flag;
		
		Scanner get=new Scanner(System.in);
		
		System.out.println("Enter no.of data items :");
		items=get.nextInt();
		
		int[] cluster1=new int[items];
		int[] cluster2=new int[items];
		int[] data=new int[items];
				
		System.out.println("Enter the data items :");
		for(i=0;i<items;i++){
			data[i]=get.nextInt();
		}

		a=data[0];
		b=data[1];
		m1=a;m2=b;		
		
		do{
			sum1=0;
			sum2=0;
			n++;
			k=0;j=0;
			cluster1=new int[items];
			cluster2=new int[items];
	 
			 for(i=0;i<items;i++)
			 {
				 if(Math.abs(data[i]-m1) <= Math.abs(data[i]-m2))
                 {
					 cluster1[k] = data[i];
					 k++;
				 }
				 
				 else{
					 cluster2[j] = data[i];
				     j++;
				     }
				 
             }	 
            System.out.println();
				 
				 for(i=0;i<k;i++)
				 {
					 sum1+=cluster1[i];
				 }
				 
				 for(i=0;i<j;i++)
				 {
					 sum2+=cluster2[i];
				 }
			 
			System.out.println("Median1 :"+m1+ "and Median2 :"+m2);
			a=m1;
			b=m2;
			
			m1=Math.round(sum1/k);
			m2=Math.round(sum2/j);
			
			flag=!(m1==a && m2==b);
			System.out.println();
			
			System.out.println("After iteration no."+n+" cluster 1 is ");
			for(i=0;i<cluster1.length;i++)
			{
				if(cluster1[i]!=0)
				System.out.print(" "+cluster1[i]);
			}
			System.out.println();
			
			System.out.println("After iteration no."+n+" cluster 2 is ");
			for(i=0;i<cluster2.length;i++)
			{
				if(cluster2[i]!=0)
				System.out.print(" "+cluster2[i]);
			}			
			
		}while(flag);
		
		System.out.println();
		System.out.println("Final cluster1 is:");
		for(i=0;i<cluster1.length;i++)
		{
			if(cluster1[i]!=0)
			System.out.print(" "+cluster1[i]);
		}
        
        System.out.println();    
		System.out.println("Final Cluster 2 is: ");
		for(i=0;i<cluster2.length;i++)
		{
			if(cluster2[i]!=0)
			System.out.print(" "+cluster2[i]);		
		}		
	}
}
