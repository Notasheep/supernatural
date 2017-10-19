
package gui;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import character.CharacterType;

public class HuntPickDia extends Dialog {
    /**
	 * 
	 */
	private static final long serialVersionUID = 832190509465543828L;
    Button action = new Button("Kampf");
    Panel po = new Panel();
    Panel pu = new Panel();

    public HuntPickDia(MainWindow m) {
        super(m ,"Neue Jagd beginnen");
        this.setLayout(new BorderLayout());
        this.setModal(true);
        po.setLayout(new GridLayout(logik.CharacterContainer.instance().charconList.size()+1, 1));
        this.add(po, BorderLayout.NORTH);
        this.add(pu, BorderLayout.SOUTH);
        for(character.Character c: logik.CharacterContainer.instance().charconList){
        	if(c.getType() == CharacterType.Hunter){
        		po.add(new Checkbox(c.getName()));
        	}
        	System.out.println(c.getType());
        	System.out.println(c.getName());
        }
        pu.add(action);
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
