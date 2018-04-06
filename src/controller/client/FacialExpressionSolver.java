package controller.client;

import network.model.Status;

/**
 * Computes the Expressions data and choose face expression according to it
 * @author raam
 *
 */
public class FacialExpressionSolver {
	
	/**
	 * Types of Lower Face Expressions
	 * @author raam
	 *
	 */
	public enum LowerFace {
		SMILE("smile"),
		CLENCH("clench"),
		SMIRK_LEFT("smirk_left"),
		SMIRK_RIGHT("smirk_right"),
		LAUGH("laugh"),
		NORMAL("normal_lower");
		
		private String fileName;
		
		LowerFace(String fileName) {
			this.fileName = fileName; 
		}
		
		public String getFileName() {
			return fileName;
		}
	}
	
	/**
	 * Types of Upper Face Expressions
	 * @author raam
	 *
	 */
	public enum UpperFace {
		RAISE_BROW("raise_brow"),
		FURROW_BROW("furrow_brow"),
		WINK_LEFT("wink_left"),
		WINK_RIGHT("wink_right"),
		LOOK_LEFT("look_left"),
		LOOK_RIGHT("look_right"),
		BLINK("blink"),
		NORMAL("normal_upper");
		
		private String fileName;
		
		UpperFace(String fileName) {
			this.fileName = fileName; 
		}
		
		public String getFileName() {
			return fileName;
		}
	}
	
	/**
	 * Computes the lower face expression based on the data sent
	 * 
	 * @param status - data sent from the server
	 * @return the lower face expression
	 */
	public static LowerFace computeLowerFace(Status status) {
		if (status.getSmile() > 0.5) {
			return LowerFace.SMILE;
		} else if (status.getClench() > 0.5) {
			return LowerFace.CLENCH;
		} else if (status.getSmile() > 0) { //TODO
			return LowerFace.SMIRK_LEFT;
		} else if (status.getSmile() > 0) { //TODO
			return LowerFace.SMIRK_RIGHT;
		} else if (status.getSmile() > 0) { //TODO
			return LowerFace.LAUGH;
		}
		return LowerFace.NORMAL;
	}
	
	/**
	 * Computes the upper face expression based on the data sent 
	 * 
	 * @param status - data sent from the server
	 * @return the upper face expression
	 */
	public static UpperFace computeUpperrFace(Status status) {
		if (status.getEyebrowRaise() > 0) {
			return UpperFace.RAISE_BROW;
		} else if (status.getEyebrowRaise() > 0) { //TODO
			return UpperFace.FURROW_BROW;
		} else if (status.getLeftWink() > 0) {
			return UpperFace.WINK_LEFT;
		} else if (status.getRightWink() > 0) {
			return UpperFace.WINK_RIGHT;
		} else if (status.getLookingLeft() > 0) {
			return UpperFace.LOOK_LEFT;
		} else if (status.getLookingRight() > 0) {
			return UpperFace.LOOK_RIGHT;
		} else if (status.getBlink() > 0) {
			return UpperFace.BLINK;
		}
		return UpperFace.NORMAL;
	}
	
	
}
