import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.applet.*;

public class Login extends JFrame implements ActionListener,Runnable
{
    static String path="login.dat";

    static String mediapath="C:\\Users\\rutuj\\OneDrive\\Documents\\Smart_Data_Sharing\\src\\image\\";

    private JPanel jpInfo = new JPanel();
	private JLabel Pinlbl;
	private JLabel l1,l2,l3,l4,l5,l6,l7;
	private JPasswordField PinVal;

	private JButton btnLogin,btnChange;

	Login(int i){}

	public void run(){}

	Login ()
	{
		super ("System Authention");
	try
		{
		File file = new File(path);           // create file object

		if(!(file.exists()))
		{
		  DataOutputStream dout = new DataOutputStream(new FileOutputStream(path));
		  dout.writeUTF("login");
		  dout.close();
		}

		  AudioClip ac = Applet.newAudioClip(new File(Login.mediapath+"Please Enter Password.wav").toURL());
    	  ac.play();


		setSize (574, 320);
		setResizable(false);
		setLocationRelativeTo(null);
		jpInfo.setBounds (0, 0, 500, 115);
		jpInfo.setLayout (null);

		l1 = new JLabel ("*** Project Team ***");
		l1.setForeground (Color.red);
		l1.setBounds (320, 10, 190, 25);

		l2 = new JLabel ("Pratik Kuwar");
		l2.setForeground (Color.black);
		l2.setBounds (340, 40, 190, 25);

		l3 = new JLabel ("Ashish Koshti");
		l3.setForeground (Color.black);
		l3.setBounds (340, 65, 190, 25);

		l4 = new JLabel ("Ajay Kakade");
		l4.setForeground (Color.black);
		l4.setBounds (340, 90, 190, 25);

		l5 = new JLabel ("Rutuja Kale");
		l5.setForeground (Color.black);
		l5.setBounds (340, 115, 190, 25);

		l6 = new JLabel ("*** Guided By ***");
		l6.setForeground (Color.red);
		l6.setBounds (320, 150, 190, 25);

		l7 = new JLabel ("Mrs.Shwetkranti Taware");
		l7.setForeground (Color.black);
		l7.setBounds (340, 175, 190, 25);

		l1.setFont(new Font("Eras Demi ITC",1,16));
		l2.setFont(new Font("Times New Roman",1,15));
		l3.setFont(new Font("Times New Roman",1,15));
		l4.setFont(new Font("Times New Roman",1,15));
		l5.setFont(new Font("Times New Roman",1,15));
		l6.setFont(new Font("Eras Demi ITC",1,16));
		l7.setFont(new Font("Times New Roman",1,15));

		Pinlbl = new JLabel ("Enter Pin:");
		Pinlbl.setForeground (Color.black);
		Pinlbl.setBounds (280, 210, 90, 25);

		PinVal = new JPasswordField(10);
		PinVal.setHorizontalAlignment (JTextField.RIGHT);
		PinVal.setEchoChar('$');
		PinVal.setBounds (355, 210, 190, 25);

		btnLogin = new JButton ("System Login");
		btnLogin.setBounds (280, 245, 120, 35);
		btnLogin.addActionListener (this);

		btnChange = new JButton ("PIN Change");
		btnChange.setBounds (425, 245, 120, 35);
		btnChange.addActionListener (this);

		JPanel panel = new JPanel ();
        JLabel label = new JLabel();
        panel.setBounds(2,2,260,280);
        label.setIcon(new ImageIcon(Login.mediapath+"two.jpg"));// your image here
        panel.add(label);

		jpInfo.add (l1);
		jpInfo.add (l2);
		jpInfo.add (l3);
		jpInfo.add (l4);
		jpInfo.add (l5);
		jpInfo.add (l6);
		jpInfo.add (l7);

		jpInfo.add (Pinlbl);
		jpInfo.add (PinVal);
		jpInfo.add (btnLogin);
		jpInfo.add (btnChange);
		jpInfo.add (panel);

		getContentPane().add (jpInfo);

		setVisible (true);


		addWindowListener (new WindowAdapter ()
		{
			public void windowClosing (WindowEvent we)
			{
				quitApp ();
			}
		}
		);
	}
		catch(Exception e){}
}
	private void quitApp ()
	{
		try
		{
		    	int reply = JOptionPane.showConfirmDialog (this,"Are you really want to exit\nFrom System?","System - Exit", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
				if (reply == JOptionPane.YES_OPTION)
				{
				setVisible (false);	//Hide the Frame.

				AudioClip ac = Applet.newAudioClip(new File(Login.mediapath+"Good_Bye.wav").toURL());
				ac.play();

				Login b=new Login(0);
				Thread t=new Thread(b);
				t.sleep(1000);
				System.exit (0);        //Close the Application.
				}
				else if (reply == JOptionPane.NO_OPTION)
				{
				setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			   }
		 }
   	    catch (Exception e) {}
     }

	public void actionPerformed (ActionEvent ae)
	{
		Object obj = ae.getSource();

		String pass = PinVal.getText();

		if(obj == btnChange)
		{
		  changePassword();
		}
      else
      {
	 try
	  {
		if(checkPassword())
		{
		 	  setVisible(false);

				AudioClip ac = Applet.newAudioClip(new File(Login.mediapath+"Welcome.wav").toURL());
				ac.play();

	  	      new Thread().sleep(1000);

	          xcopy obj1=new xcopy();
			  obj1.System_Start();
  		  }
		else
		{
				AudioClip ac = Applet.newAudioClip(new File(Login.mediapath+"Invalid Password.wav").toURL());
				ac.play();

			  JOptionPane.showMessageDialog(null,"Password does not matches with original password","Wrong User",JOptionPane.ERROR_MESSAGE);
	          PinVal.setText("");
		}
	  }
	   catch(Exception e1){}
    }
   }

  //===================================================================================================================================================================
	   public boolean checkPassword()
	   {
		  String original = null;
		  try
		  {
		 	DataInputStream dout = new DataInputStream(new FileInputStream(path));
		 	original = dout.readUTF();
		  }
		  catch(Exception e){}

		  if(PinVal.getText().equals(original))
		 	return true;
		  else
		    return false;
	   }
//===================================================================================================================================================================

   public void changePassword()
   {
	try
	{
	  DataInputStream din = new DataInputStream(new FileInputStream(path));        // Open Secure file
	  String pass = din.readUTF();           //Read Password
	  din.close();

	  final JFrame frame = new JFrame("Change PIN");

	  JPanel panel = new JPanel();

		  JLabel lblOldPass = new JLabel("Old PIN ");          // create label
	  JLabel lblNewPass = new JLabel("New PIN ");          // for password
	  JLabel lblConPass = new JLabel("Confirm PIN ");      // input and verification

	  final JPasswordField txtOldPass = new JPasswordField(15);  // create TextArea
	  final JPasswordField txtNewPass = new JPasswordField(15);  // for password entry
	  final JPasswordField txtConPass = new JPasswordField(15);  // and conform password

	  JButton btnOk = new JButton("Change");
	  JButton btnCancel = new JButton("Cancel");

	  panel.setBackground(new Color(212,223,255));

	  GridBagLayout gbl= new GridBagLayout();
	  GridBagConstraints gbc= new GridBagConstraints();

	  panel.setLayout(gbl);

	  gbc.weighty= 4;     // divide vertical space into 4 parts

	  gbc.gridx= 0;       // locate first part
	  gbl.setConstraints(lblOldPass, gbc);         // old password
	  panel.add(lblOldPass);                       // label

	  gbl.setConstraints(lblNewPass, gbc);  // New password
	  panel.add(lblNewPass);                // label

	  gbl.setConstraints(lblConPass, gbc);  // conform password
	  panel.add(lblConPass);                // label

	  gbl.setConstraints(btnOk, gbc);  // Change button
	  panel.add(btnOk);

	  gbc.gridx= 1;       //locate second part
	  gbl.setConstraints(txtOldPass, gbc);   // old password textArea
	  panel.add(txtOldPass);

	  gbl.setConstraints(txtNewPass, gbc);   // New password textArea
	  panel.add(txtNewPass);

      gbl.setConstraints(txtConPass, gbc);   // conform password textArea
	  panel.add(txtConPass);

	  gbl.setConstraints(btnCancel, gbc);  // cancel button
	  panel.add(btnCancel);

	  getContentPane().add(panel);

      frame.add(panel);

	  frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	  frame.setResizable(false);
	  frame.setLocation(400,300);
	  frame.setSize(310,200);
	  frame.setVisible(true);
	  this.setVisible(false);  // hide first window

	  btnOk.addActionListener(new ActionListener()
	  {
	   public void actionPerformed(ActionEvent event)
	   {
	    try
	    {
	 	  DataInputStream din = new DataInputStream(new FileInputStream(path));
		  String orginalPass = din.readUTF();
		  din.close();

		  if(txtOldPass.getText().equals(orginalPass))
		  {
		    if(txtNewPass.getText().equals(txtConPass.getText()))
		    {
		     try
		     {
		 	   DataOutputStream dout = new DataOutputStream(new FileOutputStream(path));
			   dout.writeUTF(txtNewPass.getText());
			   dout.close();

 		       AudioClip ac = Applet.newAudioClip(new File(Login.mediapath+"password_changed.wav").toURL());
  	           ac.play();

			   JOptionPane.showMessageDialog(null,"Password Changed!!!");
			   frame.setVisible(false);             // hide password window
			   new Login().setVisible(true); // disply first window
			 }
			 catch(Exception e){}
		    }
		    else
			{
			  JOptionPane.showMessageDialog(null,"New password does not match with confirmation password");
			}
		  }
		  else
			  JOptionPane.showMessageDialog(null,"Password does not match with the original password");
		 }
		   catch(Exception e){}
		  }
		  });

		  btnCancel.addActionListener(new ActionListener()
		  {
			 public void actionPerformed(ActionEvent event)
			 {
				frame.setVisible(false);              //hide password window
			   new Login().setVisible(true); // disply first window
			 }
		   });
		  }
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

//===================================================================================================================================================================

	public static void main(String args[])
   {
			Login obj=new Login();
			obj.setVisible(true);
		}
}