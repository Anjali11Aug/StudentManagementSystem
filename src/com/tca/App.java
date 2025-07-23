/*
 * Project : Student Management System
 * Author  : Mr. Sachin Dhane (Techon Comp Academy)
 * Date    : 06-07-2024 
 * 
 */


package com.tca;
import com.tca.controllar.*;
import com.tca.view.UpdateStudentScreen;

public class App 
{

	public static void main(String[] args) 
	{
		
		//new HomeScreen();
		new UpdateStudentScreen();
	}

}		
		
		

		
		
		
		
/*		
 * 
 
 		Student s1 = new Student(101,"AAA",60);
		Student s2 = new Student(102,"BBB",70);
		Student s3 = new Student(103,"CCC",80);
 
		List<Student> L = new ArrayList<>();
		
		L.add(s1);
		L.add(s2);
		L.add(s3);
		
		
		for(Student ob : L)
		{
			ob.display();
			
		}
		
		
		// --> Test Code getAllStudents 
		
		List<Student> L = StudentOperations.getAllStudents();
		
		if(L==null)
		{
			System.out.println("There is NO student Registered to Your Academy ");
		}
		else
		{
			for(Student ob : L)
			{
				ob.display();
			
			}
		}
		
		
		//Test code --> saveAll()
		
		
		Student s1 = new Student(104,"DDD",60);
		Student s2 = new Student(105,"EEE",70);
		Student s3 = new Student(106,"FFF",80);
 
		List<Student> L = new ArrayList<>();
		L.add(s1);
		L.add(s2);
		L.add(s3);
		
		StudentOperations.saveAll(L);
		
		
		// Test Code - search()
		
		Student ob = StudentOperations.searchStudent(107);
		
		if(ob== null)
		{
			System.out.println("NOT FOUND");
		}
		else
		{
			System.out.println("FOUND");
			System.out.println("Roll Number : " + ob.getRno());
			System.out.println("Name        : " + ob.getName());
			System.out.println("Percentage  : " + ob.getPer());
		}
		
		
		// Test Code - deleteStudent()
		 
		if( StudentOperations.deleteStudent(107) )
		{
			System.out.println("DELETED");
		}
		else
		{
			System.out.println("NON DELETED");
		}
		
		List<Student> L = StudentOperations.getAllStudents();
		
		for(Student ob : L)
		{
			ob.display();
		} 
		
*/		

