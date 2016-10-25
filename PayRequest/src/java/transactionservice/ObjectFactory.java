
package transactionservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the transactionservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _PayWithCreditCard_QNAME = new QName("http://TransactionService/", "payWithCreditCard");
    private final static QName _PayWithCreditCardResponse_QNAME = new QName("http://TransactionService/", "payWithCreditCardResponse");
    private final static QName _PayWithPaypal_QNAME = new QName("http://TransactionService/", "payWithPaypal");
    private final static QName _PayWithPaypalResponse_QNAME = new QName("http://TransactionService/", "payWithPaypalResponse");
    private final static QName _RefundTicket_QNAME = new QName("http://TransactionService/", "refundTicket");
    private final static QName _RefundTicketResponse_QNAME = new QName("http://TransactionService/", "refundTicketResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: transactionservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PayWithCreditCard }
     * 
     */
    public PayWithCreditCard createPayWithCreditCard() {
        return new PayWithCreditCard();
    }

    /**
     * Create an instance of {@link PayWithCreditCardResponse }
     * 
     */
    public PayWithCreditCardResponse createPayWithCreditCardResponse() {
        return new PayWithCreditCardResponse();
    }

    /**
     * Create an instance of {@link PayWithPaypal }
     * 
     */
    public PayWithPaypal createPayWithPaypal() {
        return new PayWithPaypal();
    }

    /**
     * Create an instance of {@link PayWithPaypalResponse }
     * 
     */
    public PayWithPaypalResponse createPayWithPaypalResponse() {
        return new PayWithPaypalResponse();
    }

    /**
     * Create an instance of {@link RefundTicket }
     * 
     */
    public RefundTicket createRefundTicket() {
        return new RefundTicket();
    }

    /**
     * Create an instance of {@link RefundTicketResponse }
     * 
     */
    public RefundTicketResponse createRefundTicketResponse() {
        return new RefundTicketResponse();
    }

    /**
     * Create an instance of {@link Transaction }
     * 
     */
    public Transaction createTransaction() {
        return new Transaction();
    }

    /**
     * Create an instance of {@link Refund }
     * 
     */
    public Refund createRefund() {
        return new Refund();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PayWithCreditCard }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://TransactionService/", name = "payWithCreditCard")
    public JAXBElement<PayWithCreditCard> createPayWithCreditCard(PayWithCreditCard value) {
        return new JAXBElement<PayWithCreditCard>(_PayWithCreditCard_QNAME, PayWithCreditCard.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PayWithCreditCardResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://TransactionService/", name = "payWithCreditCardResponse")
    public JAXBElement<PayWithCreditCardResponse> createPayWithCreditCardResponse(PayWithCreditCardResponse value) {
        return new JAXBElement<PayWithCreditCardResponse>(_PayWithCreditCardResponse_QNAME, PayWithCreditCardResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PayWithPaypal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://TransactionService/", name = "payWithPaypal")
    public JAXBElement<PayWithPaypal> createPayWithPaypal(PayWithPaypal value) {
        return new JAXBElement<PayWithPaypal>(_PayWithPaypal_QNAME, PayWithPaypal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PayWithPaypalResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://TransactionService/", name = "payWithPaypalResponse")
    public JAXBElement<PayWithPaypalResponse> createPayWithPaypalResponse(PayWithPaypalResponse value) {
        return new JAXBElement<PayWithPaypalResponse>(_PayWithPaypalResponse_QNAME, PayWithPaypalResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RefundTicket }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://TransactionService/", name = "refundTicket")
    public JAXBElement<RefundTicket> createRefundTicket(RefundTicket value) {
        return new JAXBElement<RefundTicket>(_RefundTicket_QNAME, RefundTicket.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RefundTicketResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://TransactionService/", name = "refundTicketResponse")
    public JAXBElement<RefundTicketResponse> createRefundTicketResponse(RefundTicketResponse value) {
        return new JAXBElement<RefundTicketResponse>(_RefundTicketResponse_QNAME, RefundTicketResponse.class, null, value);
    }

}
