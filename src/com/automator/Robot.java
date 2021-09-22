package com.automator;

import org.sikuli.script.Pattern;

public class Robot {
    protected Pattern GetResource(String name){
        return new Pattern(this.getClass().getResource(name+".png"));
    }
    // protected final Pattern pendingTray=new Pattern(this.getClass().getResource("pendingTray.png"));
    // protected final Pattern openButton=new Pattern(this.getClass().getResource("open.PNG"));
    // protected final Pattern openShipment=new Pattern(this.getClass().getResource("openShipment.PNG"));
    // protected final Pattern openShipmentOk=new Pattern(this.getClass().getResource("openShipmentOk.PNG"));
    // protected final Pattern voyage=new Pattern(this.getClass().getResource("activeBL.PNG"));
    // protected final Pattern issueButton=new Pattern(this.getClass().getResource("issue.PNG"));
    // protected final Pattern issueOk=new Pattern(this.getClass().getResource("issueOk.PNG"));
    // protected final Pattern issueDone=new Pattern(this.getClass().getResource("issueDone.PNG"));
    // protected final Pattern issueOpened=new Pattern(this.getClass().getResource("4.PNG"));
    protected final Pattern pendingTray=new Pattern(this.getClass().getResource("pendingTray.png"));//GetResource("pendingTray");
    protected final Pattern openOk=new Pattern(this.getClass().getResource("ok.png"));//("ok");
    protected final Pattern validationFailed=new Pattern(this.getClass().getResource("validationFailed.png"));
    protected final Pattern invalidOk=new Pattern(this.getClass().getResource("invalidOk.png"));
    protected final Pattern cancel=new Pattern(this.getClass().getResource("cancel.png"));
    protected final Pattern issue=new Pattern(this.getClass().getResource("issue.PNG"));
    protected final Pattern issueOk=new Pattern(this.getClass().getResource("invalidOk.png"));
    protected final Pattern file=new Pattern(this.getClass().getResource("file.PNG"));
    protected final Pattern close=new Pattern(this.getClass().getResource("close.png"));
    
}
