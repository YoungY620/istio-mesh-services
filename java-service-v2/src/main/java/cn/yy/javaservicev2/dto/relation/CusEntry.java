package cn.yy.javaservicev2.dto.relation;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CusEntry implements Serializable {
    private String cusID;
    private String cusName;
    private String deptID;
    private String cusMgrID;
    private String cusMgrName;
    private List<Contact> contacts;
    private List<RelCusEntry> relCustomers;
}
