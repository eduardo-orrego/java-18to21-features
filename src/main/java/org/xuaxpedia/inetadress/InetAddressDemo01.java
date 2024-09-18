package org.xuaxpedia.inetadress;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

// Java 21 introduces an SPI (Service Provider Interface) for internet address resolution,
// allowing customization of the process via the AddressResolver interface and an implementation
// such as DefaultAddressResolver. This is registered in META-INF/services and loaded by
// ServiceLoader, providing flexibility in network address resolution.

public class InetAddressDemo01 {

    public static void main(String[] args) throws UnknownHostException {

        System.out.println("--- www.google.com ---");
        InetAddress[] inetAddresses = InetAddress.getAllByName("www.google.com");
        System.out.println("addresses = " + Arrays.toString(inetAddresses));

        InetAddress inetAddress1 = InetAddress.getByName("www.google.com");
        System.out.println("host address = " + inetAddress1.getHostAddress());

        InetAddress inetAddress2 = InetAddress.getByAddress(new byte[]{(byte) 142, (byte) 251, 0, (byte) 147});
        System.out.println("hostname = " + inetAddress2.getHostName());
        System.out.println("canonical hostname = " + inetAddress2.getCanonicalHostName());

        System.out.println("--- localhost ---");
        InetAddress inetAddress3 = InetAddress.getLocalHost();
        System.out.println("localhost address = " + inetAddress3.getHostAddress());
        System.out.println("localhost name = " + inetAddress3.getHostName());
        System.out.println("localhost name canonical = " + inetAddress3.getCanonicalHostName());

    }

}
