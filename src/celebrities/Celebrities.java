package celebrities;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Main class
 */
public class Celebrities {
	Celebrities(){
		
	}
	
	/**
	 * Function to add guests to the main list
	 * @param number : number of the guest
	 * @param name : name of the guest
	 * @param listKnown : list of the known guests
	 * @param listGuests : list of all guests
	 * @return listGuests
	 */
	public static HashMap<Integer, HashMap<String, ArrayList<Integer>>> addGuest(int number, String name, ArrayList<Integer> listKnown, HashMap<Integer, HashMap<String, ArrayList<Integer>>> listGuests){
		HashMap<String, ArrayList<Integer>> guest = new HashMap<String, ArrayList<Integer>>();
		// Copy arraylist of known guests to avoid the reference problem
		ArrayList<Integer> copyGuests = new ArrayList<>(listKnown);
		guest.put(name, copyGuests);
		listGuests.put(number, guest);
		return listGuests;
	}

	/**
	 * Function to add known guests to a particular guest
	 * @param personNumber : number of the guest to be added in the list of known guests
	 * @param listToAdd : list of known guests
	 * @return listToAdd
	 */
	public static ArrayList<Integer> addList(int personNumber, ArrayList<Integer> listToAdd){
		listToAdd.add(personNumber);
		return listToAdd;
	}

	/**
	 * Main program
	 * @param args : no parameters
	 */
	public static void main(String[] args) {
		HashMap<Integer, HashMap<String, ArrayList<Integer>>> guestsList = new HashMap<Integer, HashMap<String, ArrayList<Integer>>>();
		ArrayList<Integer> celebritiesList = new ArrayList<Integer>();
		ArrayList<Integer> anybodyList = new ArrayList<Integer>();
		ArrayList<Integer> knownGuests = new ArrayList<Integer>();
		boolean celebFound = true;

		// Adding guests to the main list 
		// 1. Albert [2, 5, 6]
		// 2. Bénédicte [3, 5, 6]
		// 3. Christophe [2, 4, 5, 6]
		// 4. Delphine [1, 2, 5, 6, 8]
		// 5. Edouard [6]
		// 6. Françoise [5]
		// 7. Gaston [2, 3, 5, 6, 8]
		// 8. Heloïse [2, 4, 5, 6, 7]
		knownGuests.add(2);
		knownGuests.add(5);
		knownGuests.add(6);
		guestsList = addGuest(1, "Albert", knownGuests ,  guestsList);
		anybodyList.add(1);
		knownGuests.removeAll(knownGuests);
		knownGuests.add(3);
		knownGuests.add(5);
		knownGuests.add(6);
		guestsList = addGuest(2, "Bénédicte", knownGuests, guestsList);
		anybodyList.add(2);
		knownGuests.removeAll(knownGuests);
		knownGuests.add(2);
		knownGuests.add(4);
		knownGuests.add(5);
		knownGuests.add(6);
		guestsList = addGuest(3, "Christophe", knownGuests, guestsList);
		anybodyList.add(3);
		knownGuests.removeAll(knownGuests);
		knownGuests.add(1);
		knownGuests.add(2);
		knownGuests.add(5);
		knownGuests.add(6);
		knownGuests.add(8);
		guestsList = addGuest(4, "Delphine", knownGuests, guestsList);
		anybodyList.add(4);
		knownGuests.removeAll(knownGuests);
		knownGuests.add(6);
		guestsList = addGuest(5, "Edouard", knownGuests, guestsList);
		anybodyList.add(5);
		knownGuests.removeAll(knownGuests);
		knownGuests.add(5);
		guestsList = addGuest(6, "Françoise", knownGuests, guestsList);
		anybodyList.add(6);
		knownGuests.removeAll(knownGuests);
		knownGuests.add(2);
		knownGuests.add(3);
		knownGuests.add(5);
		knownGuests.add(6);
		knownGuests.add(8);
		guestsList = addGuest(7, "Gaston", knownGuests, guestsList);
		anybodyList.add(7);
		knownGuests.removeAll(knownGuests);
		knownGuests.add(2);
		knownGuests.add(4);
		knownGuests.add(5);
		knownGuests.add(6);
		knownGuests.add(7);
		guestsList = addGuest(8, "Heloïse", knownGuests, guestsList);
		anybodyList.add(8);

		// Search for celebrities
		for(int i = 0; i < anybodyList.size(); i++) {
			celebFound = true;
			for(Integer guest : guestsList.keySet()) {
				if(guest != anybodyList.get(i)){
					for(String name : guestsList.get(guest).keySet()) {
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

		// Find "false" celebrities
		int numCeleb = 0;
		HashMap<String, ArrayList<Integer>> listCeleb;
		for(int i = 0; i < celebritiesList.size(); i++) { 
			celebFound = true; 
			numCeleb = celebritiesList.get(i);
			listCeleb = guestsList.get(numCeleb);
			for(String guestCeleb : listCeleb.keySet()) {
				System.out.println(guestCeleb);
				for(int j = 0; j < guestsList.get(numCeleb).get(guestCeleb).size(); j++) {
					if(anybodyList.contains(guestsList.get(numCeleb).get(guestCeleb).get(j))) {
						celebFound = false;
						break;
					}
				}
			}
			if(!celebFound) {
				anybodyList.add(numCeleb);
			}
		}

		// Remove false celebrities from celebrities list
		for(int i = 0 ; i < anybodyList.size(); i++) {
			if(celebritiesList.contains(anybodyList.get(i))) {
				celebritiesList.remove(celebritiesList.indexOf(anybodyList.get(i)));
			}	
		}

		// Display lists
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