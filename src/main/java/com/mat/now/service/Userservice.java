package com.mat.now.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mat.now.CustomMessage.ShowResponse;
import com.mat.now.Repository.UserRepository;
import com.mat.now.showMessagetwoUser.ShowMessagetwoUser;
import com.mat.now.userentity.Userentity;

@Service
public class Userservice {
	@Autowired
	private UserRepository userRepository;

	// register the user by this method
	public Userentity registerUser(Userentity userentity) {

		// ------------------------ approch -----------------------
		List<Userentity> userList = userRepository.findAll();

		String newUserId;
		if (userList.isEmpty()) {
			newUserId = "User1"; // Assign User1 if no users exist
		} else {
			Userentity lastUser = userList.get(userList.size() - 1);
			String lastUserId = lastUser.getId();

			// Extract the number from the ID (e.g., "User123")
			try {
				int lastNumber = Integer.parseInt(lastUserId.replace("User", ""));
				newUserId = "User" + (lastNumber + 1);
			} catch (NumberFormatException e) {
				throw new RuntimeException("Invalid user ID format: " + lastUserId);
			}
		}

		userentity.setId(newUserId);

		try {
			return userRepository.save(userentity);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	// The algorithm used in the example above is essentially a Set-Based Matching
	// Algorithm,
	// commonly used in data analysis and search operations. Specifically, it
	// involves operations
	// from Set Theory (Intersection and Union). Here's how it is characterized:

	// matching one user with other user
	public List<ShowResponse> matchOneUserwithOtherUsers(String user) {// (List<Userentity> userentity){
		Optional<Userentity> REqUser = userRepository.findById(user);
		List<Userentity> AllUsers = userRepository.findAll();

		ArrayList<ShowResponse> L1 = new ArrayList<>(); // add users data to show on response.

		if (REqUser.isPresent()) { // if user with id present in db then and only can run
			Userentity getingDataOfREqUser = REqUser.get(); // taking id from db
			for (Userentity Allusers : AllUsers) {
				if ( !getingDataOfREqUser.getGender().equalsIgnoreCase(Allusers.getGender())) {// if gender is equal then
																								// no matching will be
																								// possible.

					if (getingDataOfREqUser.getId() == Allusers.getId()) { // matching requested id with all present id
																			// in
																			// db.
						continue; // if same id present then no matching will be shown.
					} else {
// you have to impleament male female things here keep remember
						double Comp_Score = 0.0;
						if (getingDataOfREqUser.getLocation()!=null && Allusers.getLocation() !=null && getingDataOfREqUser.getLocation().toLowerCase()
								.compareTo(Allusers.getLocation().toLowerCase()) == 0) {
							Comp_Score = Comp_Score + 0.1;
						}
						if (getingDataOfREqUser.getAge()!=null && Allusers.getAge() !=null && getingDataOfREqUser.getAge().compareTo(Allusers.getAge()) == 0) {
							Comp_Score = Comp_Score + 0.1;
						}
						if (getingDataOfREqUser.getIntreseted_in()!=null && Allusers.getIntreseted_in() !=null && getingDataOfREqUser.getIntreseted_in().compareTo(Allusers.getIntreseted_in()) == 0) {
							Comp_Score = Comp_Score + 0.1;
						}

						List<String> Hobbies = new ArrayList<>();
						if (getingDataOfREqUser.getHobbies().size() > 0 && Allusers.getHobbies().size() > 0) {
							HashSet<String> Intersaction = new HashSet<>(getingDataOfREqUser.getHobbies());
							Intersaction.retainAll(Allusers.getHobbies());
							Hobbies.addAll(Intersaction);

							HashSet<String> Union = new HashSet<>(getingDataOfREqUser.getHobbies());
							Union.addAll(Allusers.getHobbies());

							Comp_Score = Comp_Score + ((double) Intersaction.size() / Union.size());
						}
						List<String> Intresets = new ArrayList<>();
						if (getingDataOfREqUser.getInterests().size() > 0 && Allusers.getInterests().size() > 0) {
							HashSet<String> Intersaction = new HashSet<>(getingDataOfREqUser.getInterests());
							Intersaction.retainAll(Allusers.getInterests());
							Intresets.addAll(Intersaction); // store the data to show on response

							HashSet<String> Union = new HashSet<>(getingDataOfREqUser.getInterests());
							Union.addAll(Allusers.getInterests());

							Comp_Score = Comp_Score + ((double) Intersaction.size() / Union.size());
						}

						if (getingDataOfREqUser.getOccupation() !=null && Allusers.getOccupation() !=null && getingDataOfREqUser.getOccupation().compareTo(Allusers.getOccupation()) == 0) {
							Comp_Score = Comp_Score + 0.1;
						}

						if (getingDataOfREqUser.getEductaion_level()!=null && Allusers.getEductaion_level()!=null && getingDataOfREqUser.getEductaion_level().compareTo(Allusers.getEductaion_level()) == 0) {
							Comp_Score = Comp_Score + 0.1;
						}

						List<String> Personality_traits = new ArrayList<>();
						if (getingDataOfREqUser.getPersonality_traits().size() > 0
								&& Allusers.getPersonality_traits().size() > 0) {
							HashSet<String> Intersaction = new HashSet<>(getingDataOfREqUser.getPersonality_traits());
							Intersaction.retainAll(Allusers.getPersonality_traits());
							Personality_traits.addAll(Intersaction);

							HashSet<String> Union = new HashSet<>(getingDataOfREqUser.getPersonality_traits());
							Union.addAll(Allusers.getPersonality_traits());

							Comp_Score = Comp_Score + ((double) Intersaction.size() / Union.size());
						}

						ShowResponse s1 = new ShowResponse(Allusers.getId(), Allusers.getName(), Comp_Score, Intresets,
								Hobbies);
						L1.add(s1);
					}
				}
			}
		}
		return L1;
	}

	// matching two particular users
//	public ShowMessagetwoUser matchTwoUser(String user1, String user2) {
	public HashMap<String,Object> matchTwoUser(String user1, String user2) {
		Optional<Userentity> U1 = userRepository.findById(user1);
		Optional<Userentity> U2 = userRepository.findById(user2);

		HashMap<String,Object> HashResponse = new HashMap<>(); 
		if (U1.isPresent() && U2.isPresent()) { // if user with id present in db then and only can run
			Userentity getingDataOfREqUser = U1.get(); // taking id from db
			Userentity Allusers = U2.get();

			//if (!getingDataOfREqUser.getGender().equalsIgnoreCase(Allusers.getGender())) {// if gender is equal then no
																							// matching will be
																							// possible.

				if (getingDataOfREqUser.getGender().equalsIgnoreCase(Allusers.getGender()) || getingDataOfREqUser.getId().toLowerCase() == Allusers.getId().toLowerCase()) { // matching requested
																									// id with all
					HashResponse.put("Message", "Gender Is Same or Maybe ID is same");																				// present id in db.
					// if same id present then no matching will be shown.
					return HashResponse;
				} else {
					double Comp_Score = 0.0;
					if (getingDataOfREqUser.getLocation().toLowerCase()
							.compareTo(Allusers.getLocation().toLowerCase()) == 0) {
						Comp_Score = Comp_Score + 0.1;
					}
					if (getingDataOfREqUser.getAge().compareTo(Allusers.getAge()) == 0) {
						Comp_Score = Comp_Score + 0.1;
					}
					if (getingDataOfREqUser.getIntreseted_in().compareTo(Allusers.getIntreseted_in()) == 0) {
						Comp_Score = Comp_Score + 0.1;
					}

					List<String> Hobbies = new ArrayList<>();
					if (getingDataOfREqUser.getHobbies().size() > 0 && Allusers.getHobbies().size() > 0) {
						HashSet<String> Intersaction = new HashSet<>(getingDataOfREqUser.getHobbies());
						Intersaction.retainAll(Allusers.getHobbies());
						Hobbies.addAll(Intersaction);

						HashSet<String> Union = new HashSet<>(getingDataOfREqUser.getHobbies());
						Union.addAll(Allusers.getHobbies());

						Comp_Score = Comp_Score + ((double) Intersaction.size() / Union.size());
					}
					List<String> Intresets = new ArrayList<>();
					if (getingDataOfREqUser.getInterests().size() > 0 && Allusers.getInterests().size() > 0) {
						HashSet<String> Intersaction = new HashSet<>(getingDataOfREqUser.getInterests());
						Intersaction.retainAll(Allusers.getInterests());
						Intresets.addAll(Intersaction); // store the data to show on response

						HashSet<String> Union = new HashSet<>(getingDataOfREqUser.getInterests());
						Union.addAll(Allusers.getInterests());

						Comp_Score = Comp_Score + ((double) Intersaction.size() / Union.size());
					}

					if (getingDataOfREqUser.getOccupation().compareTo(Allusers.getOccupation()) == 0) {
						Comp_Score = Comp_Score + 0.1;
					}

					if (getingDataOfREqUser.getEductaion_level().compareTo(Allusers.getEductaion_level()) == 0) {
						Comp_Score = Comp_Score + 0.1;
					}

					List<String> Personality_traits = new ArrayList<>();
					if (getingDataOfREqUser.getPersonality_traits().size() > 0
							&& Allusers.getPersonality_traits().size() > 0) {
						HashSet<String> Intersaction = new HashSet<>(getingDataOfREqUser.getPersonality_traits());
						Intersaction.retainAll(Allusers.getPersonality_traits());
						Personality_traits.addAll(Intersaction);

						HashSet<String> Union = new HashSet<>(getingDataOfREqUser.getPersonality_traits());
						Union.addAll(Allusers.getPersonality_traits());

						Comp_Score = Comp_Score + ((double) Intersaction.size() / Union.size());
					}

//					S1.setUser1Id(user1);
//					S1.setUser2Id(user2);
//					S1.setCompatibilityScore(Comp_Score);
					HashResponse.put("user1_id", user1);
					HashResponse.put("user2_id", user2);
					HashResponse.put("compatibility_score", Comp_Score);
					
				}
				return HashResponse;
			}else {
				HashResponse.put("Message", "Users Not Found");
				return HashResponse;
			}
		//}
//		return S1;
	}
}
