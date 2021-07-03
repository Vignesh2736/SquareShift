import java.util.Scanner;

class Seat{
	public int seatNo;
	public boolean booked;
	public String position;
	public Seat() {
		
	}
	public Seat(int seatNo) {
		super();
		this.seatNo = seatNo;
		this.booked = false;
		this.position = "";
	}
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	public boolean getBooked() {
		return booked;
	}
	public void setBooked(boolean booked) {
		this.booked = booked;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	
}


class Block{
	public int rows;
	public int columns;
	public Seat seats[][];
	
	public Block() {
		
	}
	
	public Block(int rows,int columns) {
		this.rows=rows;
		this.columns=columns;
		
		seats=new Seat[rows][columns];
	}
	
	public int noSeatsInBlock(Block blk, String type) {
		int count=0;
		for(int i=0;i<blk.rows;i++)
			for(int j=0;j<blk.columns;j++) {
				if(blk.seats[i][j].getPosition()==type) {
					count++;
				}
			}
				
		return count;
	}
	
	public Block createSeats() {
		for(int i=0;i<this.rows;i++)
			for(int j=0;j<this.columns;j++)
				seats[i][j] = new Seat();
		
		return this;
	}
	
	public void namingSeats(Block blk,String edge) {
		for(int i=0;i<blk.rows;i++) {
			for(int j=1;j<blk.columns-1;j++) {
				seats[i][j].setPosition("M");
			}
		}
		for(int i=0;i<blk.rows;i++){
			seats[i][0].setPosition("A");
			seats[i][blk.columns-1].setPosition("A");
		}
	
		if(edge == "left") {
			for (int i = 0; i < blk.rows; i++) {
				seats[i][0].setPosition("W");
			}
		}
		
		if(edge == "right") {
			for (int i = 0; i < blk.rows; i++) {
				seats[i][blk.columns- 1].setPosition("W");
			}
		}	
	}
	
	@Override
	public String toString() {
		String result = "";
		for(int i=0;i<this.rows;i++) {
			for(int j=0;j<this.columns;j++) {
				result+=this.seats[i][j].getPosition()+" "+this.seats[i][j].getSeatNo()+" ";
			}
			result+="\n";
		}
			
		return result;
	}
}

public class seatbooking {
	public static int count = 1 ;
	public static Block blk[] = new Block[4];
	
	public static int noOfAisleSeats = 0;
	public static int noOfWindowSeats = 0;
	public static int noOfCenterSeats = 0;
		

	public static void numberingSeats(int book,String type) {
		for(int i = 0; i<blk.length; i++) {
			for(int j=0;j<blk[i].rows;j++){
				if(blk[i].seats[i] == null) 
					continue;
				for(int k=0;k<blk[i].columns;k++) {
					if(book>count) {
				        if(blk[i].seats[j][k]!=null && (!blk[i].seats[j][k].getBooked()) && (blk[i].seats[j][k].getPosition()==type)){
				        	blk[i].seats[j][k].setSeatNo(count);
				        	count++;
				        	blk[i].seats[j][k].setBooked(true);
				        }
					}
				}
			}
		}
//		blk[lastUpdatedBlock].seats[lastUpdatedRow][lastUpdatedColumn].setSeatNo(count);
//    	count++;
//    	blk[lastUpdatedBlock].seats[lastUpdatedRow][lastUpdatedColumn].setBooked(true);
		
	}
	@SuppressWarnings("resource")
	public static void main(String args[]) {
		try {
			Scanner in = new Scanner(System.in);
			for(int i=0;i<blk.length;i++) {
				System.out.println("Enter Block " + (i + 1) + " row count");
				int row = in.nextInt();
			
				System.out.println("Enter Block " + (i + 1) + " column count");
				int col = in.nextInt();

				blk[i] = new Block(row, col);
				blk[i] = blk[i].createSeats();
			}
			
			for(int i=0;i<blk.length;i++) {
				if(i>0 && i<blk.length-1) {
					blk[i].namingSeats(blk[i], "");
				}
				if(i==0) {
					blk[i].namingSeats(blk[i], "left");
				}
				
				if(i==blk.length-1) {
					blk[i].namingSeats(blk[i], "right");
				}
				
				noOfAisleSeats += blk[i].noSeatsInBlock(blk[i],"A");
				noOfCenterSeats += blk[i].noSeatsInBlock(blk[i],"M");
				noOfWindowSeats += blk[i].noSeatsInBlock(blk[i],"W");
			}
			
			for(int i=0;i<blk.length;i++) 
				System.out.println (blk[i].toString());
			
			System.out.println("Enter no.of seats to be book : ");
			int book = in.nextInt();
			
			numberingSeats(book,"A");
			numberingSeats(book,"W");
			numberingSeats(book,"M");
			
			for(int i=0;i<blk.length;i++) 
				System.out.print(blk[i].toString());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
