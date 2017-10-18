package gui;

import java.awt.*;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import java.awt.event.*;

import logik.Character;
import logik.CharacterContainer;

public class ListOfAllCharacter extends Dialog implements Observer {
	private Button close = new Button("OK");
	private Panel pn = new Panel();
	private Panel php = new Panel();
	private GridLayout g = new GridLayout(CharacterContainer.charconList.size()+ 1,1);
	
	public ListOfAllCharacter(PickOne p1) {
		super(p1, "Liste aller Charactere");
		this.setLayout(new BorderLayout());
		this.add(pn, BorderLayout.WEST);
		this.add(php, BorderLayout.EAST);
		pn.setLayout(g);
		php.setLayout(g);
		pn.add(new Label("Name", Label.CENTER));
		php.add(new Label("Health Points", Label.CENTER));
		for (Character c : CharacterContainer.charconList) {
			pn.add(new Label(c.name));
			php.add(new Label(""+ c.live));
		}
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		this.add(close, BorderLayout.SOUTH);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent wc) {
				dispose();
			}
		});
		this.setMinimumSize(new Dimension(240,0));
		this.pack();
		this.setVisible(true);
	}
	public void update(Observable o, Object arg) {
		g.setRows(g.getRows()+1);
		Character a = CharacterContainer.charconList.get(CharacterContainer.charconList.size()-1);
		pn.add(new Label(a.name));
		php.add(new Label("" + a.live));
		this.pack();
		this.setVisible(true);
	}
}
