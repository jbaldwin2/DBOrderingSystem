package dBOrderingSystem.labWork;

import java.util.List;

/**
 * The purpose of this class is to be the gateway into the database access
 * features. A program will only know about, and will only talk to this class.
 * All other classes and functionality is encapsulated in this class. That way
 * if a change is made to the DAO or the DBManager, it will not break the
 * programs that talk to this class. That type of decoupling is critical to
 * creating flexible, non-rigid, non-fragile code.
 * 
 * @author Instlogin
 */
public class MenuItemService {
    private IMenuItemDAO dao;

    public MenuItemService() throws Exception {
        Configuration cfg = new Configuration();
        dao = (IMenuItemDAO)cfg.getObject("dao.menuItem");
        cfg = null;
        dao.init();
    }

     public List<MenuItem> getMenuItemList() throws Exception {
        return dao.getMenuItemList();
    }

    // For testing only!! Comment out in production.
//    public static void main(String[] args) throws Exception {
//        MenuItemService srv = new MenuItemService();
//        List<MenuItem> records = srv.getMenuItemList();
//        for(MenuItem e : records) {
//            System.out.println(e);
//        }
//    }

}
