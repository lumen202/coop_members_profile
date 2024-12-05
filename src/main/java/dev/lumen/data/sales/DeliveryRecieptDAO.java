package dev.lumen.data.sales;

import java.util.LinkedList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import dev.lumen.App;
import dev.lumen.models.people.User;
import dev.lumen.models.sales.DeliveryReciept;
import dev.lumen.models.sales.Supplier;
import dev.sol.db.DBService;

public class DeliveryRecieptDAO {
    public static final String TABLE = "deliveryreceipt";
    public static final DBService DB = App.DB_COOP;

    public static DeliveryReciept data(CachedRowSet crs) {

        try {
            int DRID = crs.getInt("DRID");
            String DRnum = crs.getString("DRNum");

            Supplier supplierID = new Supplier();
            supplierID.setSupplierID(crs.getInt("SupplierID"));
            int deliveryDate = crs.getInt("DateDel");
            double totalAmount = crs.getDouble("TotalAmt");
            double paidAmount = crs.getDouble("paidAmt");
            User userID = new User();
            userID.setUserID(crs.getInt("userid"));

            return new DeliveryReciept(DRID, DRnum, supplierID, deliveryDate, totalAmount, paidAmount, userID);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public static List<DeliveryReciept> getMemberList() {
        CachedRowSet crs = DB.select(TABLE);
        List<DeliveryReciept> list = new LinkedList<>();
        try {
            while (crs.next()) {
                DeliveryReciept deliveryReciept = data(crs);
                if (deliveryReciept != null) {
                    list.add(deliveryReciept);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
