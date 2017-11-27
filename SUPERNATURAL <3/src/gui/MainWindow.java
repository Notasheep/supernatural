package gui;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import data.WriteCharacterFile;

import logik.CharacterContainer;

public class MainWindow extends Frame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8805017797903876173L;
	private Button bestehende = new Button("Bestehende Charactere wiedergeben");
    private Button neuerJ = new Button("Neuen Jäger anlegen");
    private Button neuesM = new Button("Neues Monster Anlegen");
    private Button cas = new Button("Castiel - Zur Zeit nicht erreichbar");
    private Button closeAndSave = new Button("Speichern und Schließen");
    private Button newHunt = new Button("Neue Jagd beginnen");
    private JPanel po = new JPanel();
    private Panel pu = new Panel(new GridLayout(5, 1));
    public MainWindow() {
    	//Layout management
    	this.setTitle("Pie Hunters");
        this.setLayout(new BorderLayout());
        this.setUndecorated(true);
        this.add(po, BorderLayout.NORTH);
        this.add(pu, BorderLayout.CENTER);
        
        //Image 
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("GuiLayoutData/toa-heftiba-82432.jpg"));
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        JLabel ii = new JLabel(new ImageIcon(image));
        ii.setBackground(Color.BLACK);
        po.add(ii);
        
        //Buttons management
        pu.add(bestehende);
        pu.add(neuerJ);
        pu.add(neuesM);
        pu.add(newHunt);
        pu.add(cas);
        pu.add(closeAndSave);

        	//Actionlistener to buttons 
        final MainWindow x = this;
        ActionListener l = new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (e.getSource() == neuerJ) {
        			@SuppressWarnings("unused")
					NewHunterDialog newHunter = new NewHunterDialog(x);
        		} else if (e.getSource() == neuesM) {
        			@SuppressWarnings("unused")
					NewMonsterGui newMonster = new NewMonsterGui(x);
        		} else if (e.getSource() == bestehende) {
        			ListAllCharDia listOfAll = new ListAllCharDia(x);
        			CharacterContainer.instance().addObserver(listOfAll);
        		} else if (e.getSource() == newHunt){
        			@SuppressWarnings("unused")
					HuntPickDia huntWindow = new HuntPickDia(x);
        		} else if (e.getSource() == closeAndSave) {
        			WriteCharacterFile.saveAllCharacters(CharacterContainer.instance());
                    dispose();
                    System.exit(0);
                    return;
        		}
        	}
        };
        bestehende.addActionListener(l);
        neuesM.addActionListener(l);
        neuerJ.addActionListener(l);
        cas.addActionListener(l);
        newHunt.addActionListener(l);
        closeAndSave.addActionListener(l);

        //Visibility
        this.setExtendedState(MAXIMIZED_BOTH); 
        this.setVisible(true);
    }
}