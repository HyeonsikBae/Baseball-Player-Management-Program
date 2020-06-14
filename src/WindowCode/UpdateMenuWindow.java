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

public class UpdateMenuWindow extends Applet{

	int type = 0;
	
	public UpdateMenuWindow() {
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JPanel namePanel = new JPanel();
		JPanel firstInputPanel = new JPanel();
		JPanel secondInputPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		JLabel nameLabel1 = new JLabel("Baseball Player");
		JLabel nameLabel2 = new JLabel("Management Program");
		String op1 = "";
		int op2 = 0;
		String op3 = "";
		int op4 = 0;
		double op5 = 0;

		namePanel.setPreferredSize(new Dimension(200, 50));
		namePanel.setBackground(Color.lightGray);
		namePanel.add(nameLabel1);
		namePanel.add(nameLabel2);
		
		panel.add(namePanel);
		panel.add(firstInputPanel);
		panel.add(secondInputPanel);
		
		firstInputPanel.setPreferredSize(new Dimension(220, 90));
		firstInputPanel.setLayout(new GridLayout(0,1,10,10));
		firstInputPanel.add(new JLabel("수정할 선수의 번호"));
		TextField playerNumber = new TextField();
		firstInputPanel.add(playerNumber);
		JButton insert = new JButton("등록");
		firstInputPanel.add(insert);
		/*
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
		*/
		insert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MemberDao member = new MemberDao();
				int index = member.search(Integer.parseInt(playerNumber.getText()));
				String typeStr = member.searchType(index);
				
				if(typeStr.equals("타자")) {
					
				}
				else if(typeStr.equals("투수")) {
					
				}
			}
		});

		frame.add(panel);
		frame.setResizable(false);	//사이즈 변경 불가
		frame.setVisible(true);	//frame 보이도록
		frame.setSize(240, 480);	//frame 사이즈
		frame.setLocationRelativeTo(null);	//중앙에서 오픈
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//프레임 끄면 프로그램 꺼지도록
		
	}
}