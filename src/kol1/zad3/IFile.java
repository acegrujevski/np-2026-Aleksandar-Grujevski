package kol1.zad3;

public interface IFile {
    public String getFileName();
    public long getFileSize();
    public String getFileInfo(String tab);
    public void sortBySize();
    public long findLargestFile();
}
