

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private String location;
    public LocalTime openingTime;
    public LocalTime closingTime;
    private List<Item> menu = new ArrayList<Item>();
    private List<String> itemName = new ArrayList<String>();

    public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public boolean isRestaurantOpen() {

        LocalTime dtcurrentTime = getCurrentTime();
        if (((dtcurrentTime.isAfter(openingTime)) || dtcurrentTime.equals(openingTime)) && ((getCurrentTime().isBefore(closingTime)) || (dtcurrentTime.equals(closingTime)))){
            return true;
        }
        else
            return false;
    }




    public LocalTime getCurrentTime(){ return  LocalTime.now(); }

    public List<Item> getMenu() {
        return this.menu;
    }

    public int calculateTotalOrderCost(List<String> itemNames){
        int orderTotal = 0;
        for(String name: itemNames){
            for(Item item: menu) {
                if(item.getName().equals(name))
                    orderTotal = orderTotal+item.getPrice();
            }
        }
        return orderTotal;
    }

    public void selectItemForOrder(String item) {
        itemName.add(item);
    }

    public List<String> getItems() {
        return itemName;
    }


    private Item findItemByName(String itemName){
        for(Item item: menu) {
            if(item.getName().equals(itemName))
                return item;
        }
        return null;
    }

    public int getMenuSize(){return getMenu().size();}

    public void addToMenu(String name, int price) {
        Item newItem = new Item(name,price);
        menu.add(newItem);
    }

    
    public void removeFromMenu(String itemName) throws itemNotFoundException {

        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        menu.remove(itemToBeRemoved);
    }
    public void displayDetails(){
        System.out.println("Restaurant:"+ name + "\n"
                +"Location:"+ location + "\n"
                +"Opening time:"+ openingTime +"\n"
                +"Closing time:"+ closingTime +"\n"
                +"Menu:"+"\n"+getMenu());

    }

    public String getName() {
        return name;
    }

}
