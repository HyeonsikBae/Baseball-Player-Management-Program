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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

import DAO.MemberDao;

public class mainMenuWindow extends Applet{

	public mainMenuWindow() {
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JPanel namePanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		JLabel nameLabel1 = new JLabel("Baseball Player");
		JLabel nameLabel2 = new JLabel("Management Program");		
		
		namePanel.setPreferredSize(new Dimension(200, 50));
		namePanel.setBackground(Color.lightGray);
		namePanel.add(nameLabel1);
		namePanel.add(nameLabel2);
		
		panel.add(namePanel);
		panel.add(buttonPanel);
		
		buttonPanel.setLayout(new GridLayout(0,1,0,10));
		
		JButton b1 = new JButton("선수 등록");
		b1.setPreferredSize(new Dimension(200, 30));
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new InsertMenuWindow();
				frame.setVisible(false);
			}
		});
		JButton b2 = new JButton("선수 삭제");
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new DeleteMenuWindow();
				frame.setVisible(false);
			}
		});
		JButton b3 = new JButton("선수 검색");
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SearchMenuWindow();
				frame.setVisible(false);
			}
		});
		JButton b4 = new JButton("선수 수정");
		b4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new UpdateMenuWindow();
				frame.setVisible(false);
			}
		});
		JButton b5 = new JButton("선수 출력");
		b5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, new MemberDao().allPrint());
			}
		});
		JButton b6 = new JButton("타자 출력");
		b6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, new MemberDao().hitAvgLine());
			}
		});
		JButton b7 = new JButton("투수 출력");
		b7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, new MemberDao().defenceLine());
			}
		});
		JButton b9 = new JButton("선수 초기화");
		b9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MemberDao().allClear();
				JOptionPane.showMessageDialog(null, "초기화 완료");
			}
		});
		JButton bExit = new JButton("시스템 종료");
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
		buttonPanel.add(b5);
		buttonPanel.add(b6);
		buttonPanel.add(b7);
		buttonPanel.add(b9);
		buttonPanel.add(bExit);
		
		frame.add(panel);
		frame.setResizable(false);	//사이즈 변경 불가
		frame.setVisible(true);	//frame 보이도록
		frame.setSize(240, 480);	//frame 사이즈
		frame.setLocationRelativeTo(null);	//중앙에서 오픈
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//프레임 끄면 프로그램 꺼지도록
		
	}
}
