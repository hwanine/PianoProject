package 자바프로젝트;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;

class High extends JFrame
{
	private static final long serialVersionUID = 1L;
	BufferedImage background;
	
	void inputKey(final JButton button, final char key, final String string)
	{
		button.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent event)
			{
			    char character = event.getKeyChar();
			    if(character == key)
			    {
			    	try
					{
					    AudioInputStream ais = AudioSystem.getAudioInputStream(new File(string));
					    Clip clip = AudioSystem.getClip();
					    clip.stop();
					    clip.open(ais);
					    clip.start();
					}
					catch (Exception error)
					{
					 	System.out.println("파일이 손상되었거나 디렉토리에 존재하지 않습니다.");
					}
			    }
		    }
		});
	}
	
	void insertSound(final JButton button, final String string)
	{
		button.addActionListener(new ActionListener()
		{	
			public void actionPerformed(ActionEvent event)
			{	
				if(event.getSource() == button)
				{
					try
					{
					    AudioInputStream ais = AudioSystem.getAudioInputStream(new File(string));
					    Clip clip = AudioSystem.getClip();
					    clip.stop();
					    clip.open(ais);
					    clip.start();
					}
					catch (Exception error)
					{
					 	System.out.println("파일이 손상되었거나 디렉토리에 존재하지 않습니다.");
					}
				}
			}
		});
	}

	public High()
	{
		setTitle("Virtual Piano");
		ImageIcon icon = new ImageIcon("images\\icon.png");
		setIconImage(icon.getImage());
		setLocation(300, 120);
		 
		try
		{
			background = ImageIO.read(new File("images\\background.png"));
		}
		catch(IOException error)
		{
			System.out.println("파일이 손상되었거나 디렉토리에 존재하지 않습니다.");
			System.exit(0);
		}
		
		JPanel panel = new JPanel()
		{
			private static final long serialVersionUID = 1L;
			
			public void paintComponent(Graphics graphics)
			{
				graphics.drawImage(background, 0, 0, 1290, 800, this);
			}
			
			public Dimension getPreferredSize()
			{
				if(background == null)
					return new Dimension(1290, 800);
				else
					return new Dimension(background.getWidth(null), background.getHeight(null));
			}
		};
		
		panel.setLayout(null);

		final JButton low_octave = new JButton();
		ImageIcon left_arrow = new ImageIcon("images\\left_arrow.png");
		low_octave.setIcon(left_arrow);
		low_octave.setBounds(20, 20, 100, 100);
		panel.add(low_octave);
		insertSound(low_octave, "sounds\\octave\\low_octave.wav");
		low_octave.addActionListener(new ActionListener()
		{	
			public void actionPerformed(ActionEvent event)
			{	
				if(event.getSource() == low_octave)
				{
					dispose();
				}
			}
		});
		
		JLabel label = new JLabel();
		ImageIcon logo = new ImageIcon("images\\logo.png");
		label.setIcon(logo);
		label.setBounds(143, 22, 1000, 350);
		panel.add(label);
		
		final JButton help_button = new JButton();
		ImageIcon help = new ImageIcon("images\\help_icon.png");
		help_button.setIcon(help);
		help_button.setBounds(1170, 20, 100, 100);
		panel.add(help_button);
		
		JTextField octave = new JTextField("4옥타브 ~ 5옥타브");
		octave.setFont(new Font("고딕체",Font.PLAIN,17));
		octave.setBounds(1150, 135, 138, 30);
		panel.add(octave);
		
		help_button.addActionListener(new ActionListener()
		{	
			public void actionPerformed(ActionEvent event)
			{	
				if(event.getSource() == help_button)
				{
					try
					{
					    AudioInputStream ais = AudioSystem.getAudioInputStream(new File("sounds\\help\\notice.wav"));
					    Clip clip = AudioSystem.getClip();
					    clip.stop();
					    clip.open(ais);
					    clip.start();
					}
					catch (Exception error)
					{
					 	System.out.println("파일이 손상되었거나 디렉토리에 존재하지 않습니다.");
					}
					
		  			Help help = new Help();
		  			help.setVisible(true);
				}
			}
		});
		
		
				
		
		int i = 1, column = 65;
		
		while(i <= 10)
		{	
			switch(i)
			{
			case 1:
			{
				JButton black_keyboard = new JButton();
				
				black_keyboard.setBounds(column, 395, 70, 220);
				black_keyboard.setBackground(Color.black);
				panel.add(black_keyboard);			
				insertSound(black_keyboard, "sounds\\piano_35_110_73.wav");
				inputKey(black_keyboard, 's', "sounds\\piano_35_110_73.wav");
			
				column += 97;
			}
			case 2:
			{
                JButton black_keyboard = new JButton();
				
				black_keyboard.setBounds(column, 395, 70, 220);
				black_keyboard.setBackground(Color.black);
				panel.add(black_keyboard);
				insertSound(black_keyboard, "sounds\\piano_35_110_75.wav");
				inputKey(black_keyboard, 'd', "sounds\\piano_35_110_75.wav");
				
				column += 174;
			}
			case 3:
			{
                JButton black_keyboard = new JButton();
				
				black_keyboard.setBounds(column, 395, 70, 220);
				black_keyboard.setBackground(Color.black);
				panel.add(black_keyboard);
				insertSound(black_keyboard, "sounds\\piano_35_110_78.wav");
				inputKey(black_keyboard, 'g', "sounds\\piano_35_110_78.wav");
				
				column += 92;
			}
			case 4:
			{
                JButton black_keyboard = new JButton();
				
				black_keyboard.setBounds(column, 395, 70, 220);
				black_keyboard.setBackground(Color.black);
				panel.add(black_keyboard);
				insertSound(black_keyboard, "sounds\\piano_35_110_80.wav");
				inputKey(black_keyboard, 'h', "sounds\\piano_35_110_80.wav");
				
				column += 94;
			}
			case 5:
			{
                JButton black_keyboard = new JButton();
				
				black_keyboard.setBounds(column, 395, 70, 220);
				black_keyboard.setBackground(Color.black);
				panel.add(black_keyboard);
				insertSound(black_keyboard, "sounds\\piano_35_110_82.wav");
				inputKey(black_keyboard, 'j', "sounds\\piano_35_110_82.wav");
				
				column += 174;
			}
			case 6:
			{
                JButton black_keyboard = new JButton();
				
				black_keyboard.setBounds(column, 395, 70, 220);
				black_keyboard.setBackground(Color.black);
				panel.add(black_keyboard);
				insertSound(black_keyboard, "sounds\\piano_35_110_85.wav");
				inputKey(black_keyboard, '2', "sounds\\piano_35_110_85.wav");
				
				column += 95;
			}
			case 7:
			{
                JButton black_keyboard = new JButton();
				
				black_keyboard.setBounds(column, 395, 70, 220);
				black_keyboard.setBackground(Color.black);
				panel.add(black_keyboard);
				insertSound(black_keyboard, "sounds\\piano_35_110_87.wav");
				inputKey(black_keyboard, '3', "sounds\\piano_35_110_87.wav");
				
				column += 174;
			}
			case 8:
			{
                JButton black_keyboard = new JButton();
				
				black_keyboard.setBounds(column, 395, 70, 220);
				black_keyboard.setBackground(Color.black);
				panel.add(black_keyboard);
				insertSound(black_keyboard, "sounds\\piano_35_110_90.wav");
				inputKey(black_keyboard, '5', "sounds\\piano_35_110_90.wav");
				
				column += 94;
			}
			case 9:
			{
                JButton black_keyboard = new JButton();
				
				black_keyboard.setBounds(column, 395, 70, 220);
				black_keyboard.setBackground(Color.black);
				panel.add(black_keyboard);
				insertSound(black_keyboard, "sounds\\piano_35_110_92.wav");
				inputKey(black_keyboard, '6', "sounds\\piano_35_110_92.wav");
				
				column += 93;
			}
			case 10:
			{
                JButton black_keyboard = new JButton();
				
				black_keyboard.setBounds(column, 395, 70, 220);
				black_keyboard.setBackground(Color.black);
				panel.add(black_keyboard);
				insertSound(black_keyboard, "sounds\\piano_35_110_94.wav");
				inputKey(black_keyboard, '7', "sounds\\piano_35_110_94.wav");
			}
			}
			
			i ++;
		}
		
	    i = 1;
	    column = 15;

	    while(i <= 14)
	    {
	    	switch(i)
	    	{
	    	case 1:
	    	{
	    		final JButton white_keyboard = new JButton();
				
				white_keyboard.setBounds(column, 615, 90, 135);
				white_keyboard.setBackground(Color.white);
				panel.add(white_keyboard);
				insertSound(white_keyboard, "sounds\\piano_35_110_72.wav");
				inputKey(white_keyboard, 'z', "sounds\\piano_35_110_72.wav");
	    	}
	    	case 2:
	    	{
	    		final JButton white_keyboard = new JButton();
				
				white_keyboard.setBounds(column, 615, 90, 135);
				white_keyboard.setBackground(Color.white);
				panel.add(white_keyboard);
				insertSound(white_keyboard, "sounds\\piano_35_110_74.wav");
				inputKey(white_keyboard, 'x', "sounds\\piano_35_110_74.wav");
	    	}
	    	case 3:
	    	{
	    		final JButton white_keyboard = new JButton();
				
				white_keyboard.setBounds(column, 615, 90, 135);
				white_keyboard.setBackground(Color.white);
				panel.add(white_keyboard);
				insertSound(white_keyboard, "sounds\\piano_35_110_76.wav");
				inputKey(white_keyboard, 'c', "sounds\\piano_35_110_76.wav");
	    	}
	    	case 4:
	    	{
	    		final JButton white_keyboard = new JButton();
				
				white_keyboard.setBounds(column, 615, 90, 135);
				white_keyboard.setBackground(Color.white);
				panel.add(white_keyboard);
				insertSound(white_keyboard, "sounds\\piano_35_110_77.wav");
				inputKey(white_keyboard, 'v',"sounds\\piano_35_110_77.wav");
	    	}
	    	case 5:
	    	{
	    		final JButton white_keyboard = new JButton();
				
				white_keyboard.setBounds(column, 615, 90, 135);
				white_keyboard.setBackground(Color.white);
				panel.add(white_keyboard);
				insertSound(white_keyboard, "sounds\\piano_35_110_79.wav");
				inputKey(white_keyboard, 'b', "sounds\\piano_35_110_79.wav");
	    	}
	    	case 6:
	    	{
	    		final JButton white_keyboard = new JButton();
				
				white_keyboard.setBounds(column, 615, 90, 135);
				white_keyboard.setBackground(Color.white);
				panel.add(white_keyboard);
				insertSound(white_keyboard, "sounds\\piano_35_110_81.wav");
				inputKey(white_keyboard, 'n', "sounds\\piano_35_110_81.wav");
	    	}
	    	case 7:
	    	{
	    		final JButton white_keyboard = new JButton();
				
				white_keyboard.setBounds(column, 615, 90, 135);
				white_keyboard.setBackground(Color.white);
				panel.add(white_keyboard);
				insertSound(white_keyboard,  "sounds\\piano_35_110_83.wav");
				inputKey(white_keyboard, 'm',  "sounds\\piano_35_110_83.wav");
	    	}
	    	case 8:
	    	{
	    		final JButton white_keyboard = new JButton();
				
				white_keyboard.setBounds(column, 615, 90, 135);
				white_keyboard.setBackground(Color.white);
				panel.add(white_keyboard);
				insertSound(white_keyboard, "sounds\\piano_35_110_84.wav");
				inputKey(white_keyboard, 'q', "sounds\\piano_35_110_84.wav");
	    	}
	    	case 9:
	    	{
	    		final JButton white_keyboard = new JButton();
				
				white_keyboard.setBounds(column, 615, 90, 135);
				white_keyboard.setBackground(Color.white);
				panel.add(white_keyboard);
				insertSound(white_keyboard, "sounds\\piano_35_110_86.wav");
				inputKey(white_keyboard, 'w', "sounds\\piano_35_110_86.wav");
	    	}
	    	case 10:
	    	{
	    		final JButton white_keyboard = new JButton();
				
				white_keyboard.setBounds(column, 615, 90, 135);
				white_keyboard.setBackground(Color.white);
				panel.add(white_keyboard);
				insertSound(white_keyboard, "sounds\\piano_35_110_88.wav");
				inputKey(white_keyboard, 'e', "sounds\\piano_35_110_88.wav");
	    	}
	    	case 11:
	    	{
	    		final JButton white_keyboard = new JButton();
				
				white_keyboard.setBounds(column, 615, 90, 135);
				white_keyboard.setBackground(Color.white);
				panel.add(white_keyboard);
				insertSound(white_keyboard, "sounds\\piano_35_110_89.wav");
				inputKey(white_keyboard, 'r', "sounds\\piano_35_110_89.wav");
	    	}
	    	case 12:
	    	{
	    		final JButton white_keyboard = new JButton();
				
				white_keyboard.setBounds(column, 615, 90, 135);
				white_keyboard.setBackground(Color.white);
				panel.add(white_keyboard);
				insertSound(white_keyboard, "sounds\\piano_35_110_91.wav");
				inputKey(white_keyboard, 't', "sounds\\piano_35_110_91.wav");
	    	}
	    	case 13:
	    	{
	    		final JButton white_keyboard = new JButton();
				
				white_keyboard.setBounds(column, 615, 90, 135);
				white_keyboard.setBackground(Color.white);
				panel.add(white_keyboard);
				insertSound(white_keyboard, "sounds\\piano_35_110_93.wav");
				inputKey(white_keyboard, 'y', "sounds\\piano_35_110_93.wav");
	    	}
	    	case 14:
	    	{
	    		final JButton white_keyboard = new JButton();
				
				white_keyboard.setBounds(column, 615, 90, 135);
				white_keyboard.setBackground(Color.white);
				panel.add(white_keyboard);
				insertSound(white_keyboard, "sounds\\piano_35_110_95.wav");
				inputKey(white_keyboard, 'u', "sounds\\piano_35_110_95.wav");
	    	}
	    	}
	
		    column += 90;
		    i ++;
	    }

		add(panel);
		pack();
		setResizable(false);
	}
}

public class Main2
{
	public static void main(String[] args)
	{
		Frame frame = new Frame();
		frame.setVisible(true);
	}
}
