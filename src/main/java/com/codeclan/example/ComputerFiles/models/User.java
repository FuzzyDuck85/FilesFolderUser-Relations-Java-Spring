package com.codeclan.example.ComputerFiles.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "name")
    public String name;

    @ManyToMany
    @JsonIgnoreProperties({"users"})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "folders_users",
            joinColumns = {@JoinColumn(name = "folder_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name="user_id", nullable = false, updatable = false)}
    )
    private List<Folder> folders;

    public User(String name) {
        this.name = name;
        this.folders = new ArrayList<Folder>();
    }

    public User(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Folder> getFolders() {
        return folders;
    }

    public void setFolders(List<Folder> folders) {
        this.folders = folders;
    }

    public void addFolder(Folder folder){
        this.folders.add(folder);
    }
}
