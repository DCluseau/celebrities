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
		
		for(int key : guestsList.keySet()) {
			for(String knownIn : guestsList.get(key).keySet()) {
				if(!guestsList.get(key).get(knownIn).contains(key)) {
					anybodyList.add(key);
					if(celebritiesList.contains(key)) {
						celebritiesList.remove(key);
					}
				}else if(guestsList.get(key).get(knownIn).contains(key) && !anybodyList.contains(key)) {
					celebritiesList.add(key);
				}
			}
		}
		System.out.println("Normal guests list : ");
		for(int i = 0 ; i < anybodyList.size() ; i++) {
			System.out.println(guestsList.get(anybodyList.get(i)));
		}
		System.out.println("Celebrities list : ");
		for(int i = 0 ; i < celebritiesList.size() ; i++) {
			System.out.println(guestsList.get(celebritiesList.get(i)));
		}
		//for(int i = 0; i < guestsList.size(); i++) {
			/*
			 * for(int j = 0 ; j < guestsList.size() ; j++) {
			 * if(guestsList.get(i).containsKey(guestsList.get(j))) {
			 * if(celebritiesList.contains(guestsList.get(j))) {
			 * celebritiesList.remove(guestsList.get(j)); anybodyList.add(guestsList.get(j))
			 * } } }
			 */
		//}
	}

}
