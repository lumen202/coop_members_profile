package dev.lumen.data.people;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import dev.lumen.App;
import dev.lumen.models.people.Member;

import dev.sol.db.DBParam;
import dev.sol.db.DBService;
import dev.sol.db.DBType;

public class MemberDAO {
        public static final String TABLE = "member";
        public static final DBService DB = App.DB_COOP;

        public static Member data(CachedRowSet crs) {
                try {

                        String firstName = crs.getString("Fname");
                        String lastName = crs.getString("Lname");
                        String income = crs.getString("SourceofIncome");
                        String relative = crs.getString("NearestRelative");
                        String dependent = crs.getString("Dependent");
                        String relationship = crs.getString("Relationship");
                        String middleName = crs.getString("Mname");
                        String dateOfBirth = crs.getString("DateofBirth");
                        String placeOfBirth = crs.getString("PlaceofBirth");
                        String currentAddress = crs.getString("CurrentAddress");
                        String occupation = crs.getString("Occupation");
                        String sex = crs.getString("Sex");

                        int status = crs.getInt("Status");
                        int officeID = crs.getInt("OfficeID");
                        int memberID = crs.getInt("memberID");
                        int stockshare = crs.getInt("StockShare");
                        int stockpaid = crs.getInt("StockPaid");

                        double amountPaid = crs.getDouble("AmountPaid");
                        double salary = crs.getDouble("Salary");
                        double stockamount = crs.getDouble("StockAmount");



                        return new Member(memberID, firstName, lastName, amountPaid, relationship, middleName,
                                        dateOfBirth,
                                        placeOfBirth, status, currentAddress, occupation, officeID, salary, income,
                                        relative, dependent,
                                        stockshare,
                                        stockamount, stockpaid, sex);

                } catch (Exception e) {
                        e.printStackTrace();
                }
                return null;

        }


        private static DBParam[] paramList(Member member) {
                List<DBParam> paramList = new LinkedList<>();

                paramList.add(new DBParam(DBType.TEXT, "SourceofIncome", member.getIncome()));
                paramList.add(new DBParam(DBType.TEXT, "NearestRelative", member.getRelative()));
                paramList.add(new DBParam(DBType.TEXT, "Dependent", member.getDependent()));
                paramList.add(new DBParam(DBType.TEXT, "Fname", member.getFirstName()));
                paramList.add(new DBParam(DBType.TEXT, "Lname", member.getLastName()));
                paramList.add(new DBParam(DBType.TEXT, "Relationship", member.getRelationship()));
                paramList.add(new DBParam(DBType.TEXT, "Mname", member.getMiddleName()));
                paramList.add(new DBParam(DBType.TEXT, "DateofBirth", member.getDateOfBirth()));
                paramList.add(new DBParam(DBType.TEXT, "PlaceofBirth", member.getPlaceOfBirth()));
                paramList.add(new DBParam(DBType.TEXT, "CurrentAddress", member.getCurrentAddress()));
                paramList.add(new DBParam(DBType.TEXT, "Occupation", member.getOccupation()));
                paramList.add(new DBParam(DBType.TEXT, "Sex", member.getSex()));

                paramList.add(new DBParam(DBType.NUMERIC, "memberID", member.getMemberID()));
                paramList.add(new DBParam(DBType.NUMERIC, "OfficeID", member.getOfficeID()));
                paramList.add(new DBParam(DBType.NUMERIC, "StockPaid", member.getStockpaid()));
                paramList.add(new DBParam(DBType.NUMERIC, "StockShare", member.getStockshare()));
                paramList.add(new DBParam(DBType.NUMERIC, "Status", member.getStatus()));

                paramList.add(new DBParam(DBType.DECIMAL, "Salary", member.getSalary()));
                paramList.add(new DBParam(DBType.DECIMAL, "StockAmount", member.getStockamount()));
                paramList.add(new DBParam(DBType.DECIMAL, "AmountPaid", member.getAmountPaid()));

                return paramList.toArray(new DBParam[0]);
        }

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

        public static void insert(Member member) {
                DB.insert(TABLE, paramList(member));
        }

        public static void delete(Member member) {
                DB.delete(TABLE, new DBParam(DBType.NUMERIC, "memberID", member.getMemberID()));
        }

        public static void update(Member member) {

                DBParam[] params = paramList(member);

                for (int i = 0; i <= 17; i++) {
                        DB.update(TABLE, new DBParam(DBType.NUMERIC, "memberID",
                                        member.getMemberID()), params[i]);
                }

        }
}
