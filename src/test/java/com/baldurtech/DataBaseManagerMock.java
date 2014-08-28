package com.baldurtech;

public class DataBaseManagerMock implements DataBaseManager{
    
    public String executeUpdateParm;
    public int executeUpdateShouldReturn = 0;

    public int executeUpdate(String sql){
        executeUpdateParm = sql;
        return executeUpdateShouldReturn;
    }

}
