package gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FailDia extends Dialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2928332125937332305L;
	Button ok = new Button("OK");
	public FailDia(Dialog nhd, Exception e) {
		super(nhd, "Uuupsala...");
		this.setLayout(new BorderLayout());
		ok.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent ev){
				if (ev.getSource() == ok) {
					toBack();
					dispose();
				}
			}
		});
		this.add(ok, BorderLayout.SOUTH);
		this.add(new Label(e.getMessage()),BorderLayout.NORTH);
		this.setModal(true);
		this.pack();
		this.toFront();
		this.setVisible(true);
	}
}
