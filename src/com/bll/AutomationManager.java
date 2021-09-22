package com.bll;

import java.util.LinkedList;

import com.dal.ExcelDataReader;
import com.models.Bl;

public class AutomationManager {
    private ExcelDataReader dataReader;

    public AutomationManager(ExcelDataReader dataReader) {
        super();
        this.dataReader = dataReader;
    }
    public LinkedList<Bl> getBlList(String fileName){
        return dataReader.GetBLs(fileName);
    }
}
