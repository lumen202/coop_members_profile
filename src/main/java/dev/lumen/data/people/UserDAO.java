package dev.lumen.data.people;

import javax.sql.rowset.CachedRowSet;

import dev.lumen.App;
import dev.lumen.models.people.Office;
import dev.sol.db.DBService;

public class UserDAO {
    public static final String TABLE = "user";
    public static final DBService DB = App.DB_COOP;

    public static Office data(CachedRowSet crs) {
        try {

            int officeId = crs.getInt("officeId");
            String officeName = crs.getString("officeName");
            return new Office(officeId, officeName);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

}
