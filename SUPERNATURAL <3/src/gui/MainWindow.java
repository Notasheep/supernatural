package gui;

import java.awt.*;
import java.awt.event.*;

import data.WriteCharacterFile;

import logik.CharacterContainer;

public class MainWindow extends Dialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8805017797903876173L;
	private Button bestehende = new Button("Bestehende Charactere wiedergeben");
    private Button neuerJ = new Button("Neuen Jäger anlegen");
    private Button cas = new Button("Castiel - Zur Zeit nicht erreichbar");
    private Button closeAndSave = new Button("Schpeichern und Schließen");
    private Button newHunt = new Button("Neue Jagd beginnen");
     
    public MainWindow(BackgroundGui g) {
    	//Layout management
    	super(g, "Jägerregister");
        this.setLayout(new GridLayout(5,1));
        this.setLocationRelativeTo(0,0);
        this.setModal(true);
        this.setUndecorated(true);
        
        //Buttons management
        this.add(bestehende);
        this.add(neuerJ);
        this.add(newHunt);
        this.add(cas);
        this.add(closeAndSave);
        	//Buttons color
        bestehende.setForeground(Color.WHITE);
        neuerJ.setForeground(Color.WHITE);
        cas.setForeground(Color.WHITE);
        newHunt.setForeground(Color.WHITE);
        closeAndSave.setForeground(Color.WHITE);
        	//Actionlistener to buttons 
        final MainWindow x = this;
        ActionListener l = new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (e.getSource() == neuerJ) {
        			@SuppressWarnings("unused")
					NewHunterDialog newHunter = new NewHunterDialog(x);
        		} else if (e.getSource() == bestehende) {
        			ListAllCharDia listOfAll = new ListAllCharDia(x);
        			CharacterContainer.instance().addObserver(listOfAll);
        		} else if (e.getSource() == newHunt){
        			@SuppressWarnings("unused")
					HuntPickDia huntWindow = new HuntPickDia(x);
        		}else if (e.getSource() == closeAndSave) {
        			WriteCharacterFile.saveAllCharacters(CharacterContainer.instance());
                    dispose();
                    System.exit(0);
                    return;
        		}
        	}
        };
        bestehende.addActionListener(l);
        neuerJ.addActionListener(l);
        cas.addActionListener(l);
        newHunt.addActionListener(l);
        closeAndSave.addActionListener(l);

        //Visibility
        this.pack(); 
        this.setVisible(true);
    }


	private void setLocationRelativeTo(int i, int j) {
		// TODO Auto-generated method stub
		
	}
}