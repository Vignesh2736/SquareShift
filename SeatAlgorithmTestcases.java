import static org.junit.jupiter.api.Assertions.*;
import org.junit.*;
import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

class SeatAlgorithmTestcases {

	@Before
	public void setUp() {
		
	}
	
	@After
	public void tearDown() {
		
	}
	@Test
	void test() {
		seatbooking st = new seatbooking();
		
		seatbooking.blk[0] = new Block(2, 3);
		seatbooking.blk[0] = seatbooking.blk[0].createSeats();
		
		seatbooking.blk[1] = new Block(3, 4);
		seatbooking.blk[1] = seatbooking.blk[1].createSeats();
		
		seatbooking.blk[2] = new Block(3, 2);
		seatbooking.blk[2] = seatbooking.blk[2].createSeats();
		
		seatbooking.blk[3] = new Block(4, 3);
		seatbooking.blk[3] = seatbooking.blk[3].createSeats();
		
		for(int i=0;i<seatbooking.blk.length;i++) {
			if(i>0 && i<seatbooking.blk.length-1) {
				seatbooking.blk[i].namingSeats(seatbooking.blk[i], "");
			}
			if(i==0) {
				seatbooking.blk[i].namingSeats(seatbooking.blk[i], "left");
			}
			
			if(i==seatbooking.blk.length-1) {
				seatbooking.blk[i].namingSeats(seatbooking.blk[i], "right");
			}
			
			seatbooking.noOfAisleSeats += seatbooking.blk[i].noSeatsInBlock(seatbooking.blk[i],"A");
			seatbooking.noOfCenterSeats += seatbooking.blk[i].noSeatsInBlock(seatbooking.blk[i],"M");
			seatbooking.noOfWindowSeats += seatbooking.blk[i].noSeatsInBlock(seatbooking.blk[i],"W");
		}
		
		
		int book = 30;
		
		seatbooking.numberingSeats(book,"A");
		seatbooking.numberingSeats(book,"W");
		seatbooking.numberingSeats(book,"M");
		
		String result = "";
		for(int i=0;i<seatbooking.blk.length;i++) 
			result+=seatbooking.blk[i].toString();
		
		assertAll(result);
//		fail("Not yet implemented");
	}

}
