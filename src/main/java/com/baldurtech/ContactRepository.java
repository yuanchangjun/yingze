package com.baldurtech;

public class ContactRepository{
    private final DataBaseManager db;
    public ContactRepository(DataBaseManager db){
        this.db = db;
    }
    public void deleteById(Long id){
        db.executeUpdate("DELETE FROM contact WHERE id=1");
    }
}
