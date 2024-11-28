package dev.lumen.data;

import java.sql.Types;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.sql.rowset.CachedRowSet;

import dev.lumen.App;
import dev.lumen.models.Member;
import dev.sol.db.DBParam;
import dev.sol.db.DBService;

public class MemberDAO {
    public static final String TABLE = "member";
    public static final DBService DB = App.DB_COOP;

    public static Member data(CachedRowSet crs) {
        try {
            int memberID = crs.getInt("memberID");
            String firstName = crs.getString("Fname");
            String lastName = crs.getString("Lname");
            double amountPaid = crs.getDouble("AmountPaid");
            String relationship = crs.getString("Relationship");
            String middleName = crs.getString("Mname");
            String dateOfBirth = crs.getString("DateofBirth");
            String placeOfBirth = crs.getString("PlaceofBirth");
            int status = crs.getInt("Status");
            String currentAddress = crs.getString("CurrentAddress");
            String occupation = crs.getString("Occupation");
            int officeID = crs.getInt("OfficeID");
            double salary = crs.getDouble("Salary");
            String income = crs.getString("SourceofIncome");
            String relative = crs.getString("NearestRelative");
            String dependent = crs.getString("Dependent");
            int stockshare = crs.getInt("StockShare");
            double stockamount = crs.getDouble("StockAmount");
            int stockpaid = crs.getInt("StockPaid");

            return new Member(memberID, firstName, lastName, amountPaid, relationship, middleName, dateOfBirth,
                    placeOfBirth, status, currentAddress, occupation, officeID, salary, income, relative, dependent,
                    stockshare,
                    stockamount, stockpaid);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    private static DBParam[] paramList(Member member) {
        List<DBParam> paramList = new LinkedList<>();
        paramList.add(new DBParam(Types.VARCHAR, "Fname", member.getFirstName()));
        paramList.add(new DBParam(Types.VARCHAR, "Lname", member.getLastName()));
        paramList.add(new DBParam(Types.VARCHAR, "Relationship", member.getRelationship()));
        paramList.add(new DBParam(Types.VARCHAR, "Mname", member.getMiddleName()));
        paramList.add(new DBParam(Types.VARCHAR, "DateofBirth", member.getDateOfBirth()));
        paramList.add(new DBParam(Types.VARCHAR, "PlaceofBirth", member.getPlaceOfBirth()));
        paramList.add(new DBParam(Types.TINYINT, "Status", member.getStatus()));
        paramList.add(new DBParam(Types.VARCHAR, "CurrentAddress", member.getCurrentAddress()));
        paramList.add(new DBParam(Types.VARCHAR, "Occupation", member.getOccupation()));
        paramList.add(new DBParam(Types.TINYINT, "OfficeID", member.getOfficeID()));
        paramList.add(new DBParam(Types.DOUBLE, "Salary", member.getSalary()));
        paramList.add(new DBParam(Types.VARCHAR, "SourceofIncome", member.getIncome()));
        paramList.add(new DBParam(Types.VARCHAR, "NearestRelative", member.getRelative()));
        paramList.add(new DBParam(Types.VARCHAR, "Dependent", member.getDependent()));
        paramList.add(new DBParam(Types.INTEGER, "StockShare", member.getStockshare()));
        paramList.add(new DBParam(Types.DECIMAL, "StockAmount", member.getStockamount()));
        paramList.add(new DBParam(Types.INTEGER, "StockPaid", member.getStockpaid()));

        return paramList.toArray(new DBParam[0]);
    }

    // private static Map<String, DBParam> paramMap(Member member) {
    // Map<String, DBParam> paramMap = new LinkedHashMap<>();
    // paramMap.put("memberID", new DBParam(Types.INTEGER, "memberID",
    // member.getMemberID()));
    // paramMap.put("Fname", new DBParam(Types.VARCHAR, "Fname",
    // member.getFirstName()));
    // paramMap.put("Lname", new DBParam(Types.VARCHAR, "Lname",
    // member.getLastName()));
    // paramMap.put("Relationship", new DBParam(Types.VARCHAR, "Relationship",
    // member.getAmountPaid()));
    // paramMap.put("Mname", new DBParam(Types.VARCHAR, "Mname",
    // member.getAmountPaid()));
    // paramMap.put("DateofBirth", new DBParam(Types.VARCHAR, "DateofBirth",
    // member.getAmountPaid()));
    // paramMap.put("PlaceofBirth", new DBParam(Types.VARCHAR, "PlaceofBirth",
    // member.getAmountPaid()));
    // paramMap.put("Status", new DBParam(Types.TINYINT, "Status",
    // member.getAmountPaid()));
    // paramMap.put("CurrentAddress", new DBParam(Types.VARCHAR, "CurrentAddress",
    // member.getAmountPaid()));
    // paramMap.put("Occupation", new DBParam(Types.VARCHAR, "Occupation",
    // member.getAmountPaid()));
    // paramMap.put("OfficeID", new DBParam(Types.TINYINT, "OfficeID",
    // member.getAmountPaid()));
    // paramMap.put("Salary", new DBParam(Types.DOUBLE, "Salary",
    // member.getAmountPaid()));
    // paramMap.put("SourceofIncome", new DBParam(Types.VARCHAR, "SourceofIncome",
    // member.getAmountPaid()));
    // paramMap.put("NearestRelative", new DBParam(Types.VARCHAR, "NearestRelative",
    // member.getAmountPaid()));
    // paramMap.put("Dependent", new DBParam(Types.VARCHAR, "Dependent",
    // member.getAmountPaid()));
    // paramMap.put("StockShare", new DBParam(Types.INTEGER, "StockShare",
    // member.getAmountPaid()));
    // paramMap.put("StockAmount", new DBParam(Types.DECIMAL, "StockAmount",
    // member.getAmountPaid()));
    // paramMap.put("StockPaid", new DBParam(Types.INTEGER, "StockPaid",
    // member.getAmountPaid()));

    // return paramMap;
    // }

    public static List<Member> getMemberList() {
        CachedRowSet crs = DB.select(TABLE);
        List<Member> list = new LinkedList<>();
        try {
            while (crs.next()) {
                Member member = data(crs);
                if (member != null) {
                    list.add(member);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void delete(Member member) {
        DB.delete(TABLE, new DBParam(Types.INTEGER, "memberID", member.getMemberID()));
    }

    public static void update(Member member) {
        DB.update(TABLE, new DBParam(Types.INTEGER, "memberID", member.getMemberID()),
                new DBParam(Types.VARCHAR, "Fname", member.getFirstName()));

        DB.update(TABLE, new DBParam(Types.INTEGER, "memberID", member.getMemberID()),
                new DBParam(Types.VARCHAR, "Lname", member.getLastName()));

        DB.update(TABLE, new DBParam(Types.INTEGER, "memberID", member.getMemberID()),
                new DBParam(Types.VARCHAR, "Relationship", member.getRelationship()));
        DB.update(TABLE, new DBParam(Types.INTEGER, "memberID", member.getMemberID()),
                new DBParam(Types.VARCHAR, "Mname", member.getMiddleName()));
        DB.update(TABLE, new DBParam(Types.INTEGER, "memberID", member.getMemberID()),
                new DBParam(Types.VARCHAR, "DateofBirth", member.getDateOfBirth()));
        DB.update(TABLE, new DBParam(Types.INTEGER, "memberID", member.getMemberID()),
                new DBParam(Types.VARCHAR, "PlaceofBirth", member.getPlaceOfBirth()));
        DB.update(TABLE, new DBParam(Types.INTEGER, "memberID", member.getMemberID()),
                new DBParam(Types.TINYINT, "Status", member.getStatus()));
        DB.update(TABLE, new DBParam(Types.INTEGER, "memberID", member.getMemberID()),
                new DBParam(Types.VARCHAR, "CurrentAddress", member.getCurrentAddress()));
        DB.update(TABLE, new DBParam(Types.INTEGER, "memberID", member.getMemberID()),
                new DBParam(Types.VARCHAR, "Occupation", member.getOccupation()));
        DB.update(TABLE, new DBParam(Types.INTEGER, "memberID", member.getMemberID()),
                new DBParam(Types.TINYINT, "OfficeID", member.getOfficeID()));
        DB.update(TABLE, new DBParam(Types.INTEGER, "memberID", member.getMemberID()),
                new DBParam(Types.DOUBLE, "Salary", member.getSalary()));
        DB.update(TABLE, new DBParam(Types.INTEGER, "memberID", member.getMemberID()),
                new DBParam(Types.VARCHAR, "SourceofIncome", member.getIncome()));
        DB.update(TABLE, new DBParam(Types.INTEGER, "memberID", member.getMemberID()),
                new DBParam(Types.VARCHAR, "NearestRelative", member.getRelative()));
        DB.update(TABLE, new DBParam(Types.INTEGER, "memberID", member.getMemberID()),
                new DBParam(Types.VARCHAR, "Dependent", member.getDependent()));
        DB.update(TABLE, new DBParam(Types.INTEGER, "memberID", member.getMemberID()),
                new DBParam(Types.INTEGER, "StockShare", member.getStockshare()));
        DB.update(TABLE, new DBParam(Types.INTEGER, "memberID", member.getMemberID()),
                new DBParam(Types.DECIMAL, "StockAmount", member.getStockamount()));
        DB.update(TABLE, new DBParam(Types.INTEGER, "memberID", member.getMemberID()),
                new DBParam(Types.INTEGER, "StockPaid", member.getStockpaid()));

        // DBParam[] params = paramList(member);

        // for (int i = 0; i < 18; i++) {
        // DB.update(TABLE, new DBParam(Types.INTEGER, "memberID",
        // member.getMemberID()), params[i]);
        // }

    }
}
