//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.logging.Logger;
//import java.util.stream.Collectors;
//
//public class FindByName {
//
//    public List<Drinki> drinkList = new ArrayList<>();
//
//    // method to find a recipe by drinks' name
//    public  List<Drinki> findByName(String drinkFromJson) {
//            List<String> drinkListToFind = new ArrayList<>();
//        for (Drinki drinkElement : drinkList) {
//            if (drinkElement.equals(drinkFromJson)) {
//                drinkListToFind.add(drinkElement);
//            }
//        }
//        if (drinkListToFind.isEmpty()) {
//            return Collections.emptyList();
//        }
//        return drinkListToFind;
//    }
//    // proba zrobienia tego funkcyjnie
//    public void functionMethod(){
//    List<Drinki> functionDrink = drinkList.stream().filter(b -> b.getName().compareTo(drinkFromJson)).collect(Collectors.toList());
//    Logger logger = Logger.getLogger("main");
//    logger.info(functionDrink.toString());
//    }
//}