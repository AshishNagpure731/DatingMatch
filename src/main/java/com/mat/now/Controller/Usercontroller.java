package com.mat.now.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mat.now.ApiMessage.ApiMessageBaseEndPoint;
import com.mat.now.CustomMessage.ShowResponse;
import com.mat.now.service.Userservice;
import com.mat.now.showMessagetwoUser.ShowMessagetwoUser;
import com.mat.now.userentity.Userentity;

@RestController
//@RequestMapping("/")
public class Usercontroller {
	@Autowired
	private Userservice userservice;

	@GetMapping("/")
	public ResponseEntity baseEndPoint() {
		ApiMessageBaseEndPoint res = new ApiMessageBaseEndPoint("Welcome to the Dating App Matchmaking API");
		return ResponseEntity.status(200).body(res);
	}

	// to saving the user
	@PostMapping("/api/v1/match/save")
	public ResponseEntity registerUser(Userentity userentity) {
		try {
			Userentity obtData = userservice.registerUser(userentity);
			if (obtData != null) {
				return ResponseEntity.status(200).body(obtData);
			} else {
				return ResponseEntity.status(400).body("User Not saved");
			}
		} catch (Exception e) {
			return ResponseEntity.status(400).body(e.getStackTrace());
		}
	}

	// One user matching with multiple Users
	@PostMapping("/api/v1/match/{user}")
	public ResponseEntity oneUsermatchingWithOther(@PathVariable("user") String user) {
		List<ShowResponse> value = userservice.matchOneUserwithOtherUsers(user);
		if (value == null) {
			return ResponseEntity.status(404).body(user + " Not Found");
		} else {
			return ResponseEntity.status(200).body(value);
		}
	}

	@PostMapping("/api/v1/compatibility/{user1}/{user2}")
	public ResponseEntity MatchingTwoUsers(@PathVariable("user1") String user1, @PathVariable("user2") String user2) {
		HashMap<String,Object> HashResponse  = userservice.matchTwoUser(user1, user2);
		if (HashResponse == null) {
			return ResponseEntity.status(404).body("User Not Found");
		} else {
			return ResponseEntity.status(200).body(HashResponse);
		}
	}
}
