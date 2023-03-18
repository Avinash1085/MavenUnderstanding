import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.virtualauthenticator.VirtualAuthenticatorOptions.Transport;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mysql.cj.xdevapi.Session;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeBodyPart;
import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeMultipart;

import java.util.*;
import javax.activation.*;

import io.restassured.RestAssured;

public class ArrayProgramsForTest {

	@Test
	public void sortArray() 
	{

		int num[]= {4,20,7,3,50,7,21,6,56};
		int temp=0;

		for (int i=0 ; i<=num.length;i++)
		{		

			for(int j=i;j<num.length;j++)
			{
				if(num[i]>=num[j])
				{
					temp=num[i];
					num[i]=num[j];
					num[j]=temp;
				}
			}
		} 			System.out.println("Max number :"+temp);

	}
	@Test
	public void maxNumberOfArray()
	{
//		int arr[]=new int[5];
		int [] arr=new int[] {30,4,7,1,20,31};
		int max=arr[0];
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]>max)
			{
				max=arr[i];
			}
		}
		System.out.println("Maximum number of array is : "+max);
	}
	
	@Test
	public void minNumberOfArray()
	{
		
		int [] arr=new int[] {30,4,7,1,20,31};
		int min=arr[0];
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]<min)
			{
				min=arr[i];
			}
		}
		System.out.println("Minimum number of array is : "+min);
	}

	@Test
	public void duplicateElementfromArray()
	{
		int [] arr=new int [] {3,5,2,7,2,8,3,5,7,9,4};
		System.out.println("Below are the repeated numbers in given Array :");
		for(int i=0;i<arr.length;i++)
		{
			int cnt=0;
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]==arr[j])
				{
					System.out.println(arr[j]);
					cnt++;
//					System.out.println("Occurances of "+arr[j]+" "+cnt);
				}
			}
		}
	}
	
	@Test
	public void sortArrayAscendingOrder()
	{
		int [] NumberArray={0,1,4,12,10,21,20,41,30};
		int tempval=0;
		int arr2[]=new int[NumberArray.length];
		int len=NumberArray.length;
		System.out.println("Ascending Order.");
		for(int i=0;i<len;i++)
		{
			for(int j=i+1;j<len;j++)
			{
				if(NumberArray[i]>NumberArray[j])
				{
					tempval=NumberArray[i];
					NumberArray[i]=NumberArray[j];
					NumberArray[j]=tempval;
				
				}
			}
			System.out.println("At : "+i +"  "+ NumberArray[i]); //Working properly
		}
		System.out.println("2nd highest num is : "+NumberArray[NumberArray.length-2]);
	}
	
	@Test
	public void sortArrayinDesc()
	{
		int [] NumberArray={0,1,10,51,31,20,51,40,10,11,30};
		int tempval=0;
		int len=NumberArray.length;
		System.out.println("Descending Order.");
		for(int i=0;i<len;i++)
		{
			for(int j=i+1;j<len;j++)
			{
				if(NumberArray[i]<NumberArray[j])
				{
					tempval=NumberArray[i];
					NumberArray[i]=NumberArray[j];
					NumberArray[j]=tempval;
				}
			}
			System.out.println(NumberArray[i]);
		}
	}
	
	@Test
	public void sortArrayBuiltinfunction()
	{
		int arr[]= {13,7,6,45,21,9,101,102};
		System.out.println("Array Without sorting : "+Arrays.toString(arr));
		Arrays.sort(arr);
		System.out.println("Sorted Array is : "+Arrays.toString(arr));
		System.out.println("2nd Max number is : "+arr[arr.length-2]);
		System.out.println("2nd Smallest number is : "+arr[1]);	
	}
	
	@Test
	public void reverseTheWordsOfString()
	{
		String mystring="Welcome to Selenium";
		String rev[]=mystring.split(" ");
		String newRev[]=new String [rev.length]; 
		 for(int i=rev.length-1;i>=0;i--)
		{
			newRev[i]=newRev+rev[i];
//			System.out.println(newRev[i].toString());
		}
		 for(int i=0;i<newRev.length;i++)
		 {
			 System.out.println(newRev[i]);
		 }
	}
	
	@Test
	public void vowelsInString()
	{
		int vCount=0,cCount=0;
		String str="This is really a simple statement";
		str=str.toLowerCase();
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)=='a' || str.charAt(i)=='i' || str.charAt(i)=='o'
					|| str.charAt(i)=='e' || str.charAt(i)=='u')
			{
				vCount++;
				System.out.println(str.charAt(i));
			}
			else if(str.charAt(i)>'a' || str.charAt(i)<'z')
			{
				cCount++;
			}
		}
		System.out.println("Vowels Count is : "+vCount);
		System.out.println("Consonents Count is : "+cCount);

	}
	
	@Test
	public void reverseString()
	{
		String str=new String();
		str="!! enoyrevE & hsanivA olleH";
		
		String revStr="";
		
		for(int i=str.length()-1;i>=0;i--)
		{
			revStr=revStr+str.charAt(i);
		}
		System.out.println("Original String : "+str);
		System.out.println("Reversed String : "+revStr);
	}
	
	@Test
	public void evenNumTernaryOp()
	{
		int a;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your Number : ");
		a=sc.nextInt();
		
		String Result=(a%2==0) ? "is an Even Number." : "is an Odd Number.";
		System.out.println(+a+" "+Result);
	}
	
	@Test
	public void maxNumTernaryOp()
	{
		int a=203,b=112,c=125;
		
		int maxOfThree = a > b ? (a > c ? a : c) : (b  > c ? b : c);
		  System.out.println("Max of three is: " + maxOfThree);
		  
		  int minOfThree = a < b ? (a < c ? a : c) : (b  < c ? b : c);
		  System.out.println("Minimum of three is: " + minOfThree);
	}
	
	@Test
	public void setProgram()
	{
		Set<Integer> mySet=new HashSet<>();
		mySet.add(1);
		mySet.add(3);
		mySet.add(5);
		
		System.out.println("Printing Set Elements Using for Iterator loop..");
		Iterator<Integer> it=mySet.iterator();
		while(it.hasNext())
		{
			int no=it.next();
			System.out.println(no);
		}
		
		System.out.println("Printing Set Elements Using for each loop..");
		for(int num:mySet)
		{
			System.out.println(num);
		}
	}
	@Test
	public void countOccuranceOfEachElementOfList()
	{
		List<Integer> numList=new ArrayList<>();
		Set<Integer> numSet;
		List<Integer> setList;
		int n=0;
		int cnt=0;
		int t=0, b=0;
		
		numList.add(3);		numList.add(5);		numList.add(7);		numList.add(2);
		numList.add(3);		numList.add(7);		numList.add(4);
		//converting ArraList to Set, numSet is declared as Set & numList is a List.
		
		numSet=new HashSet<>(numList);
		System.out.println("Elements of Set which are taken and converted from List to Set.");
		//For Each loop to print Set elements using For each because Set cannot have get method to use index in for loop.
		for(Integer val:numSet)
		{
			System.out.println(val);
		}
		
		//converting Set into List again so that it will not have duplicates now.
		setList=new ArrayList<>(numSet);
		System.out.println("Elements of List which are taken and converted into List from Set");
		
		//using for loop printing List elements which will be with duplicates as converted from set to list.
		for(int i=0;i<setList.size();i++)
		{
			System.out.println(setList.get(i));
		}
		
		System.out.println(numList); // will print original List elements in format of :[] e.g [10,20,2,9,10,1,2,1]
		
		//here I am counting the occurances of each element from original List
		// setList is Arraylist and having each element only once from original numList
		//by using setList which List in type but each element from original List is only once in it,So iteration is made easy on each element so no duplicate printing will happen.
		for(int i=0;i<setList.size();i++) 
		{
			t=setList.get(i);
				for(int j=0;j<numList.size();j++) //Original numList with duplicates present in it.
				{
					if(t==numList.get(j))
					{
						cnt++;
					}

				}
			System.out.println("Occurances of "+t+" in List are : "+cnt);
			cnt=0;
		}
	}

	@Test
	public void reverseArray()
	{
		int arr[]= {2,4,1,5,6,7,3};
		System.out.println("Array elements in natural order: ");
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
		
		System.out.println("Array in reverse Order: ");
		for(int i=arr.length-1;i>=0;i--)
		{
			System.out.println(arr[i]);
		}
	}
	
	@Test(dependsOnMethods="arrayA")
	public static int secondLargestNum(int []a,int total)
	{
//		int b[]= {4,6,2,8,1,9,9};
//		total=a.length;
		int temp;
		for(int i=0;i<total;i++)
		{
			for(int j=i=1;j<total;j++)
			{
				if(a[i]>a[j])
				{
					temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
//			System.out.println("second Largest num : "+a[total-2]);
		}
		return a[total-2];
	}
	
	@Test(priority=1)
	public static void arrayA()
	{
		int a[]= {4,6,2,8,1,9,9};
		System.out.println("Elements of array : ");
		for(int i=0;i<a.length;i++)
		{
			System.out.println(a[i]);
		}
//		return 0;
		System.out.println("HighestNum: "+secondLargestNum(a,7));
	}
	
	/*
	public void RestApi()
	{
		String S="Avi";
		RestAssured.baseURI="URL";
		RestAssured.given().when().body(S).log().all().post("/api").then();
	} */
	
}
