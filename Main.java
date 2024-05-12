import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of proxies you wan't generate: ");
        int numberOfProxies = scanner.nextInt();

        String fileName = "proxies.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 0; i < numberOfProxies; i++) {
                InetSocketAddress address = new InetSocketAddress(getRandomIp(), getRandomPort());
                writer.write(address.getHostName() + ":" + address.getPort());
                writer.newLine();

                System.out.println("Creating a new proxy... ");
            }

            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(" \uD83C\uDD5C\uD83C\uDD50\uD83C\uDD53\uD83C\uDD54 \uD83C\uDD51\uD83C\uDD68 \uD83C\uDD67\uD83C\uDD5E\uD83C\uDD61\uD83C\uDD50\uD83C\uDD58\uD83C\uDD58");
    }

    private static String getRandomIp() {
        Random random = new Random();
        return random.nextInt(256) + "." + random.nextInt(256) + "." + random.nextInt(256) + "." + random.nextInt(256);
    }

    private static int getRandomPort() {
        Random random = new Random();
        return random.nextInt(65535);
    }
}