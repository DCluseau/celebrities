package celebrities;

import java.util.ArrayList;
import java.util.HashMap;

public class Celebrities {
	public static HashMap<Integer, HashMap<String, ArrayList<Integer>>> addGuest(int number, String name, ArrayList<Integer> listKnown, HashMap<Integer, HashMap<String, ArrayList<Integer>>> listGuests){
		HashMap<String, ArrayList<Integer>> guest = new HashMap<String, ArrayList<Integer>>();
		// Copy arraylist of known guests to avoid the reference problem
		ArrayList<Integer> copyGuests = new ArrayList<>(listKnown);
		guest.put(name, copyGuests);
		listGuests.put(number, guest);
		return listGuests;
	}
	
	public static ArrayList<Integer> addList(int personNumber, ArrayList<Integer> listToAdd){
		listToAdd.add(personNumber);
		return listToAdd;
	}
	
	public static void main(String[] args) {
		HashMap<Integer, HashMap<String, ArrayList<Integer>>> guestsList = new HashMap<Integer, HashMap<String, ArrayList<Integer>>>();
		ArrayList<Integer> celebritiesList = new ArrayList<Integer>();
		ArrayList<Integer> anybodyList = new ArrayList<Integer>();
		ArrayList<Integer> knownGuests = new ArrayList<Integer>();
		boolean celebFound = true;
		knownGuests.add(2);
		knownGuests.add(5);
		knownGuests.add(6);
		guestsList = addGuest(1, "Albert", knownGuests ,  guestsList);
		knownGuests.removeAll(knownGuests);
		knownGuests.add(3);
		knownGuests.add(5);
		knownGuests.add(6);
		guestsList = addGuest(2, "Bénédicte", knownGuests, guestsList);
		knownGuests.removeAll(knownGuests);
		knownGuests.add(2);
		knownGuests.add(4);
		knownGuests.add(5);
		knownGuests.add(6);
		guestsList = addGuest(3, "Christophe", knownGuests, guestsList);
		knownGuests.removeAll(knownGuests);
		knownGuests.add(1);
		knownGuests.add(2);
		knownGuests.add(5);
		knownGuests.add(6);
		knownGuests.add(8);
		guestsList = addGuest(4, "Delphine", knownGuests, guestsList);
		knownGuests.removeAll(knownGuests);
		knownGuests.add(6);
		guestsList = addGuest(5, "Edouard", knownGuests, guestsList);
		knownGuests.removeAll(knownGuests);
		knownGuests.add(5);
		guestsList = addGuest(6, "Françoise", knownGuests, guestsList);
		knownGuests.removeAll(knownGuests);
		knownGuests.add(2);
		knownGuests.add(3);
		knownGuests.add(5);
		knownGuests.add(6);
		knownGuests.add(8);
		guestsList = addGuest(7, "Gaston", knownGuests, guestsList);
		knownGuests.removeAll(knownGuests);
		knownGuests.add(2);
		knownGuests.add(4);
		knownGuests.add(5);
		knownGuests.add(6);
		knownGuests.add(7);
		guestsList = addGuest(8, "Heloïse", knownGuests, guestsList);
		for(int i = 0; i < 8; i++) {
			anybodyList.add(i+1);
		}
		
		for(int i = 0; i < anybodyList.size(); i++) {
			celebFound = true;
			for(Integer guest : guestsList.keySet()) {
				if(guest != anybodyList.get(i)){
					for(String name : guestsList.get(guest).keySet()) {
						System.out.println(guestsList.get(guest).get(name));
						if(!guestsList.get(guest).get(name).contains(anybodyList.get(i))) {
							celebFound = false;
							break;
						}
					}
				}
			}
			if(celebFound) {
				celebritiesList.add(anybodyList.get(i));
			}
		}
		for(int i = 0 ; i < celebritiesList.size(); i++) {
			anybodyList.remove(anybodyList.indexOf(celebritiesList.get(i)));
		}
		System.out.println("Normal guests list : ");
		for(int i = 0 ; i < anybodyList.size() ; i++) {
			System.out.println(guestsList.get(anybodyList.get(i)));
		}
		System.out.println("Celebrities list : ");
		for(int i = 0 ; i < celebritiesList.size() ; i++) {
			System.out.println(guestsList.get(celebritiesList.get(i)));
		}
	}

}
