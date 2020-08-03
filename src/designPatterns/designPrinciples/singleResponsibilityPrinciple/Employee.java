package designPatterns.designPrinciples.singleResponsibilityPrinciple;

import java.util.Date;

public class Employee {

    private String employeeID;
    private String name;
    private String address;
    private Date dateOfJoining;

    // getters and setters
// here these two methods has no role, this should have different class
    /*public boolean isPromotionDueThisYear(){
        boolean flag=false;
        //promotion logic

        return flag;
    }

    public boolean calcIncomeTaxForCurrentYear(){
        boolean flag=false;
        //income tax logic

        return flag;
    }*/

}
