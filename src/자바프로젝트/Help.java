package 자바프로젝트;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Help extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	public Help()
	{
	    setBounds(300, 120, 505, 415);
	    setTitle("도움말");
	    ImageIcon icon = new ImageIcon("images\\help_icon.png");
	    setIconImage(icon.getImage());
	    	   
	    JPanel panel = new JPanel(); 	
	    panel.setLayout(null);
	    	   
	    JLabel label = new JLabel();
	    ImageIcon help = new ImageIcon("images\\help.png");
	    label.setIcon(help);
	    label.setBounds(0, 0, 498, 383);
	    panel.add(label);
	    	
	    add(panel);
	    setResizable(false);
	}
}
