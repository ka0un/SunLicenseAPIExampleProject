package com.hapangama;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Example of how to use SunLicenseAPI in a simple application

        // Creating an instance of SunLicenseAPI with a hardcoded license key, product ID, product version, and API URL.
        // Replace the placeholder values with your actual license key, product ID, and API URL.
        SunLicenseAPI api = SunLicenseAPI.getLicense("FE72-URFX-4RKW-M38T-0ARO", 602, "1.0.0", "http://localhost:8080");

        try {
            // Validate the license. This method will throw an IOException if the license is invalid.
            api.validate();
            System.out.println("License is valid");
        } catch (IOException e) {
            // Handle the exception if the license validation fails.
            // Pro Tip: Customize the error message to provide more context to the user.
            System.out.println("Error: " + e.getMessage());
            System.exit(1); // Exit the program with a non-zero status code indicating an error.
        }

        // Pro Tip: For production use, it's better to load the license key from a file
        // rather than hard-coding it in your source code. This enhances security and makes
        // it easier to update the license key without modifying the code.
        //
        // Example of loading the license from a file in production:
        //
        // try {
        //     // Replace "path/to/license.txt" with the actual path to your license file
        //     SunLicenseAPI api = SunLicenseAPI.getLicenseFromFile("path/to/license.txt", 1203, "1.0.0", "http://localhost:8080");
        //
        //     // Validate the license. This method will throw an IOException if the license is invalid.
        //     api.validate();
        //     System.out.println("License is valid");
        // } catch (IOException e) {
        //     // Handle the exception if the license validation fails.
        //     // Pro Tip: Customize the error message to provide more context to the user.
        //     System.out.println("Error: " + e.getMessage());
        //     System.exit(1); // Exit the program with a non-zero status code indicating an error.
        // }

        // ================== Optional Configuration ==================

        // You can force the license validation to use given IP address instead of the request IP address.

        // Get the public IP address of the machine (optional)
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("https://api.ipify.org")) // IP service
//                .GET()
//                .build();
//        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        String publicIP = response.body();
//
//        // Manually set the public IP address (optional)
//        api.setIp(publicIP);
    }
}