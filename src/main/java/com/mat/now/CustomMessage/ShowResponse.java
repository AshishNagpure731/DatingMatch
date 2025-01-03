package com.mat.now.CustomMessage;

import java.util.List;

public class ShowResponse {
	private String userId;
    private String name;
    private double compatibilityScore;
    private List<String> commonInterests;
    private List<String> commonHobbies;

    // Constructors, Getters, and Setters
    public ShowResponse(String userId, String name, double compatibilityScore, List<String> commonInterests, List<String> commonHobbies) {
        this.userId = userId;
        this.name = name;
        this.compatibilityScore = compatibilityScore;
        this.commonInterests = commonInterests;
        this.commonHobbies = commonHobbies;
    }

    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCompatibilityScore() {
        return compatibilityScore;
    }

    public void setCompatibilityScore(double compatibilityScore) {
        this.compatibilityScore = compatibilityScore;
    }

    public List<String> getCommonInterests() {
        return commonInterests;
    }

    public void setCommonInterests(List<String> commonInterests) {
        this.commonInterests = commonInterests;
    }

    public List<String> getCommonHobbies() {
        return commonHobbies;
    }

    public void setCommonHobbies(List<String> commonHobbies) {
        this.commonHobbies = commonHobbies;
    }

}
