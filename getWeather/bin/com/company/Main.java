package com.company;

import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Main {
	
	public static Scanner scaner = new Scanner(System.in);
	
	public static void main(String args[]) throws IOException {
		Document doc;
		try {
			System.out.print("Enter your city: ");
			String city = scaner.next();
			// Get html
			doc = Jsoup.connect("https://world-weather.ru/pogoda/russia/" + city).get();
			
			// Get <div class="day-temperature">
			Elements links = doc.select("div.day-temperature");
			
			// Output results
			System.out.println("Weather forecast for this week:");
			System.out.print(links.text());
			
		} catch (org.jsoup.HttpStatusException e) {
			// TODO Auto-generated catch block
			System.out.println("Wrong name of city!");
		}
	}	 
}
