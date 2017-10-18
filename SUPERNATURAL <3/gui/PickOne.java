package gui;

import java.awt.*;
import java.awt.event.*;

import logik.CharacterContainer;

public class PickOne extends Frame {

	Button bestehende = new Button("Bestehende Charactere wiedergeben");
    Button neuerJ = new Button("Neuen Jäger anlegen");
    Button cas = new Button("Castiel - Zur Zeit nicht erreichbar");
    Button closeAndSave = new Button("Schpeichern und Schließen");
    Button newHunt = new Button("Neue Jagd beginnen");
    
    public PickOne() {
    	super("Jägerregister");
        this.setLayout(new GridLayout(5,1));
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	saveAllCharacters();
                dispose();
            }
        });
        this.add(bestehende);
        final PickOne x = this;
        ActionListener l = new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (e.getSource() == neuerJ) {
        			AddHunter newHunter = new AddHunter(x);
        		} else if (e.getSource() == bestehende) {
        			ListOfAllCharacter listOfAll = new ListOfAllCharacter(x);
        			CharacterContainer.instance().addObserver(listOfAll);
        		} else if (e.getSource() == newHunt){
        			Hunt huntWindow = new Hunt(x);
        		}else if (e.getSource() == closeAndSave) {
        			
        		}
        	}
        };
        bestehende.addActionListener(l);
        neuerJ.addActionListener(l);
        cas.addActionListener(l);
        newHunt.addActionListener(l);
        closeAndSave.addActionListener(l);
        this.add(neuerJ);
        this.add(newHunt);
        this.add(cas);
        this.add(closeAndSave);
        this.pack(); 
        this.setVisible(true);
    }
}