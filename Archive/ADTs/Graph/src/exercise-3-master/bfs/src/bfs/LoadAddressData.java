package bfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.zip.GZIPInputStream;

public class LoadAddressData {

    // This was an arbitrarily defined number -- It approximately represents the distance squared (in latitude and longitude)
    // between two buildings that were across the street from each other.
    private static final double CLOSE_THRESHOLD = 0.0000003;

    // You shouldn't change this until after you're done answering the required questions and want to explore the data more.
    private static final String SAMPLE_ZIP_CODE = "10128";

    public static Map<String, List<String>> getAddressData() throws IOException {
        List<Address> addresses = readAddresses();
        return computeGraph(addresses);
    }

    private static Map<String, List<String>> computeGraph(List<Address> addresses) {
        System.out.println("Converting address data into a graph format...");
        Map<String, List<String>> addressesToCloseAddressesGraph = new HashMap<>();
        for (Address address1 : addresses) {
            for (Address address2 : addresses) {
                if (!address1.equals(address2)) {
                    if (address1.isCloseTo(address2)) {
                        addressesToCloseAddressesGraph.putIfAbsent(address1.address, new LinkedList<>());
                        addressesToCloseAddressesGraph.get(address1.address).add(address2.address);
                    }
                }
            }
        }
        System.out.println("Done computing the graph");
        return addressesToCloseAddressesGraph;
    }

    private static List<Address> readAddresses() throws IOException {
        System.out.println("Decompressing and loading `nyc_addresses.gz`...");
        GZIPInputStream gis = new GZIPInputStream(new FileInputStream("nyc_addresses.gz"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(gis, "UTF-8"));
        String line = bufferedReader.readLine();
        Map<String, Integer> columnNameToIndex = new HashMap<>();
        for (String column : line.split(",")) {
            columnNameToIndex.put(column, columnNameToIndex.size());
        }
        List<Address> addresses = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null) {
            String[] address = line.split(",");
            String zipCode = address[columnNameToIndex.get("ZIPCODE")];

            // You can change this line if you want to filter by a different ZIP code or
            // remove this if you want to look at all ZIP codes (there's 1 million addresses though)
            if (zipCode.equals(SAMPLE_ZIP_CODE)) {
                String fullPoint = address[columnNameToIndex.get("the_geom")];
                String[] coordinates = fullPoint.substring(fullPoint.indexOf("(") + 1,
                        fullPoint.indexOf(")")).split(" ");
                addresses.add(new Address(address[columnNameToIndex.get("H_NO")]
                        + " " + address[columnNameToIndex.get("FULL_STREE")] + ", NY",
                        Double.parseDouble(coordinates[0]),
                        Double.parseDouble(coordinates[1])));
            }
        }
        System.out.println("Done loading the `nyc_address.gz` data");
        return addresses;
    }

    private static class Address {
        String address;
        double longitude;
        double latitude;

        Address(String address, double longitude, double latitude) {
            this.address = address;
            this.longitude = longitude;
            this.latitude = latitude;
        }

        @Override
        public String toString() {
            return "Address{" +
                    "address='" + address + '\'' +
                    ", longitude=" + longitude +
                    ", latitude=" + latitude +
                    '}';
        }

        boolean isCloseTo(Address other) {
            return Math.pow(this.latitude - other.latitude, 2) + Math.pow(this.longitude - other.longitude, 2) < CLOSE_THRESHOLD;
        }
    }
}
