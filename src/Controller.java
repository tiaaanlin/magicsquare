import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controller {
	private Model model;
	private View view;
	
	public Controller() {
		this.view = new View();
		this.view.addButtonActionListener(new ButtonActionListener());
		
		this.model = new Model();
		this.model.setRow(this.view.getRow());
		this.model.createModel();
	}
	private class ButtonActionListener implements ActionListener{

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
		
	}
	
}
