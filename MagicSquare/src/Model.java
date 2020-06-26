
public class Model {
	
 private int row;
 private Square[][] board;
 private boolean iswin = false;
 private int[] sumrow;
 private int[] sumcol;
 private boolean iswinrow;
 private boolean iswincol;
 private boolean iswinadj;
 private int sumadj1;
 private int sumadj2;
 private boolean isfull= false;
 
 
 
 public void setRow(int num) {
	 this.row = num;
 }
 
 public void createModel() {
	 this.board = new Square[row][row];
	 for (int i=0;i<row;i++) {
		 for(int j=0;j<row;j++) {
			 this.board[i][j] = new Square();
		 }
	 }
 }
 public void setNum(int i,int j,int num){
	 if((num > (row*row)) ||(num < 1))
     System.out.print("Please enter number from 1 to "+ (row*row));
	 else
	 this.board[i][j].setNum(num);
	 
 }
 public boolean checkwin() {
	 sumrow = new int[row];
	 sumcol = new int[row];
	 for(int i=0;i<row;i++) {// i stand for row
		 for(int j=0;j<row;j++) {//j stand for col
			 sumrow[i] += board[i][j].getNum();
			 sumcol[i] += board[j][i].getNum();
		 }
	 }
	 for(int i=0;i<row-1;i++) {
		 if(sumrow[i] != sumrow[i+1])
		 break;
	 iswinrow = true; 
	 }
	 for(int i=0;i<row-1;i++) {
		 if(sumcol[i] != sumcol[i+1])
		 break;
	 iswincol = true; 
	 }
	 for(int i=0;i<row;i++) {
			 sumadj1 += board[i][i].getNum();
			 sumadj2 += board[i][row-1].getNum();
	 }
	 if(sumadj1 == sumadj2) {
		 iswinadj=true;
	 }
	 if(iswincol&&iswinrow&&iswinadj) {
		 if(sumadj1==sumrow[0]) {
			 if(sumadj1== sumcol[0]) {
				 this.iswin = true;
			 } 
		 }
	 }
	 return this.iswin;
		
	 }
 public int getNum(int i, int j) {
	 return this.board[i][j].getNum();
 }
 
 public boolean isFull() {
	 int count = 0;
	 for (int i=0;i<row;i++) {
		 for(int j=0;j<row;j++) {
			 if(this.board[i][j].getNum()!= 0) {
				count ++;
			 }
		 }
	 }
	 if(count == (this.row * this.row)) {
		 this.isfull = true;
	 }
	 else
		 this.isfull = false;
	 
	 return this.isfull;
 }

 public void empty() {
	 this.createModel();
 }
 
 }

