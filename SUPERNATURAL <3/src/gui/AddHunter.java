package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import logik.CharacterContainer;
import logik.Hunter;

public class AddHunter extends Dialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1409989112406408631L;
	Button save = new Button("Speichern");
	TextField enterName = new TextField(20);
	Label name = new Label("Name:");

	public AddHunter(PickOne p1) {

		super(p1, "Neuen Jäger anlegen");
		this.setLayout(new BorderLayout());
		this.setModal(true);
		this.add(save, BorderLayout.SOUTH);
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == save) {
					CharacterContainer.instance().add(new Hunter(enterName.getText()));
					dispose();
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
