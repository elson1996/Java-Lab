import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class CustomerForm extends JPanel{
	private JTextField txtCustId;
	private JTextField txtCustName;
	private JTextField txtCustState;
	private JTextField txtCreditLimit;
	private JTextField txtCustRepNo;
    private JButton btnSubmit;
	private JButton btnBack;

	JdbcHelper db;
	CustomerForm()	{
		db = new JdbcHelper();
		setupLayout();
		setActions();
	}
	void setupLayout()	{
        JLabel lblCustId = new JLabel("Customer ID: ");
        JLabel lblCustName = new JLabel("Customer Name: ");
        JLabel lblCustState = new JLabel("Customer State: ");
        JLabel lblCreditLimit = new JLabel("Customer Credit Limit: ");
        JLabel lblCustRepNo = new JLabel("Representative Number: ");
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
		setLayout(new GridLayout(6,2));
	}
	void setActions()	{
		btnSubmit.addActionListener(e -> {
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
        });
		btnBack.addActionListener(e -> {
            // TODO Auto-generated method stub
            MainFrame.setDefaultFrame();
        });
	}
}
