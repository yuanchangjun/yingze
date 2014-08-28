package com.baldurtech;

import com.baldurtech.unit.TestCase;

public class ContactRepositoryTest extends TestCase{
    public void test_根据指定id删除contact(){
        DataBaseManagerMock db = new DataBaseManagerMock();
        ContactRepository contactRepository = new ContactRepository(db);
        contactRepository.deleteById(1L);
        assertEquals("DELETE FROM contact WHERE id=1",db.executeUpdateParm);
    }

    public void test_更新指定的contact(){
        DataBaseManagerMock db = new DataBaseManagerMock();
        ContactRepository contactRepository = new ContactRepository(db);
        Contact contact = new Contact();
        contact.setId(2L);
        contact.setName("Tom");        
        contactRepository.update(contact);
        assertEquals("UPDATE contact SET name=tom WHERE id=2",db.executeUpdateParm);
    }
}
