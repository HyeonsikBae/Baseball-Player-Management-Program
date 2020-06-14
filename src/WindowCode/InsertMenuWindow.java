package WindowCode;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DAO.MemberDao;

public class InsertMenuWindow extends Applet{

	int type = 0;
	
	public InsertMenuWindow() {
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JPanel namePanel = new JPanel();
		JPanel explainPanel = new JPanel();
		JPanel firstInputPanel = new JPanel();
		JPanel secondInputPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		JLabel nameLabel1 = new JLabel("Baseball Player");
		JLabel nameLabel2 = new JLabel("Management Program");
		TextField op1 = new TextField();
		TextField op2 = new TextField();
		TextField op3 = new TextField();
		TextField op4 = new TextField();
		TextField op5 = new TextField();
		TextField op6 = new TextField();
		TextField op7 = new TextField();		
		
		JButton batter = new JButton("타자");
		JButton pitcher = new JButton("투수");

		
		namePanel.setPreferredSize(new Dimension(200, 50));
		namePanel.setBackground(Color.lightGray);
		namePanel.add(nameLabel1);
		namePanel.add(nameLabel2);
		
		panel.add(namePanel);
		panel.add(explainPanel);
		panel.add(firstInputPanel);
		panel.add(secondInputPanel);
		
		explainPanel.setPreferredSize(new Dimension(200, 30));
		explainPanel.add(new JLabel("선수 타입 선택"));
		
		JButton insert = new JButton("등록");
		
		firstInputPanel.setPreferredSize(new Dimension(220, 30));
		firstInputPanel.setLayout(new GridLayout(0,2,10,10));
		batter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				secondInputPanel.setPreferredSize(new Dimension(220, 270));
				secondInputPanel.setLayout(new GridLayout(0,2,10,10));
				type = 1;

				secondInputPanel.add(new JLabel("선수 번호"));
				secondInputPanel.add(op1);
				secondInputPanel.add(new JLabel("선수 이름"));
				secondInputPanel.add(op2);
				secondInputPanel.add(new JLabel("선수 나이"));
				secondInputPanel.add(op3);
				secondInputPanel.add(new JLabel("선수 신장"));
				secondInputPanel.add(op4);
				secondInputPanel.add(new JLabel("타석 횟수"));
				secondInputPanel.add(op5);
				secondInputPanel.add(new JLabel("안타 횟수"));
				secondInputPanel.add(op6);
				secondInputPanel.add(new JLabel("타율"));
				secondInputPanel.add(op7);

				panel.add(buttonPanel);
				buttonPanel.add(insert);
				
				frame.setVisible(false);	//frame 보이도록
				frame.setVisible(true);	//frame 보이도록
			}
		});
		pitcher.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				secondInputPanel.setPreferredSize(new Dimension(220, 270));
				secondInputPanel.setLayout(new GridLayout(0,2,10,10));
				type = 2;
				
				TextField ds = new TextField();
				secondInputPanel.add(new JLabel("선수 번호"));
				secondInputPanel.add(op1);
				secondInputPanel.add(new JLabel("선수 이름"));
				secondInputPanel.add(op2);
				secondInputPanel.add(new JLabel("선수 나이"));
				secondInputPanel.add(op3);
				secondInputPanel.add(new JLabel("선수 신장"));
				secondInputPanel.add(op4);
				secondInputPanel.add(new JLabel("승수"));
				secondInputPanel.add(op5);
				secondInputPanel.add(new JLabel("패수"));
				secondInputPanel.add(op6);
				secondInputPanel.add(new JLabel("방어율"));
				secondInputPanel.add(op7);

				panel.add(buttonPanel);
				buttonPanel.add(insert);

				frame.setVisible(false);	//frame 보이도록
				frame.setVisible(true);	//frame 보이도록
			}
		});
		
		insert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int opt1 = Integer.parseInt(op1.getText());
				String opt2 = op2.getText();
				int opt3 = Integer.parseInt(op3.getText());
				double opt4 = Double.parseDouble(op4.getText());
				int opt5 = Integer.parseInt(op5.getText());
				int opt6 = Integer.parseInt(op6.getText());
				double opt7 = Double.parseDouble(op7.getText());
				
				if(type == 1) {
					new MemberDao().insert(1,opt1,opt2,opt3,opt4,opt5,opt6,opt7);
				}
				else if(type == 2) {
					new MemberDao().insert(2,opt1,opt2,opt3,opt4,opt5,opt6,opt7);
				}
				frame.setVisible(false);
				new mainMenuWindow();
			}
		});
		
		firstInputPanel.add(batter);
		firstInputPanel.add(pitcher);

		frame.add(panel);
		frame.setResizable(false);	//사이즈 변경 불가
		frame.setVisible(true);	//frame 보이도록
		frame.setSize(240, 480);	//frame 사이즈
		frame.setLocationRelativeTo(null);	//중앙에서 오픈
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//프레임 끄면 프로그램 꺼지도록
		
	}
}