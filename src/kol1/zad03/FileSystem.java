package kol1.zad03;

public class FileSystem {

    private Folder rootFolder;

    public FileSystem(){
        rootFolder = new Folder("root");
    }

    void addFile (IFile file) throws FileNameExistsException{
        rootFolder.addFile(file);
    }

    long findLargestFile (){
        return rootFolder.findLargestFile();
    }

    void sortBySize(){
        rootFolder.sortBySize();
    }

    @Override
    public String toString() {
        return rootFolder.getFileInfo("");
    }
}
