package view;

import javax.swing.JOptionPane;

import controller.*;

public class Main {

	public static void main(String[] args) {
		RedesController rc = new RedesController();
		int choice = 0;
		
		do {
			choice = Integer.parseInt(JOptionPane.showInputDialog(null,
					"1- Fazer teste de ip." + "\n" 
				  + "2- Fazer ping para www.google.com." + "\n"
				  + "9- Sair."));

			switch (choice) {
				case 1: 
					rc.ip();
					break;

				case 2: 
					rc.ping();
					break;

				case 9:
					JOptionPane.showMessageDialog(null, "Finalizando...");
					break;

				default:
					JOptionPane.showMessageDialog(null, "Valor invalido. Digite novamente...");
			}

		} while (choice != 9);

	}

}
