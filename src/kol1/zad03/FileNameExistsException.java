package kol1.zad03;

public class FileNameExistsException extends Exception {
    public FileNameExistsException(String name, String folderName) {
        super(String.format("There is already a file named %s in the folder %s",name,folderName));
    }
}
