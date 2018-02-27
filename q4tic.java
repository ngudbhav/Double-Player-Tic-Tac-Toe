import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class q4tic implements ActionListener
{
	JFrame f;
	TextField t1;
	TextField t2;
	String p1;
	String p2;
	int i,j,k=0;
	Button b[] = new Button[9];	
	Label l1;
	Label l2;
	Label l3;
	Button ok;
	Button cancel;

	{
		p1 = JOptionPane.showInputDialog(f,"Enter player 1 name");
		p2 = JOptionPane.showInputDialog(f,"Enter player 2 name");
	}
	q4tic()
	{
		f = new JFrame("q3");
		f.setLayout(null);
		for(i=0;i<3;i++)
		{
			for(j=0;j<3;j++)
			{
				b[k] = new Button(""+(k+1));
				b[k].setBounds((30+j*70),(395 +i*65),60,60);
				b[k].addActionListener(this);
				f.add(b[k]);
				k=k+1;
			}
		}
		t1 = new TextField(p1);
		t1.setBounds(250,325,200,25);
		t1.setEnabled(false);
		f.add(t1);
		t2 = new TextField(p2);
		t2.setBounds(250,360,200,25);
		t2.setEnabled(false);
		f.add(t2);
		l1 = new Label("");
		l1.setBounds(20,40,550,260);
		l1.setBackground(Color.red);
		f.add(l1);
		ok = new Button("EXIT");
		ok.setBounds(400,425,60,30);
		f.add(ok);
		ok.addActionListener(this);
		cancel = new Button("RESET");
		cancel.setBounds(400,525,60,30);
		f.add(cancel);
		cancel.addActionListener(this);
		l2 = new Label("Name of 1st player:");
		l2.setBounds(30,325,200,25);
		f.add(l2);
		l3 = new Label("Name of 2nd player:");
		l3.setBounds(30,360,200,25);
		f.add(l3);
		k=0;
		f.setSize(600,650);
		f.setBackground(Color.white);
		f.setVisible(true);
	}
public void check()
{
	if((b[0].getLabel()==b[1].getLabel()) && (b[1].getLabel()==b[2].getLabel()) || (b[3].getLabel()==b[4].getLabel())&&(b[4].getLabel()==b[5].getLabel()) || (b[6].getLabel()==b[7].getLabel())&&(b[7].getLabel()==b[8].getLabel()) || (b[0].getLabel()==b[3].getLabel())&&(b[3].getLabel()==b[6].getLabel()) || (b[1].getLabel()==b[4].getLabel())&&(b[4].getLabel()==b[7].getLabel()) || (b[2].getLabel()==b[5].getLabel())&&(b[5].getLabel()==b[8].getLabel()) || (b[0].getLabel()==b[4].getLabel())&&(b[4].getLabel()==b[8].getLabel()) || (b[2].getLabel()==b[4].getLabel())&&(b[4].getLabel()==b[6].getLabel()))
	{
		for(j=0;j<9;j++)
		{
			b[j].setEnabled(false);
		}
		JOptionPane.showMessageDialog(null,"Game Over!");
		if(k==1)
		{
			JOptionPane.showMessageDialog(null ,"Wins "+ p1);
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Wins "+ p2);
		}
		JOptionPane.showMessageDialog(null,"Please click on the Reset Button.");
		
	}
}
public void actionPerformed(ActionEvent e)
{
	Object ob1 = e.getSource();
	for(i=0;i<9;i++)
	{
		if(ob1==b[i])
		{
			if(k==0)
			{
				b[i].setLabel("X");
				k=1;
				b[i].setEnabled(false);
				check();
			}
			else
			{
				b[i].setLabel("0");
				k=0;
				b[i].setEnabled(false);
				check();
			}
		}
	}
	if(ob1==ok)
	{
		System.exit(0);
	}
	else if(ob1==cancel)
	{
		for(j=0;j<9;j++)
		{
			b[j].setLabel(""+(j+1));
			b[j].setEnabled(true);
			k=0;
		}
	}
}
public static void main(String z[])
{
	q4tic ob = new q4tic();
}
}