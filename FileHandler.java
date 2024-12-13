// package com.noteapp;

// import java.io.*;
// import java.nio.file.Files;
// import java.nio.file.Paths;
// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;

// import javafx.fxml.FXML;

// public class FileHandler {

//       /**
//      * Updates the password for an existing user.
//      *
//      * @param username the username whose password needs to be updated
//      * @param newPassword the new password
//      * @throws IOException if an I/O error occurs
//      */
//     private static final String USER_FILE = "data/users.dat";
//     private static final String NOTES_FILE = "data/notes.dat";

//     private Map<String, String> users;
//     private Map<String, String> notes;

//     public FileHandler() {
//         users = loadUsers();
//         notes = loadNotes();
//     }

//     // Load users from file
//     private Map<String, String> loadUsers() {
//         try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(USER_FILE))) {
//             return (Map<String, String>) ois.readObject();
//         } catch (IOException | ClassNotFoundException e) {
//             return new HashMap<>(); // Return empty map if file does not exist
//         }
//     }

//     // Save users to file
//     private void saveUsers() {
//         try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USER_FILE))) {
//             oos.writeObject(users);
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }


//     // Save a new user
//     public boolean saveUser(String username, String password) {
//         if (users.containsKey(username)) {
//             return false; // User already exists
//         }
//         users.put(username, password);
//         saveUsers();
//         return true;
//     }

//     // Verify a user's credentials
//     public boolean verifyUser(String username, String password) {
//         return password.equals(users.get(username));
//     }

//     // Load notes from file
//     private Map<String, String> loadNotes() {
//         try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(NOTES_FILE))) {
//             return (Map<String, String>) ois.readObject();
//         } catch (IOException | ClassNotFoundException e) {
//             return new HashMap<>(); // Return empty map if file does not exist
//         }
//     }

//     // Save notes to file
//     private void saveNotes() {
//         try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(NOTES_FILE))) {
//             oos.writeObject(notes);
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }

//     // Save a note
//     public void saveNote(String title, String content) {
//         notes.put(title, content);
//         saveNotes();
//     }

//     // Retrieve a note
//     public String getNote(String title) {
//         return notes.get(title);
//     }

//     // Delete a note
//     public void deleteNote(String title) {
//         notes.remove(title);
//         saveNotes();
//     }

//     // Get all notes
//     public Map<String, String> getAllNotes() {
//         return notes;
//     }

   

//     public boolean doesUserExist(String username) {
       
//         throw new UnsupportedOperationException("Unimplemented method 'doesUserExist'");
//     }

//     public void updateUserPassword(String username, String newPassword) throws IOException {
//         // Read the current user data from the file
//         List<String> userData = Files.readAllLines(Paths.get("users.dat"));
//         List<String> updatedData = new ArrayList<>();

//         for (String line : userData) {
//             String[] parts = line.split(":");
//             String existingUsername = parts[0];
//             String existingPassword = parts[1];

//             if (existingUsername.equals(username)) {
//                 // Update the password for the existing username
//                 updatedData.add(existingUsername + ":" + newPassword);
//             } else {
//                 // Keep the existing data unchanged
//                 updatedData.add(line);
//             }
//         }

//         // Write the updated data back to the file
//         Files.write(Paths.get("users.dat"), updatedData);
//     }
// }

package com.noteapp;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileHandler {
    private static final String USER_FILE = "data/users.dat";
    private static final String NOTES_FILE = "data/notes.dat";

    private Map<String, String> users;
    private Map<String, String> notes;

    public FileHandler() {
        users = loadUsers();
        notes = loadNotes();
    }

    // Load users from file
    private Map<String, String> loadUsers() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(USER_FILE))) {
            return (Map<String, String>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new HashMap<>(); // Return empty map if file does not exist
        }
    }

    // Save users to file
    private void saveUsers() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USER_FILE))) {
            oos.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Save a new user
    public boolean saveUser(String username, String password) {
        if (users.containsKey(username)) {
            return false; // User already exists
        }
        users.put(username, password);
        saveUsers();
        return true;
    }

    // Verify a user's credentials
    public boolean verifyUser(String username, String password) {
        return password.equals(users.get(username));
    }

    // Load notes from file
    private Map<String, String> loadNotes() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(NOTES_FILE))) {
            return (Map<String, String>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new HashMap<>(); // Return empty map if file does not exist
        }
    }

    // Save notes to file
    private void saveNotes() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(NOTES_FILE))) {
            oos.writeObject(notes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Save a note
    public void saveNote(String title, String content) {
        notes.put(title, content);
        saveNotes();
    }

    // Retrieve a note
    public String getNote(String title) {
        return notes.get(title);
    }

    // Delete a note
    public void deleteNote(String title) {
        notes.remove(title);
        saveNotes();
    }

    // Get all notes
    public Map<String, String> getAllNotes() {
        return notes;
    }

    public boolean doesUserExist(String username) {
      
        throw new UnsupportedOperationException("Unimplemented method 'doesUserExist'");
    }
}