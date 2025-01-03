package com.mat.now.showMessagetwoUser;

public class ShowMessagetwoUser {

    private String user1Id;
    private String user2Id;
    private double compatibilityScore;

    
    public ShowMessagetwoUser(String user1Id, String user2Id, double compatibilityScore) {
        this.user1Id = user1Id;
        this.user2Id = user2Id;
        this.compatibilityScore = compatibilityScore;
        
        
    }
    
    public ShowMessagetwoUser() {
        
    }


	public String getUser1Id() {
		return user1Id;
	}


	public void setUser1Id(String user1Id) {
		this.user1Id = user1Id;
	}


	public String getUser2Id() {
		return user2Id;
	}


	public void setUser2Id(String user2Id) {
		this.user2Id = user2Id;
	}


	public double getCompatibilityScore() {
		return compatibilityScore;
	}


	public void setCompatibilityScore(double compatibilityScore) {
		this.compatibilityScore = compatibilityScore;
	}
}
