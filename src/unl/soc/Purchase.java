package unl.soc;

import unl.soc.items.Item;
import unl.soc.person.Employee;
import unl.soc.person.Person;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Purchase {
    private static final byte TOTAL_PRICE = 0;
    private static final byte TAX = 1;
    
    private final UUID uniqueCode;
    private Store store;
    private List<Item> itemsList;
    private Employee salesman;
    private LocalDateTime dateTime;
    private double totalTax;
    private double totalPrice;

    public Purchase(Store store, List<Item> itemsList, Employee salesman) {
        this.uniqueCode = UUID.randomUUID();
        this.store = store;
        this.itemsList = itemsList;
        this.salesman = salesman;
        this.dateTime = LocalDateTime.now();
        this.totalTax = calculateTotal(TAX);
        this.totalPrice = calculateTotal(TOTAL_PRICE);
    }
    /**
     * Calculates the total price or total tax of the purchase..
     *
     * @param variableToCalculate A short variable indicating the type of calculation:
     *                            - If variableToCalculate is TOTAL_PRICE, calculates the total price of all items.
     *                            - Otherwise, calculates the total tax of all items.
     * @return The calculated total value based on the specified variable.
     */
    private double calculateTotal(short variableToCalculate){
        double total = 0;

        if (variableToCalculate == TOTAL_PRICE){
            for(Item item : this.itemsList){
                total += item.getTotalPrice();
            }
        }
        else {
            for(Item item : this.itemsList){
                total += item.getTax();
            }
        }

        return total;
    }
}

