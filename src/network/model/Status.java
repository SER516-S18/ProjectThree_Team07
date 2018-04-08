package network.model;

/**
 * The singleton implementation of the server status
 *
 */
public class Status {

    // expressive values
    private boolean lookingRight;
    private boolean eyebrowRaise;
    private boolean lookingLeft;
    private boolean lookingDown;
    private boolean lookingUp;
    private boolean rightWink;
    private boolean leftWink;
    private boolean blink;
    private boolean eyebrowFurrow;

    private double eyesOpen;
    private double smile;
    private double clench;
    private double smirkLeft;
    private double smirkRight;
    private double laugh;

    // affective values
    private double mediation;
    private double engagementBoredom;
    private double excitementShortTerm;
    private double frustration;
    private double excitementLongTerm;
    
    // eye activate status
    private boolean isEyeActivated;

    private static Status statusInstance = null;

    private Status() {}

    public static Status getInstance() {
        if (statusInstance == null) {
            statusInstance = new Status();
        }
        return statusInstance;
    }

    public double getLaugh() {
        return laugh;
    }

    public void setLaugh(double laugh) {
        this.laugh = laugh;
    }

    public boolean isEyebrowFurrow() {
        return eyebrowFurrow;
    }

    public void setEyebrowFurrow(boolean eyebrowFurrow) {
        this.eyebrowFurrow = eyebrowFurrow;
    }

    public double getSmirkLeft() {
        return smirkLeft;
    }

    public void setSmirkLeft(double smirkLeft) {
        this.smirkLeft = smirkLeft;
    }

    public double getSmirkRight() {
        return smirkRight;
    }

    public void setSmirkRight(double smirkRight) {
        this.smirkRight = smirkRight;
    }

    public boolean getEyebrowRaise() {
        return eyebrowRaise;
    }

    public void setEyebrowRaise(boolean eyebrowRaise) {
        this.eyebrowRaise = eyebrowRaise;
    }

    public boolean getLookingLeft() {
        return lookingLeft;
    }

    public void setLookingLeft(boolean lookingLeft) {
        this.lookingLeft = lookingLeft;
    }

    public boolean getLookingDown() {
        return lookingDown;
    }

    public void setLookingDown(boolean lookingDown) {
        this.lookingDown = lookingDown;
    }

    public boolean getLookingUp() {
        return lookingUp;
    }

    public void setLookingUp(boolean lookingUp) {
        this.lookingUp = lookingUp;
    }

    public boolean getRightWink() {
        return rightWink;
    }

    public void setRightWink(boolean rightWink) {
        this.rightWink = rightWink;
    }

    public boolean getLeftWink() {
        return leftWink;
    }

    public void setLeftWink(boolean leftWink) {
        this.leftWink = leftWink;
    }

    public boolean getBlink() {
        return blink;
    }

    public void setBlink(boolean blink) {
        this.blink = blink;
    }

    public double getEyesOpen() {
        return eyesOpen;
    }

    public void setEyesOpen(double eyesOpen) {
        this.eyesOpen = eyesOpen;
    }

    public double getSmile() {
        return smile;
    }

    public void setSmile(double smile) {
        this.smile = smile;
    }

    public double getClench() {
        return clench;
    }

    public void setClench(double clench) {
        this.clench = clench;
    }

    public double getEngagementBoredom() {
        return engagementBoredom;
    }

    public void setEngagementBoredom(double engagementBoredom) {
        this.engagementBoredom = engagementBoredom;
    }

    public double getExcitementShortTerm() {
        return excitementShortTerm;
    }

    public void setExcitementShortTerm(double excitementShortTerm) {
        this.excitementShortTerm = excitementShortTerm;
    }

    public double getFrustration() {
        return frustration;
    }

    public void setFrustration(double frustration) {
        this.frustration = frustration;
    }

    public double getExcitementLongTerm() {
        return excitementLongTerm;
    }

    public void setExcitementLongTerm(double excitementLongTerm) {
        this.excitementLongTerm = excitementLongTerm;
    }

    public boolean getLookingRight() {
        return lookingRight;
    }

    public void setLookingRight(boolean lookingRight) {
        this.lookingRight = lookingRight;
    }

    public double getMediation() {
        return mediation;
    }

    public void setMediation(double mediation) {
        this.mediation = mediation;
    }

	public boolean isEyeActivated() {
		return isEyeActivated;
	}

	public void setActivatedEye(boolean isEyeActivated) {
		this.isEyeActivated = isEyeActivated;
	}
}
