
package gui;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class HuntPickDia extends Dialog {
    /**
	 * 
	 */
	private static final long serialVersionUID = 832190509465543828L;
	TextArea zeigeAlle = new TextArea(10,100);
    Button action = new Button("Kampf");


    public HuntPickDia(MainWindow m) {
        super(m ,"Neue Jagd beginnen");
        this.setLayout(new BorderLayout());
        this.setModal(true);
        this.add(zeigeAlle, BorderLayout.NORTH);
        this.add(action, BorderLayout.SOUTH);
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
