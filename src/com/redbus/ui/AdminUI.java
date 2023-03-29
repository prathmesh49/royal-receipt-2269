package com.redbus.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.redbus.dao.BusDao;
import com.redbus.dao.BusDaoIMPL;
import com.redbus.dto.BusInfo;
import com.redbus.dto.BusInfoIMPL;
import com.redbus.dto.BusName;
import com.redbus.dto.BusType;
import com.redbus.dto.Destination;
import com.redbus.dto.Source;
import com.redbus.exception.NoRecordFoundException;
import com.redbus.exception.SomeThingWentWrongException;

public class AdminUI {
	Scanner sc;
	BusDao bdao;
	BufferedReader br;

	public AdminUI(Scanner sc) {
		super();
		this.sc = sc;
		this.bdao = new BusDaoIMPL();
		this.br = new BufferedReader(new InputStreamReader(System.in));
	}

	public void mainOpp() {
		System.out.println("+----------------------------+\n"
						  +"| Welcome                    |\n"
						  +"| To                         |\n"
						  +"| RedBus Admin               |\n"
						  +"+----------------------------+\n");
		
		int choice =0;
		do {
			System.out.println("+----------------------------+\n"
							  +"| 1. Add a new Bus		     |\n"
							  +"| 2. Update bus Details      |\n"
							  +"| 0. Log Out                 |\n"
							  +"+----------------------------+\n");
			while(!sc.hasNextInt()) {
				sc.next();
				System.out.println("Invalid Input, try again!");
			}
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				addNewBus();
				break;
			case 2:
				updateBus();
				break;
		
			default:
				if(choice !=0)
					System.out.println("Invalid Input, try again!");
				else
					System.out.println("Log Out Successfull!");
				break;
			}
		}while(choice != 0);
	}

	public void addNewBus() {
		BusInfo bus = new BusInfoIMPL();
		System.out.println("Bus Name: ");
		BusName busname = null;
		System.out.println("1. " + BusName.MohanTravels);
		System.out.println("2. " + BusName.NakodaTravels);
		System.out.println("3. " + BusName.Shivaneri);
		System.out.println("4. " + BusName.Shivshahi);
		System.out.println("5. " + BusName.VaibhavTravels);
				
		int cho = 0;
		System.out.println("Please Enter Correct Option:");
		while(!sc.hasNextInt()) {
			sc.next();
			System.out.println("Invalid Input, try again!");
		}
		cho = sc.nextInt();
		switch (cho) {
		case 1:
			busname = BusName.MohanTravels;
			break;
		case 2:
			busname = BusName.NakodaTravels;
			break;
		case 3:
			busname = BusName.Shivaneri;
			break;
		case 4:
			busname = BusName.Shivshahi;
			break;
		case 5:
			busname = BusName.VaibhavTravels;
			break;

		default:

			break;
		}
		bus.setBusname(busname);
//      --------
		
		System.out.println("Source: ");
		Source source = null;
		System.out.println("1. " + Source.KOLHAPUR);
		System.out.println("2. " + Source.SANGLI);
		System.out.println("3. " + Source.PETH);
		System.out.println("4. " + Source.PUNE);
		cho = 0;
		System.out.println("Please Enter Correct Option:");
		while(!sc.hasNextInt()) {
			sc.next();
			System.out.println("Invalid Input, try again!");
		}
		cho = sc.nextInt();
		switch (cho) {
		case 1:
			source = Source.KOLHAPUR;
			break;
		case 2:
			source = Source.SANGLI;
			break;
		case 3:
			source = Source.PETH;
			break;
		case 4:
			source = Source.PUNE;
			break;

		default:

			break;
		}
		bus.setSource(source);
		System.out.println("Destination: ");
		cho = 0;
		Destination desti = null;
		System.out.println("1. " + Destination.GUJRAT);
		System.out.println("2. " + Destination.MUMBAI);
		System.out.println("3. " + Destination.PUNE);
		System.out.println("Please Enter Correct Option:");
		while(!sc.hasNextInt()) {
			sc.next();
			System.out.println("Invalid Input, try again!");
		}
		cho = sc.nextInt();
		switch (cho) {
		case 1:
			desti = Destination.GUJRAT;
			break;
		case 2:
			desti = Destination.MUMBAI;
			break;
		case 3:
			desti = Destination.PUNE;
			break;

		default:

			break;
		}
		bus.setDestination(desti);

		System.out.println("Bus Type: ");
		BusType type = null;
		cho = 0;
		System.out.println("1. " + BusType.SEATING);
		System.out.println("2. " + BusType.SEMISLEEPER);
		System.out.println("3. " + BusType.SLEEPER);
		System.out.println("Please Enter Correct Option:");
		while(!sc.hasNextInt()) {
			sc.next();
			System.out.println("Invalid Input, try again!");
		}
		cho = sc.nextInt();
		switch (cho) {
		case 1:
			type = BusType.SEATING;
			break;
		case 2:
			type = BusType.SEMISLEEPER;
			break;
		case 3:
			type = BusType.SLEEPER;
			break;

		default:

			break;
		}
		bus.setBustype(type);
//		----------
		
		System.out.println("Departure Time: '(YYYY-MM-DD) (HR-MIN-SEC)'");
		 DateTimeFormatter formatter
         = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
		String ip = null;
		try {
			ip = br.readLine();
		} catch (IOException e1) {
			System.out.println(e1.getLocalizedMessage());
		}
        String[] str = ip.split(" ");
        String d= str[0];
        String t = str[1];
        LocalDateTime lt = LocalDateTime.parse(d+"T"+t, formatter);
		bus.setDepartur_time(lt);
		
//		----------
		
		System.out.println("Arrival Time: '(YYYY-MM-DD) (HR-MIN-SEC)'");
		try {
			ip = br.readLine();
		} catch (IOException e1) {
			System.out.println(e1.getLocalizedMessage());
		}
        str = ip.split(" ");
        d= str[0];
        t = str[1];
        lt = LocalDateTime.parse(d+"T"+t, formatter);
		bus.setArrival_time(lt);
		
//		---------
		
		System.out.println("Total Seats: ");
		bus.setTotal_seat(sc.nextInt());
		System.out.println("Bus In Service: (true/false)");
		bus.setStatus(sc.nextBoolean());
		System.out.println("Per Seat Price: ");
		bus.setSeat_price(sc.nextDouble());

		try {
			bdao.addNewBus(bus);
		} catch (SomeThingWentWrongException e) {
			System.out.println(e.getLocalizedMessage());
		}

	}

	public void updateBus() {
		BusInfo bus = new BusInfoIMPL();
		System.out.println("BusName:");
		bus.setbName(sc.next());
		System.out.println("BusType:");
		bus.setbType(sc.next());
		System.out.println("TotalSeat:");
		bus.setTotal_seat(sc.nextInt());
		
		System.out.println("Enter bus name, Want to be change:");
		String bname = null;
		try {
			bname = br.readLine();
		} catch (IOException e1) {
			System.out.println(e1.getLocalizedMessage());
		}
		
		try {
			bdao.updateBus(bus, bname);
		} catch (NoRecordFoundException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
}