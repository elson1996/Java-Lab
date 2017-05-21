import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
	private static CustomerForm cf;
	private static RepresentativeForm rf;
	private static RepDetails rd;
    private static Container ct;

    MainFrame(String s)	{
		super(s);
		cf = new CustomerForm();
		rf = new RepresentativeForm();
		rd = new RepDetails();
		ct = getContentPane();
		setDefaultFrame();
		setSize(200,400);
		setVisible(true);
		
	}

	static void setDefaultFrame()	{
		ct.removeAll();
		JButton btn1 = new JButton("Insert Customer");
		JButton btn2 = new JButton("Insert Representative");
		JButton btn3 = new JButton("Display Representatives");
		JPanel mainPanel = new JPanel();
		mainPanel.add(btn1);
		mainPanel.add(btn2);
		mainPanel.add(btn3);
		mainPanel.setLayout(new GridLayout(3,1));
		ct.add(mainPanel);
		ct.revalidate();
		ct.repaint();

		btn1.addActionListener(e -> {
            // TODO Auto-generated method stub
            ct.removeAll();
            ct.add(cf);
            ct.revalidate();
            ct.repaint();
        });

		btn2.addActionListener(e -> {
            // TODO Auto-generated method stub
            ct.removeAll();
            ct.add(rf);
            ct.revalidate();
            ct.repaint();

        });
		btn3.addActionListener(e -> {
            // TODO Auto-generated method stub
            ct.removeAll();
            rd.setDetails();
            ct.add(rd);
            ct.revalidate();
            ct.repaint();
        });
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainFrame("Forms");
		
	}

}
