package gui;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;
import java.awt.event.*;
import logik.Hunter;
import logik.HunterContainer;

public class ListOfAllCharacter extends Dialog implements Observer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 421769429299314717L;
	private Button close = new Button("OK");
	private Panel pn = new Panel();
	private Panel php = new Panel();
	private GridLayout g = new GridLayout(HunterContainer.instance().hunconList.size()+ 1,1);
	
	public ListOfAllCharacter(PickOne p1) {
		super(p1, "Liste aller Charactere");
		this.setLayout(new BorderLayout());
		this.add(pn, BorderLayout.WEST);
		this.add(php, BorderLayout.EAST);
		pn.setLayout(g);
		php.setLayout(g);
		pn.add(new Label("Name", Label.CENTER));
		php.add(new Label("Health Points", Label.CENTER));
		for (Hunter c : HunterContainer.instance().hunconList) {
			pn.add(new Label(c.getName()));
			php.add(new Label(""+ c.getLive()));
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
		Hunter a = HunterContainer.instance().hunconList.get(HunterContainer.instance().hunconList.size()-1);
		pn.add(new Label(a.getName()));
		php.add(new Label("" + a.getLive()));
		this.pack();
		this.setVisible(true);
	}
}
