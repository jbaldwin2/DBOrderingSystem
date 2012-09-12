/*
 * To change this titemlate, choose Tools | Titemlates
 * and open the titemlate in the editor.
 */
package dBOrderingSystem.labWork;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author JBaldwin
 */
public class MenuItemDAO implements IMenuItemDAO {
    private IDBManager db;
    private int MAX_RECS = 500;

    public MenuItemDAO() throws Exception {
    }

    /**
     *
     * @throws Exception
     */
    @Override
    public void init() throws Exception {
        Configuration cfg = new Configuration();
        db = (IDBManager)cfg.getObject("db.manager");
        cfg = null;
        db.init();
    }
  @Override
    public List<MenuItem> getMenuItemList() throws Exception {
        MenuItem item = null;
        List<MenuItem> menuItems = new ArrayList<MenuItem>();
        // Carefull! You don't want a million records to come back!
        // Use TOP to limit total records returned.
        String sql = "SELECT TOP " + MAX_RECS
                + " * FROM EMPLOYEE ORDER BY LASTNAME ASC;";

        List<Map> rawRecords = db.getAllRecords(sql);
        for(Map map : rawRecords) {
           item = new MenuItem();
           item.setId(Integer.parseInt(map.get("ID").toString()));
           item.setName(map.get("NAME").toString());
           
           menuItems.add(item);
        }

        return menuItems;
    }

  
  
}
