package WindowCode;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import AboutFile.AboutFile;

public class TeamMenuWindow extends Applet{
	
	AboutFile file = new AboutFile();

	public TeamMenuWindow() {
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JPanel namePanel = new JPanel();
		JPanel explainPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		JLabel nameLabel1 = new JLabel("Baseball Player");
		JLabel nameLabel2 = new JLabel("Management Program");

		JLabel explainLabel = new JLabel("팀을 선택해주세요.");
		
		
		namePanel.setPreferredSize(new Dimension(200, 50));
		namePanel.setBackground(Color.lightGray);
		namePanel.add(nameLabel1);
		namePanel.add(nameLabel2);
		
		explainPanel.setPreferredSize(new Dimension(200, 40));
		explainPanel.add(explainLabel);
		
		panel.add(namePanel);
		panel.add(explainPanel);
		panel.add(buttonPanel);
		
		buttonPanel.setLayout(new GridLayout(0,1,0,20));
		
		JButton b1 = new JButton("롯데");
		b1.setPreferredSize(new Dimension(200, 50));
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				file.createFile("롯데");
				//file.fileLoad();
				frame.setVisible(false);
				new mainMenuWindow();
				
			}
		});
		JButton b2 = new JButton("엘지");
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				file.createFile("엘지");
				file.fileLoad();
				frame.setVisible(false);
				new mainMenuWindow();
			}
		});
		JButton b3 = new JButton("기아");
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				file.createFile("기아");
				file.fileLoad();
				frame.setVisible(false);
				new mainMenuWindow();
			}
		});
		JButton b4 = new JButton("엘롯기");
		b4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				file.createFile("엘롯기");
				file.fileLoad();
				frame.setVisible(false);
				new mainMenuWindow();
			}
		});
		JButton bExit = new JButton("종료");
		bExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		buttonPanel.add(b1);
		buttonPanel.add(b2);
		buttonPanel.add(b3);
		buttonPanel.add(b4);
		buttonPanel.add(bExit);
		
		frame.add(panel);
		frame.setResizable(false);	//사이즈 변경 불가
		frame.setVisible(true);	//frame 보이도록
		frame.setSize(240, 480);	//frame 사이즈
		frame.setLocationRelativeTo(null);	//중앙에서 오픈
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//프레임 끄면 프로그램 꺼지도록
		
	}
}
