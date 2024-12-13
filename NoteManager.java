package com.noteapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NoteManager {
    private final FileHandler fileHandler;

    public NoteManager(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
    }

    /**
     * Create a new note.
     *
     * @param title   The title of the note.
     * @param content The content of the note.
     * @return True if the note was created successfully, false if the title already exists.
     */
    public boolean createNote(String title, String content) {
        if (fileHandler.getAllNotes().containsKey(title)) {
            return false; // Note with the same title already exists
        }
        fileHandler.saveNote(title, content);
        return true;
    }

    /**
     * Edit an existing note.
     *
     * @param title   The title of the note to edit.
     * @param content The new content for the note.
     */
    public void editNote(String title, String content) {
        fileHandler.saveNote(title, content);
    }

    /**
     * Delete a note by its title.
     *
     * @param title The title of the note to delete.
     */
    public void deleteNote(String title) {
        fileHandler.deleteNote(title);
    }

    /**
     * Get the content of a note by its title.
     *
     * @param title The title of the note.
     * @return The content of the note, or null if the note does not exist.
     */
    public String getNoteContent(String title) {
        return fileHandler.getNote(title);
    }

    /**
     * Search for notes containing a specific keyword in the title or content.
     *
     * @param keyword The keyword to search for.
     * @return A list of matching note titles.
     */
    public List<String> searchNotes(String keyword) {
        Map<String, String> notes = fileHandler.getAllNotes();
        List<String> matchingNotes = new ArrayList<>();

        for (Map.Entry<String, String> entry : notes.entrySet()) {
            if (entry.getKey().toLowerCase().contains(keyword.toLowerCase()) ||
                    entry.getValue().toLowerCase().contains(keyword.toLowerCase())) {
                matchingNotes.add(entry.getKey());
            }
        }
        return matchingNotes;
    }
}
