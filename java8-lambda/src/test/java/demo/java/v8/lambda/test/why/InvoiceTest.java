package demo.java.v8.lambda.test.why;

import demo.java.v8.lambda.why.Customer;
import demo.java.v8.lambda.why.Invoice;

import java.util.ArrayList;
import java.util.List;

public class InvoiceTest {

    public void testAsInnerClass() {
        List<Invoice> invoices = new ArrayList<>();
        List<Invoice> expensiveInvoicesFromOracle
                = Invoice.findInvoices(invoices, new Invoice.InvoicePredicate() {

            @Override
            public boolean test(Invoice inv) {
                return inv.getAmount() > 10_000
                        && inv.getCustomer() == Customer.ORACLE;
            }
        });
    }

    public void testAsLambda() {
        List<Invoice> invoices = new ArrayList<>();
        List<Invoice> expensiveInvoicesFromOracle
                = Invoice.findInvoices(invoices, inv ->
                inv.getAmount() > 10_000
                        && inv.getCustomer() ==
                        Customer.ORACLE);
    }
}
