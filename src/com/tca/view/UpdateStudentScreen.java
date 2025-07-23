package com.tca.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.tca.entities.Student;
import com.tca.student.util.StudentOperations;

public class UpdateStudentScreen extends JFrame implements ActionListener
{
	JLabel lRno,lName,lPer;
	JTextField tfRno,tfName,tfPer;
	JButton bSearch,bUpdate;
		
	public UpdateStudentScreen()
	{
		setLayout(null);
		
		lRno =  new JLabel("Roll Num :");
		lRno.setSize(100,30);
		lRno.setLocation(30,30);
		add(lRno);
		
		tfRno = new JTextField();
		tfRno.setSize(200,30);
		tfRno.setLocation(150,30);
		add(tfRno);
		
		lName = new JLabel("Name : ");
		lName.setSize(100,30);
		lName.setLocation(30,80);
		add(lName);
		
		tfName = new JTextField();
		tfName.setSize(200,30);
		tfName.setLocation(150, 80);
		
		add(tfName);
		
		lPer = new JLabel("Percentage : ");
		lPer.setSize(100,30);
		lPer.setLocation(30, 130);
		add(lPer);
		
		tfPer = new JTextField();
		tfPer.setSize(200,30);
		tfPer.setLocation(150,130);
		
		add(tfPer);
		
		bSearch = new JButton("SEARCH");
		bSearch.setSize(100,30);
		bSearch.setLocation(60,190);
		bSearch.addActionListener(this);
		add(bSearch);
		
		
		bUpdate = new JButton("UPDATE");
		bUpdate.setSize(100,30);
		bUpdate.setLocation(200,190);
		bUpdate.addActionListener(this);
		add(bUpdate);
		
		setTitle("Update Student");
		setSize(400,300);
		setVisible(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 }
	
	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		String command = ae.getActionCommand();
		
		if(command.equals("SEARCH"))
		{
			
			try
			{
				int rno = Integer.parseInt(tfRno.getText());
				Student ob = StudentOperations.searchStudent(rno);
				
				if(ob==null)
				{
					JOptionPane.showMessageDialog(null, "No Record Found for Roll Number:" + rno);
					tfName.setText("");
					tfPer.setText("");
				}
				else
				{
					tfName.setText(ob.getName());
					tfPer.setText( Double.toString(ob.getPer()));
								
				}
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,"Check Your Input !!");
				//e.printStackTrace();
			}
			
			
		}
		
		if(command.equals("UPDATE"))
		{
			try
			{
				int rno = Integer.parseInt(tfRno.getText());
				String name = tfName.getText();
				double per = Double.parseDouble(tfPer.getText());
				
				boolean status = StudentOperations.updateStudent(rno,name,per);
			
				if(status==true)
				{
					JOptionPane.showMessageDialog(null,"Record Update for Roll Number :" + rno);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Unable Update record for Roll Number :" + rno);
				}
			
			
				tfRno.setText("");
				tfName.setText("");
				tfPer.setText("");
				tfRno.requestFocus();
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,"Check Your Input !!");
				//e.printStackTrace();
			}
		}
		
	}
}
