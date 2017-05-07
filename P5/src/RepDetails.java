import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

public class RepDetails extends JPanel{
	JdbcHelper db;
	private JButton btnBack;
	RepDetails()	{
		btnBack = new JButton("Back");
		db = new JdbcHelper();
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MainFrame.setDefaultFrame();
			}
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
