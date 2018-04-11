package network.model;

/** The singleton implementation of the server status Team 7
 * Getter and Setters for Status Object
 * */
public class Status {

  // expressive values
  private boolean lookingRight;
  private boolean lookingLeft;
  private boolean lookingDown;
  private boolean lookingUp;
  private boolean rightWink;
  private boolean leftWink;
  private boolean blink;

  private double eyebrowRaise;
  private double eyebrowFurrow;
  private double eyesOpen;
  private double smile;
  private double clench;
  private double smirkLeft;
  private double smirkRight;
  private double laugh;

  // emotional values
  private double interest;
  private double engagement;
  private double stress;
  private double relaxation;
  private double excitement;
  private double focus;

  // affective values
  private double mediation;
  private double engagementBoredom;
  private double excitementShortTerm;
  private double frustration;
  private double excitementLongTerm;

  // eye activate status
  private boolean isEyeActivated;

  private boolean isAutoReset;

  private double timestamp;

  private static Status statusInstance = null;

  private Status() {}

  /**
   * Status singleton instance
   *
   * @return Status statusInstance
   */
  public static Status getInstance() {
    if (statusInstance == null) {
      statusInstance = new Status();
    }
    return statusInstance;
  }

  /**
   * Getter for isAutoReset
   *
   * @return boolean isAutoReset
   */
  public boolean isAutoReset() {
    return isAutoReset;
  }

  /**
   * Setter for autoReset
   * @param autoReset */
  public void setAutoReset(boolean autoReset) {
    isAutoReset = autoReset;
  }

  /**
   * Getter for timestamp
   * @return timestamp
   */
  public double getTimestamp() {
    return timestamp;
  }

  /**
   * Setter for timestamp
   * @param double timestamp
   */
  public void setTimestamp(double timestamp) {
    this.timestamp = timestamp;
  }

  /**
   * Getter for interest
   * @return double interest
   */
  public double getInterest() {
    return interest;
  }

  /**
   * Setter for interest
   * @param double interest
   */
  public void setInterest(double interest) {
    this.interest = interest;
  }

  /**
   * Getter for engagement
   * @return double engagement
   */
  public double getEngagement() {
    return engagement;
  }

  /**
   * Setter for engagement
   * @param double engagement
   */
  public void setEngagement(double engagement) {
    this.engagement = engagement;
  }

  /**
   * Getter for stress
   * @return double stress
   */
  public double getStress() {
    return stress;
  }

  /**
   * Setter for stress
   * @param double stress
   */
  public void setStress(double stress) {
    this.stress = stress;
  }

  /**
   * getter for relaxation
   * @return double relaxation
   */
  public double getRelaxation() {
    return relaxation;
  }

  /**
   * Setter for relaxation
   * @param double relaxation
   */
  public void setRelaxation(double relaxation) {
    this.relaxation = relaxation;
  }

  /**
   * Getter for excitement
   * @return double excitement
   */
  public double getExcitement() {
    return excitement;
  }

  /**
   * Setter for excitement
   * @param double excitement
   */
  public void setExcitement(double excitement) {
    this.excitement = excitement;
  }

  /**
   * Getter for focus
   * @return double focus
   */
  public double getFocus() {
    return focus;
  }

  /**
   * Setter for focus
   * @param double focus
   */
  public void setFocus(double focus) {
    this.focus = focus;
  }

  /**
   * Getter for laugh
   * @return double laugh
   */
  public double getLaugh() {
    return laugh;
  }

  /**
   * Setter for laugh
   * @param double laugh
   */
  public void setLaugh(double laugh) {
    this.laugh = laugh;
  }

  /**
   * Getter for eyebrowfurrow
   * @return double eyebrowfurrow
   */
  public double getEyebrowFurrow() {
    return eyebrowFurrow;
  }

  /**
   * Setter for eyebrowfurrow
   * @param double eyebrowFurrow
   */
  public void setEyebrowFurrow(double eyebrowFurrow) {
    this.eyebrowFurrow = eyebrowFurrow;
  }

  /**
   * Getter for Smirk left
   * @return double smirk left
   */
  public double getSmirkLeft() {
    return smirkLeft;
  }

  /**
   * Setter for smirk left
   * @param double smirkLeft
   */
  public void setSmirkLeft(double smirkLeft) {
    this.smirkLeft = smirkLeft;
  }

  /**
   * Getter for smirk right
   * @return double smirkRight
   */
  public double getSmirkRight() {
    return smirkRight;
  }

  /**
   * Setter for smirk right
   * @param double smirkRight
   */
  public void setSmirkRight(double smirkRight) {
    this.smirkRight = smirkRight;
  }

  /**
   * Getter for eyebrow raise
   * @return double eyebrowraise
   */
  public double getEyebrowRaise() {
    return eyebrowRaise;
  }

  /**
   * Setter for eyebrowraise
   * @param double eyebrowRaise
   */
  public void setEyebrowRaise(double eyebrowRaise) {
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
