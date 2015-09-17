import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TSSLTransportFactory;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TSSLTransportFactory.TSSLTransportParameters;

import java.util.HashMap;

public class HotelBookingServer {

    public static BookingManagerHandler handler;

    public static BookingManager.Processor processor;

    public static void main(String[] args) {
        try {
            handler = new BookingManagerHandler();
            processor = new BookingManager.Processor(handler);

            Runnable secure = new Runnable() {
                public void run() {
                    secure(processor);
                }
            };

            new Thread(simple).start();
            new Thread(secure).start();
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

    public static void secure(BookingManager.Processor processor) {
        try {
            TSSLTransportParameters params = new TSSLTransportParameters();
            params.setKeyStore("C:\\_store for crimore\\tools\\lib\\debug.keystore", "thrift", null, null);

            TServerTransport tServerTransport = TSSLTransportFactory.getServerSocket(9091, 0, null, params);
            TServer tServer = new TSimpleServer(new Args(tServerTransport).processor(processor));

            System.out.println("Starting the secure server...");
            tServer.serve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}