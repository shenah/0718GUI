package event;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class EventHandling1 extends Frame {

	// ������
	public EventHandling1() {
		setBounds(300, 300, 350, 400);
		setTitle("�̺�Ʈ ó�� ����");
		
		//���� ���� ��ġ�ϱ� ���ؼ� �г� ��ġ
		Panel panel =new Panel();
		
		// ���ϱ� ����ϴ� �̺�Ʈ �����
		TextField tf1 = new TextField(5);
	    Label plus = new Label("+");
	    TextField tf2 = new TextField(5);
	    Label assign = new Label("=");
	    TextField result = new TextField(6);
	  
	    panel.add(tf1);
	    panel.add(plus);
	    panel.add(tf2);
	    panel.add(assign);
	    panel.add(result);
	    
	    Button btn = new Button("���");
	    panel.add(btn);
	    //��ư : ActionEvent
	    ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int n1 = Integer.parseInt(tf1.getText());
				int n2 = Integer.parseInt(tf2.getText());
				result.setText(n1 +n2 + "");//result.setText(String.format("%d", n1+n2));
			}
	    	
	    };
	    btn.addActionListener(listener);
	    
	    Label pw = new Label("��й�ȣ:");   
	    TextField tfpw = new TextField(10);
	    Label pwresult = new Label();
	    
	    panel.add(pw);
	    panel.add(tfpw);
	    panel.add(pwresult);
	    
	    //TextEvent
	    TextListener tl = new TextListener() {

			@Override
			public void textValueChanged(TextEvent e) {
				String password = tfpw.getText();
				int dae = 0;
				int so = 0;
				int su = 0;
				int tec = 0;
				
				for(int i = 0; i<password.length(); i++) {
					char ch = password.charAt(i);
					if(ch >= 'A' && ch <= 'Z') {
						dae = dae + 1;
					}
					else if(ch >= 'a' && ch <= 'z') {
						so = so + 1;
					}
					else if(ch >= '0' && ch <= '9') {
						su = su + 1;
					}
					else {
						tec = tec + 1;
					}
				}
				if(dae*so*su*tec>0) {
					pwresult.setText("��й�ȣ ������ �����ϴ�.");
				}
				else {
					pwresult.setText("��й�ȣ ������ �����ϴ�.");
				}

			}
	    	
	    };
	    
	    tfpw.addTextListener(tl);
	    
		add(panel);
		setVisible(true);
	}

}
