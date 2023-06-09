

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ChatDataBase {

	public ArrayList<DataBaseUser> getUsers() {
		return users;
	}

	private ArrayList<DataBaseUser> users = new ArrayList<>(10);
	
	public ChatDataBase() {
		openData();
	}
	
	private void openData() {
		try {
			File file = new File("Data.png");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = reader.readLine()) != null){
				String name = line;
				line = reader.readLine();
				String addres = line;
				users.add(new DataBaseUser(addres, name));			
			}
			reader.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void saveData(){
		try{
		BufferedWriter writer = new BufferedWriter(new FileWriter("Data.txt"));
		writer.close();
		
		}catch(IOException ex){
			System.out.println("File not found");
			ex.printStackTrace();
		}
	}
	
	public DataBaseUser getUser(String findName) {
		for (DataBaseUser user: users){
			if (findName.equals(user.getName())){
				return user;
			}
		}
	}
}
