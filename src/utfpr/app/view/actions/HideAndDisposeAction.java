package utfpr.app.view.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;

public class HideAndDisposeAction implements ActionListener {
	
	private JInternalFrame owner;
	
	public HideAndDisposeAction(JInternalFrame tela) {
		// TODO Auto-generated constructor stub
		this.owner = tela;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		owner.setVisible(false);
		owner.dispose();

	}

	

}
