package com.example.suryanarayan.sample.ExpandDrawer.data;

import com.example.suryanarayan.sample.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by awidiyadew on 15/09/16.
 */
public class CustomDataProvider {

    private static final int MAX_LEVELS = 3;
    private static final int LEVEL_1 = 1;


    public static List<BaseItem> getInitialItems() {
        //return getSubItems(new GroupItem("root"));

        List<BaseItem> rootMenu = new ArrayList<>();

        /*
        * ITEM = TANPA CHILD
        * GROUPITEM = DENGAN CHIL
        * */






        /*rootMenu.add(new GroupItem("Select Region",selectregion));
        rootMenu.add(new Item("DashBoard",dashboard));
        rootMenu.add(new Item("Live Site Review",livesitereview));
        rootMenu.add(new Item("Service Request",servicerequest));
        rootMenu.add(new Item("System Health",systemhealth));*/

        rootMenu.add(new GroupItem("Select Region"));
        rootMenu.add(new Item("DashBoard"));
        rootMenu.add(new Item("Live Site Review"));
        rootMenu.add(new Item("Service Request"));
        rootMenu.add(new Item("System Health"));
       /* rootMenu.add(new Item("Feedback"));
        rootMenu.add(new Item("Setting"));*/



        return rootMenu;
    }

    public static List<BaseItem> getSubItems(BaseItem baseItem) {

        List<BaseItem> result = new ArrayList<>();
        int level = ((GroupItem) baseItem).getLevel() + 1;
        String menuItem = baseItem.getName();

        if (!(baseItem instanceof GroupItem)) {
            throw new IllegalArgumentException("GroupItem required");
        }

        GroupItem groupItem = (GroupItem)baseItem;
        if(groupItem.getLevel() >= MAX_LEVELS){
            return null;
        }

        /*
        * HANYA UNTUK GROUP-ITEM
        * */
        switch (level){
            case LEVEL_1 :
                switch (menuItem){
                    case "Select Region" :
                        result = getListKategori();
                        break;
                }
                break;
        }

        return result;
    }

    public static boolean isExpandable(BaseItem baseItem) {
        return baseItem instanceof GroupItem;
    }

    private static List<BaseItem> getListKategori(){

        List<BaseItem> list = new ArrayList<>();
        // Setiap membuat groupItem harus di set levelnya
       /* GroupItem groupItem = new GroupItem("GROUP 1");
        groupItem.setLevel(groupItem.getLevel() + 1);*/

        list.add(new Item("All"));
        list.add(new Item("North"));
        list.add(new Item("South"));
        list.add(new Item("East"));
        list.add(new Item("West"));
        /*list.add(groupItem);*/

        return list;
    }


}
