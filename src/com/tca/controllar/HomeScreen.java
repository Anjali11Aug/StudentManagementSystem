package com.tca.controllar;



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.tca.view.AddStudentScreen;
import com.tca.view.DisplayStudentScreen;

public class HomeScreen extends JFrame implements ActionListener
{
	JMenuBar mbr;
	JMenu mStudent, mTeacher;
	JMenuItem miAddStudent, miDisplayStudent, miExit;

	public HomeScreen()
	{
		setLayout(null);
		mbr = new JMenuBar();
		mbr.setSize(500,30);
		mbr.setLocation(0,0);
		add(mbr);

		mStudent = new JMenu("Student");
		mbr.add(mStudent);

		miAddStudent = new JMenuItem("Add Student");
		miAddStudent.addActionListener(this);
		mStudent.add(miAddStudent);

		miDisplayStudent = new JMenuItem("Display Student");
		miDisplayStudent.addActionListener(this);
		mStudent.add(miDisplayStudent);

		miExit = new JMenuItem("Exit");
		miExit.addActionListener(this);
		mStudent.add(miExit);

		setTitle("Home Screen");
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent ae)
	{
		String s = ae.getActionCommand();

		if(s.equals("Add Student"))
		{
			new AddStudentScreen();
		}

		if(s.equals("Display Student"))
		{
			new DisplayStudentScreen();
		}

		if(s.equals("Exit"))
		{
			JOptionPane.showMessageDialog(null,"Closing System");
			System.exit(0);
		}
	}

	
}