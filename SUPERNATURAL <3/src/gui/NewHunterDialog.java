package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import character.Hunter;

import logik.CharacterContainer;

public class NewHunterDialog extends Dialog {
	private NewHunterDialog nhd;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1409989112406408631L;
	Button save = new Button("Speichern");
	TextField enterName = new TextField(20);
	Label name = new Label("Name:");

	public NewHunterDialog (MainWindow m) {

		super(m, "Neuen Jäger anlegen");
		this.setLayout(new BorderLayout());
		this.setModal(true);
		this.add(save, BorderLayout.SOUTH);
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == save) {
					try {
						CharacterContainer.instance().add(new Hunter(enterName.getText()));
						dispose();
					} catch (IllegalArgumentException inex){
						new FailDia (nhd , inex);
					}
				}

			}
		});
		this.add(enterName, BorderLayout.EAST);
		this.add(name, BorderLayout.WEST);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		this.pack();
		this.setVisible(true);
	}
}
