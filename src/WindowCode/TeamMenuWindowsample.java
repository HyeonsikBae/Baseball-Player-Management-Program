package WindowCode;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class TeamMenuWindowsample extends Applet{

	public TeamMenuWindowsample() {
		JFrame teamMenuFrame = new JFrame();
		JPanel panel = new JPanel();
		JLabel programName = new JLabel("Baseball Player Management Program");
		JButton btn1 = new JButton("Click");
		JButton btn2 = new JButton("Exit");
		JTextArea textA = new JTextArea();	//	여러 줄 입력 
		JTextField textF = new JTextField();	//	한 줄 입력
		JPanel btnPanel = new JPanel();
		
		btnPanel.add(btn1);
		btnPanel.add(btn2);
		
		panel.setLayout(new BorderLayout());
		panel.add(programName, BorderLayout.NORTH);
		panel.add(btnPanel,BorderLayout.WEST);
		panel.add(textA,BorderLayout.CENTER);
		
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textA.append("gg\n");
				programName.setText("ggg");
			}
		});
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		teamMenuFrame.add(panel);
		
		teamMenuFrame.setResizable(false);	//사이즈 변경 불가
		teamMenuFrame.setVisible(true);	//frame 보이도록
		teamMenuFrame.setSize(240, 480);	//frarm 사이즈
		teamMenuFrame.setLocationRelativeTo(null);	//중앙에서 오픈
		teamMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//프레임 끄면 프로그램 꺼지도록
		
	}
}
