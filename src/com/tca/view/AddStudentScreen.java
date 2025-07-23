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

public class AddStudentScreen extends JFrame implements ActionListener
{
	JLabel lRno,lName,lPer;
	JTextField tfRno,tfName,tfPer;
	JButton bSave,bClear;
		
	public AddStudentScreen()
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
		
		bSave = new JButton("SAVE");
		bSave.setSize(100,30);
		bSave.setLocation(60,190);
		bSave.addActionListener(this);
		add(bSave);
		
		
		bClear = new JButton("CLEAR");
		bClear.setSize(100,30);
		bClear.setLocation(200,190);
		bClear.addActionListener(this);
		add(bClear);
		
		setTitle("Add Student");
		setSize(400,300);
		setVisible(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 }
	
	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		String command = ae.getActionCommand();
		
		if(command.equals("SAVE"))
		{
			
			try
			{
				int rno     = Integer.parseInt( tfRno.getText() );
				String name = tfName.getText();
				double per  = Double.parseDouble(tfPer.getText());
				
				Student ob  =  new Student(rno,name,per);
				
				boolean status = StudentOperations.save(ob);
				
				if(status==true)
				{
					JOptionPane.showMessageDialog(null,"Record is Saved Succesfully");
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Problem while Saving for Roll Number :" + rno);
				}
				
				tfRno.setText("");
				tfName.setText("");
				tfPer.setText("");
				tfRno.requestFocus();
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,"Check Your Input !!");
				e.printStackTrace();
			}
			
			
		}
		
		if(command.equals("CLEAR"))
		{
			tfRno.setText("");
			tfName.setText("");
			tfPer.setText("");
			tfRno.requestFocus();
		}
		
	}
}
