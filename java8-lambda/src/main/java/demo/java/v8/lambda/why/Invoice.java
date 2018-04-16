package demo.java.v8.lambda.why;

import java.util.ArrayList;
import java.util.List;

public class Invoice {

    private int amount;

    private String customer;

    /**
     * @param invoices
     * @param amount
     * @return
     * 简单
     * 可读性可以
     * 没有灵活性
     */
    List<Invoice> findInvoicesGreaterThanAmount(List<Invoice> invoices, double amount) {
        List<Invoice> result = new ArrayList<>();
        for (Invoice inv : invoices) {
            if (inv.getAmount() > amount) {
                result.add(inv);
            }
        }
        return result;
    }

    public String getCustomer() {
        return "customer";
    }

    public interface InvoicePredicate {
        boolean test(Invoice inv);
    }

    /**
     * @param invoices
     * @param p
     * @return
     * 灵活性可以
     * 可读性较差
     */
    public static List<Invoice> findInvoices(List<Invoice> invoices, InvoicePredicate p) {
        List<Invoice> result = new ArrayList<>();
        for(Invoice inv: invoices) {
            if(p.test(inv)) {
                result.add(inv);
            }
        }
        return result;
    }

    public int getAmount() {
        return amount;
    }
}
