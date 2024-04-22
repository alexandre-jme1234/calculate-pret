package com.visiplus.pret_a_la_consommation;
// import java.text.SimpleDateFormat;
// import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.*;
import java.util.*;
import com.visiplus.pret_a_la_consommation.business.Client;
import com.visiplus.pret_a_la_consommation.business.Mensualite;
import com.visiplus.pret_a_la_consommation.business.Pret;
// import com.visiplus.pret_a_la_consommation.business.Mensualite;
// import com.visiplus.pret_a_la_consommation.business.Pret;

public class App {
	private static List<Pret> prets = new ArrayList<>();
	private static List<Mensualite> mensualites = new ArrayList<Mensualite>();
	private static Set<Client> clients = new HashSet<>();
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// Partie déclarative
		Double montantDemande = 0D;
		short montantMensualite = 0;
		Double partMensualite = 0D;
		byte tauxAnnuel = 0;
		byte dateEffect = 0;
		String str = null;
		Client client = null;
		
		// Partie traitement
		addClient();
		client = selectClient(str);
		getMensualite(montantDemande, tauxAnnuel, montantMensualite, partMensualite, dateEffect, client);
		getMenu();
	}
	
	
	public static void addClient() {
		 clients.add(new Client("John", "Doe"));
		 clients.add(new Client("Jack", "Doe"));
		 clients.add(new Client("Bob", "Doe"));
		 clients.add(new Client("Bruce", "Doe"));
		 clients.add(new Client("Elvis", "Doe"));
		
		for (Client client : clients) {
			System.out.println(client.getId()+ " " + client.getPrenom() + " " + client.getNom());
		}
	};
	
	
	public static Client selectClient(String str) {
		Client currentClient = null;
		System.out.println("Veuillez saisir l'id du client concerné :");
		str = sc.nextLine();
		
		
		for (Client client : clients) {
			if(Long.parseLong(str) == client.getId()) {
				System.out.println(client);
				currentClient = client;
			}
		}
		return currentClient;
		
	}
	
	public static Pret addPret() {
		System.out.println("Veuillez saisir le montant demandé : ");
		Double montantDemande = sc.nextDouble();
	 	prets.add(new Pret(montantDemande, LocalDateTime.now(), null, null));
	 	
	 	Iterator<Pret> iterator = prets.iterator();
        Pret dernierElement = null;
        while (iterator.hasNext()) {
            dernierElement = iterator.next();
        }
        
        System.out.println("Pret ajouté   "+dernierElement);
        return dernierElement;
	}

	
	
	public static void getMensualite(Double montantDemande, byte tauxAnnuel, short montantMensualite, Double partMensualite, byte dateEffect, Client client) {
		System.out.println("Veuillez saisir le montant demandé : ");
		montantDemande = sc.nextDouble();
		
		
		System.out.println("Veuillez saisir le taux annuel :");
		tauxAnnuel = sc.nextByte();	
		
		System.out.println("Veuillez saisir la durée en mois :");
		dateEffect = sc.nextByte();
		
		System.out.println("Veuillez saisir la date d'effet au format MM/yyyy :");
		String dateString = sc.next();
		
		
		// Partie traitement - calcul de la mensualité
		partMensualite = montantDemande * tauxAnnuel / (1 - Math.pow(1 + tauxAnnuel, -dateEffect));
		partMensualite = partMensualite / 12;
		
		
		prets.add(new Pret(montantDemande, LocalDateTime.now(), null, null));
		
		
		System.out.println();
		System.out.printf("Voici les détails du prêt :" + "id :" + client + ", montant emprunté\n"
				+ ":" + montantDemande + "taux annuel" + tauxAnnuel +", mensualité : %.2f :", partMensualite);
		System.out.println();
		System.out.println("Date " + "       Capital Remboursé");
		addMensualite((byte) dateEffect, dateString, partMensualite);
		
	}
	
	
	public static LocalDate addMensualite(byte months, String dateString, Double partMensualite) {
		
		List<Double> mensualitelist = new ArrayList<Double>();
		
		String[] dateParts = dateString.split("/");
        int month = Integer.parseInt(dateParts[0]);
        int year = Integer.parseInt(dateParts[1]);
       
        
        try {
        	LocalDate date = LocalDate.of(year, month, 1);
            LocalDate nouvelleDate = date.plusMonths(months);
            
            
            for (int i = 0; i <= months; i++) {
            	mensualitelist.add(partMensualite*i);
            	mensualites.add(new Mensualite(null, date.plusMonths(i), mensualitelist.get(i), null));
            }
            
            

            for (Mensualite mensualite : mensualites) {
                System.out.println(mensualite);
            }
            return nouvelleDate;
        } catch (DateTimeParseException e) {
            System.err.println("Erreur de parsing : " + e.getMessage());
            return null;
        }
    }
	
	public static void getMenu() {
		int choice = 0;
		
		System.out.println("");	
		System.out.println("");
		System.out.println("1. Voir tous les prêts triées par montant (du plus élevé au plus petit)");
		System.out.println("");
		System.out.println("2. Voir tous les prêts triées par taux (du plus élevé au plus petit)");
		System.out.println("");
		System.out.println("3. Voir la liste des prêts qui débutent entre deux dates données");
		System.out.println("");
		System.out.println("4. Ajouter un prêt");
		System.out.println("");
		System.out.println("5. Quitter");
		System.out.println("");
		
		choice = sc.nextInt();
		
		switch (choice) {
		case 1: {
			
			Collections.sort(mensualites);
	        
	        for (Mensualite mensualite : mensualites) {
				System.out.println(mensualite);
				
			}
	        
	        
			break;
		}
		case 2: {
			Comparator<Mensualite> comparateur = new Comparator<Mensualite>() {
	            @Override
	            public int compare(Mensualite a, Mensualite b) {
	                return a.compareTo(b);
	            }
	        };
	        Collections.sort(mensualites, comparateur);
	        
	        for (Mensualite mensualite : mensualites) {
				System.out.println(mensualite);
				
			}
			break;
		}
		case 3: {
			System.out.println("1. Voir tous les prêts triées par montant (du plus élevé au plus petit)");
			break;
		}
		case 4: {
			addPret();
			break;
		}
		case 5: {
			System.out.println("");
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + choice);
		}
	}
}
 