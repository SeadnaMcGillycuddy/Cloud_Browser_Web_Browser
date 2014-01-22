import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ReadFile extends JFrame {
	
	private JTextField addressBar;
	private JEditorPane display;
	
	//constructor
	public ReadFile(){
		super("Cloud Browser");
		
		addressBar = new JTextField("http://");
		addressBar.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent event){
					loadPage(event.getActionCommand());
				}
			}
		);
		add(addressBar, BorderLayout.NORTH);
		
		display = new JEditorPane();
		display.setEditable(false);
		display.addHyperlinkListener(
			new HyperlinkListener(){
				public void hyperlinkUpdate(HyperlinkEvent event){
					if (event.getEventType() == HyperlinkEvent.EventType.ACTIVATED){
						loadPage(event.getURL().toString());
					}
				}
			}
		);
		add(new JScrollPane(display), BorderLayout.CENTER);
		setSize(800, 600);
		setVisible(true);
	}
	
	//load page
	private void loadPage(String userText){
		try{
			display.setPage(userText);
			addressBar.setText(userText);
		}catch(Exception e){
			JOptionPane.showMessageDialog(display, "That is not a valid URL! \n Please enter a URL in the format: http://www.[web address]");
		}
  }
}
