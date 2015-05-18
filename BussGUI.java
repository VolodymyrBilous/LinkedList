import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BussGUI {
	LinkedList<Buss> bl_in = new LinkedList<Buss>(), bl_out = new LinkedList<Buss>();
	
	int capac = 10;

	JFrame mainFrm = new JFrame("Buss park");
	JButton btnFormList = new JButton("form list");
	JButton btnFromPark = new JButton("from park");
	JButton btnInPark = new JButton("in park");
	JPanel pnl1 = new JPanel();
	JPanel pnl2 = new JPanel();
	JPanel pnl3 = new JPanel();
	//JLabel lblInPark = new JLabel("in park");
	//JLabel lblOutPark = new JLabel("out park");
	JTextArea txtin = new JTextArea("text");
	JTextArea txtout = new JTextArea("text");

	public void formAllBussList() {
		for (int i = 0; i < capac; i++) {
			Buss e = new Buss(i, i, "driver " + i);
			bl_in.add(e);
		}
	}

	public void fromPark(int bn) {
		Buss buss = null;
		//int indx;
		for (Iterator iterator = ((List<Buss>) bl_in).iterator(); iterator.hasNext();) {
			Buss bussFrom = (Buss) iterator.next();
			if (bussFrom.bussNumber == bn) {
				buss = bussFrom;
				break;
			}

		}
		if (buss != null) {
			bl_out.add(buss);
			bl_in.remove(buss);
		}

	}
	public void inPark(int bn) {
		Buss buss = null;
		//int indx;
		for (Iterator iterator = bl_out.iterator(); iterator.hasNext();) {
			Buss bussFrom = (Buss) iterator.next();
			if (bussFrom.bussNumber == bn) {
				buss = bussFrom;
				break;
			}

		}
		if (buss != null) {
			bl_in.add(buss);
			bl_out.remove(buss);
		}

	}
	public BussGUI() {
		mainFrm.setSize(200, 400);
		//mainFrm.getContentPane().setLayout(new CardLayout(0, 0));
		btnFromPark.setEnabled(false);
		btnInPark.setEnabled(false);
		
		btnFormList.setLocation(10, 10);
		btnFormList.setSize(180, 20);
		
		btnFromPark.setLocation(200, 10);
		btnFromPark.setSize(180, 20);
		
		btnInPark.setLocation(400, 10);
		btnInPark.setSize(180, 20);
		
		txtin.setLocation(10, 40);
		txtin.setSize(300, 400);
		
		txtout.setLocation(350, 40);
		txtout.setSize(300, 400);
		
		pnl1.add(btnFormList);
		pnl1.add(btnFromPark);
		pnl1.add(btnInPark);
		
		pnl1.add(txtin);
       
		pnl1.add(txtout);
		
		pnl1.setLayout(null);
		//mainFrm.getContentPane().add(pnl1);
		//mainFrm.getContentPane().add(pnl2);
		mainFrm.setContentPane(pnl1);
		//mainFrm.getContentPane().add(pnl3);


		mainFrm.setSize(700, 500);
		mainFrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 		
		
		//mainFrm.pack();
		mainFrm.setVisible(true);	
		
		btnFromPark.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
        		fromPark((int)(Math.random()*capac));
        		
        		showInParkList();
        		showOutParkList();
			}
		});	
		btnInPark.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				inPark((int)(Math.random()*capac));
        		
        		showInParkList();
        		showOutParkList();
			}
		});		
		btnFormList.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnFormList.setEnabled(false);
				btnFromPark.setEnabled(true);
				btnInPark.setEnabled(true);
        		formAllBussList();
        		showInParkList();
			}
		});
	}
    public void showOutParkList(){
    	
    	txtout.setText(display(bl_out));

    }
    public void showInParkList(){
    	
    	txtin.setText(display(bl_in));

    }
    String display(LinkedList<Buss> bl){
    	String str="";
    	for (Iterator iterator = bl.iterator(); iterator.hasNext();) {
			Buss buss = (Buss) iterator.next();
			str=str+buss.getName()+"\n";
							
		}
    	return str;
    }
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new BussGUI();
			}
		});
	}
}
