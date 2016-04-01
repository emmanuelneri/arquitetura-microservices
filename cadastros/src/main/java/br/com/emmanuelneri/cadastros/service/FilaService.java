package br.com.emmanuelneri.cadastros.service;


import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSDestinationDefinitions;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueBrowser;

@Named
@JMSDestinationDefinitions({
        @JMSDestinationDefinition(
                name = "java:comp/jms/cliente",
                interfaceName = "javax.jms.Queue",
                destinationName = "ClienteQueue")
})
public class FilaService {

    @Inject
    @JMSConnectionFactory("java:jboss/DefaultJMSConnectionFactory")
    private JMSContext context;

    @Resource(mappedName = "java:comp/jms/cliente")
    private Queue fila;

    public void send(String clienteJson) {
        context.createProducer().send(fila, clienteJson);
    }

    @Schedule(minute = "*/1", hour = "*", persistent = false)
    public void receiveMessageNew() throws JMSException {
//        JMSConsumer consumer = context.createConsumer(fila);
//        return consumer.receiveBody(String.class);

        QueueBrowser browser = context.createBrowser(fila);
        while (browser.getEnumeration().hasMoreElements()) {
            context.createConsumer(fila).receiveBody(String.class, 1000);
        }

    }


}
