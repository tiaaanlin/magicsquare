import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controller implements ActionListener{
	private Model model;
	private View view;
	
	public Controller(Model model,View view) {
		this.model = model;
		this.view = view;
		//this.view.addButtonActionListener(new ButtonActionListener());
		
		//this.model = new Model();
		//this.model.setRow(this.view.getRow());
		//this.model.createModel();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String[] coordinates = e.getActionCommand().split(" ");
		int i = view.inputNum();
		model.setNum(Integer.parseInt(coordinates[0]),Integer.parseInt(coordinates[1]),i);
	}

	/*private class ButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			for(int i = 0;i<view.getRow();i++) {
				for(int j =0;j<view.getRow();j++) {
					if(e.getSource()== view.getButton()[i][j]) {
						int input =view.inputNum(); 
						String s = Integer.toString(input);
						if(input<1 || input > (view.getRow()*view.getRow()))
						{view.popInvalidInput();}
						else {
							model.setNum(i, j, input);
							view.getButton()[i][j].setText(s);
						}
						if(model.isFull()) {
							if(model.checkwin())
						        { view.popWin();
								  System.exit(0);	}
							else
								{view.popLose();
								 model.empty();
								 view.popQuestion();
								 }
							
							
						}
					}
					
					
				}
				
			}
			
		}
		
	}*/
	
}
