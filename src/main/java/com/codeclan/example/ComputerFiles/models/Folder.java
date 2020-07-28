package com.codeclan.example.ComputerFiles.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "folders")
public class Folder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "folder", fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"folder"})
    private List<File> files;

    @ManyToMany
    @JsonIgnoreProperties({"folders"})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "folders_users",
            joinColumns = {@JoinColumn(name = "user_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name="folder_id", nullable = false, updatable = false)}
    )
    private List<User> users;

    public Folder(String title) {
        this.title = title;
        this.users = new ArrayList<User>();
    }

    public Folder(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void addUser(User user){
        this.users.add(user);

    }

}
