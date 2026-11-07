package kol1.zad03;
import java.util.*;
import java.util.stream.Collectors;

public class Folder implements IFile{

    private String name;
    private long size;
    List<IFile> files;


    public Folder(String name) {
        this.name = name;
        this.size = 0;
        this.files = new ArrayList<>();
    }

    void addFile (IFile file) throws FileNameExistsException {
        if (file == null)
            throw new IllegalArgumentException();

        if (files.stream().anyMatch(f -> f.getFileName().equals(file.getFileName())))
            throw new FileNameExistsException(file.getFileName(),this.getFileName());

        files.add(file);
    }

    @Override
    public String getFileName() {
        return name;
    }

    @Override
    public long getFileSize() {
        return files.stream().mapToLong(IFile::getFileSize).sum();
    }

    @Override
    public String getFileInfo(String tab) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("%sFolder name: %10s Folder size: %10d\n",tab,getFileName(),getFileSize()));

        for (IFile file : files)
            stringBuilder.append(file.getFileInfo(tab + "    "));

        return stringBuilder.toString();
    }

    @Override
    public void sortBySize() {
        files = files.stream().sorted(Comparator.comparingLong(IFile::getFileSize)).collect(Collectors.toList());

        for (IFile file : files)
            file.sortBySize();
    }

    @Override
    public long findLargestFile() {
        return files.stream().mapToLong(IFile::findLargestFile).max().orElse(0L);
    }
}
