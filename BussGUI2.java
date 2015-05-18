import java.awt.Color;
import java.awt.GridLayout;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BussGUI2 {
	
	LinkList bl_in = new LinkList(), bl_out = new LinkList();
	int capac = 10;

	JFrame mainFrm = new JFrame("Buss park");
	JButton btnFormList = new JButton("form list");
	JButton btnFromPark = new JButton("from park");
	JButton btnInPark = new JButton("in park");
	JPanel pnl1 = new JPanel();
	JPanel pnl2 = new JPanel();
	JPanel pnl3 = new JPanel();
	JTextField bussNum = new JTextField(0);
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

		buss = bl_in.find(bn);

		if (buss != null) {			
			
			bl_out.add(bl_in.remove(buss));
		}

	}
	public void inPark(int bn) {
		Buss buss = null;
		buss = bl_out.find(bn);
		
		if (buss != null) {
						
			bl_in.add(bl_out.remove(buss));
		}

	}
	public BussGUI2() {
		mainFrm.setSize(200, 400);
		
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
		
		txtin.setBorder(new TitledBorder("Busses in park"));
		pnl1.add(txtin);
		txtout.setBorder(new TitledBorder("Busses out park"));
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
				int bn = 0;
				if(bl_in.getFirst()!=null) bn=bl_in.getFirst().bussNumber;
        		fromPark(bn);
        		
        		showInParkList();
        		showOutParkList();
			}
		});	
		btnInPark.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int bn = 0;
				if(bl_out.getFirst()!=null) bn=bl_out.getFirst().bussNumber;
				inPark(bn);
        		
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
    
    String display(LinkList bl){
    	String str="";
		Buss current = bl.first;

		while(current != null){
			 
		     str = str + current.getName()+"\n";	
		     current = current.next;
		}
    	return str;
    }
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new BussGUI2();
			}
		});
	}
}
