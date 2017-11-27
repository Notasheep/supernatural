package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import character.Bad;
import logik.CharacterContainer;

public class NewMonsterGui extends Dialog {
	private NewMonsterGui nmg;
	/**
	 * 
	 */
	private static final long serialVersionUID = -1428945471404987092L;
		Button save = new Button("Speichern");
		TextField enterName = new TextField(20);
		List monsterTyp = new List(1);
		Label name = new Label("Name:");

		public NewMonsterGui (MainWindow m) {
			super(m, "Neues Monster?");
			this.setLayout(new BorderLayout());
			this.setModal(true);
			this.add(save, BorderLayout.SOUTH);
			save.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == save) {
						try {
							CharacterContainer.instance().add(new Bad(enterName.getText()));
							dispose();
						} catch (IllegalArgumentException inex){
							new FailDia (nmg , inex);
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