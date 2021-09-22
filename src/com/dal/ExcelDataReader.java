 package com.dal;

import java.util.LinkedList;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.models.Bl;


public class ExcelDataReader
{

    public LinkedList<Bl> GetBLs(String fileName){

        LinkedList<Bl> list=new LinkedList<Bl>();
        String query="SELECT * FROM Sheet1 WHERE BlNo<>''";
        try {
            Fillo fillo=new Fillo();
            Connection connection=fillo.getConnection(fileName);
            Recordset recordset=connection.executeQuery(query);
            while(recordset.next()){
                Bl bl=new Bl(recordset.getField("BLNo"));
            list.addLast(bl);
            }
            recordset.close();
            connection.close();

        
        } catch (Exception e) {
            //TODO: handle exception
        }
        return list;
    }
    public int PutStatus(String fileName,Bl bl){
        try {
            Fillo fillo=new Fillo();
            Connection connection=fillo.getConnection(fileName);
            String query="UPDATE Sheet1 SET Status='"+bl.getStatus()+"' WHERE BLNo='"+bl.getBlNo()+"'";
            int rowAffected=connection.executeUpdate(query);
            connection.close();
            return rowAffected;
        } catch (Exception e) {
            //TODO: handle exception
        }
        return 0;
    }
}