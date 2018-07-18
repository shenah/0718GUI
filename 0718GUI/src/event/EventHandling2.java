package event;

import java.awt.Frame;
import java.awt.Label;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class EventHandling2 extends Frame {

	public EventHandling2() {

		setBounds(100, 100, 500, 500);
		setTitle("Ű���� �̺�Ʈ");
		setLayout(null);

		Label air = new Label("@");
		air.setBounds(10, 90, 30, 30);
		add(air);

		KeyListener keyListener = new KeyListener() {
			// ���� Ű�� ������ ��
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			// Ű���带 ������ �� ȣ��ɶ� �޼ҵ�
			@Override
			public void keyPressed(KeyEvent e) {
				int x = air.getLocation().x;
				int y = air.getLocation().y;
				if (e.getKeyCode() == e.VK_LEFT) {
					x = x - 10;
				}
				if (e.getKeyCode() == e.VK_RIGHT) {
					x = x + 10;
				}
				if (e.getKeyCode() == e.VK_DOWN) {
					y = y + 10;
				}
				if (e.getKeyCode() == e.VK_UP) {
					y = y - 10;
				}
				air.setLocation(x, y);
				if (e.getModifiers() == KeyEvent.ALT_MASK && e.getKeyCode() == KeyEvent.VK_F1) {
					System.exit(0);
				}
				if (e.getKeyCode() == e.VK_ENTER) {
					Label label2 = new Label("�Ѿ�");
					label2.setBounds(air.getLocation().x, air.getLocation().y - 30, 30, 30);
					add(label2);

					Thread th = new Thread() {
						public void run() {
							try {
								while (true) {
									Thread.sleep(1000);
									int x = label2.getLocation().x;
									int y = label2.getLocation().y;
									label2.setLocation(x, y - 10);
								}
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					};
					th.start();
				}

			}

			// Ű���忡�� ���� �� ��
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

		};
		addKeyListener(keyListener);

		//Adaper Ŭ���� ����ϸ� ���ʿ��� �޼ҵ带 ������ �� �ʿ䰡 ����. 
		WindowAdapter wlistener = new WindowAdapter() {
			// �����ư�� ���� �� ȣ��Ǵ� �޼ҵ�
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);			
			}		
		};
		addWindowListener(wlistener);
		setVisible(true);
	}
}
