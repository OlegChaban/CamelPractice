package com.nixsolutions.chaban.camel.beans;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chaban on 22.05.15.
 */
@XmlRootElement(name = "directory")
@XmlAccessorType(XmlAccessType.FIELD)
public class Folders {

    public Folders() {
    }

    @XmlAttribute
    private String name;
    @XmlElement(name = "folder")
    private List<Folders> folders = new ArrayList<Folders>();
    @XmlElement(name = "file")
    private List<Files> files = new ArrayList<Files>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Folders> getFolders() {
        return folders;
    }

    public void setFolders(ArrayList<Folders> folders) {
        this.folders = folders;
    }

    public List<Files> getFiles() {
        return files;
    }

    public void setFiles(ArrayList<Files> files) {
        this.files = files;
    }

    public void addFile(Files file) {
        files.add(file);
    }

    public void addDirectory(Folders folder) {
        folders.add(folder);
    }
}
