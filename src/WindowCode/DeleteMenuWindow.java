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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import DAO.MemberDao;

public class DeleteMenuWindow extends Applet{

	int type = 0;
	
	public DeleteMenuWindow() {
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JPanel namePanel = new JPanel();
		JPanel inputPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		JLabel nameLabel1 = new JLabel("Baseball Player");
		JLabel nameLabel2 = new JLabel("Management Program");		
		
		namePanel.setPreferredSize(new Dimension(200, 50));
		namePanel.setBackground(Color.lightGray);
		namePanel.add(nameLabel1);
		namePanel.add(nameLabel2);
		
		panel.add(namePanel);
		panel.add(inputPanel);
		panel.add(buttonPanel);
		
		inputPanel.setPreferredSize(new Dimension(220, 60));
		inputPanel.setLayout(new GridLayout(0,1,10,10));
		inputPanel.add(new JLabel("삭제할 선수의 번호"));
		TextField playerNumber = new TextField();
		inputPanel.add(playerNumber);
		
		JButton insert = new JButton("삭제");
		buttonPanel.add(insert);
		insert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int input = JOptionPane.showConfirmDialog(null, "정말 삭제하시겠습니까");
				if(input == 0) {
					new MemberDao().delete(Integer.parseInt(playerNumber.getText()));
				}
				if(input==0||input==1) {
					frame.setVisible(false);
					new mainMenuWindow();
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