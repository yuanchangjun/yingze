package com.baldurtech;

import com.baldurtech.unit.TestCase;

public class ContactRepositoryTest extends TestCase{
    public void test_根据指定id删除contact(){
        DataBaseManagerMock db = new DataBaseManagerMock();
        ContactRepository contactRepository = new ContactRepository(db);
        contactRepository.deleteById(1L);
        assertEquals("DELETE FROM contact WHERE id=1L",db.executeUpdateParm);
    }
}
