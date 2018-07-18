package swing;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyWindow extends JFrame {

	public MyWindow() {
		setBounds(100, 100, 400, 400);
		setTitle("스윙을 이용한 윈도우");
		//종료버튼 이벤트 처리
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		
		
		JLabel label = new JLabel("레이블");
		panel.add(label);
		label.setToolTipText("그냥 레이블");
		
		ImageIcon icon = new ImageIcon("C:\\Users\\503-03\\Pictures\\Saved Pictures\\smile.png");
		JLabel imagelabel = new JLabel(icon);
		panel.add(imagelabel);
		
		//그림 파일  이름으로 배열 만들기 - 크기 변경 안됨
		String [] image = {"smile.png", "meh.png", "frown.png"};
		// list 만들기
		
		Thread th = new Thread() {
			public void run() {
				int idx = 0;
				try {
					while(true) {
						Thread.sleep(500);
						ImageIcon imageicon = new ImageIcon("C:\\Users\\503-03\\Pictures\\Saved Pictures\\" + image[idx%image.length]);
						label.setIcon(imageicon);
						idx = idx + 1;
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		th.start();
		
		add(panel);
		setVisible(true);
	}
}
