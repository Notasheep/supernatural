package gui;

import java.awt.Color;
import java.awt.Frame;

public class BackgroundGui extends Frame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5084189068551505475L;

	public BackgroundGui() {
		super("Supernatural");
		setBackground(Color.BLACK);
		setExtendedState(MAXIMIZED_BOTH);
		toBack();
		setUndecorated(true);
		setVisible(true);
		@SuppressWarnings("unused")
		MainWindow erschaffe = new MainWindow(this);
	}
}
