package com.tca.student.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.tca.entities.Student;

public class StudentOperations 
{
	
	public static boolean save(Student ob) // ob[103,"PPP", 90]
	{
		boolean status = false;
		
		try
		{
			
			
			FileWriter fw = new FileWriter("resource\\student.csv",true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			int rno = ob.getRno();
			String name = ob.getName();
			double per = ob.getPer();
						
			Student tob = StudentOperations.searchStudent(rno);
			
			if(tob==null)
			{
				String line = rno + "," + name + "," + per + "\n";
				bw.write(line);
				status = true;
				
			}
			else
			{
				System.out.println("Student Already Exist for Roll Number :" + rno);
				status=false;
				
			}
			bw.close();
			fw.close();
			
			return status;
		}
		catch(Exception e)
		{
			//System.out.println("Unable to save Student Record");
			e.printStackTrace();
			return false;
		}
		
		
		
	}
	
	public static List<Student> getAllStudents()
	{
		List<Student> l = new ArrayList<>(); // l ==> [1] [2]  [3]
		
		try
		{
			FileReader fr = new FileReader("resource\\student.csv");
			BufferedReader br = new BufferedReader(fr);
			
			
			while(true)
			{
				String line = br.readLine();  // line --> null
				
				if(line==null)
				{
					break;
				}
						
				String tok[] = line.split(",");  // 0:"101"  1:"AAA" 2:"60"
				
				int rno = Integer.parseInt(tok[0]);
				String name = tok[1];
				double per = Double.parseDouble(tok[2]);
				
				Student s = new Student(rno,name,per);
				l.add(s);
								
			}
			
			br.close();
			fr.close();
			return l;
		}
		catch(Exception e)
		{
			
			//e.printStackTrace();
			
			return null;
			
		}
		
	}
	
	
	public static void saveAll(List<Student> L ) // L --> [101] [102] [104]
	{
		if(L==null)
		{
			return;
		}
		
		for(Student ob : L)
		{
			StudentOperations.save(ob);
			
		}
	}
	
	
	public static Student searchStudent(int r)
	{
	
		List<Student> L = StudentOperations.getAllStudents(); // L --> [101,AAA,60 ] [102 ] [103 ]
							
		for(Student ob : L)
		{
			if(  ob.getRno() == r )
			{
				return ob;
			}
		}
	
		return null;
	}
	
											
	public static boolean deleteStudent(int r) // 103
	{
		List<Student> L = StudentOperations.getAllStudents(); // [101,AAA,60] [102]  [104]
		
		for(Student ob : L)
		{
			if(ob.getRno() == r)
			{
				L.remove(ob); // delete from student where rno = r
				
				File f = new File("resource\\student.csv");
				f.delete();  // It delete existing file
				StudentOperations.saveAll(L);
				
				return true;
			}
		}
		
		return false;
		
	}
	
	public static boolean updateStudent(int r, String newname, double newper) // 101 PPP 99
	{
		
		//delete - 101
		//save   - 101
		                                                                
		List<Student> L = StudentOperations.getAllStudents(); // [101 ZZZ 99] [102....] [103..]
		
		
		for(Student ob : L)
		{
			if(ob.getRno() == r)
			{
				ob.setName(newname);
				ob.setPer(newper);
				
				File f = new File("resource\\student.csv");
				f.delete();  // It delete existing file
				StudentOperations.saveAll(L);
							
				return true;
			}
		}
		
		return false;
	}
	
	
	
}
