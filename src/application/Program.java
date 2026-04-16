package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.Reservation;

public class Program {

    public static void main(String[] args) throws ParseException {

        try (Scanner sc = new Scanner(System.in)) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            System.out.print("Room number: ");
            int number = sc.nextInt();

            System.out.print("Check-in date (dd/MM/yyy): ");
            // Vai entrar a data em formato de texto, sdf vai converter em um Date
            Date checkIn = sdf.parse(sc.next());

            System.out.print("Check-out date (dd/MM/yyy): ");
            Date checkout = sdf.parse(sc.next());

            if (!checkout.after(checkIn)) {
                System.out.println("Error in reservation: Check-out date must be after check-in date");
            } else {
                Reservation reservation = new Reservation(checkIn, checkout, number);
                System.out.println("Reservation : " + reservation);

                System.out.println();
                System.out.println("Enter data to update the reservation:");
                System.out.print("Check-in date (dd/MM/yyy): ");
                checkIn = sdf.parse(sc.next());
                System.out.print("Check-out date (dd/MM/yyy): ");
                checkout = sdf.parse(sc.next());

                String error = reservation.updateDates(checkIn, checkout);
                if (error != null) {
                    System.out.println("Error in reservation: " + error);

                } else {
                    System.out.println("Reservation : " + reservation);

                }
            }
        }
    }
}
