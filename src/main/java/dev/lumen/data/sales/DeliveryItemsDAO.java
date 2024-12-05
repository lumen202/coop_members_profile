package dev.lumen.data.sales;

import java.util.LinkedList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import dev.lumen.App;
import dev.lumen.models.sales.DeliveryItems;
import dev.lumen.models.sales.DeliveryReciept;
import dev.lumen.models.sales.Stock;
import dev.sol.db.DBParam;
import dev.sol.db.DBService;
import dev.sol.db.DBType;

public class DeliveryItemsDAO {

    public static final String TABLE = "deliveryitems";
    public static final DBService DB = App.DB_COOP;

    public static DeliveryItems data(CachedRowSet crs) {
        try {

            DeliveryReciept drid = new DeliveryReciept();
            drid.setDRID(crs.getInt("DRID"));
            Stock stockID = new Stock();
            stockID.setStockId(crs.getInt("StockID"));
            double buyingPrice = crs.getDouble("BuyingPrice");
            float qty = crs.getFloat("Qty");
            double amount = crs.getDouble("Amount");
            return new DeliveryItems(drid, stockID, buyingPrice, qty, amount);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public static List<DeliveryItems> getMemberList() {
        CachedRowSet crs = DB.select(TABLE);
        List<DeliveryItems> list = new LinkedList<>();
        try {
            while (crs.next()) {
                DeliveryItems deliveryItems = data(crs);
                if (deliveryItems != null) {
                    list.add(deliveryItems);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void delete(DeliveryItems deliveryItems) {
        DB.delete(TABLE, new DBParam(DBType.NUMERIC, "DRID", deliveryItems.getDRID()));
    }

}
