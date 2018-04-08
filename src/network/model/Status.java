package network.model;

public class Status {

    // expressive values
    private double lookingRight;
    private double eyebrowRaise;
    private double lookingLeft;
    private double lookingDown;
    private double lookingUp;
    private double rightWink;
    private double leftWink;
    private double blink;
    private double eyesOpen;
    private double smile;
    private double clench;

    // affective values
    private boolean mediation;
    private boolean engagementBoredom;
    private boolean excitementShortTerm;
    private boolean frustration;
    private boolean excitementLongTerm;
    
    // eye activate status
    private boolean isEyeActivated;

    public double getEyebrowRaise() {
        return eyebrowRaise;
    }

    public void setEyebrowRaise(double eyebrowRaise) {
        this.eyebrowRaise = eyebrowRaise;
    }

    public double getLookingLeft() {
        return lookingLeft;
    }

    public void setLookingLeft(double lookingLeft) {
        this.lookingLeft = lookingLeft;
    }

    public double getLookingDown() {
        return lookingDown;
    }

    public void setLookingDown(double lookingDown) {
        this.lookingDown = lookingDown;
    }

    public double getLookingUp() {
        return lookingUp;
    }

    public void setLookingUp(double lookingUp) {
        this.lookingUp = lookingUp;
    }

    public double getRightWink() {
        return rightWink;
    }

    public void setRightWink(double rightWink) {
        this.rightWink = rightWink;
    }

    public double getLeftWink() {
        return leftWink;
    }

    public void setLeftWink(double leftWink) {
        this.leftWink = leftWink;
    }

    public double getBlink() {
        return blink;
    }

    public void setBlink(double blink) {
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

    public boolean getEngagementBoredom() {
        return engagementBoredom;
    }

    public void setEngagementBoredom(boolean engagementBoredom) {
        this.engagementBoredom = engagementBoredom;
    }

    public boolean getExcitementShortTerm() {
        return excitementShortTerm;
    }

    public void setExcitementShortTerm(boolean excitementShortTerm) {
        this.excitementShortTerm = excitementShortTerm;
    }

    public boolean getFrustration() {
        return frustration;
    }

    public void setFrustration(boolean frustration) {
        this.frustration = frustration;
    }

    public boolean getExcitementLongTerm() {
        return excitementLongTerm;
    }

    public void setExcitementLongTerm(boolean excitementLongTerm) {
        this.excitementLongTerm = excitementLongTerm;
    }

    public double getLookingRight() {
        return lookingRight;
    }

    public void setLookingRight(double lookingRight) {
        this.lookingRight = lookingRight;
    }

    public boolean getMediation() {
        return mediation;
    }

    public void setMediation(boolean mediation) {
        this.mediation = mediation;
    }

	public boolean isAvtivateEye() {
		return isEyeActivated;
	}

	public void setAvtivateEye(boolean isAvtivateEye) {
		this.isEyeActivated = isAvtivateEye;
	}

	
}
