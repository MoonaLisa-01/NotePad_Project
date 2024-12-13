package com.noteapp;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class MainController {
    @FXML
    private ListView<String> notesList;

    @FXML
    private TextArea noteContent;

    private final FileHandler fileHandler = new FileHandler();

    @FXML
    public void initialize() {
        notesList.getItems().addAll(fileHandler.getAllNotes().keySet());
        notesList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                noteContent.setText(fileHandler.getNote(newValue));
            }
        });
    }

    @FXML
    private void createNote() {
        String newNoteTitle = "New Note " + (notesList.getItems().size() + 1);
        notesList.getItems().add(newNoteTitle);
        fileHandler.saveNote(newNoteTitle, "");
    }

    @FXML
    private void saveNotes() {
        String selectedNote = notesList.getSelectionModel().getSelectedItem();
        if (selectedNote != null) {
            fileHandler.saveNote(selectedNote, noteContent.getText());
        }
    }

    @FXML
    private void searchNotes() {
        System.out.println("Search feature not implemented yet.");
    }

    @FXML
    private void changeTheme() {
        System.out.println("Theme change feature not implemented yet.");
    }

    @FXML
    private void exitApp() {
        System.exit(0);
    }
}
