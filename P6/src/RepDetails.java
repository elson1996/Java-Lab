import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;

public class RepDetails extends JPanel{
	JdbcHelper db;
	private JButton btnBack;
	RepDetails()	{
		btnBack = new JButton("Back");
		db = new JdbcHelper();
		btnBack.addActionListener(e -> {
            // TODO Auto-generated method stub
            MainFrame.setDefaultFrame();
        });
	}
	void setDetails(){
		this.removeAll();
		DefaultTableModel model = new DefaultTableModel();
		JTable tbl = new JTable(model);
		String header[] = new String[]{"RepNumber","RepName"} ;
		model.setColumnIdentifiers(header);
		try {
			db.getReps(model);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		tbl.setPreferredScrollableViewportSize(tbl.getPreferredSize());
		add(new JScrollPane(tbl));
		add(btnBack);
	}
}
