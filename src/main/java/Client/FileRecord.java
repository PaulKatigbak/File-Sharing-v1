package Client;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.File;

//This class is to initialize the files
public class FileRecord {
    //Variables
    private StringProperty filename;
    private File file;

    //Constructor
    public FileRecord(File file){
        this.file = file;
        this.filename = new SimpleStringProperty(file.getName().toString());

    }

    //Setters and Getters
    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFilename() {
        return filename.get();
    }

    public StringProperty filenameProperty() {
        return filename;
    }
}
