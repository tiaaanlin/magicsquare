import java.awt.Container;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class View extends JFrame implements ModelView{
private int row;
private JButton button[][];
	public View() {



		 Object result = JOptionPane.showInputDialog(this, "Enter the number of row:");
		 String s = (String)result;
		 int i=Integer.parseInt(s); 
		 this.row = i;

		Model model = new Model();
		model.addView(this);
		model.setRow(i);
		model.createModel();
		Controller con = new Controller(model,this);
		 
		 this.button = new JButton[row][row];
		 Container pane = getContentPane();
		 pane.setLayout(new GridLayout(i,i));
		 
		 for(int j=0;j<this.row;j++) {
			 for(int a=0;a<this.row;a++) {
				 this.button[j][a] = new JButton();
				 this.button[j][a].setPreferredSize(new Dimension(100, 100));
				 pane.add(button[j][a]);
				 this.button[j][a].addActionListener(con);
				 this.button[j][a].setActionCommand(j+" "+a);

			 }
			 
		 }
		 
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.pack();
		 this.setVisible(true);
		 
	}
	public void addButtonActionListener(ActionListener e) {
		for(int j=0;j<this.row;j++) {
			 for(int a=0;a<this.row;a++) {
				 this.button[j][a].addActionListener(e);
				
			 }
		 }
	}
	public void popWin() {
		JOptionPane.showMessageDialog(this, "You Win");
	}
	public void popLose() {
		JOptionPane.showMessageDialog(this, "You Lose");
	}
	public void popQuestion() {
		 int r=JOptionPane.showConfirmDialog(this,
				 "Do you want play again? ","Try again?",JOptionPane.YES_NO_OPTION);
		 if(r==JOptionPane.YES_OPTION) {
			 empty();
		 }
		 else {
			 System.exit(0);
		 }
	}	
	public void empty() {
		for(int i=0;i<this.row;i++) {
			for(int j=0;j<this.row;j++) {
				this.button[i][j].setText(null);
			}
		}
	}
	public int inputNum() { 
		
	        Object result = JOptionPane.showInputDialog(this, "Enter your Number:");
	        String s = (String)result;
	        int i=Integer.parseInt(s); 
	        return i;
	}
    public void popInvalidInput() {
    	JOptionPane.showMessageDialog(this, "Please enter the number from 1 to "
        		+ (row*row),"Invalid Input",JOptionPane.ERROR_MESSAGE);	
    }
	public int getRow() {
		return this.row;
	}
	 public JButton[][] getButton() {
	    	return this.button;
	    }
	    
	public void handleUpdate(viewEvent e){
       int i = e.getI();
       int j = e.getJ();
       int num = e.getNum();
       Model m = (Model)e.getSource();
       this.getButton()[i][j].setText(String.valueOf(num));
       if(m.getStatus() == Model.Status.WIN){
		   JOptionPane.showMessageDialog(this, "You Win");
	   }
       else if(m.getStatus() == Model.Status.LOSE){
		   JOptionPane.showMessageDialog(this, "You Lose");
		   popQuestion();

	   }
       else
       	return;


	}
}
