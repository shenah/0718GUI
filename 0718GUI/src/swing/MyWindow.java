package swing;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyWindow extends JFrame {

	public MyWindow() {
		setBounds(100, 100, 400, 400);
		setTitle("������ �̿��� ������");
		//�����ư �̺�Ʈ ó��
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		
		
		JLabel label = new JLabel("���̺�");
		panel.add(label);
		label.setToolTipText("�׳� ���̺�");
		
		ImageIcon icon = new ImageIcon("C:\\Users\\503-03\\Pictures\\Saved Pictures\\smile.png");
		JLabel imagelabel = new JLabel(icon);
		panel.add(imagelabel);
		
		//�׸� ����  �̸����� �迭 ����� - ũ�� ���� �ȵ�
		String [] image = {"smile.png", "meh.png", "frown.png"};
		// list �����
		
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
