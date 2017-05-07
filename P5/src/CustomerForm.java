import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CustomerForm extends JPanel{
	private JTextField txtCustId;
	private JTextField txtCustName;
	private JTextField txtCustState;
	private JTextField txtCreditLimit;
	private JTextField txtCustRepNo;
	private JLabel lblCustId;
	private JLabel lblCustName;
	private JLabel lblCustState;
	private JLabel lblCreditLimit;
	private JLabel lblCustRepNo;
	private JButton btnSubmit;
	private JButton btnBack;
	JdbcHelper db;
	CustomerForm()	{
		db = new JdbcHelper();
		setupLayout();
		setActions();
	}
	void setupLayout()	{
		lblCustId = new JLabel("Customer ID: ");
		lblCustName = new JLabel("Customer Name: ");
		lblCustState = new JLabel("Customer State: ");
		lblCreditLimit = new JLabel("Customer Credit Limit: ");
		lblCustRepNo = new JLabel("Representative Number: ");
		txtCustId = new JTextField(10);
		txtCustName = new JTextField(10);
		txtCustState = new JTextField(10);
		txtCreditLimit = new JTextField(10);
		txtCustRepNo = new JTextField(10);
		btnSubmit = new JButton("Submit");
		btnBack = new JButton("Back");
		add(lblCustId);add(txtCustId);
		add(lblCustName);add(txtCustName);
		add(lblCustState);add(txtCustState);
		add(lblCreditLimit);add(txtCreditLimit);
		add(lblCustRepNo);add(txtCustRepNo);
		add(btnSubmit);add(btnBack);
	}
	void setActions()	{
		btnSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
/* TODO Auto-generated method stub */
				System.out.println("Submitted");
				int id = Integer.parseInt(txtCustId.getText());
				String name1 = txtCustName.getText();
				String state = txtCustState.getText();
				double creditLimit = Double.parseDouble(txtCreditLimit.getText());
				int repNo = Integer.parseInt(txtCustRepNo.getText());
				try {
					db.insertCustomer(id, name1, state, creditLimit, repNo);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					MainFrame.setDefaultFrame();
				}
			}
		});
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MainFrame.setDefaultFrame();
			}
		});
	}
}
