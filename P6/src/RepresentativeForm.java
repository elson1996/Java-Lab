import javax.swing.*;
import java.sql.SQLException;

public class RepresentativeForm extends JPanel{
	private JTextField txtRepNo;
	private JTextField txtRepName;
	private JTextField txtRepState;
	private JTextField txtComm;
	private JTextField txtRepRate;
	private JLabel lblRepNo;
	private JLabel lblRepName;
	private JLabel lblRepState;
	private JLabel lblComm;
	private JLabel lblRepRate;
	private JButton btnSubmit;
	private JButton btnBack;
	private JdbcHelper db;
	RepresentativeForm()	{
		db = new JdbcHelper();
		setupLayout();
		setActions();
	}
	void setupLayout()	{
		lblRepNo = new JLabel("Representative No: ");
		lblRepName = new JLabel("Representative Name: ");
		lblRepState = new JLabel("Representative State: ");
		lblComm = new JLabel("Commission: ");
		lblRepRate = new JLabel("Representative Rate: ");
		txtRepNo = new JTextField(10);
		txtRepName = new JTextField(10);
		txtRepState = new JTextField(10);
		txtComm = new JTextField(10);
		txtRepRate = new JTextField(10);
		btnSubmit = new JButton("Submit");
		btnBack = new JButton("Back");
		add(lblRepNo);add(txtRepNo);
		add(lblRepName);add(txtRepName);
		add(lblRepState);add(txtRepState);
		add(lblComm);add(txtComm);
		add(lblRepRate);add(txtRepRate);
		add(btnSubmit);add(btnBack);
	}
	void setActions()	{
		btnSubmit.addActionListener(e -> {
            // TODO Auto-generated method stub
            System.out.println("Submitted");
            int repNo = Integer.parseInt(txtRepNo.getText());
            String name = txtRepName.getText();
            String state = txtRepState.getText();
            double comm = Double.parseDouble(txtComm.getText());
            Double rate = Double.parseDouble(txtRepRate.getText());
            try {
                db.insertRep(repNo, name, state, comm, rate);
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } finally{
                MainFrame.setDefaultFrame();
            }
        });

		btnBack.addActionListener(e -> {
            // TODO Auto-generated method stub
            MainFrame.setDefaultFrame();
        });
	}
}
