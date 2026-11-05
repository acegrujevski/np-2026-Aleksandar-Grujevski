package kol1.zad3;

public class File implements IFile {
    private String name;
    private long size;

    public File(String name, long size) {
        this.name = name;
        this.size = size;
    }


    @Override
    public String getFileName() {
        return name;
    }

    @Override
    public long getFileSize() {
        return size;
    }

    @Override
    public String getFileInfo(String tab) {
        return String.format("%sFile name: %10s File size: %10d\n",tab,getFileName(),getFileSize());
    }

    @Override
    public void sortBySize() {

    }

    @Override
    public long findLargestFile() {
        return size;
    }
}
