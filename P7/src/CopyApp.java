import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CopyApp extends JPanel{
	
	JProgressBar pbCopy;
	Thread t;
	Boolean copying;
	JTextArea textArea;
	FileIoHelper fih;
	CopyApp()	{
		copying = false;
		setInputPanel();
		setCopyPanel();
	}
	private void setCopyPanel() {
		// TODO Auto-generated method stub
		pbCopy = new JProgressBar();
		textArea = new JTextArea(30,20);
		add(pbCopy);
		add(textArea);
	}
	private void setInputPanel() {
		// TODO Auto-generated method stub
		JLabel lblInputFile, lblOutputFile;
		JTextField tfInputFile, tfOutputFile;
		JButton btnCopy;
		lblInputFile = new JLabel("InputFile: ");
		lblOutputFile = new JLabel("OutputFile: ");
		btnCopy = new JButton("Start Copying");
		btnCopy.setToolTipText("Press to Copy");
		tfInputFile = new JTextField(15);
		tfOutputFile = new JTextField(15);
		add(lblInputFile);
		add(tfInputFile);
		add(lblOutputFile);
		add(tfOutputFile);
		add(btnCopy);
		btnCopy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!copying)	{
					String inputFile = tfInputFile.getText();
					String outputFile = tfOutputFile.getText();
					if(inputFile.isEmpty() || outputFile.isEmpty())
						return;
					copying = true;
					tfInputFile.setEditable(false);
					tfOutputFile.setEditable(false);
					btnCopy.setText("Cancel Copy");
					Runnable runner = new Runnable()	{
						@Override
						public void run() {
							// TODO Auto-generated method stub
							fih = new FileIoHelper(inputFile, outputFile, pbCopy);
							try {
								fih.copy();
								fih.displayCopied(textArea);
								btnCopy.setText("Completed");
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					};
					t = new Thread(runner, "CopyThread");
					t.start();
				}else{
					btnCopy.setText("Stopped");
					btnCopy.setEnabled(false);
					copying = false;
					//fih.stopCopy = true;
					t.stop();
					try {
						fih.displayCopied(textArea);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}	
			}
		});
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame jfm = new JFrame("Copy App");
		jfm.setSize(300, 150);
		jfm.setContentPane(new CopyApp());
		jfm.setVisible(true);
	}

}
